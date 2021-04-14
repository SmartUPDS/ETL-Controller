package com.smartupds.etlcontroller.etl.controller.impl.hertziana;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;
import org.apache.jena.riot.Lang;

/** Transformer class for resources from Hertziana 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class HertzianaTransformer implements Transformer {

    @Override
    public void transformResources() throws ETLGenericException {
        Timer.start(HertzianaTransformer.class.getCanonicalName()+".artworks");
        log.info("START: Transform artworks from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ARTWORKS),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);

        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".artworks");
        log.info("FINISH: Transform artworks from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".artworks"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".artworks-lv2");
        log.info("START: Transform artworks LVL2 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ARTWORKS_LVL2),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL2), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);

        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".artworks-lv2");
        log.info("FINISH: Transform artworks from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".artworks-lv2"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".artworks-lv3");
        log.info("START: Transform artworks LVL3 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ARTWORKS_LVL3),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL3), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);

        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".artworks-lv3");
        log.info("FINISH: Transform artworks from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".artworks-lv3"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".artworks-lv4");
        log.info("START: Transform artworks LVL4 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ARTWORKS_LVL4),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL4), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);

        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".artworks-lv4");
        log.info("FINISH: Transform artworks from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".artworks-lv4"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".builtworks");
        log.info("START: Transform Builtworks from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_BUILTWORKS),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);
        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".builtworks");
        log.info("FINISH: Transform Builtworks from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".builtworks"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".builtworks-lv2");
        log.info("START: Transform Builtworks LVL2 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_BUILTWORKS_LVL2),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL2), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);
        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".builtworks-lv2");
        log.info("FINISH: Transform Builtworks from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".builtworks-lv2"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".builtworks-lv3");
        log.info("START: Transform Builtworks LVL3 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_BUILTWORKS_LVL3),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL3), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);
        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".builtworks-lv3");
        log.info("FINISH: Transform Builtworks from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".builtworks-lv3"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".builtworks-lv4");
        log.info("START: Transform Builtworks LVL4 from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_BUILTWORKS_LVL4),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL4), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);
        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".builtworks-lv4");
        log.info("FINISH: Transform Builtworks from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".builtworks-lv4"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".photographs");
        log.info("START: Transform photographs from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_PHOTOGRAPHS),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);
        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".photographs");
        log.info("FINISH: Transform photographs from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".photographs"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".actors");
        log.info("START: Transform Actors from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ACTORS),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ACTORS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);
        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".actors");
        log.info("FINISH: Transform Builtworks from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".actors"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".photographs-fc-fr");
        log.info("START: Transform Photographs using FCs FRs from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_PHOTOGRAPHS_FC_FR),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".photographs-fc-fr");
        log.info("FINISH: Transform Photographs using FCs FRs from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".photographs-fc-fr"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".artworks-fc-fr");
        log.info("START: Transform Artorks using FCs FRs from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_ARTWORKS_FC_FR),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".artworks-fc-fr");
        log.info("FINISH: Transform Artworks using FCs FRs from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".artworks-fc-fr"));

        Timer.start(HertzianaTransformer.class.getCanonicalName()+".buildworks-fc-fr");
        log.info("START: Transform Buildworks using FCs FRs from Hertziana");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_HERTZIANA_BUILTWORKS_FC_FR),
                                new File(Resources.GENERATOR_POLICY_HERTZIANA),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(HertzianaTransformer.class.getCanonicalName()+".buildworks-fc-fr");
        log.info("FINISH: Transform Buildworks using FCs FRs from Hertziana in "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()+".buildworks-fc-fr"));
        
        log.info("Hertziana Transformations Time: "+Timer.reportHumanFriendly(HertzianaTransformer.class.getCanonicalName()));
    }
     
    public static HertzianaTransformer create(){
        return new HertzianaTransformer();
    }
 
}
