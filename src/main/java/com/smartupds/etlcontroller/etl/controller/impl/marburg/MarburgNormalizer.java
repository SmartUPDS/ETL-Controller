package com.smartupds.etlcontroller.etl.controller.impl.marburg;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Normalizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.normalizer.exceptions.NormalizerException;
import com.smartupds.xmlsplit.Splitter;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import split.ElementsSplit;

/** Normalizer for input sources from Marburg
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class MarburgNormalizer implements Normalizer{

    @Override
    public void normalizeResources() throws ETLGenericException {
        Timer.start(MarburgNormalizer.class.getCanonicalName()+".split");
        log.info("START: Split large files from Marburg");
        this.splitFiles(Resources.FOLDER_INPUT_FETCHED_MARBURG, 
                           Resources.FOLDER_INPUT_NORMALIZED_MARBURG,
                           Resources.MARBURG_COMBINED_RESOURCES_ROOT_ELEMENT,
                           Resources.MARBURG_COMBINED_RESOURCES_OBJ_ELEMENT,
                           Resources.MAX_FILESIZE_INPUT_RESOURCES_IN_MB);
        Timer.stop(MarburgNormalizer.class.getCanonicalName()+".split");
        log.info("FINISH: Split large files from Marburg in "+Timer.reportHumanFriendly(MarburgNormalizer.class.getCanonicalName()+".split"));

        log.info("START: Perform Syntax Normalization for resources from Marburg");
        Timer.start(MarburgNormalizer.class.getCanonicalName()+".syntax-norm");
//        List<String> elementsList=Arrays.asList("a30nr",
//                                                "a3105",
//                                                "a3200",
//                                                "a5220","a5260","a5300","a5500",
//                                                "a8498");
        List<String> elementsList=Arrays.asList("a30nr",
                                                "a3105",
                                                "a3200",
                                                "a523nr","a520nr","a526nr","a533nr",
                                                "a8498");
        try{
            this.normalizeSyntax(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG),elementsList,"&");
            
        }catch(NormalizerException | IOException ex){
            log.error("An error occured while normalizing input resources",ex);
            throw new ETLGenericException("An error occured while normalizing input resources",ex);
        }
        Timer.stop(MarburgNormalizer.class.getCanonicalName()+".syntax-norm");
        log.info("FINISH: Perform Syntax Normalization for resources from Marburg in "+Timer.reportHumanFriendly(MarburgNormalizer.class.getCanonicalName()+".syntax-norm"));
        
        log.info("Marburg Normalizations Time: "+Timer.reportHumanFriendly(MarburgNormalizer.class.getCanonicalName()));
    }
    
    /** This methods splits the files found in the input folder, into files with 
     * of a particular size and outputs the results in the given output folder. 
     * In addition the root element of the input file is given as well as the 
     * name of the elements that will be divided among different files. 
     * The output resources will be named using the name of their corresponding
     * filename suffixed with the file number. 
     * 
     * @param inputFolderPath the path of the folder containing the original input sources
     * @param outputFolderPath the path of the folder where the split resources will be exported
     * @param rootElement the name of the root element of the document
     * @param splitElement the name of the element that will be used for splitting the file 
     * @param sizeInMb the maximum file of split files */
    private void splitFiles(String inputFolderPath, String outputFolderPath, String rootElement, String splitElement, int sizeInMb) throws ETLGenericException{
        for(File file : new File(inputFolderPath).listFiles()){
            try{
                log.info("Split resource with filename "+file.getName());
                new Splitter(file, rootElement, splitElement, sizeInMb).split(new File(outputFolderPath));
            }catch(IOException | ParserConfigurationException | SAXException | TransformerException | XPathExpressionException ex){
                log.error("An error occured while splitting large input file",ex);
                throw new ETLGenericException("An error occured while splitting large input file",ex);
            }
        }
    }
    
    /** This method carries out syntax normalization. In particular it normalizes (creates two or more) elements with the 
     * given element name, if they contain one or more occurences of the given splitCharSequence
     * 
     * @param inputFolder the folder containing XML files to be normalized
     * @param elementName the element name to be considered for normalization
     * @param splitCharSequence the charSsequence to define the normalization */
    private void normalizeSyntax(File inputFolder, List<String> elementsName, String splitCharSequence) throws NormalizerException, IOException{
        log.info("Normalize files in folder "+inputFolder+". Elements to normalize: "+elementsName+"\t Split String: "+splitCharSequence);
        Map<String,List<String>> elementsSeparatorsMap=new HashMap<>();
        elementsName.forEach(elementName -> elementsSeparatorsMap.put(elementName,Arrays.asList(splitCharSequence)));
        for(File file : FileUtils.listFiles(inputFolder, null, true)){
            String folderName=file.getParent();
            String filename=file.getName();
            log.debug("Normalize file "+file.getAbsolutePath());
            Document doc=ElementsSplit.splitElements(ElementsSplit.parseXmlDocument(file), elementsSeparatorsMap);
            // To split a5500 on & needs to  take the sub elements and then split its sub elements
            Map<String,List<String>> list = getListOfSubElements(doc,"a5500",splitCharSequence);
            doc = ElementsSplit.splitElements(doc, list);
            
            doc=normalizeYear(doc, "a5064");
            doc=normalizeYear(doc, "a8494");
            doc=identifySource(doc, "a30nr");
            doc=addRootAttribute(doc,"root");
            doc=normalizeId(doc,"a520s");
            doc=normalizeId(doc,"a522s");
            doc=normalizeId(doc,"a523s");
            doc=normalizeId(doc,"a526s");
            doc=normalizeId(doc,"a533s");
            doc=normalizeId(doc,"a524s");
            doc=normalizeId(doc,"a3000");
            
            ElementsSplit.exportXmlDocument(doc, new File(folderName+"/"+filename.replace(".xml","")+"_cleaned"+".xml")); 
            FileUtils.deleteQuietly(file);  //Seems that it doesn't work
        }
    }
    
    private Document normalizeYear(Document doc, String elementName){
        log.info("START: Normalize Years");
        NodeList parentNodes=doc.getElementsByTagName(elementName);
        for(int i=0;i<parentNodes.getLength();i++){
            Element parentElem=((Element)parentNodes.item(i));
            if(!Character.isDigit(parentElem.getTextContent().charAt(0))){
                continue;
            }
            String[] splitYears=parentElem.getTextContent().split("/");
            if(splitYears.length==2){
                parentElem.setAttribute("start", splitYears[0]);
                parentElem.setAttribute("end", splitYears[1]);
            }else{
                splitYears=parentElem.getTextContent().split("-");
                if(splitYears.length==2){
                    parentElem.setAttribute("start", splitYears[0]);
                    parentElem.setAttribute("end", splitYears[1]);
                }
            }
        }
        log.info("END: Normalize Years");
        return doc;
    }
    private Document addRootAttribute(Document doc,String rootName){
        log.info("START: Normalize Type");
        NodeList rootNode = doc.getElementsByTagName(rootName);
        for (int j=0;j<rootNode.getLength();j++){
            ((Element)rootNode.item(j)).setAttribute("xmlns:edp", "http://www.stegmannsystems.com/2009/edp");
        }
        log.info("END: Normalize Type");
        return doc;
    }
    
    
    private Document normalizeId(Document doc, String elementName) {
        log.info("START: Normalize Type");
        NodeList nodes = doc.getElementsByTagName(elementName);
        for(int i=0;i<nodes.getLength();i++){
            Element elem=((Element)nodes.item(i));
            String txt =elem.getTextContent();
            Matcher m = Pattern.compile("([a-zA-Z]{3})\\s*([0-9]+)").matcher(txt);
            if (m.find()){
                String pre = m.group(1);
                String id = m.group(2);
                elem.setAttribute("edp:augmented", pre+"::"+id.trim());
                elem.setTextContent(id);
            }
        }
        log.info("END: Normalize Type");
        return doc;
    }
        
    private Document identifySource(Document doc, String elementName){
        log.info("START: Identify Source");
        NodeList parentNodes=doc.getElementsByTagName(elementName);
        for(int i=0;i<parentNodes.getLength();i++){
            Element parentElem=((Element)parentNodes.item(i));
            String textualIdentifier=parentElem.getTextContent();
            if(textualIdentifier.toLowerCase().startsWith("ulan")){
                parentElem.setAttribute("type", "ulan");
            }else if(textualIdentifier.toLowerCase().startsWith("gnd")){
                parentElem.setAttribute("type", "gnd");
            }else if(textualIdentifier.toLowerCase().startsWith("akl")){
                parentElem.setAttribute("type", "akl");
            }else if(textualIdentifier.toLowerCase().startsWith("viaf")){
                parentElem.setAttribute("type", "viaf");
            }
        }
        log.info("END: Identify Source");
        return doc;
    }
    
    public static MarburgNormalizer create(){
        return new MarburgNormalizer();
    }

    private Map<String,List<String>> getListOfSubElements(Document doc, String elementName, String splitCharSequence) {
        Map<String,List<String>> list = new HashMap<>();
        NodeList nodes = doc.getElementsByTagName(elementName);
        for (int i=0;i<nodes.getLength();i++){
            NodeList childNodes = ((Element) nodes.item(i)).getChildNodes();
            for (int j=0;j<childNodes.getLength();j++){
                String nodeName = childNodes.item(j).getNodeName();
                if (!nodeName.equals("#text")){
                    list.put(nodeName, Arrays.asList(splitCharSequence));
                    
                }
            }
        }
        if(list.isEmpty()){
            list.put(elementName, Arrays.asList(splitCharSequence));
        }
        return list;
    }

}
