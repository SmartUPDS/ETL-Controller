/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartupds.etlcontroller.etl.controller.impl.vocs;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Homogenizer;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author mafragias
 */
@Log4j
public class VocsHomogenizer implements Homogenizer{

    @Override
    public void homogenizeResources() throws ETLGenericException {
        try{
//            this.checkN3Validity();
            this.consolidateN3Resources();
        }catch(IOException ex){
            log.error("An error occured while validating N3 resources",ex);
            throw new ETLGenericException("An error occured while validating N3 resources",ex);
        }
        
        log.info("MIDAS Vocabbularies Homogenization Time: "+Timer.reportHumanFriendly(VocsHomogenizer.class.toString()));
    }
    
    private void checkN3Validity() throws FileNotFoundException{
        log.info("START: Check the validity of vocabularies in N3 format from MIDAS");
        Timer.start(VocsHomogenizer.class.getCanonicalName()+".n3validation.vocabularies");
        Utils.N3Validator(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS));
        Timer.stop(VocsHomogenizer.class.getCanonicalName()+".n3validation.vocabularies");
        log.info("FINISH: Check the validity of vocabularies in N3 format from MIDAS in "+Timer.reportHumanFriendly(VocsHomogenizer.class.getCanonicalName()+".n3validation.vocabularies"));
    }
    
    private void consolidateN3Resources() throws IOException{
        log.info("START: Create consolidated N3 files for MIDAS Vocabularies");
        Timer.start(VocsHomogenizer.class.getCanonicalName()+".n3consolidation.vocabularies");
        Utils.consolidateN3Resources(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS), new File(Resources.FOLDER_OUTPUT_NORMALIZED_MIDAS_VOCS), Resources.VOCABULARIES, Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB, Resources.EXTENSION_TRIG);
        Timer.stop(VocsHomogenizer.class.getCanonicalName()+".n3consolidation.vocabularies");
        log.info("FINISH: Create consolidated N3 files for MIDAS Vocabularies in "+Timer.reportHumanFriendly(VocsHomogenizer.class.getCanonicalName()+".n3consolidation.vocabularies"));
    } 

    public static VocsHomogenizer create(){
        return new VocsHomogenizer();
    }
}
