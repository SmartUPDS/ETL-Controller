package com.smartupds.etlcontroller.etl.controller.impl.frick;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Normalizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiNormalizer;
import com.smartupds.normalizer.exceptions.NormalizerException;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
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
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.frick.fricknanormalizer.normalize");
        log.info("START: Normalize textual contents from FRICK");
        try{
            for(File file : new File(Resources.FOLDER_INPUT_FETCHED_FRICK).listFiles()){
                Document doc=ElementsSplit.parseXmlDocument(file);
                doc=this.removeSuffixPunctuation(doc,"marc:subfield");
                doc=this.normalizeDimension(doc,Triple.of("marc:datafield","tag", "340"),Triple.of("marc:subfield","code", "b"));
                ItattiNormalizer.exportXmlDocument(doc, new File(Resources.FOLDER_INPUT_NORMALIZED_FRICK+"/"+file.getName()));
            }
        }catch(NormalizerException ex){
            log.error("An error occured while normalizing collection",ex);
            throw new ETLGenericException("An error occured while normalizing collection",ex);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.frick.fricknanormalizer.normalize");
        log.info("FINISH: Split large files from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.frick.fricknanormalizer.normalize"));
    }
    
    private Document removeSuffixPunctuation(Document doc,String elementName){
        NodeList elements=doc.getElementsByTagName(elementName);
        for(int i=0;i<=elements.getLength();i++){
            Element elem=((Element)elements.item(i));
            if(elem!=null && elem.getTextContent()!=null && !elem.getTextContent().isEmpty()){
                String normText=this.removeSuffixPunctuation(elem.getTextContent());
                if(!elem.getTextContent().equals(normText)){
                    elem.setTextContent(normText);
                }
            }
        }
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
                            System.out.println(childElement.getTextContent());
                        }
                    }
                }
            }
        }
        
        return doc;
    }
    
    public static FrickNormalizer create(){
        return new FrickNormalizer();
    }

}
