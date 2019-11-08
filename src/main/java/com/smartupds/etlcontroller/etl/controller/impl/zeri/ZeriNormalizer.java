package com.smartupds.etlcontroller.etl.controller.impl.zeri;

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
import org.xml.sax.SAXException;

/** Normalizer for input sources from Zeri
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class ZeriNormalizer implements Normalizer{

    @Override
    public void normalizeResources() throws ETLGenericException {
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.zerinormalizer.unzip");
        log.info("START: Unzip Artworks from Zeri");
        String artworksFolder=Resources.FOLDER_INPUT_NORMALIZED_ZERI+"/"+Resources.ZERI_ARTWORKS_ZIP_FILENAME.replace(".zip", "");
        new File(artworksFolder).mkdir();
        this.unzipFiles(new File(Resources.FOLDER_INPUT_FETCHED_ZERI+"/"+Resources.ZERI_ARTWORKS_ZIP_FILENAME),new File(artworksFolder));
        String photographsFolder=Resources.FOLDER_INPUT_NORMALIZED_ZERI+"/"+Resources.ZERI_PHOTOGRAPHS_ZIP_FILENAME.replace(".zip", "");
        new File(artworksFolder).mkdir();
        this.unzipFiles(new File(Resources.FOLDER_INPUT_FETCHED_ZERI+"/"+Resources.ZERI_PHOTOGRAPHS_ZIP_FILENAME),new File(artworksFolder));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zerinormalizer.unzip");
        log.info("FINISH: Unzip Artworks from Zeri in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zerinormalizer.unzip"));
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
        File destFile = new File(destinationDir, zipEntry.getName());
        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();
         
        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }
        return destFile;
    }
    
    public static ZeriNormalizer create(){
        return new ZeriNormalizer();
    }

}
