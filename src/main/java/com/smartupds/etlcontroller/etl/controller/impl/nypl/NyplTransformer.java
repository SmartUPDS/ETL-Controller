/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartupds.etlcontroller.etl.controller.impl.nypl;

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

/**
 *
 * @author mafragias
 */
@Log4j
public class NyplTransformer implements Transformer  {
    
    @Override
    public void transformResources() throws ETLGenericException {
        Timer.start(NyplTransformer.class.getCanonicalName()+".vocabularies");
        log.info("START: Transform Artworks from MIDAS");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_INPUT_FETCHED_NYPL_ADDRESS), null, true)){
            String filename = Utils.transformFile(file,
                                new File(Resources.MAPPINGS_MIDAS_VOCS_THESAURUS),
                                new File(Resources.GENERATOR_POLICY_MIDAS_VOCS),
                                new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS), 
                                X3MLEngineFactory.OutputFormat.TRIG);
            Utils.removeTypes(filename, Lang.TRIG);
        }
        Timer.stop(NyplTransformer.class.getCanonicalName()+".vocabularies");
        log.info("FINISH: Transform vocabularies from MIDAS in "+Timer.reportHumanFriendly(NyplTransformer.class.getCanonicalName()+".vocabularies"));
        
        log.info("MIDAS Transformations Time: "+Timer.reportHumanFriendly(NyplTransformer.class.getCanonicalName()));
    }
    
    public static NyplTransformer create(){
        return new NyplTransformer();
    } 
}
