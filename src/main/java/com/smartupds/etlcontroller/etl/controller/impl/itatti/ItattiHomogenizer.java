package com.smartupds.etlcontroller.etl.controller.impl.itatti;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Homogenizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.log4j.Log4j;

/** Itatti Homogenizer 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class ItattiHomogenizer implements Homogenizer{

    @Override
    public void homogenizeResources() throws ETLGenericException {
        try{
            this.consolidateN3Resources();
        }catch(IOException ex){
            log.error("An error occured while consolidating resources",ex);
            throw new ETLGenericException("An error occured while consolidating resources",ex);
        }
        
        log.info("Itatti Homogenization Time: "+Timer.reportHumanFriendly(ItattiHomogenizer.class.toString()));
    }
    
    private void consolidateN3Resources() throws IOException{
        log.info("START: Create consolidated TRIG files for Sharedshelf resources");
        Timer.start(ItattiHomogenizer.class.getCanonicalName()+".consolidate.sharedshelf");
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF), new File(Resources.FOLDER_OUTPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF), Resources.SHAREDSHELF, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF_ULAN), new File(Resources.FOLDER_OUTPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF_ULAN), Resources.SHAREDSHELF, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF_FC_FR), new File(Resources.FOLDER_OUTPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF_FC_FR), Resources.SHAREDSHELF, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_N3);
        Timer.stop(ItattiHomogenizer.class.getCanonicalName()+".consolidate.sharedshelf");
        log.info("FINISH: Create consolidated TRIG files for Sharedshelf resources in "+Timer.reportHumanFriendly(ItattiHomogenizer.class.getCanonicalName()+".consolidate.sharedshelf"));
    } 

    public static ItattiHomogenizer create(){
        return new ItattiHomogenizer();
    }
}
