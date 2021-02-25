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
        List<String> elementsList=Arrays.asList("a30nr",
                                                "a3105",
                                                "a3200",
                                                "a5220","a5260","a5300","a5500",
                                                "a8498");
        try{
            this.normalizeSyntax(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG),elementsList,"&");
            
        }catch(NormalizerException | IOException ex){
            log.error("An error occured while normalizing input resources",ex);
            throw new ETLGenericException("An error occured while normalizing input resources",ex);
        }
        Timer.stop(MarburgNormalizer.class.getCanonicalName()+".syntax-norm");
        log.info("FINISH: Perform Syntax Normalization for resources from Marburg in "+Timer.reportHumanFriendly(MarburgNormalizer.class.getCanonicalName()+".syntax-norm"));
        
        log.info("KHI Normalizations Time: "+Timer.reportHumanFriendly(MarburgNormalizer.class.getCanonicalName()));
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
            doc=normalizeYear(doc, "a5064");
            doc=normalizeYear(doc, "a8494");
            doc=identifySource(doc, "a30nr");
            doc=normalizeType(doc,"obj","a5220");
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
    
    private Document normalizeType(Document doc,String elementName, String afterElement) {
        log.info("START: Normalize Type");
        NodeList parentNodes=doc.getElementsByTagName(elementName);
        for(int i=0;i<parentNodes.getLength();i++){
            NodeList childNodes = parentNodes.item(i).getChildNodes();
            String text = "";
            ArrayList<Node> nodesToRemove = new ArrayList<>();
            Node baseNode = null;
            for (int j=0;j<childNodes.getLength();j++){
                if(childNodes.item(j).getNodeName().equals(afterElement)){
                    if(childNodes.item(j).getChildNodes().getLength()==1){
                        text = text + childNodes.item(j).getChildNodes().item(0).getTextContent();
                        baseNode = childNodes.item(j);
                        nodesToRemove.add(baseNode);
                    }
                }
            }
            for(Node child:nodesToRemove)
                parentNodes.item(i).removeChild(child);
            if (!text.equals("")){
                Matcher a520nr = Pattern.compile("([a-zA-Z]+[0-9-]+[\\s]*\\([a-zA-Z]*\\))").matcher(text);
                Matcher typeAndId = Pattern.compile("([a-zA-Z]+)([0-9]+)[\\s]*[a-z]").matcher(text);
                Matcher a520a = Pattern.compile("[^\\||\\(|\\\\]\\b([a-zA-Z]+)\\b[^\\||\\)]").matcher(text);
                Matcher a520m = Pattern.compile("([\\|]*[0-9]+[\\\\]*[a-zA-Z]+)+").matcher(text);
                String a5220 = "";
                String a520s = "";
                if (typeAndId.find()){
                    a5220 = typeAndId.group(1);
                    a520s = typeAndId.group(2);
                }
                String a520aStr = "";
                if (a520a.find())
                    a520aStr = a520a.group(1);
                String a010gn = "";
                while (a520nr.find()){
                    a010gn += a520nr.group(1) + " & " ;
                }
                if(a010gn.contains("&")){
                    a010gn = a010gn.substring(0,a010gn.lastIndexOf("&"));
                }
                String a520mStr = "";
                if (a520m.find())
                    a520mStr = a520m.group();
                if (baseNode!=null){
                    Node newNode = baseNode.cloneNode(false);
                    newNode.setTextContent(a5220);
                    Node id = baseNode.cloneNode(false);
                    doc.renameNode(id, null, "a520s");
                    id.setTextContent(a520s);
                    ((Element)id).setAttribute("edp:augmented", "the::"+a520s);
                    newNode.appendChild(id);
                    if (!a010gn.equals("")){
                        Node sameAs = baseNode.cloneNode(false);
                        doc.renameNode(sameAs, null, "a520nr");
                        ((Element)sameAs).setAttribute("edp:augmented", "the::"+a520s);
                        Node link = baseNode.cloneNode(false);
                        doc.renameNode(link, null, "a010gn");
                        link.setTextContent(a010gn);
                        sameAs.appendChild(link);
                        newNode.appendChild(sameAs);
                    }
                    if (!a520aStr.equals("")){
                        Node type = baseNode.cloneNode(false);
                        doc.renameNode(type, null, "a520a");
                        ((Element)type).setAttribute("edp:augmented", "the::"+a520s);
                        type.setTextContent(a520aStr);
                        newNode.appendChild(type);
                    }
                    if (!a520mStr.equals("")){
                        Node info = baseNode.cloneNode(false);
                        doc.renameNode(info, null, "a520m");
                        ((Element)info).setAttribute("edp:augmented", "the::"+a520s);
                        info.setTextContent(a520mStr);
                        newNode.appendChild(info);
                    }
                    parentNodes.item(i).appendChild(newNode);
                }
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

}
