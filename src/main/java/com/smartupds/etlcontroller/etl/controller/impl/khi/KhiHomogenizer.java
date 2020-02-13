package com.smartupds.etlcontroller.etl.controller.impl.khi;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Homogenizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.FileNotFoundException;
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
            this.checkN3Validity();
        }catch(IOException ex){
            log.error("An error occured while validating N3 resources",ex);
            throw new ETLGenericException("An error occured while validating N3 resources",ex);
        }
    }
    
    private void checkN3Validity() throws FileNotFoundException{
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.actors");
        log.info("START: Check the validity of actors in N3 format from KHI");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ACTORS));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.actors");
        log.info("FINISH: Check the validity of actors in N3 format from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.actors"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks");
        log.info("START: Check the validity of artworks in N3 format from KHI");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks");
        log.info("FINISH: Check the validity of artworks in N3 format from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks.lvl2");
        log.info("START: Check the validity of artworks LVL2 in N3 format from KHI");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL2));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks.lvl2");
        log.info("FINISH: Check the validity of artworks LVL2 in N3 format from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks.lvl2"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks.lvl3");
        log.info("START: Check the validity of artworks LVL3 in N3 format from KHI");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL3));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks.lvl3");
        log.info("FINISH: Check the validity of artworks LVL3 in N3 format from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks.lvl3"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks.lvl4");
        log.info("START: Check the validity of artworks LVL4 in N3 format from KHI");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL4));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks.lvl4");
        log.info("FINISH: Check the validity of artworks LVL4 in N3 format from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.artworks.lvl4"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks");
        log.info("START: Check the validity of builtworks in N3 format from KHI");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks");
        log.info("FINISH: Check the validity of builtworks in N3 format from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks.lvl2");
        log.info("START: Check the validity of builtworks LVL2 in N3 format from KHI");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL2));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks.lvl2");
        log.info("FINISH: Check the validity of builtworks LVL2 in N3 format from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks.lvl2"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks.lvl3");
        log.info("START: Check the validity of builtworks LVL3 in N3 format from KHI");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL3));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks.lvl3");
        log.info("FINISH: Check the validity of builtworks LVL3 in N3 format from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks.lvl3"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks.lvl4");
        log.info("START: Check the validity of builtworks LVL4 in N3 format from KHI");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL4));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks.lvl4");
        log.info("FINISH: Check the validity of builtworks LVL4 in N3 format from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.builtworks.lvl4"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.photographs");
        log.info("START: Check the validity of photographs in N3 format from KHI");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS));
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.photographs");
        log.info("FINISH: Check the validity of photographs in N3 format from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khihomogenizer.checkN3validity.photographs"));
    }

    public static KhiHomogenizer create(){
        return new KhiHomogenizer();
    }
}
