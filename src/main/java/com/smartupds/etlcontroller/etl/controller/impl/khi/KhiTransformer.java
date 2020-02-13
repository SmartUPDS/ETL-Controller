package com.smartupds.etlcontroller.etl.controller.impl.khi;

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
import org.w3c.dom.Element;

/** Transformer class for resources from KHI 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class KhiTransformer implements Transformer {

    @Override
    public void transformResources() throws ETLGenericException {
        try{
            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworks");
            log.info("START: Transform artworks from KHI");
            for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_KHI_ARTWORKS),
                               new File(Resources.GENERATOR_POLICY_KHI),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworks");
            log.info("FINISH: Transform artworks from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworks"));
            
            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworkslvl2");
            log.info("START: Transform artworks LVL2 from KHI");
            for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_KHI_ARTWORKS_LVL2),
                               new File(Resources.GENERATOR_POLICY_KHI),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL2));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworkslvl2");
            log.info("FINISH: Transform artworks from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworkslvl2"));
            
            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworkslvl3");
            log.info("START: Transform artworks LVL3 from KHI");
            for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_KHI_ARTWORKS_LVL3),
                               new File(Resources.GENERATOR_POLICY_KHI),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL3));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworkslvl3");
            log.info("FINISH: Transform artworks from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworkslvl3"));            
            
            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworkslvl4");
            log.info("START: Transform artworks LVL4 from KHI");
            for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_KHI_ARTWORKS_LVL4),
                               new File(Resources.GENERATOR_POLICY_KHI),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL4));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworkslvl4");
            log.info("FINISH: Transform artworks from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.artworkslvl4"));
            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworks");
            log.info("START: Transform Builtworks from KHI");
            for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_KHI_BUILTWORKS),
                               new File(Resources.GENERATOR_POLICY_KHI),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworks");
            log.info("FINISH: Transform Builtworks from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworks"));

            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworkslvl2");
            log.info("START: Transform Builtworks LVL2 from KHI");
            for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_KHI_BUILTWORKS_LVL2),
                               new File(Resources.GENERATOR_POLICY_KHI),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL2));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworkslvl2");
            log.info("FINISH: Transform Builtworks from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworkslvl2"));

            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworkslvl3");
            log.info("START: Transform Builtworks LVL3 from KHI");
            for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_KHI_BUILTWORKS_LVL3),
                               new File(Resources.GENERATOR_POLICY_KHI),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL3));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworkslvl3");
            log.info("FINISH: Transform Builtworks from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworkslvl3"));
            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworkslvl4");
            log.info("START: Transform Builtworks LVL4 from KHI");
            for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_KHI_BUILTWORKS_LVL4),
                               new File(Resources.GENERATOR_POLICY_KHI),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL4));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworkslvl4");
            log.info("FINISH: Transform Builtworks from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.builtworkslvl4"));
            
            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.photographs");
            log.info("START: Transform photographs from KHI");
            for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_KHI_PHOTOGRAPHS),
                               new File(Resources.GENERATOR_POLICY_KHI),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.photographs");
            log.info("FINISH: Transform photographs from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.photographs"));

            
            Timer.start("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.actors");
            log.info("START: Transform Actors from KHI");
            for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).listFiles()){
                this.transformFile(file,
                               new File(Resources.MAPPINGS_KHI_ACTORS),
                               new File(Resources.GENERATOR_POLICY_KHI),
                               new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ACTORS));
            }
            Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.actors");
            log.info("FINISH: Transform Builtworks from KHI in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.khi.khitransformer.transform.actors"));
            
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
        File outputFile=new File(outputFolder.getAbsolutePath()+"/"+inputFile.getName().replace(".xml", ".n3"));
        log.debug("Transforming resource "+inputFile.getAbsolutePath());
        X3MLEngine engine=X3MLEngine.load(new FileInputStream(mappingsFile));
        Generator policy=X3MLGeneratorPolicy.load(new FileInputStream(generatorPolicyFile), X3MLGeneratorPolicy.createUUIDSource(-1));
        X3MLEngine.Output output = engine.execute(document(inputFile), policy);
        output.write(new PrintStream(outputFile),"application/n-triples");
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
    
    public static KhiTransformer create(){
        return new KhiTransformer();
    }
 
}
