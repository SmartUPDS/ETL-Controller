/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartupds.etlcontroller.etl.controller.impl.Indexing;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.IndexGenerator;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.normalizer.exceptions.NormalizerException;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.log4j.Log4j;
import org.w3c.dom.Document;
import split.ElementsSplit;

/** This class is responsible for generating Indexes using Apache Solr
 *
 * @author Manolis Fragiadoulakis <fragiadoulakis at smartupds.com>
 */
@Log4j
public class WorkIndexGenerator implements IndexGenerator{
    private File configurationFile;

    public WorkIndexGenerator(File configurationFile){
        this.configurationFile = configurationFile;
    }
    @Override
    public void indexResources() throws ETLGenericException {
        Timer.start(WorkIndexGenerator.class.getCanonicalName()+".index");
        log.info("START: Indexing resources");
        try {
            Utils.retrieveResourcesByType(Resources.TYPE_WORK, this.configurationFile);
        } catch (NormalizerException ex) {
            Logger.getLogger(WorkIndexGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        Timer.stop(WorkIndexGenerator.class.getCanonicalName()+".index");
        log.info("FINISH: Indexing resources in "+Timer.reportHumanFriendly(WorkIndexGenerator.class.getCanonicalName()+".index"));
        log.info("Indexing resources Time: "+Timer.reportHumanFriendly(WorkIndexGenerator.class.getCanonicalName()));
    }
    
    public static WorkIndexGenerator create(File configurationfile){

        return new WorkIndexGenerator(configurationfile);
    }
    
}
