package com.smartupds.etlcontroller.etl.controller.impl.khi;

import com.smartupds.etlcontroller.etl.controller.impl.zeri.*;
import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Normalizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.xmlsplit.Splitter;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FilenameUtils;
import org.xml.sax.SAXException;

/** Normalizer for input sources from KHI
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class KhiNormalizer implements Normalizer{

    @Override
    public void normalizeResources() throws ETLGenericException {
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khinormalizer.unzip");
        log.info("START: Unzip resoruces from KHI");
        for(File zipFile : new File(Resources.FOLDER_INPUT_FETCHED_KHI).listFiles()){
            if(FilenameUtils.getExtension(zipFile.getName()).equalsIgnoreCase("zip")){
                log.info("Unzip the contents of the file with filename "+zipFile+" at "+Resources.FOLDER_INPUT_FETCHED_KHI);
                this.unzipFiles(zipFile, new File(Resources.FOLDER_INPUT_FETCHED_KHI));
                zipFile.delete();
            }else{
                log.warn("Unable to unzip the contents of the file "+zipFile.getAbsolutePath()+"\t Only Zip files are supported");
            }  
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khinormalizer.unzip");
        log.info("FINISH: Unzip Resources from Zeri in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khinormalizer.unzip"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khinormalizer.split");
        log.info("START: Split large files from KHI");
        this.splitFiles(Resources.FOLDER_INPUT_FETCHED_KHI, 
                           Resources.FOLDER_INPUT_NORMALIZED_KHI,
                           Resources.KHI_COMBINED_RESOURCES_ROOT_ELEMENT,
                           Resources.KHI_COMBINED_RESOURCES_OBJ_ELEMENT,
                           Resources.MAX_FILESIZE_INPUT_RESOURCES_IN_MB);
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khinormalizer.split");
        log.info("FINISH: Split large files from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khinormalizer.split"));
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
    
    public static KhiNormalizer create(){
        return new KhiNormalizer();
    }

}
