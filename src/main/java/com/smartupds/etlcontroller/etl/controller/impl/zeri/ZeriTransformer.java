package com.smartupds.etlcontroller.etl.controller.impl.zeri;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;

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
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_ARTWORKS).listFiles()){
            this.transformFile(file,
                           new File(Resources.MAPPINGS_ZERI_ARTWORKS),
                           new File(Resources.GENERATOR_POLICY_ZERI),
                           new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_ARTWORKS));
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.artworks");
        log.info("FINISH: Transform data from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.artworks"));
        log.info("START: Transform Photographs from Zeri");
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.photographs");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_PHOTOGRAPHS).listFiles()){
            this.transformFile(file,
                           new File(Resources.MAPPINGS_ZERI_PHOTOGRAPHS),
                           new File(Resources.GENERATOR_POLICY_ZERI),
                           new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS));
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.transform.photographs");
        log.info("FINISH: Transform data from Hertziana in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.zeri.zeritransformer.photographs"));
    }
    
    /** Transforms the given resources using X3ML engine.
     * 
     * @param inputFile the XML input file
     * @param mappingsFile the X3ML mapping definition file
     * @param generatorPolicyFile the generator policy file
     * @param outputFolder the folder where the transformed contents will be exported. */
    private void transformFile(File inputFile, File mappingsFile, File generatorPolicyFile, File outputFolder){
        File outputFile=new File(outputFolder.getAbsolutePath()+"/"+inputFile.getName().replace(".xml", ".rdf"));
        X3MLEngineFactory.create()
                         .withInputFiles(inputFile)
                         .withMappings(mappingsFile)
                         .withGeneratorPolicy(generatorPolicyFile)
                         .withOutput(outputFile, X3MLEngineFactory.OutputFormat.RDF_XML)
                         .execute();
    }
    
    public static ZeriTransformer create(){
        return new ZeriTransformer();
    }
 
}
