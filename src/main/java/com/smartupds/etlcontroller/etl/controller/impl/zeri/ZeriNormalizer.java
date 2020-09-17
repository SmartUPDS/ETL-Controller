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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import lombok.extern.log4j.Log4j;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
        this.replicateZeriResources(new File(Resources.FOLDER_INPUT_FETCHED_ZERI_PHOTOGRAPHS),new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_PHOTOGRAPHS));
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
    
    private void replicateZeriResources(File folderWithInputFiles, File folderForNormFiles) throws ETLGenericException{
        try{
            for(File file : folderWithInputFiles.listFiles()){
                log.debug("Copy resource "+file.getAbsolutePath()+" to folder "+folderForNormFiles.getAbsolutePath());
                Files.copy(file, new File(folderForNormFiles.getAbsoluteFile()+"/"+file.getName()));
            }
        }catch(IOException ex){
            log.error("An error occured while copying file resources",ex);
            throw new ETLGenericException("An error occured while copying file resources",ex);
        }
    }

    public static ZeriNormalizer create(){
        return new ZeriNormalizer();
    }
}
