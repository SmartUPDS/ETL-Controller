package com.smartupds.etlcontroller.etl.controller.impl.khi;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Homogenizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
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
            Timer.start(KhiHomogenizer.class+".actors");
            log.info("START: Check the validity of actors in N3 format from KHI");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ACTORS));
            Timer.stop(KhiHomogenizer.class+".actors");
            log.info("FINISH: Check the validity of actors in N3 format from KHI in "+Timer.reportHumanFriendly(KhiHomogenizer.class+".actors"));

            Timer.start(KhiHomogenizer.class+".artworks");
            log.info("START: Check the validity of artworks in N3 format from KHI");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS));
            Timer.stop(KhiHomogenizer.class+".artworks");
            log.info("FINISH: Check the validity of artworks in N3 format from KHI in "+Timer.reportHumanFriendly(KhiHomogenizer.class+".artworks"));

            Timer.start(KhiHomogenizer.class+".artworks-lv2");
            log.info("START: Check the validity of artworks LVL2 in N3 format from KHI");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL2));
            Timer.stop(KhiHomogenizer.class+".artworks-lv2");
            log.info("FINISH: Check the validity of artworks LVL2 in N3 format from KHI in "+Timer.reportHumanFriendly(KhiHomogenizer.class+".artworks-lv2"));

            Timer.start(KhiHomogenizer.class+".artworks-lv3");
            log.info("START: Check the validity of artworks LVL3 in N3 format from KHI");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL3));
            Timer.stop(KhiHomogenizer.class+".artworks-lv3");
            log.info("FINISH: Check the validity of artworks LVL3 in N3 format from KHI in "+Timer.reportHumanFriendly(KhiHomogenizer.class+".artworks-lv3"));

            Timer.start(KhiHomogenizer.class+".artworks-lv4");
            log.info("START: Check the validity of artworks LVL4 in N3 format from KHI");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL4));
            Timer.stop(KhiHomogenizer.class+".artworks-lv4");
            log.info("FINISH: Check the validity of artworks LVL4 in N3 format from KHI in "+Timer.reportHumanFriendly(KhiHomogenizer.class+".artworks-lv4"));

            Timer.start(KhiHomogenizer.class+".builtworks");
            log.info("START: Check the validity of builtworks in N3 format from KHI");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS));
            Timer.stop(KhiHomogenizer.class+".builtworks");
            log.info("FINISH: Check the validity of builtworks in N3 format from KHI in "+Timer.reportHumanFriendly(KhiHomogenizer.class+".builtworks"));

            Timer.start(KhiHomogenizer.class+".builtworks-lv2");
            log.info("START: Check the validity of builtworks LVL2 in N3 format from KHI");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL2));
            Timer.stop(KhiHomogenizer.class+".builtworks-lv2");
            log.info("FINISH: Check the validity of builtworks LVL2 in N3 format from KHI in "+Timer.reportHumanFriendly(KhiHomogenizer.class+".builtworks-lv2"));

            Timer.start(KhiHomogenizer.class+".builtworks-lv3");
            log.info("START: Check the validity of builtworks LVL3 in N3 format from KHI");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL3));
            Timer.stop(KhiHomogenizer.class+".builtworks-lv3");
            log.info("FINISH: Check the validity of builtworks LVL3 in N3 format from KHI in "+Timer.reportHumanFriendly(KhiHomogenizer.class+".builtworks-lv3"));

            Timer.start(KhiHomogenizer.class+".builtworks-lv4");
            log.info("START: Check the validity of builtworks LVL4 in N3 format from KHI");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL4));
            Timer.stop(KhiHomogenizer.class+".builtworks-lv4");
            log.info("FINISH: Check the validity of builtworks LVL4 in N3 format from KHI in "+Timer.reportHumanFriendly(KhiHomogenizer.class+".builtworks-lv4"));

            Timer.start(KhiHomogenizer.class+".photographs");
            log.info("START: Check the validity of photographs in N3 format from KHI");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS));
            Timer.stop(KhiHomogenizer.class+".photographs");
            log.info("FINISH: Check the validity of photographs in N3 format from KHI in "+Timer.reportHumanFriendly(KhiHomogenizer.class+".photographs"));
        }catch(IOException ex){
            log.error("An error occured while validating N3 resources",ex);
            throw new ETLGenericException("An error occured while validating N3 resources",ex);
        }
        log.info("KHI Homogenization Time: "+Timer.reportHumanFriendly(KhiHomogenizer.class.toString()));
    }
    
    public static KhiHomogenizer create(){
        return new KhiHomogenizer();
    }
}
