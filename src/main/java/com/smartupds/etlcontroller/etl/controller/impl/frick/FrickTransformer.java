package com.smartupds.etlcontroller.etl.controller.impl.frick;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;

/** Transformer class for resources from FRICK
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class FrickTransformer implements Transformer{

    @Override
    public void transformResources() throws ETLGenericException {
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.frick.fricktransformer.transform");
        log.info("START: Transform data from FRICK");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_FRICK).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_FRICK_ALL),
                                new File(Resources.GENERATOR_POLICY_FRICK),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK_ALL), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.frick.fricktransformer.transform");
        log.info("FINISH: Transform data from FRICK in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.frick.fricktransformer.transform"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.frick.fricktransformer.transform-fc-fr");
        log.info("START: Transform data using FCs FRs from FRICK");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_FRICK).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_FRICK_FC_FR),
                                new File(Resources.GENERATOR_POLICY_FRICK),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK_FC_FR),
                                X3MLEngineFactory.OutputFormat.RDF_XML);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.frick.fricktransformer.transform-fc-fr");
        log.info("FINISH: Transform data using FCs FRs from FRICK in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.frick.fricktransformer.transform-fc-fr"));
    }
    
    public static FrickTransformer create(){
        return new FrickTransformer();
    }
}
    