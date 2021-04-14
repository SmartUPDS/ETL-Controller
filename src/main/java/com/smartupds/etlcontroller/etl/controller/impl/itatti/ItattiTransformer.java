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
public class ItattiTransformer implements Transformer {

    @Override
    public void transformResources() throws ETLGenericException {
        Timer.start(ItattiTransformer.class.getCanonicalName()+".sharedshelf");
        log.info("START: Transform SharedShelf data from Villa I Tatti");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF).listFiles()){
            String filename = Utils.transformFile(  file,
                                                    new File(Resources.MAPPINGS_VILLA_I_TATTI_SHAREDSHELF_ALL),
                                                    new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_SHAREDSHELF),
                                                    new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF), 
                                                    X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);
        }
        Timer.stop(ItattiTransformer.class.getCanonicalName()+".sharedshelf");
        log.info("FINISH: Transform SharedShelf data from Villa I Tatti in "+Timer.reportHumanFriendly(ItattiTransformer.class.getCanonicalName()+".sharedshelf"));
        
        Timer.start(ItattiTransformer.class.getCanonicalName()+".sharedshelf-fc-fr");
        log.info("START: Transform SharedShelf data using FCs FRs from Villa I Tatti");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF).listFiles()){
            Utils.transformFile(file,
                                new File(Resources.MAPPINGS_VILLA_I_TATTI_SHAREDSHELF_FC_FR),
                                new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_SHAREDSHELF),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(ItattiTransformer.class.getCanonicalName()+".sharedshelf-fc-fr");
        log.info("FINISH: Transform SharedShelf data using FCs FRs from Villa I Tatti in "+Timer.reportHumanFriendly(ItattiTransformer.class.getCanonicalName()+".sharedshelf-fc-fr"));
        
        Timer.start(ItattiTransformer.class.getCanonicalName()+".fotoindex");
        log.info("START: Transform FotoIndex data from Villa I Tatti");
         for(File workFile : new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_FOTOINDEX).listFiles()){
            if(workFile.getName().toLowerCase().contains(Resources.ARTIST.toLowerCase())){
                String filename = Utils.transformFile(workFile,
                                    new File(Resources.MAPPINGS_VILLA_I_TATTI_FOTOINDEX_ARTIST), 
                                    new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_FOTOINDEX), 
                                    new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX),
                                    X3MLEngineFactory.OutputFormat.TRIG);
                Utils.removeTypes(filename, Lang.TRIG);
            }
            if(workFile.getName().toLowerCase().contains(Resources.COLLECTION.toLowerCase())){
                String filename = Utils.transformFile(workFile,
                                    new File(Resources.MAPPINGS_VILLA_I_TATTI_FOTOINDEX_COLLECTION), 
                                    new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_FOTOINDEX), 
                                    new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX),
                                    X3MLEngineFactory.OutputFormat.TRIG);
                Utils.removeTypes(filename, Lang.TRIG);
            }
            if(workFile.getName().toLowerCase().contains(Resources.INSTITUTION.toLowerCase())){
                String filename = Utils.transformFile(workFile,
                                    new File(Resources.MAPPINGS_VILLA_I_TATTI_FOTOINDEX_INSTITUTION), 
                                    new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_FOTOINDEX), 
                                    new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX),
                                    X3MLEngineFactory.OutputFormat.TRIG);
                Utils.removeTypes(filename, Lang.TRIG);
            }
            if(workFile.getName().toLowerCase().contains(Resources.PHOTOGRAPH.toLowerCase())){
                String filename = Utils.transformFile(workFile,
                                    new File(Resources.MAPPINGS_VILLA_I_TATTI_FOTOINDEX_PHOTO), 
                                    new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_FOTOINDEX), 
                                    new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX),
                                    X3MLEngineFactory.OutputFormat.TRIG);
                Utils.removeTypes(filename, Lang.TRIG);
            }
            if(workFile.getName().toLowerCase().contains(Resources.WORK.toLowerCase())){
                String filename = Utils.transformFile(workFile,
                                    new File(Resources.MAPPINGS_VILLA_I_TATTI_FOTOINDEX_WORK), 
                                    new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_FOTOINDEX), 
                                    new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX),
                                    X3MLEngineFactory.OutputFormat.TRIG);
                Utils.removeTypes(filename, Lang.TRIG);
            }
        }
        Timer.stop(ItattiTransformer.class.getCanonicalName()+".fotoindex");
        log.info("FINISH: Transform FotoIndex data from Villa I Tatti in "+Timer.reportHumanFriendly(ItattiTransformer.class.getCanonicalName()+".fotoindex"));
        
        Timer.start(ItattiTransformer.class.getCanonicalName()+".fotoindex-fc-fr");
        log.info("START: Transform FotoIndex data using FCs FRs from Villa I Tatti");
        for(File inputFile : new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_FOTOINDEX).listFiles()){
            Utils.transformFile(inputFile,
                                new File(Resources.MAPPINGS_VILLA_I_TATTI_FOTOINDEX_FC_FR), 
                                new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_FOTOINDEX), 
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX_FC_FR), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
        }
        Timer.stop(ItattiTransformer.class.getCanonicalName()+".fotoindex-fc-fr");
        log.info("FINISH: Transform FotoIndex using FCs FRs data from Villa I Tatti in "+Timer.reportHumanFriendly(ItattiTransformer.class.getCanonicalName()+".fotoindex-fc-fr"));
        
        Timer.start(ItattiTransformer.class.getCanonicalName()+".sharedshelf-ulan");
        log.info("START: Transform SharedShelf ULAN data from Villa I Tatti");
        for(File file: new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF).listFiles()){
            String filename = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_VILLA_I_TATTI_SHAREDSHELF_ULAN),
                                new File(Resources.GENERATOR_POLICY_VILLA_I_TATTI_SHAREDSHELF),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF_ULAN), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);
        }
        Timer.stop(ItattiTransformer.class.getCanonicalName()+".sharedshelf-ulan");
        log.info("FINISH: Transform SharedShelf ULAN data from Villa I Tatti in "+Timer.reportHumanFriendly(ItattiTransformer.class.getCanonicalName()+".sharedshelf-ulan"));
        
        log.info("Villa I Tatti Transformations Time: "+Timer.reportHumanFriendly(ItattiTransformer.class.getCanonicalName()));
    }
    
    public static ItattiTransformer create(){
        return new ItattiTransformer();
    }
    
}
