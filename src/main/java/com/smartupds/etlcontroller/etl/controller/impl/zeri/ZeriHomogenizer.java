package com.smartupds.etlcontroller.etl.controller.impl.zeri;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Homogenizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.log4j.Log4j;

/** Zeri Homogenizer 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class ZeriHomogenizer implements Homogenizer{

    @Override
    public void homogenizeResources() throws ETLGenericException {
        try{
            this.checkN3Validity();
            this.consolidateN3Resources();
        }catch(IOException ex){
            log.error("An error occured while validating N3 resources",ex);
            throw new ETLGenericException("An error occured while validating N3 resources",ex);
        }
    }
    
    private void checkN3Validity() throws FileNotFoundException{
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.checkN3validity.artworks");
        log.info("START: Check the validity of artworks in N3 format from Zeri");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_ARTWORKS));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.checkN3validity.artworks");
        log.info("FINISH: Check the validity of artworks in N3 format from Zeri in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.checkN3validity.artworks"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.checkN3validity.photographs");
        log.info("START: Check the validity of photographs in N3 format from Zeri");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.checkN3validity.photographs");
        log.info("FINISH: Check the validity of photographs in N3 format from Zeri in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.checkN3validity.photographs"));           
    }
    
    private void consolidateN3Resources() throws IOException{
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.N3consolidation.artworks");
        log.info("START: Create consolidated N3 files for Zeri artworks");
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_ARTWORKS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_ZERI_ARTWORKS), Resources.ARTWORKS, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB);
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.N3consolidation.artworks");
        log.info("FINISH: Create consolidated N3 files for Zeri artworks in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.N3consolidation.artworks"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.N3consolidation.photographs");
        log.info("START: Create consolidated N3 files for Zeri photographs");
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_ZERI_PHOTOGRAPHS), Resources.PHOTOGRAPHS, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB);
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.N3consolidation.photographs");
        log.info("FINISH: Create consolidated N3 files for Zeri photographs in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zeri.zerihomogenizer.N3consolidation.photographs"));
    } 

    public static ZeriHomogenizer create(){
        return new ZeriHomogenizer();
    }
}
