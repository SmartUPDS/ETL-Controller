package com.smartupds.etlcontroller.etl.controller.impl.marburg;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;

/** Transformer class for resources from Marburg 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class MarburgTransformer implements Transformer{
  @Override
    public void transformResources() throws ETLGenericException {
        Timer.start(MarburgTransformer.class.getCanonicalName()+".artworks");
        log.info("START: Transform Artworks from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_ARTWORKS),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".artworks");
        log.info("FINISH: Transform Artworks from Marburg in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".artworks"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".artworks-lv2");
        log.info("START: Transform Artworks LVL2 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_ARTWORKS_LVL2),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL2), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".artworks-lv2");
        log.info("FINISH: Transform Artworks from Marburg in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".artworks-lv2"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".artworks-lv3");
        log.info("START: Transform Artworks LVL3 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_ARTWORKS_LVL3),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL3), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".artworks-lv3");
        log.info("FINISH: Transform Artworks from Marburg in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".artworks-lv3"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".artworks-lv4");
        log.info("START: Transform Artworks LVL4 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_ARTWORKS_LVL4),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL4), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".artworks-lv4");
        log.info("FINISH: Transform Artworks from Marburg in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".artworks-lv4"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".builtworks");
        log.info("START: Transform Builtworks from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_BUILTWORKS),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".builtworks");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".builtworks"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".builtworks-lv2");
        log.info("START: Transform Builtworks LVL2 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_BUILTWORKS_LVL2),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL2), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".builtworks-lv2");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".builtworks-lv2"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".builtworks-lv3");
        log.info("START: Transform Builtworks LVL3 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_BUILTWORKS_LVL3),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL3), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".builtworks-lv3");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".builtworks-lv3"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".builtworks-lv4");
        log.info("START: Transform Builtworks LVL4 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_BUILTWORKS_LVL4),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL4), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".builtworks-lv4");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".builtworks-lv4"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".photographs");
        log.info("START: Transform Photographs from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_PHOTOGRAPHS),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".photographs");
        log.info("FINISH: Transform Photographs from Marburg in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".photographs"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".actors");
        log.info("START: Transform Actors from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            String filename =   Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_ACTORS),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ACTORS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".actors");
        log.info("FINISH: Transform Actors from Marburg in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".actors"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".works-fc-fr");
        log.info("START: Transform Works from Marburg using FCs FRs");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_WORKS_FC_FR),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_WORKS_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".works-fc-fr");
        log.info("FINISH: Transform Works from Marburg using FCs FRs in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".works-fc-fr"));

        Timer.start(MarburgTransformer.class.getCanonicalName()+".photographs-fc-fr");
        log.info("START: Transform Photographs from Marburg using FCs FRs");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MARBURG_PHOTOGRAPHS_FC_FR),
                                new File(Resources.GENERATOR_POLICY_MARBURG),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(MarburgTransformer.class.getCanonicalName()+".photographs-fc-fr");
        log.info("FINISH: Transform Works from Marburg using FCs FRs in "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()+".photographs-fc-fr"));
        
        log.info("Marburg Transformations Time: "+Timer.reportHumanFriendly(MarburgTransformer.class.getCanonicalName()));
    }
    
    public static MarburgTransformer create(){
        return new MarburgTransformer();
    }
}