package com.smartupds.etlcontroller.etl.controller.impl.zeri;

import com.google.common.io.Files;
import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Normalizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiNormalizer;
import com.smartupds.normalizer.exceptions.NormalizerException;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import lombok.extern.log4j.Log4j;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import split.ElementsSplit;

/** Normalizer for input sources from Zeri
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class ZeriNormalizer implements Normalizer{

    @Override
    public void normalizeResources() throws ETLGenericException {
        log.info("START: Normalize Artwork Resources from Zeri");
        Timer.start(ZeriNormalizer.class.getCanonicalName()+".normalize.art");
        this.normalizeZeriResources(new File(Resources.FOLDER_INPUT_FETCHED_ZERI_ARTWORKS),new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_ARTWORKS));
        Timer.stop(ZeriNormalizer.class.getCanonicalName()+".normalize.art");
        log.info("FINISH: Normalize Artwork Resources from Zeri in "+Timer.reportHumanFriendly(ZeriNormalizer.class.getCanonicalName()+".normalize.art"));
        
        log.info("START: Normalize Photograph Resources from Zeri");
        Timer.start(ZeriNormalizer.class.getCanonicalName()+".normalize.phot");
        this.normalizeZeriPhotographs(new File(Resources.FOLDER_INPUT_FETCHED_ZERI_PHOTOGRAPHS),new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_PHOTOGRAPHS));
        Timer.stop(ZeriNormalizer.class.getCanonicalName()+".normalize.phot");
        log.info("FINISH: Normalize Photograph Resources from Zeri in "+Timer.reportHumanFriendly(ZeriNormalizer.class.getCanonicalName()+".normalize.phot"));
        
        log.info("Zeri Normalizations Time: "+Timer.reportHumanFriendly(ZeriNormalizer.class.getCanonicalName()));   
    }
    
    /** This method unzips the contents of the given file into the given folder
     * 
     * @param zipFile the compressed file
     * @param outputFolder the folder where the contents of the zip will be unzipped */
    private void unzipFiles(File zipFile, File outputFolder) throws ETLGenericException{
        try{
            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = newFile(outputFolder, zipEntry);
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        }catch(IOException ex){
            log.error("An error occured while unzipping the contents of a compressed file",ex);
            throw new ETLGenericException("An error occured while unzipping the contents of a compressed file",ex);
        }
    }
    
    private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        destinationDir.mkdirs();
        File destFile = new File(destinationDir, zipEntry.getName());
        destFile.getParentFile().mkdirs();
        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();
         
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }
        return destFile;
    }

    private void normalizeZeriResources(File folderWithInputFiles, File folderForNormFiles){
        for(File file : folderWithInputFiles.listFiles()){
            log.debug("Normalize file "+file.getAbsolutePath());
            try {
                Document doc = ElementsSplit.parseXmlDocument(file);
                doc = this.normalizeElements(doc,"FOTO","ftan" , "fotoID");
                doc = this.normalizeLevel(doc);
                // PARAGRAFO[@etichetta="OBJECT"]/MTC[@etichetta="Medium or materials"]
                doc = this.normalizeVoc(doc,"PARAGRAFO","OBJECT","MTC","Medium or materials",",");
                // PARAGRAFO[@etichetta="OBJECT"]/OGTT[@etichetta="Object type"]
                doc = this.normalizeVoc(doc,"PARAGRAFO","OBJECT","OGTT","Object type","/");
                ItattiNormalizer.exportXmlDocument(doc, new File(folderForNormFiles+"/"+file.getName()));
            } catch (NormalizerException ex) {
                Logger.getLogger(ZeriNormalizer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Document normalizeElements(Document doc,String elementName, String oldTag, String newTag){
        NodeList element = doc.getElementsByTagName(elementName);
        for(int i=0;i<element.getLength();i++){
            Node node = element.item(i).getAttributes().getNamedItem(oldTag);
            String tagValue = node.getNodeValue();
            String newTagValue = tagValue.substring(tagValue.lastIndexOf("\\")+1,tagValue.lastIndexOf("."));
            Node newNode = node.cloneNode(true);
            newNode.setNodeValue(newTagValue);
            doc.renameNode(newNode, newNode.getNamespaceURI(), newTag);
            element.item(i).getAttributes().setNamedItem(newNode);
        }
        return doc;    
    }
    
    public Document normalizeLevel(Document doc){
        NodeList element = doc.getElementsByTagName("RVEL");
        for (int i=0; i<element.getLength();i++){
            if (Integer.parseInt(element.item(i).getTextContent())>0){
                Node nrschedaNode = doc.getElementsByTagName("NRSCHEDA").item(0);
                String nrscheda = nrschedaNode.getTextContent();
                String sercd = doc.getElementsByTagName("SERCD").item(0).getTextContent();
                String rvel = element.item(i).getTextContent();
                nrschedaNode.setTextContent(nrscheda+sercd+rvel);
            }
        }
        return doc;
    }
    private Document normalizeVoc(Document doc, String field, String field_etichetta,String subfield,String subfield_etichetta, String del) {
         NodeList element = doc.getElementsByTagName(field);
        for (int i=0; i<element.getLength();i++){
            if(element.item(i).getAttributes().getNamedItem("etichetta").getNodeValue().equals(field_etichetta)){
                NodeList childNodes = element.item(i).getChildNodes();
                HashSet<Node> new_nodes = new HashSet<>();
                HashSet<Node> old_nodes = new HashSet<>();
                for (int j=0; j<childNodes.getLength();j++){
                    if(childNodes.item(j).getNodeName().equals(subfield) && 
                            childNodes.item(j).getAttributes().getNamedItem("etichetta").getNodeValue().equals(subfield_etichetta)){
                        // only in the case where it is splitable
                        System.out.println(String.join(" - ", childNodes.item(j).getTextContent().split(del)));
                        if (childNodes.item(j).getTextContent().split(del).length>1){
                            new_nodes.add(childNodes.item(j).cloneNode(true));
                            old_nodes.add(childNodes.item(j));
                        }
                    }
                }
                // remove old nodes
                for (Node node: old_nodes){
                    element.item(i).removeChild(node);
                }
                // add new nodes 
                for (Node node: new_nodes){
                    String[] splits = node.getTextContent().split(del);
                    for (String split: splits){
                        Node child_node = node.cloneNode(true);
                        child_node.setTextContent(split.trim());
                        element.item(i).appendChild(child_node);
                    }
                }
            }
        }
        return doc;
    }
    private void normalizeZeriPhotographs(File folderWithInputFiles, File folderForNormFiles) throws ETLGenericException{
        for(File file : folderWithInputFiles.listFiles()){
            log.debug("Normalize file "+file.getAbsolutePath());
            try {
                Document doc = ElementsSplit.parseXmlDocument(file);
                doc = this.normalizeFotoElements(doc,"FOTO", "fotoID");
                ItattiNormalizer.exportXmlDocument(doc, new File(folderForNormFiles+"/"+file.getName()));
            } catch (NormalizerException ex) {
                Logger.getLogger(ZeriNormalizer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Document normalizeFotoElements(Document doc,String elementName, String newTag){
        NodeList element = doc.getElementsByTagName(elementName);
        for(int i=0;i<element.getLength();i++){
            Node node = element.item(i);
            String nodeTextContent = node.getTextContent();
            Matcher m = Pattern.compile("([^\\/]+)\\/([^\\/]+)\\.").matcher(nodeTextContent);
            String newAttributeValue = "";
            if(m.find())
                newAttributeValue = m.group(1) +"!"+ m.group(2);
            ((Element) node).setAttribute(newTag,newAttributeValue);
        }
        return doc;    
    }
    
    public static ZeriNormalizer create(){
        return new ZeriNormalizer();
    }

}
