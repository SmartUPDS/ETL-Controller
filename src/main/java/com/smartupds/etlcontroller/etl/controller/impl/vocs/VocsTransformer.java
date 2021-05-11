/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartupds.etlcontroller.etl.controller.impl.vocs;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Transformer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import java.io.File;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.apache.jena.riot.Lang;

/** Transformer class for resources from MIDAS Vocabularies 
 *
 * @author mafragias
 */
@Log4j
public class VocsTransformer implements Transformer {

    @Override
    public void transformResources() throws ETLGenericException {
        Timer.start(VocsTransformer.class.getCanonicalName()+".vocabularies");
        log.info("START: Transform Vocabularies from MIDAS");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MIDAS_VOCS_THESAURUS), null, true)){
            String filename = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MIDAS_VOCS_THESAURUS),
                                new File(Resources.GENERATOR_POLICY_MIDAS_VOCS),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_THESAURUS), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
            Utils.removeTypes(filename, Lang.NTRIPLES);
        } 
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MIDAS_VOCS_ARTISTS), null, true)){
            String filename1 = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MIDAS_VOCS_ARTISTS_HERTZIANA),
                                new File(Resources.GENERATOR_POLICY_MIDAS_VOCS),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_ARTISTS_HERTZIANA), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
            Utils.removeTypes(filename1, Lang.NTRIPLES);
            String filename2 = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MIDAS_VOCS_ARTISTS_KHI),
                                new File(Resources.GENERATOR_POLICY_MIDAS_VOCS),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_ARTISTS_KHI), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
            Utils.removeTypes(filename2, Lang.NTRIPLES);
            String filename3 = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MIDAS_VOCS_ARTISTS_MARBURG),
                                new File(Resources.GENERATOR_POLICY_MIDAS_VOCS),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_ARTISTS_MARBURG), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
            Utils.removeTypes(filename3, Lang.NTRIPLES);
        }
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_NORMALIZED_MIDAS_VOCS_PLACES), null, true)){
            String filename1 = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MIDAS_VOCS_PLACES_KHI),
                                new File(Resources.GENERATOR_POLICY_MIDAS_VOCS),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_PLACES_KHI), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
            Utils.removeTypes(filename1, Lang.NTRIPLES);
            String filename2 = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MIDAS_VOCS_PLACES_HERTZIANA),
                                new File(Resources.GENERATOR_POLICY_MIDAS_VOCS),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_PLACES_HERTZIANA), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
            Utils.removeTypes(filename2, Lang.NTRIPLES);
            String filename3 = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MIDAS_VOCS_PLACES_MARBURG),
                                new File(Resources.GENERATOR_POLICY_MIDAS_VOCS),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_PLACES_MARBURG), 
                                X3MLEngineFactory.OutputFormat.NTRIPLES);
            Utils.removeTypes(filename3, Lang.NTRIPLES);
        }
        Timer.stop(VocsTransformer.class.getCanonicalName()+".vocabularies");
        log.info("FINISH: Transform vocabularies from MIDAS in "+Timer.reportHumanFriendly(VocsTransformer.class.getCanonicalName()+".vocabularies"));
        
        log.info("MIDAS Transformations Time: "+Timer.reportHumanFriendly(VocsTransformer.class.getCanonicalName()));
    }
    
    public static VocsTransformer create(){
        return new VocsTransformer();
    }       
}

