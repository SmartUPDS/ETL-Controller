/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartupds.etlcontroller.etl.controller.impl.vocs;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Normalizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiNormalizer;
import com.smartupds.normalizer.exceptions.NormalizerException;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import split.ElementsSplit;

/**
 * Normalizer for input sources from MIDAS Vocabularies
 * 
 * @author mafragias
 */
@Log4j
public class VocsNormalizer implements Normalizer{

    @Override
    public void normalizeResources() throws ETLGenericException {
        Timer.start(VocsNormalizer.class.getCanonicalName()+".normalize");
        log.info("START: Normalize textual contents from MIDAS Vocabularies");
        try{
            for(File file : new File(Resources.FOLDER_INPUT_FETCHED_MIDAS_VOCS).listFiles()){
                log.info("Normalize file "+file);
                List<String> elementsName = Arrays.asList("a0102","a010gn");
                Map<String,List<String>> elementsSeparatorsMap=new HashMap<>();
                elementsName.forEach(elementName -> elementsSeparatorsMap.put(elementName,Arrays.asList("&")));
                Document doc=ElementsSplit.splitElements(ElementsSplit.parseXmlDocument(file), elementsSeparatorsMap);
                
                doc=normalizeMatch(doc,"a010gn");
                
                ItattiNormalizer.exportXmlDocument(doc, new File(Resources.FOLDER_INPUT_NORMALIZED_MIDAS_VOCS+"/"+file.getName()));
            }
        }catch(NormalizerException ex){
            log.error("An error occured while normalizing collection",ex);
            throw new ETLGenericException("An error occured while normalizing collection",ex);
        }
        Timer.stop(VocsNormalizer.class.getCanonicalName()+".normalize");
        log.info("FINISH: Split large files from MIDAS Vocabularies in "+Timer.reportHumanFriendly(VocsNormalizer.class.getCanonicalName()+".normalize"));
        
        log.info("MIDAS Vocabularies Normalizations Time: "+Timer.reportHumanFriendly(VocsNormalizer.class.getCanonicalName()));
    }
    
    /** This method normalizes elements of matches
     * 
     * @param doc document to normalize
     * @param elementName name of the element to normalize
     * @return document */
    private Document normalizeMatch(Document doc, String elementName) {
        log.info("START: Normalize Matches");
        NodeList nodes=doc.getElementsByTagName(elementName);
        for(int i=0;i<nodes.getLength();i++){
             Element elem=((Element)nodes.item(i));
            String txt =elem.getTextContent();
            Matcher m = Pattern.compile("([a-zA-Z]{3})([^\\(]+)\\(([^\\)]+)\\)").matcher(txt);
            if (m.find()){
                String source =  m.group(1);
                String id = m.group(2);
                String matchType = m.group(3);
                elem.setAttribute("source",source.trim());
                elem.setAttribute("id",id.trim());
                elem.setAttribute("type",matchType.trim());
            }
        }
        log.info("END: Normalize Years");
        return doc;
    }
        
    public static VocsNormalizer create(){
        return new VocsNormalizer();
    }


    
}
