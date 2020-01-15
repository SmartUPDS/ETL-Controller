package com.smartupds.etlcontroller.etl.controller.impl.frick;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Normalizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiNormalizer;
import com.smartupds.normalizer.exceptions.NormalizerException;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.tuple.Triple;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import split.ElementsSplit;

/** Normalizer for input sources from FRICK
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class FrickNormalizer implements Normalizer{

    @Override
    public void normalizeResources() throws ETLGenericException {
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.frick.fricknanormalizer.normalize");
        log.info("START: Normalize textual contents from FRICK");
        try{
            for(File file : new File(Resources.FOLDER_INPUT_FETCHED_FRICK).listFiles()){
                Document doc=ElementsSplit.parseXmlDocument(file);
                doc=this.removeSuffixPunctuation(doc,"marc:subfield");
                doc=this.normalizeDimension(doc,Triple.of("marc:datafield","tag", "340"),Triple.of("marc:subfield","code", "b"));
                doc=this.normalizeYear(doc,Triple.of("marc:datafield","tag", "260"),Triple.of("marc:subfield","code", "c"));
                doc=this.normalizePersonAndPlace(doc,Triple.of("marc:datafield","tag", "590"),Triple.of("marc:subfield","code", Arrays.asList("b","k")));
                doc=this.addCountInfo(doc,"marc:record",Triple.of("marc:datafield","tag", "590"));
                ItattiNormalizer.exportXmlDocument(doc, new File(Resources.FOLDER_INPUT_NORMALIZED_FRICK+"/"+file.getName()));
            }
        }catch(NormalizerException ex){
            log.error("An error occured while normalizing collection",ex);
            throw new ETLGenericException("An error occured while normalizing collection",ex);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.frick.fricknanormalizer.normalize");
        log.info("FINISH: Split large files from FRICK in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.frick.fricknanormalizer.normalize"));
    }
    
    private Document removeSuffixPunctuation(Document doc,String elementName){
        log.info("START: Remove suffix punctuation");
        NodeList elements=doc.getElementsByTagName(elementName);
        System.out.println(elements.getLength());
        for(int i=0;i<=elements.getLength();i++){
            Element elem=((Element)elements.item(i));
            if(elem!=null && elem.getTextContent()!=null && !elem.getTextContent().isEmpty()){
                String normText=this.removeSuffixPunctuation(elem.getTextContent());
                if(!elem.getTextContent().equals(normText)){
                    elem.setTextContent(normText);
                }
                if(elem.getTextContent().startsWith("(") && elem.getTextContent().endsWith(")")){
                    elem.setTextContent(elem.getTextContent().substring(1,elem.getTextContent().length()-1));
                }
            }
            System.out.println(i+" out of "+elements.getLength());
        }
        log.info("END: Remove suffix punctuation");
        return doc;
    }
    
    private String removeSuffixPunctuation(String originalText){
        originalText=originalText.trim();
        while(originalText.endsWith(".") || originalText.endsWith(",")){
            if(originalText.endsWith(".")){
                originalText=originalText.substring(0,originalText.lastIndexOf(".")).trim();
            }else if(originalText.endsWith(",")){
                originalText=originalText.substring(0,originalText.lastIndexOf(",")).trim();
            }
        }
        return originalText;
    }
    
    private Document normalizeDimension(Document doc, Triple<String,String,String> parentElement, Triple<String,String,String> subElement){
        log.info("START: Normalize Dimensions");
        NodeList parentNodes=doc.getElementsByTagName(parentElement.getLeft());
        for(int i=0;i<parentNodes.getLength();i++){
            Element parentElem=((Element)parentNodes.item(i));
            if(parentElem.getAttribute(parentElement.getMiddle()).equals(parentElement.getRight())){
                NodeList childNodes=parentElem.getChildNodes();
                for(int j=0;j<childNodes.getLength();j++){
                    Node child=childNodes.item(j);
                    if(child.getNodeType()==Node.ELEMENT_NODE && child.getNodeName().equals(subElement.getLeft())){
                        Element childElement=((Element)child);
                        if(childElement.getAttribute(subElement.getMiddle()).equals(subElement.getRight())){
                            List<String> dims=this.splitDimensionText(childElement.getTextContent());
                            if(!dims.isEmpty()){
                                childElement.setAttribute("dimension1", dims.get(0));
                                childElement.setAttribute("dimension2", dims.get(1));
                                childElement.setAttribute("unit", dims.get(2));
                            }
                        }
                    }
                }
            }
        }
        log.info("END: Normalize Dimensions");
        return doc;
    }
    
    private Document normalizeYear(Document doc, Triple<String,String,String> parentElement, Triple<String,String,String> subElement){
        log.info("START: Normalize Years");
        NodeList parentNodes=doc.getElementsByTagName(parentElement.getLeft());
        for(int i=0;i<parentNodes.getLength();i++){
            Element parentElem=((Element)parentNodes.item(i));
            if(parentElem.getAttribute(parentElement.getMiddle()).equals(parentElement.getRight())){
                NodeList childNodes=parentElem.getChildNodes();
                for(int j=0;j<childNodes.getLength();j++){
                    Node child=childNodes.item(j);
                    if(child.getNodeType()==Node.ELEMENT_NODE && child.getNodeName().equals(subElement.getLeft())){
                        Element childElement=((Element)child);
                        if(childElement.getAttribute(subElement.getMiddle()).equals(subElement.getRight())){
                            List<String> years=this.normalizeYear(childElement.getTextContent());
                            if(years.size()==1){
                                childElement.setTextContent(years.get(0));
                            }else if(years.size()==2){
                                childElement.setAttribute("c1", years.get(0));
                                childElement.setAttribute("c2", years.get(1));
                            }
                        }
                    }
                }
            }
        }
        log.info("END: Normalize Years");
        return doc;
    }
    
    private Document normalizePersonAndPlace(Document doc, Triple<String,String,String> parentElement, Triple<String,String,List<String>> subElement){
        log.info("START: Normalize Persons");
        NodeList parentNodes=doc.getElementsByTagName(parentElement.getLeft());
        for(int i=0;i<parentNodes.getLength();i++){
            Element parentElem=((Element)parentNodes.item(i));
            if(parentElem.getAttribute(parentElement.getMiddle()).equals(parentElement.getRight())){
                NodeList childNodes=parentElem.getChildNodes();
                for(int j=0;j<childNodes.getLength();j++){
                    Node child=childNodes.item(j);
                    if(child.getNodeType()==Node.ELEMENT_NODE && child.getNodeName().equals(subElement.getLeft())){
                        Element childElement=((Element)child);
                        if(subElement.getRight().contains(childElement.getAttribute(subElement.getMiddle()))){
                            List<String> personAndPlace=this.normalizePersonAndPlace(childElement.getTextContent());
                            if(!personAndPlace.isEmpty()){
                                childElement.setAttribute("person", personAndPlace.get(0));
                                childElement.setAttribute("place", personAndPlace.get(1));
                            }
                        }
                    }
                }
            }
        }
        log.info("END: Normalize Persons");
        return doc;
    }
    
    private Document addCountInfo(Document doc, String parentElementName, Triple<String,String,String> subElement){
        log.info("START: add count Info");
        NodeList parentNodes=doc.getElementsByTagName(parentElementName);
        for(int i=0;i<parentNodes.getLength();i++){
            int cnt=1;
            NodeList childNodes=parentNodes.item(i).getChildNodes();
            for(int j=0;j<childNodes.getLength();j++){
                Node child=childNodes.item(j);
                if(child.getNodeType()==Node.ELEMENT_NODE && child.getNodeName().equals(subElement.getLeft())){
                    Element childElement=((Element)child);
                    if(childElement.getAttribute(subElement.getMiddle()).equals(subElement.getRight())){
                        childElement.setAttribute("count", String.valueOf(cnt++));
                    }
                }
            }
        }
        log.info("END: Add count info");
        return doc;
    }
    
    private List<String> splitDimensionText(String originalDimension){
        List<String> retList=new ArrayList<>();
        String[] dimensionTerms=originalDimension.split(" x ");
        if(dimensionTerms.length==2){
            retList.add(dimensionTerms[0]);
            if(dimensionTerms[1].endsWith(")")){
                String normalizedValue=dimensionTerms[1].substring(0,dimensionTerms[1].lastIndexOf("(")).trim();
                retList.add(normalizedValue.substring(0,normalizedValue.lastIndexOf(" ")));
                retList.add(normalizedValue.substring(normalizedValue.lastIndexOf(" ")+1));
            }else{
                retList.add(dimensionTerms[1].trim().substring(0,dimensionTerms[1].trim().lastIndexOf(" ")));
                retList.add(dimensionTerms[1].trim().substring(dimensionTerms[1].trim().lastIndexOf(" ")+1));
            }
        }
        return retList;
    }
    
    private List<String> normalizeYear(String originalYear){
        List<String> retList=new ArrayList<>();
        if(originalYear.length()!=4){
            if(originalYear.startsWith("c.")){
                retList.add(originalYear.replace("c.", "").trim());
            }else if(originalYear.startsWith("ca.")){
                retList.add(originalYear.replace("ca.", "").trim());
            }else if(originalYear.contains("-")){
                String[] terms=originalYear.split("-");
                retList.add(terms[0]);
                retList.add(terms[1]);
            }
        }
        return retList;
    }
    
    private List<String> normalizePersonAndPlace(String originalStr){
        List<String> retList=new ArrayList();
        if(originalStr.contains(",")){
            retList.add(originalStr.substring(0,originalStr.indexOf(",")).trim());
            retList.add(originalStr.substring(originalStr.indexOf(",")+1).trim());
        }
        return retList;
    }
    
    public static FrickNormalizer create(){
        return new FrickNormalizer();
    }

}
