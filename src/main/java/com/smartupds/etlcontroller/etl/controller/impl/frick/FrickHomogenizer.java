package com.smartupds.etlcontroller.etl.controller.impl.frick;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Homogenizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.IOException;
import lombok.extern.log4j.Log4j;

/** Frick Homogenizer 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class FrickHomogenizer implements Homogenizer{

    @Override
    public void homogenizeResources() throws ETLGenericException {
        try{
            log.info("START: Check the validity of transformed resources in N3 format from FRICK");
            Timer.start(FrickHomogenizer.class+".n3validation");
            Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK_ALL));
            Timer.stop(FrickHomogenizer.class+".n3validation");
            log.info("FINISH: Check the validity of transformed resources in N3 format from FRICK in "+Timer.reportHumanFriendly(FrickHomogenizer.class+".n3validation"));
            
            log.info("Frick Homogenization Time: "+Timer.reportHumanFriendly(FrickHomogenizer.class.toString()));
        }catch(IOException ex){
            log.error("An error occured while validating N3 resources",ex);
            throw new ETLGenericException("An error occured while validating N3 resources",ex);
        }
    }
    
    public static FrickHomogenizer create(){
        return new FrickHomogenizer();
    }
}
