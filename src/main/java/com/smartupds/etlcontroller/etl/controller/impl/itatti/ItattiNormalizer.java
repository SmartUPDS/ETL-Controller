package com.smartupds.etlcontroller.etl.controller.impl.itatti;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Normalizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.normalizer.exceptions.NormalizerException;
import gr.forth.ics.isl.timer.Timer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import lombok.extern.log4j.Log4j;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import split.ElementsSplit;

/** Normalizer for input sources from Villa I Tatti
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class ItattiNormalizer implements Normalizer {

    @Override
    public void normalizeResources() throws ETLGenericException {   
        try {
            log.info("START: Normalize contents from Villa I Tatti - SharedShelf");
            Timer.start(ItattiNormalizer.class.getCanonicalName()+".normalize.sharedshelf");
            this.normalizeSharedShelfNotes(new File(Resources.FOLDER_INPUT_FETCHED_VILLA_I_TATTI_SHAREDSHELF),new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF));
            Timer.stop(ItattiNormalizer.class.getCanonicalName()+".normalize.sharedshelf");
            log.info("FINISH: Normalize contents from Villa I Tatti - SharedShelf in "+Timer.reportHumanFriendly(ItattiNormalizer.class.getCanonicalName()+".normalize.sharedshelf"));
        } catch (IOException ex) {
            log.error(ex + " error at " + ItattiNormalizer.class.getName());
        }
        log.info("START: Normalize contents from Villa I Tatti - FotoIndex");
        Timer.start(ItattiNormalizer.class.getCanonicalName()+".normalize.fotoindex");
        this.normalizeFotoIndex(new File(Resources.FOLDER_INPUT_FETCHED_VILLA_I_TATTI_FOTOINDEX),new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_FOTOINDEX));
        Timer.stop(ItattiNormalizer.class.getCanonicalName()+".normalize.fotoindex");
        log.info("FINISH: Normalize contents from Villa I Tatti - SharedShelf in "+Timer.reportHumanFriendly(ItattiNormalizer.class.getCanonicalName()+".normalize.fotoindex"));
                
        log.info("Villa I Tatti Normalizations Time: "+Timer.reportHumanFriendly(ItattiNormalizer.class.getCanonicalName()));
    }
    
    public void normalizeSharedShelfNotes(File folderWithInputFiles, File folderForNormFiles) throws ETLGenericException, IOException{
        for(File file : folderWithInputFiles.listFiles()){
            try{
                log.info("analyze file "+file);
                Document doc=ElementsSplit.parseXmlDocument(file);
                NodeList notesElements=doc.getElementsByTagName("Notes");
                for(int i=0;i<notesElements.getLength();i++){
                    Node notesElem=notesElements.item(i);
                    for(int j=0;j<notesElem.getChildNodes().getLength();j++){
                        Node noteElem=notesElem.getChildNodes().item(j);
                        if(noteElem.getNodeType()==Node.ELEMENT_NODE && noteElem.getNodeName().equals("Note")){
                            Element noteAsElement=((Element)noteElem);
                            List<String> normalizedNoteList=this.normalizeNotes(noteAsElement.getAttribute("term"));
                            if(normalizedNoteList.size()>=1){
                                int index=1;
                                for(Node newElement : createElements(doc, noteAsElement, normalizedNoteList)){
                                        noteAsElement.getParentNode().appendChild(newElement);
                                    ((Element)newElement).setAttribute("index", String.valueOf(index++));
                                    }
                                noteAsElement.getParentNode().removeChild(noteAsElement);
                            }
                        }
                    }
                }
                NodeList rightsElements=doc.getElementsByTagName("Rights");
                for(int i=0;i<rightsElements.getLength();i++){
                    Node rightsElem=rightsElements.item(i);
                    for(int j=0;j<rightsElem.getChildNodes().getLength();j++){
                        Node rightElem=rightsElem.getChildNodes().item(j);
                        if(rightElem.getNodeType()==Node.ELEMENT_NODE && rightElem.getNodeName().equals("Right")){
                            Element rightAsElement=((Element)rightElem);
                            List<String> normRights=normalizeRights(rightAsElement.getAttribute("term"));
                            if(normRights.size()==2){
                                rightAsElement.setAttribute("rightholder", normRights.get(0));
                                rightAsElement.setAttribute("term", normRights.get(1));
                            }
                        }
                    }
                }
                NodeList displayRecords=doc.getElementsByTagName("DisplayRecord");
                for(int i=0;i<displayRecords.getLength();i++){
                    Node displayRec=displayRecords.item(i);
                    for(int j=0;j<displayRec.getChildNodes().getLength();j++){
                        Node fieldString=displayRec.getChildNodes().item(j);
                        if(fieldString.getNodeType()==Node.ELEMENT_NODE && fieldString.getNodeName().equals("field_string")){
                            Element fieldAsElem=((Element)fieldString);
                            if(fieldAsElem.getAttribute("label").equals("Image Measurements")){
                                List<String> normMeasurementValues=this.normalizeMeasurements(fieldAsElem.getAttribute("value"));
                                if(!normMeasurementValues.isEmpty()){
                                    fieldAsElem.setAttribute("dimension1", normMeasurementValues.get(0));
                                    fieldAsElem.setAttribute("dimension2", normMeasurementValues.get(1));
                                    fieldAsElem.setAttribute("unit", normMeasurementValues.get(2));
                                }
                            }
                        }
                    }
                }
                NodeList measurements=doc.getElementsByTagName("Measurements");
                for(int i=0;i<measurements.getLength();i++){
                    Node measurementsNode=measurements.item(i);
                    for(int j=0;j<measurementsNode.getChildNodes().getLength();j++){
                        Node measurementNode=measurementsNode.getChildNodes().item(j);
                        if(measurementNode.getNodeType()==Node.ELEMENT_NODE && measurementNode.getNodeName().equals("Measurement")){
                            for(int k=0;k<measurementNode.getChildNodes().getLength();k++){
                                Node measureNode=measurementNode.getChildNodes().item(k);
                                if(measureNode.getNodeType()==Node.ELEMENT_NODE && measureNode.getNodeName().equals("ssw:Measure")){
                                    for(int l=0;l<measureNode.getChildNodes().getLength();l++){
                                        Node termNode=measureNode.getChildNodes().item(l);
                                        if(termNode.getNodeType()==Node.ELEMENT_NODE && termNode.getNodeName().equals("Term")){
                                            Element termNodeAsElem=((Element)termNode);
                                            List<String> normMeasurementValues=this.normalizeMeasurements(termNodeAsElem.getTextContent());
                                            if(!normMeasurementValues.isEmpty()){
                                                termNodeAsElem.setAttribute("dimension1", normMeasurementValues.get(0));
                                                termNodeAsElem.setAttribute("dimension2", normMeasurementValues.get(1));
                                                termNodeAsElem.setAttribute("unit", normMeasurementValues.get(2));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
                doc = this.shiftElementContent(doc, "Entry", "Language");
                doc = this.deleteElement(doc,"Language");
                doc = this.correctElementId(doc,Resources.ASSET);
                
                this.exportXmlDocument(doc, new File(folderForNormFiles.getAbsolutePath()+"/"+file.getName()));
            }catch(NormalizerException ex){
                log.error("An error occured while normalizing file",ex);
                throw new ETLGenericException("An error occured while normalizing file",ex);
            }   
        }
    }
    
    private List<String> normalizeNotes(String originalText){
        String normText=originalText.replaceAll("&quot;", "QUOT_DELIMITER_UNNORMALIZED").replaceAll("\"","QUOT_DELIMITER_UNNORMALIZED");
        if(normText.contains(";")){
            String[] normTokens=normText.split(";");
            List<String> retList=new ArrayList<>();
            for(String normToken : normTokens){
                retList.add(normToken.trim().replaceAll("QUOT_DELIMITER_UNNORMALIZED", "&quot;"));
            }
            return retList;
        }else{
            return Arrays.asList(originalText);
        }
    }
    
    private List<String> normalizeRights(String originalText){
        String[] splitRights=originalText.split(";");
        if(splitRights.length>1){
            List<String> retList=new ArrayList<>();
            retList.add(splitRights[0].trim());
            String restText="";
            for(int i=1;i<splitRights.length;i++){
                restText+=splitRights[i].trim();
            }
            retList.add(restText);
            return retList;
        }else{
            return Arrays.asList(originalText);
        }
    }
    
    private List<String> normalizeMeasurements(String origMeasurement){
        String[] splitValues=origMeasurement.split(" ");
        if(splitValues.length==4){
            return Arrays.asList(splitValues[0],splitValues[2],splitValues[3]);
        }
        return new ArrayList<>();
    }
    
    private static List<Node> createElements(Document refDoc, Node origElement, List<String> contents){
        List<Node> retList=new ArrayList<>();
        for(String textElem : contents){
            Node newElement=origElement.cloneNode(true);
            ((Element)newElement).setAttribute("term", textElem);
            retList.add(newElement);
        }
        return retList;
    }
    
    /** Exports the contents of the XML Document in the given file
     * 
     * @param doc the XML document
     * @param file the file to export the contents of the XML document 
     * @throws NormalizerException for any error that might occur while exporting */ 
    public static void exportXmlDocument(Document doc, File file) throws NormalizerException{
        try{
            TransformerFactory transformerFactory=TransformerFactory.newInstance();
            Transformer transformer=transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source=new DOMSource(doc);
            StreamResult result=new StreamResult(file);
            transformer.transform(source, result);
        }catch(TransformerException | TransformerFactoryConfigurationError ex){
            log.error("An error occured while exporting data to XML",ex);
            throw new NormalizerException("An error occured while exporting data to XML",ex);
        }
    }
    
    public void normalizeFotoIndex(File folderWithInputFiles, File folderForNormFiles) throws ETLGenericException{
        for(File file : folderWithInputFiles.listFiles()){
            try{
                log.info("analyze file "+file);
                Document doc=ElementsSplit.parseXmlDocument(file);
            
//                NodeList versoElements=doc.getElementsByTagName("Verso_Image_URI");
//                for(int i=0;i<versoElements.getLength();i++){
//                    Node versoElem=versoElements.item(i);
//                    String versoUriOriginal=versoElem.getTextContent();
//                    versoElem.setTextContent(this.normalizeImageUrl(versoUriOriginal));
//                    Element jsonElement=doc.createElement("Verso_Image_JSON");
//                    jsonElement.setTextContent(this.normalizeImageJson(versoUriOriginal));
//                    versoElem.getParentNode().appendChild(jsonElement);
//                }
//                NodeList rectoElements=doc.getElementsByTagName("Recto_Image_URI");
//                for(int i=0;i<rectoElements.getLength();i++){
//                    Node rectoElem=rectoElements.item(i);
//                    String rectoUriOriginal=rectoElem.getTextContent();
//                    rectoElem.setTextContent(this.normalizeImageUrl(rectoUriOriginal));
//                    Element jsonElement=doc.createElement("Recto_Image_JSON");
//                    jsonElement.setTextContent(this.normalizeImageJson(rectoUriOriginal));
//                    rectoElem.getParentNode().appendChild(jsonElement);
//                }
                exportXmlDocument(doc, new File(folderForNormFiles.getAbsolutePath()+"/"+file.getName()));
                
                // Case of document contains institution
                mergeInstitutionElements(folderForNormFiles.getAbsolutePath()+"/"+file.getName(),new File(folderForNormFiles.getAbsolutePath()+"/"+file.getName()));
                
            }catch(NormalizerException ex){
                log.error("An error occured while normalizing file",ex);
                throw new ETLGenericException("An error occured while normalizing file",ex);
            }   
        }
    }
    
    private void mergeInstitutionElements(String filename, File output){
        try {
            Map<String,org.dom4j.Element> elementsMap = new TreeMap<>();
            SAXReader reader = new SAXReader();
            reader.setEncoding("UTF-8");
            org.dom4j.Document doc = reader.read(new FileInputStream(filename));
            org.dom4j.Element rootElement = doc.getRootElement();
            List<org.dom4j.Element> elements = rootElement.elements();
            boolean isInstitution = false;
            for (org.dom4j.Element element :elements){
                if (element.getName().equals("FINAL_EXPORT_Institution")){
                    isInstitution = true;
                    String id = element.element("Institution_ID").getStringValue();
                    if (!elementsMap.containsKey(id))
                        elementsMap.put(id,element);
                    else{
                        List<org.dom4j.Element> childElements = element.elements();
                        for (org.dom4j.Element childElement : childElements){
                            childElement.detach();
                            if(!elementsMap.get(id).asXML().contains(childElement.asXML()))
                                elementsMap.get(id).add(childElement);
                        }
                    }
                }
            }
            if (isInstitution){
                rootElement.clearContent();
                elementsMap.forEach((k,v) -> {
                    rootElement.add(v);
    //                System.out.println("KEY =" + k);
    //                System.out.println(v.asXML());
                });

                OutputFormat format = OutputFormat.createPrettyPrint();
                XMLWriter xmlwriter = new XMLWriter( new OutputStreamWriter(new FileOutputStream(output.getAbsolutePath()), "UTF-8"), format );
                xmlwriter.write( doc );
                xmlwriter.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItattiNormalizer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(ItattiNormalizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Document correctElementId(Document doc,String elementName) throws IOException{
        NodeList elements = doc.getElementsByTagName(elementName);
        for(int i=0;i<elements.getLength();i++){
            NamedNodeMap attributes = elements.item(i).getAttributes();
            Node uriNode = attributes.getNamedItem(Resources.URI);
            Node idNode = attributes.getNamedItem(Resources.ID);
            String id = idNode.getNodeValue();
            String uri = uriNode.getNodeValue();
            if (id.equals(Resources.NONE)){
                String command = "curl " + uri;
                Process p = Runtime.getRuntime().exec(command);
                try {
                    final BufferedReader reader = new BufferedReader( new InputStreamReader(p.getInputStream()));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        String newUri = line.substring(line.indexOf("http")).trim();
                        String newId = newUri.substring(newUri.lastIndexOf("/")+1);
                        idNode.setNodeValue(newId);
                    }
                    reader.close();
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return doc;    
    }
    
    private Document deleteElement(Document doc,String elementName){
        NodeList element = doc.getElementsByTagName(elementName);
        int numOfElements = element.getLength();
        while(element.getLength()!=0){
            Node childNode = element.item(0);
            Node parentNode = childNode.getParentNode();
            parentNode.removeChild(childNode);
        }
        return doc;    
    }
    
    private Document shiftElementContent(Document doc,String elementName, String afterElement){
        NodeList element = doc.getElementsByTagName(elementName);
        for(int i=0;i<element.getLength();i++){
            NodeList childNodes = element.item(i).getChildNodes();
            boolean after = false;
            String previousValue = "";
            for (int j=0;j<childNodes.getLength();j++){
                if (after && childNodes.item(j).getNodeType()!=3) {
                    String currentValue = childNodes.item(j).getTextContent();
                    childNodes.item(j).setTextContent(previousValue);
                    previousValue = currentValue;
                }
                if (afterElement==null)
                    after = true;
                else if(!after && childNodes.item(j).getNodeName().equals(afterElement))
                    after = true;
                
            }
        }
        return doc;    
    }
    
    private String normalizeImageUrl(String versoImageUri){
        return versoImageUri.replace("Scaler/IIIF/GRI", "iiif/2/fotoindex")+".jpg/full/!700,700/0/default.jpg";
    }
    
    private String normalizeImageJson(String versoImageUri){
        return versoImageUri.replace("Scaler/IIIF/GRI", "iiif/2/fotoindex")+".jpg/info.json";
    }
    
    public static ItattiNormalizer create(){
        return new ItattiNormalizer();
    }
}
