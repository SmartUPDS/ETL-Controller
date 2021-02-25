package com.smartupds.etlcontroller.etl.controller.impl.khi;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Homogenizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.impl.hertziana.HertzianaHomogenizer;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.IOException;
import lombok.extern.log4j.Log4j;

/** KHI Homogenizer 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class KhiHomogenizer implements Homogenizer{

        @Override
    public void homogenizeResources() throws ETLGenericException {
        try{
            this.consolidateN3Resources();
        }catch(IOException ex){
            log.error("An error occured while consolidating resources",ex);
            throw new ETLGenericException("An error occured while consolidating resources",ex);
        }
        
        log.info("Itatti Homogenization Time: "+Timer.reportHumanFriendly(HertzianaHomogenizer.class.toString()));
    }
    
    public void consolidateN3Resources() throws IOException {
        log.info("START: Create consolidated TRIG and N3 files for KHI resources");
        Timer.start(KhiHomogenizer.class.getCanonicalName()+".consolidate");
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ACTORS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_ACTORS), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_ARTWORKS), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL2), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_ARTWORKS_LVL2), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL3), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_ARTWORKS_LVL3), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL4), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_ARTWORKS_LVL4), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_BUILTWORKS), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL2), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_BUILTWORKS_LVL2), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL3), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_BUILTWORKS_LVL3), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL4), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_BUILTWORKS_LVL4), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_PHOTOGRAPHS), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_FC_FR), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_ARTWORKS_FC_FR), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_N3);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_FC_FR), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_BUILTWORKS_FC_FR), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_N3);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS_FC_FR), new File(Resources.FOLDER_OUTPUT_NORMALIZED_KHI_PHOTOGRAPHS_FC_FR), Resources.KHI, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_N3);
        Timer.stop(KhiHomogenizer.class.getCanonicalName()+".consolidate");
        log.info("FINISH: Create consolidated TRIG and N3 files for KHI resources in "+Timer.reportHumanFriendly(KhiHomogenizer.class.getCanonicalName()+".consolidate"));
    }
    
    public static KhiHomogenizer create(){
        return new KhiHomogenizer();
    }
}
