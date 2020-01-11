package com.smartupds.etlcontroller.etl.controller.impl.itatti;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;

/** Transformer class for resources from Villa I Tatti
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class ItattiTransformer implements Transformer {

     @Override
    public void transformResources() throws ETLGenericException {
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.itatti.itattitransformer.transform");
        log.info("START: Transform data from Villa I Tatti");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI).listFiles()){
            this.transformFile(file,
                           new File(Resources.MAPPINGS_VILLA_I_TATTI),
                           new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI),
                           new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI));
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.itatti.itattitransformer.transform");
        log.info("FINISH: Transform data from Villa I Tatti in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.itatti.itattitransformer.transform"));
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
    
    public static ItattiTransformer create(){
        return new ItattiTransformer();
    }
    
}
