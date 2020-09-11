package com.smartupds.etlcontroller.etl.controller.impl.frick;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Normalizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiNormalizer;
import com.smartupds.normalizer.exceptions.NormalizerException;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.tuple.Pair;
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
        Timer.start(FrickNormalizer.class.getCanonicalName()+".normalize");
        log.info("START: Normalize textual contents from FRICK");
        try{
            for(File file : new File(Resources.FOLDER_INPUT_FETCHED_FRICK).listFiles()){
                Utils.lineUpdater(file, new File(file.getAbsolutePath()+"norm.xml"), "<collection>" , "<collection xmlns:marc=\"http://www.loc.gov/MARC21/slim\">");
            }
            for(File file : new File(Resources.FOLDER_INPUT_FETCHED_FRICK).listFiles()){
                log.info("Normalize file "+file);
                Document doc=ElementsSplit.parseXmlDocument(file);
                doc=this.removeSuffixPunctuation(doc,"marc:subfield");
                doc=this.normalizeDimension(doc,Triple.of("marc:datafield","tag", "340"),Triple.of("marc:subfield","code", "b"));
                doc=this.normalizeYear(doc,Triple.of("marc:datafield","tag", "260"),Triple.of("marc:subfield","code", "c"));
                doc=this.normalizePersonAndPlace(doc,Triple.of("marc:datafield","tag", "590"),Triple.of("marc:subfield","code", Arrays.asList("b","k")));
                doc=this.normalizePostfix(doc,Triple.of("marc:datafield","tag", "590"),Pair.of("ind1","9"), Triple.of("marc:subfield","code", "g"),Arrays.asList("_POST.tif",".tif"),Triple.of("marc:subfield","code", "d"));
                doc=this.addCountInfo(doc,"marc:record",Triple.of("marc:datafield","tag", "590"));
                doc=this.activeRemove(doc,Triple.of("marc:datafield","tag", "100"),Triple.of("marc:subfield","code", "d"));
                doc=this.concatenateElements(doc,Triple.of("marc:datafield","tag", "655"),Triple.of("marc:subfield","code", "b"), Triple.of("marc:subfield","code", "a"));
                doc=this.normalizeNarrative(doc,Triple.of("marc:datafield","tag", "561"),Triple.of("marc:subfield","code", "a"));
                ItattiNormalizer.exportXmlDocument(doc, new File(Resources.FOLDER_INPUT_NORMALIZED_FRICK+"/"+file.getName()));
            }
        }catch(NormalizerException | IOException ex){
            log.error("An error occured while normalizing collection",ex);
            throw new ETLGenericException("An error occured while normalizing collection",ex);
        }
        Timer.stop(FrickNormalizer.class.getCanonicalName()+".normalize");
        log.info("FINISH: Split large files from FRICK in "+Timer.reportHumanFriendly(FrickNormalizer.class.getCanonicalName()+".normalize"));
        
        log.info("FRICK Normalizations Time: "+Timer.reportHumanFriendly(FrickNormalizer.class.getCanonicalName()));
    }
    
    private Document removeSuffixPunctuation(Document doc,String elementName){
        log.info("START: Remove suffix punctuation");
        NodeList elements=doc.getElementsByTagName(elementName);
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
            if(i%10000==0){
                log.info(i+" out of "+elements.getLength()+"\t("+(((float)i/(float)elements.getLength())*100)+" %)");
            }
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
                            if(dims.size()==3){
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
    
    private Document activeRemove(Document doc, Triple<String,String,String> parentElement, Triple<String,String,String> subElement){
        log.info("START: Active remove");
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
                            if(childElement.getTextContent().startsWith("active")){
                                childElement.setAttribute("active", "true");
                                childElement.setTextContent(childElement.getTextContent().replace("active", "").trim());
                            }else{
                                childElement.setAttribute("active", "false");
                                String[] splitContents=childElement.getTextContent().split("-");
                                if(splitContents.length==2){
                                    childElement.setAttribute("birth", splitContents[0]);
                                    childElement.setAttribute("death", splitContents[1]);
                                }
                            }
                        }
                    }
                }
            }
        }
        log.info("END: Active Remove");
        return doc;
    }
    
    private Document concatenateElements(Document doc, Triple<String,String,String> parentElement, Triple<String,String,String> existElement, Triple<String,String,String> concatElement){
        log.info("START: Concatenante Elements");
        NodeList parentNodes=doc.getElementsByTagName(parentElement.getLeft());
        for(int i=0;i<parentNodes.getLength();i++){
            Element parentElem=((Element)parentNodes.item(i));
            if(parentElem.getAttribute(parentElement.getMiddle()).equals(parentElement.getRight())){
                NodeList childNodes=parentElem.getChildNodes();
                Element elementFirst=null;
                Element elementSecond=null;
                for(int j=0;j<childNodes.getLength();j++){
                    Node child=childNodes.item(j);
                    if(child.getNodeType()==Node.ELEMENT_NODE && child.getNodeName().equals(concatElement.getLeft())){
                        Element childElement=((Element)child);
                        if(childElement.getAttribute(concatElement.getMiddle()).equals(concatElement.getRight())){
                            elementFirst=((Element)child);
                        }else if(childElement.getAttribute(existElement.getMiddle()).equals(existElement.getRight())){
                            elementSecond=((Element)child);
                        }    
                    }
                }
                if(elementFirst!=null && elementSecond!=null){
                    elementFirst.setTextContent(elementFirst.getTextContent()+" "+elementSecond.getTextContent());
                }
            }
        }
        log.info("END: Active Remove");
        return doc;
    }
    
    private Document normalizeNarrative(Document doc, Triple<String,String,String> parentElement, Triple<String,String,String> subElement){
        log.info("START: Concatenante Elements");
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
                            String text=childElement.getTextContent();
                            text=(text.endsWith(";")?text.substring(0,text.length()-1):text);
                            int parethesisOpenIndex=text.indexOf("(");
                            int parethesisCloseIndex=text.indexOf(")");
                            if(parethesisOpenIndex>=0 && parethesisCloseIndex>0 && parethesisCloseIndex>parethesisOpenIndex && parethesisCloseIndex-parethesisOpenIndex<10){
                                text=text.substring(parethesisCloseIndex+1).trim();
                                childElement.setTextContent(text);
                            }
                            
                        }  
                    }
                }
            }
        }
        log.info("END: Active Remove");
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
    
    private Document normalizePostfix(Document doc, Triple<String,String,String> parentElement, Pair<String,String> indexElement, Triple<String,String,String> checkElement, List<String> postfixOrderedList, Triple<String,String,String> addElement){
        log.info("START: Normalize Postfix");
        NodeList parentNodes=doc.getElementsByTagName(parentElement.getLeft());
        for(int i=0;i<parentNodes.getLength();i++){
            Element parentElem=((Element)parentNodes.item(i));
            if(parentElem.getAttribute(parentElement.getMiddle()).equals(parentElement.getRight()) && parentElem.getAttribute((indexElement.getKey())).equals(indexElement.getValue())){
                NodeList childNodes=parentElem.getChildNodes();
                for(int j=0;j<childNodes.getLength();j++){
                    Node child=childNodes.item(j);
                    if(child.getNodeType()==Node.ELEMENT_NODE && child.getNodeName().equals(checkElement.getLeft())){
                        Element childElement=((Element)child);
                        if(childElement.getAttribute(checkElement.getMiddle()).equals(checkElement.getRight())){
                            boolean alreadyNormalized=false;
                            for(String postfix : postfixOrderedList){
                                if(childElement.getTextContent().endsWith(postfix) & !alreadyNormalized){
                                    Element newElement=doc.createElement(addElement.getLeft());
                                    newElement.setAttribute(addElement.getMiddle(), addElement.getRight());
                                    newElement.setTextContent(childElement.getTextContent().replace(postfix, ""));
                                    childElement.getParentNode().appendChild(newElement);
                                    alreadyNormalized=true;
                                }
                            }
                        }
                    }
                }
            }
        }
        log.info("END: Normalize Postfix");
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
            if(dimensionTerms[1].endsWith(")") && dimensionTerms[1].contains("(")){
                String normalizedValue=dimensionTerms[1].substring(0,dimensionTerms[1].lastIndexOf("(")).trim();
                if(normalizedValue.contains(" ")){
                    retList.add(normalizedValue.substring(0,normalizedValue.lastIndexOf(" ")));
                    retList.add(normalizedValue.substring(normalizedValue.lastIndexOf(" ")+1));
                }
            }else{
                if(dimensionTerms[1].contains(" ")){
                    retList.add(dimensionTerms[1].trim().substring(0,dimensionTerms[1].trim().lastIndexOf(" ")));
                    retList.add(dimensionTerms[1].trim().substring(dimensionTerms[1].trim().lastIndexOf(" ")+1));
                }
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
