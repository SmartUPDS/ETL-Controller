package com.smartupds.etlcontroller.etl.controller.impl.khi;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;

/** Transformer class for resources from KHI 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class KhiTransformer implements Transformer {

    @Override
    public void transformResources() throws ETLGenericException {
        Timer.start(KhiTransformer.class.getCanonicalName()+".artworks");
        log.info("START: Transform artworks from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_ARTWORKS),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".artworks");
        log.info("FINISH: Transform artworks from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".artworks"));

        Timer.start(KhiTransformer.class.getCanonicalName()+".artworks-lv2");
        log.info("START: Transform artworks LVL2 from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_ARTWORKS_LVL2),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL2),
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".artworks-lv2");
        log.info("FINISH: Transform artworks from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".artworks-lv2"));

        Timer.start(KhiTransformer.class.getCanonicalName()+".artworks-lv3");
        log.info("START: Transform artworks LVL3 from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_ARTWORKS_LVL3),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL3),
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".artworks-lv3");
        log.info("FINISH: Transform artworks from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".artworks-lv3"));            

        Timer.start(KhiTransformer.class.getCanonicalName()+".artworks-lv4");
        log.info("START: Transform artworks LVL4 from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_ARTWORKS_LVL4),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL4), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".artworks-lv4");
        log.info("FINISH: Transform artworks from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".artworks-lv4"));
        
        Timer.start(KhiTransformer.class.getCanonicalName()+".builtworks");
        log.info("START: Transform Builtworks from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_BUILTWORKS),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS),
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".builtworks");
        log.info("FINISH: Transform Builtworks from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".builtworks"));

        Timer.start(KhiTransformer.class.getCanonicalName()+".builtworks-lv2");
        log.info("START: Transform Builtworks LVL2 from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_BUILTWORKS_LVL2),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL2), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".builtworks-lv2");
        log.info("FINISH: Transform Builtworks from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".builtworks-lv2"));

        Timer.start(KhiTransformer.class.getCanonicalName()+".builtworks-lv3");
        log.info("START: Transform Builtworks LVL3 from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_BUILTWORKS_LVL3),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL3), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".builtworks-lv3");
        log.info("FINISH: Transform Builtworks from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".builtworks-lv3"));
        
        Timer.start(KhiTransformer.class.getCanonicalName()+".builtworks-lv4");
        log.info("START: Transform Builtworks LVL4 from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_BUILTWORKS_LVL4),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL4), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".builtworks-lv4");
        log.info("FINISH: Transform Builtworks from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".builtworks-lv4"));

        Timer.start(KhiTransformer.class.getCanonicalName()+".photographs");
        log.info("START: Transform photographs from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_PHOTOGRAPHS),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".photographs");
        log.info("FINISH: Transform photographs from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".photographs"));

        Timer.start(KhiTransformer.class.getCanonicalName()+".actors");
        log.info("START: Transform Actors from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_ACTORS),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ACTORS),
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".actors");
        log.info("FINISH: Transform Builtworks from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".actors"));
        
        Timer.start(KhiTransformer.class.getCanonicalName()+".photographs-fc-fr");
        log.info("START: Transform photographs using FCs FRs from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_PHOTOGRAPHS_FC_FR),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".photographs-fc-fr");
        log.info("FINISH: Transform photographs using FCs FRs from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".photographs-fc-fr"));
        
        Timer.start(KhiTransformer.class.getCanonicalName()+".works-fc-fr");
        log.info("START: Transform Works using FCs FRs from KHI");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_KHI_WORKS_FC_FR),
                                new File(Resources.GENERATOR_POLICY_KHI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_WORKS_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(KhiTransformer.class.getCanonicalName()+".works-fc-fr");
        log.info("FINISH: Transform Works using FCs FRs from KHI in "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()+".works-fc-fr"));
        
        log.info("KHI Transformations Time: "+Timer.reportHumanFriendly(KhiTransformer.class.getCanonicalName()));
    }
    
    public static KhiTransformer create(){
        return new KhiTransformer();
    }
}
