/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartupds.etlcontroller.etl.controller.impl.vocs;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Ingester;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.instance_maching.InstanceMatchingIngester;
import com.smartupds.etlcontroller.etl.controller.model.TripleStoreConnection;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;

/** This class is responsible for ingesting Vocabularies resources in a triplestore
 * 
 * @author mafragias
 */
@Log4j
public class VocsIngester implements Ingester {
    private final TripleStoreConnection triplestoreConnection;
    
    private VocsIngester(TripleStoreConnection tripleStoreConn){
        this.triplestoreConnection=tripleStoreConn;
    }
    
    @Override
    public void ingestResources() throws ETLGenericException {
        log.info("START: Ingest Vocabularies results for NYPL/PIC");
        Timer.start(VocsIngester.class.getCanonicalName()+".nypl-pic");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_VOCABULARIES_NYPL_PIC), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_VOCAB_NYPL_PIC, true);
        }
        Timer.stop(VocsIngester.class.getCanonicalName()+".nypl-pic");
        log.info("FINISH: Ingest Vocabularies results for NYPL/PIC in "+Timer.reportHumanFriendly(VocsIngester.class.getCanonicalName()+".nypl-pic"));
        
        log.info("START: Ingest Vocabularies results for ULAN");
        Timer.start(VocsIngester.class.getCanonicalName()+".ulan");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_VOCABULARIES_ULAN), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_VOCAB_ULAN, true);
        }
        Timer.stop(VocsIngester.class.getCanonicalName()+".ulan");
        log.info("FINISH: Ingest Vocabularies results for ULAN in "+Timer.reportHumanFriendly(VocsIngester.class.getCanonicalName()+".ulan"));

        log.info("START: Ingest Vocabularies results for Wikidata");
        Timer.start(VocsIngester.class.getCanonicalName()+".wikidata");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_VOCABULARIES_WIKIDATA), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_VOCAB_WIKIDATA, true);
        }
        Timer.stop(VocsIngester.class.getCanonicalName()+".wikidata");
        log.info("FINISH: Ingest Vocabularies results for Wikidata in "+Timer.reportHumanFriendly(VocsIngester.class.getCanonicalName()+".wikidata"));

        log.info("START: Ingest Vocabularies results for AAT");
        Timer.start(VocsIngester.class.getCanonicalName()+".aat");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_VOCABULARIES_AAT), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_VOCAB_AAT, true);
        }
        Timer.stop(VocsIngester.class.getCanonicalName()+".aat");
        log.info("FINISH: Ingest Vocabularies results for AAT in "+Timer.reportHumanFriendly(VocsIngester.class.getCanonicalName()+".aat"));

        log.info("START: Ingest Vocabularies results for Geonames");
        Timer.start(VocsIngester.class.getCanonicalName()+".geonames");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_VOCABULARIES_GEONAMES), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_VOCAB_GEONAMES, true);
        }
        Timer.stop(VocsIngester.class.getCanonicalName()+".geonames");
        log.info("FINISH: Ingest Vocabularies results for Geonames in "+Timer.reportHumanFriendly(VocsIngester.class.getCanonicalName()+".geonames"));

        log.info("START: Ingest Vocabularies results for MIDAS");
        Timer.start(VocsIngester.class.getCanonicalName()+".midas");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_VOCABULARIES_MIDAS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_VOCAB_MIDAS, true);
        }
        Timer.stop(VocsIngester.class.getCanonicalName()+".midas");
        log.info("FINISH: Ingest Vocabularies results for MIDAS in "+Timer.reportHumanFriendly(VocsIngester.class.getCanonicalName()+".midas"));
        
        log.info("Vocabularies Ingest Time: "+Timer.reportHumanFriendly(VocsIngester.class.getCanonicalName()));
    }
 
    public static VocsIngester create(TripleStoreConnection triplestoreConnection){
        return new VocsIngester(triplestoreConnection);
    }
}
