/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartupds.etlcontroller.etl.controller.impl.instance_maching;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Ingester;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiIngester;
import com.smartupds.etlcontroller.etl.controller.model.TripleStoreConnection;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;

/** This class is responsible for ingesting intance matched resources in a triplestore
 * 
 * @author mafragias
 */
@Log4j
public class InstanceMatchingIngester implements Ingester{
    private final TripleStoreConnection triplestoreConnection;
    
    private InstanceMatchingIngester(TripleStoreConnection tripleStoreConn){
        this.triplestoreConnection=tripleStoreConn;
    }
    
    @Override
    public void ingestResources() throws ETLGenericException {
        log.info("START: Ingest Instance Matching results for Artists");
        Timer.start(InstanceMatchingIngester.class.getCanonicalName()+".artists");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_ARTISTS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MATCHINGS_ARTISTS, false);
        }
        Timer.stop(InstanceMatchingIngester.class.getCanonicalName()+".artists");
        log.info("FINISH: Ingest Instance Matching results for Artists in "+Timer.reportHumanFriendly(InstanceMatchingIngester.class.getCanonicalName()+".artists"));
        
        log.info("START: Ingest Instance Matching results for Institutions");
        Timer.start(InstanceMatchingIngester.class.getCanonicalName()+".institutions");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_INSTITUTIONS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MATCHINGS_INSTITUTIONS, false);
        }
        Timer.stop(InstanceMatchingIngester.class.getCanonicalName()+".institutions");
        log.info("FINISH: Ingest Instance Matching results for Institutions in "+Timer.reportHumanFriendly(InstanceMatchingIngester.class.getCanonicalName()+".institutions"));
        
        log.info("START: Ingest Instance Matching results for Places");
        Timer.start(InstanceMatchingIngester.class.getCanonicalName()+".places");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_PLACES), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MATCHINGS_PLACES, false);
        }
        Timer.stop(InstanceMatchingIngester.class.getCanonicalName()+".places");
        log.info("FINISH: Ingest Instance Matching results for Places in "+Timer.reportHumanFriendly(InstanceMatchingIngester.class.getCanonicalName()+".places"));

        log.info("START: Ingest Instance Matching results for Photographers");
        Timer.start(InstanceMatchingIngester.class.getCanonicalName()+".photographers");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_PHOTOGRAPHERS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MATCHINGS_PHOTOGRAPHERS, false);
        }
        Timer.stop(InstanceMatchingIngester.class.getCanonicalName()+".photographers");
        log.info("FINISH: Ingest Instance Matching results for Photographers in "+Timer.reportHumanFriendly(InstanceMatchingIngester.class.getCanonicalName()+".photographers"));

        log.info("START: Ingest Instance Matching results for Types");
        Timer.start(InstanceMatchingIngester.class.getCanonicalName()+".types");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_TYPES), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MATCHINGS_TYPES, false);
        }
        Timer.stop(InstanceMatchingIngester.class.getCanonicalName()+".types");
        log.info("FINISH: Ingest Instance Matching results for Types in "+Timer.reportHumanFriendly(InstanceMatchingIngester.class.getCanonicalName()+".types")); 

        log.info("START: Ingest Instance Matching results for Works");
        Timer.start(InstanceMatchingIngester.class.getCanonicalName()+".works");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_WORKS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MATCHINGS_WORKS, false);
        }
        Timer.stop(InstanceMatchingIngester.class.getCanonicalName()+".works");
        log.info("FINISH: Ingest Instance Matching results for Works in "+Timer.reportHumanFriendly(InstanceMatchingIngester.class.getCanonicalName()+".works"));
        
        log.info("Instance Matchings Ingest Time: "+Timer.reportHumanFriendly(InstanceMatchingIngester.class.getCanonicalName()));
    }
    public static InstanceMatchingIngester create(TripleStoreConnection triplestoreConnection){
        return new InstanceMatchingIngester(triplestoreConnection);
    }
}
