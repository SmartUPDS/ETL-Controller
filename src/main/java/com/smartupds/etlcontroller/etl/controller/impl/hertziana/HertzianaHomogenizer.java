package com.smartupds.etlcontroller.etl.controller.impl.hertziana;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Homogenizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.IOException;
import lombok.extern.log4j.Log4j;

/** Hertziana Homogenizer 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class HertzianaHomogenizer implements Homogenizer{

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
    
    private void consolidateN3Resources() throws IOException{
        log.info("START: Create consolidated TRIG and N3 files for Hertzianna resources");
        Timer.start(HertzianaHomogenizer.class.getCanonicalName()+".consolidate");
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ACTORS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ACTORS), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ARTWORKS), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL2), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ARTWORKS_LVL2), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL3), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ARTWORKS_LVL3), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL4), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ARTWORKS_LVL4), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_BUILTWORKS), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL2), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_BUILTWORKS_LVL2), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL3), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_BUILTWORKS_LVL3), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL4), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_BUILTWORKS_LVL4), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_PHOTOGRAPHS), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_FC_FR), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ARTWORKS_FC_FR), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_N3);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_FC_FR), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_BUILTWORKS_FC_FR), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_N3);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS_FC_FR), new File(Resources.FOLDER_OUTPUT_NORMALIZED_HERTZIANA_PHOTOGRAPHS_FC_FR), Resources.HERTZIANA, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_N3);
        Timer.stop(HertzianaHomogenizer.class.getCanonicalName()+".consolidate");
        log.info("FINISH: Create consolidated TRIG and N3 files for Hertzianna resources in "+Timer.reportHumanFriendly(HertzianaHomogenizer.class.getCanonicalName()+".consolidate.sharedshelf"));
    } 

    public static HertzianaHomogenizer create(){
        return new HertzianaHomogenizer();
    }
}
