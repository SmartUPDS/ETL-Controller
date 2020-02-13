package com.smartupds.etlcontroller.etl.controller.impl.zeri;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Homogenizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.FileNotFoundException;
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
        }catch(FileNotFoundException ex){
            log.error("An error occured while validating N3 resources",ex);
            throw new ETLGenericException("An error occured while validating N3 resources",ex);
        }
    }

    public static ZeriHomogenizer create(){
        return new ZeriHomogenizer();
    }
}
