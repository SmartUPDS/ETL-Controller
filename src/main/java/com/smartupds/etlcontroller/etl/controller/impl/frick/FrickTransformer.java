package com.smartupds.etlcontroller.etl.controller.impl.frick;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;
import org.apache.jena.riot.Lang;

/** Transformer class for resources from FRICK
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class FrickTransformer implements Transformer{

    @Override
    public void transformResources() throws ETLGenericException {
        Timer.start(FrickTransformer.class.getCanonicalName()+".all");
        log.info("START: Transform data from FRICK");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_FRICK).listFiles()){
            String filename_work = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_FRICK_WORK),
                                new File(Resources.GENERATOR_POLICY_FRICK),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK_WORKS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename_work, Lang.TRIG);
            String filename_institution = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_FRICK_INSTITUTION),
                                new File(Resources.GENERATOR_POLICY_FRICK),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK_INSTITUTIONS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename_institution, Lang.TRIG);
        }
        Timer.stop(FrickTransformer.class.getCanonicalName()+".all");
        log.info("FINISH: Transform data from FRICK in "+Timer.reportHumanFriendly(FrickTransformer.class.getCanonicalName()+".all"));
        
        Timer.start(FrickTransformer.class.getCanonicalName()+".all-fc-fr");
        log.info("START: Transform data using FCs FRs from FRICK");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_FRICK).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_FRICK_FC_FR),
                                new File(Resources.GENERATOR_POLICY_FRICK),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK_FC_FR),
                                X3MLEngineFactory.OutputFormat.RDF_XML);
        }
        Timer.stop(FrickTransformer.class.getCanonicalName()+".all-fc-fr");
        log.info("FINISH: Transform data using FCs FRs from FRICK in "+Timer.reportHumanFriendly(FrickTransformer.class.getCanonicalName()+".all-fc-fr"));
        
        log.info("Frick Transformations Time: "+Timer.reportHumanFriendly(FrickTransformer.class.getCanonicalName()));
    }
    
    public static FrickTransformer create(){
        return new FrickTransformer();
    }
}
    