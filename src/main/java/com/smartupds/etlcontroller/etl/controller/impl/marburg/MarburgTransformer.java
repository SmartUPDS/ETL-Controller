package com.smartupds.etlcontroller.etl.controller.impl.marburg;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngine;
import static gr.forth.ics.isl.x3ml.X3MLEngine.exception;
import gr.forth.ics.isl.x3ml.X3MLGeneratorPolicy;
import gr.forth.ics.isl.x3ml.engine.Generator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import javax.xml.parsers.DocumentBuilderFactory;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Element;

/** Transformer class for resources from Marburg 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class MarburgTransformer implements Transformer{
  @Override
    public void transformResources() throws ETLGenericException {
        try{
            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgtransformer.transform.artworks");
            log.info("START: Transform Artworks from Marburg");
            for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_MARBURG_ARTWORKS),
                               new File(Resources.GENERATOR_POLICY_MARBURG),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgtransformer.transform.artworks");
            log.info("FINISH: Transform Artworks from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgtransformer.transform.artworks"));

//            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgtransformer.transform.photographs");
//            log.info("START: Transform Photographs from Marburg");
//            for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
//                this.transformFile(file,
//                               new File(Resources.MAPPINGS_MARBURG_PHOTOGRAPHS),
//                               new File(Resources.GENERATOR_POLICY_MARBURG),
//                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS));
//            }
//            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgtransformer.transform.photographs");
//            log.info("FINISH: Transform Photographs from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgtransformer.transform.photographs"));
//
//            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgtransformer.transform.l2v");
//            log.info("START: Transform L2V from Marburg");
//            for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG), null, true)){
//                this.transformFile(file,
//                               new File(Resources.MAPPINGS_MARBURG_L2V),
//                               new File(Resources.GENERATOR_POLICY_MARBURG),
//                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_L2V));
//            }
//            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgtransformer.transform.l2v");
//            log.info("FINISH: Transform L2v from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgtransformer.transform.l2v"));
        }catch(FileNotFoundException ex){
            log.error("An error occured while transforming resources",ex);
            throw new ETLGenericException("An error occured while transforming resources",ex);
        }
    }
    
    /** Transforms the given resources using X3ML engine.
     * 
     * @param inputFile the XML input file
     * @param mappingsFile the X3ML mapping definition file
     * @param generatorPolicyFile the generator policy file
     * @param outputFolder the folder where the transformed contents will be exported. */
    private void transformFile(File inputFile, File mappingsFile, File generatorPolicyFile, File outputFolder) throws FileNotFoundException{
        File outputFile=new File(outputFolder.getAbsolutePath()+"/"+inputFile.getName().replace(".xml", ".rdf"));
        log.debug("Transforming resource "+inputFile.getAbsolutePath());
        X3MLEngine engine=X3MLEngine.load(new FileInputStream(mappingsFile));
        Generator policy=X3MLGeneratorPolicy.load(new FileInputStream(generatorPolicyFile), X3MLGeneratorPolicy.createUUIDSource(-1));
        X3MLEngine.Output output = engine.execute(document(inputFile), policy);
        output.writeXML(new PrintStream(outputFile));
    }
    
    private static Element document(File file) {
        try {
            return documentBuilderFactory().newDocumentBuilder().parse(file).getDocumentElement();
        }
        catch (Exception e) {
            throw exception("Unable to parse " + file.getAbsolutePath()+"\n"+e.toString());
        }
    }
    
    private static DocumentBuilderFactory documentBuilderFactory() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory;
    }
    
    public static MarburgTransformer create(){
        return new MarburgTransformer();
    }
}