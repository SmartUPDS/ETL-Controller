package com.smartupds.etlcontroller.etl.controller.impl.itatti;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;
import org.apache.jena.riot.Lang;

/** Transformer class for resources from Villa I Tatti
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class ItattiTransformerFCFR implements Transformer {

    @Override
    public void transformResources() throws ETLGenericException {
        Timer.start(ItattiTransformer.class.getCanonicalName()+".sharedshelf");
        log.info("START: Transform SharedShelf data from Villa I Tatti");
        
        Timer.start(ItattiTransformerFCFR.class.getCanonicalName()+".sharedshelf-fc-fr");
        log.info("START: Transform SharedShelf data using FCs FRs from Villa I Tatti");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_VILLA_I_TATTI_SHAREDSHELF_FC_FR),
                                new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_SHAREDSHELF),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(ItattiTransformerFCFR.class.getCanonicalName()+".sharedshelf-fc-fr");
        log.info("FINISH: Transform SharedShelf data using FCs FRs from Villa I Tatti in "+Timer.reportHumanFriendly(ItattiTransformerFCFR.class.getCanonicalName()+".sharedshelf-fc-fr"));
        
        Timer.start(ItattiTransformerFCFR.class.getCanonicalName()+".fotoindex-fc-fr");
        log.info("START: Transform FotoIndex data using FCs FRs from Villa I Tatti");
        for(File inputFile : new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_FOTOINDEX).listFiles()){
            Utils.transformFile(inputFile,
                                new File(Resources.MAPPINGS_VILLA_I_TATTI_FOTOINDEX_FC_FR), 
                                new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_FOTOINDEX), 
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(ItattiTransformerFCFR.class.getCanonicalName()+".fotoindex-fc-fr");
        log.info("FINISH: Transform FotoIndex using FCs FRs data from Villa I Tatti in "+Timer.reportHumanFriendly(ItattiTransformerFCFR.class.getCanonicalName()+".fotoindex-fc-fr")); 
        log.info("Villa I Tatti Transformations Time: "+Timer.reportHumanFriendly(ItattiTransformer.class.getCanonicalName()));
    }
    
    public static ItattiTransformerFCFR create(){
        return new ItattiTransformerFCFR();
    }
    
}
