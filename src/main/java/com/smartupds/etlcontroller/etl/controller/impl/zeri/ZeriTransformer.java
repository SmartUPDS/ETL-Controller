package com.smartupds.etlcontroller.etl.controller.impl.zeri;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;

/** Transformer class for resources from Zeri 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class ZeriTransformer implements Transformer {

    @Override
    public void transformResources() throws ETLGenericException {
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.artworks");
        log.info("START: Transform Artworks from Zeri");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_ARTWORKS), null, true)){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_ZERI_ARTWORKS),
                                new File(Resources.GENERATOR_POLICY_ZERI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_ARTWORKS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.artworks");
        log.info("FINISH: Transform artworks from Zeri in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.artworks"));
        
        log.info("START: Transform Photographs from Zeri");
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.photographs");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_PHOTOGRAPHS), null, true)){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_ZERI_PHOTOGRAPHS),
                                new File(Resources.GENERATOR_POLICY_ZERI),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.photographs");
        log.info("FINISH: Transform photographs from Zeri in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.photographs"));
        
        log.info("START: Transform Photographs using FCs FRs from Zeri");
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.photographs-fc-fr");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_PHOTOGRAPHS), null, true)){
            Utils.transformFile(file,
                           new File(Resources.MAPPINGS_ZERI_PHOTOGRAPHS_FC_FR),
                           new File(Resources.GENERATOR_POLICY_ZERI),
                           new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS_FC_FR), 
                           X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.photographs-fc-fr");
        log.info("FINISH: Transform photographs using FCs FRs from Zeri in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.photographs-fc-fr"));
        
        log.info("START: Transform Works using FCs FRs from Zeri");
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.works-fc-fr");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_ARTWORKS), null, true)){
            Utils.transformFile(file,
                           new File(Resources.MAPPINGS_ZERI_WORKS_FC_FR),
                           new File(Resources.GENERATOR_POLICY_ZERI),
                           new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_WORKS_FC_FR), 
                           X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.works-fc-fr");
        log.info("FINISH: Transform Works using FCs FRs from Zeri in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.works-fc-fr"));
    }
    
    public static ZeriTransformer create(){
        return new ZeriTransformer();
    }       
}
