package com.smartupds.etlcontroller.etl.controller.impl.marburg;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Homogenizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.IOException;
import lombok.extern.log4j.Log4j;

/** Marburg Homogenizer 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class MarburgHomogenizer implements Homogenizer{

    @Override
    public void homogenizeResources() throws ETLGenericException {
        try{
            this.consolidateN3Resources();
        }catch(IOException ex){
            log.error("An error occured while consolidating resources",ex);
            throw new ETLGenericException("An error occured while consolidating resources",ex);
        }
        
        log.info("Itatti Homogenization Time: "+Timer.reportHumanFriendly(MarburgHomogenizer.class.toString()));
    }
    
    private void consolidateN3Resources() throws IOException{
        log.info("START: Create consolidated TRIG and N3 files for Marburg resources");
        Timer.start(MarburgHomogenizer.class.getCanonicalName()+".consolidate");
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ACTORS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_ACTORS), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_ARTWORKS), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL2), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_ARTWORKS_LVL2), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL2), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_ARTWORKS_LVL3), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL4), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_ARTWORKS_LVL4), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_BUILTWORKS), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL2), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_BUILTWORKS_LVL2), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL3), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_BUILTWORKS_LVL3), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL4), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_BUILTWORKS_LVL4), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS_FC_FR), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_PHOTOGRAPHS_FC_FR), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_N3);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_WORKS_FC_FR), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MARBURG_WORKS_FC_FR), Resources.MARBURG, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_N3);
        
        Timer.stop(MarburgHomogenizer.class.getCanonicalName()+".consolidate");
        log.info("FINISH: Create consolidated TRIG and N3 files for Marburg resources in "+Timer.reportHumanFriendly(MarburgHomogenizer.class.getCanonicalName()+".consolidate"));
    } 

    public static MarburgHomogenizer create(){
        return new MarburgHomogenizer();
    }
}
