package com.smartupds.etlcontroller.etl.controller.impl.hertziana;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;

/** Transformer class for resources from Hertziana 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class HertzianaTransformer implements Transformer {

    @Override
    public void transformResources() throws ETLGenericException {
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworks");
        log.info("START: Transform artworks from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ARTWORKS),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworks");
        log.info("FINISH: Transform artworks from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworks"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworkslvl2");
        log.info("START: Transform artworks LVL2 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ARTWORKS_LVL2),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL2), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworkslvl2");
        log.info("FINISH: Transform artworks from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworkslvl2"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworkslvl3");
        log.info("START: Transform artworks LVL3 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ARTWORKS_LVL3),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL3), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworkslvl3");
        log.info("FINISH: Transform artworks from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworkslvl3"));            

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworkslvl4");
        log.info("START: Transform artworks LVL4 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ARTWORKS_LVL4),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL4), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworkslvl4");
        log.info("FINISH: Transform artworks from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.artworkslvl4"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworks");
        log.info("START: Transform Builtworks from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_BUILTWORKS),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworks");
        log.info("FINISH: Transform Builtworks from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworks"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworkslvl2");
        log.info("START: Transform Builtworks LVL2 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_BUILTWORKS_LVL2),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL2), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworkslvl2");
        log.info("FINISH: Transform Builtworks from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworkslvl2"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworkslvl3");
        log.info("START: Transform Builtworks LVL3 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_BUILTWORKS_LVL3),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL3), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworkslvl3");
        log.info("FINISH: Transform Builtworks from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworkslvl3"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworkslvl4");
        log.info("START: Transform Builtworks LVL4 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_BUILTWORKS_LVL4),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL4), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworkslvl4");
        log.info("FINISH: Transform Builtworks from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.builtworkslvl4"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.photographs");
        log.info("START: Transform photographs from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_PHOTOGRAPHS),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.photographs");
        log.info("FINISH: Transform photographs from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.photographs"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.actors");
        log.info("START: Transform Actors from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ACTORS),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ACTORS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.actors");
        log.info("FINISH: Transform Builtworks from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.actors"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.photographs-fc-fr");
        log.info("START: Transform Photographs using FCs FRs from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_PHOTOGRAPHS_FC_FR),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS_FC_FR), 
                                X3MLEngineFactory.OutputFormat.RDF_XML);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.photographs-fc-fr");
        log.info("FINISH: Transform Photographs using FCs FRs from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.photographs-fc-fr"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.works-fc-fr");
        log.info("START: Transform Works using FCs FRs from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_WORKS_FC_FR),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_WORKS_FC_FR), 
                                X3MLEngineFactory.OutputFormat.RDF_XML);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.works-fc-fr");
        log.info("FINISH: Transform Works using FCs FRs from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.hertziana.hertzianatransformer.transform.works-fc-fr"));
    }
     
    public static HertzianaTransformer create(){
        return new HertzianaTransformer();
    }
 
}
