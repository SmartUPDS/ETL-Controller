package com.smartupds.etlcontroller.etl.controller.impl.marburg;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.api.Ingester;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.model.TripleStoreConnection;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;

/** This class is responsible for ingesting the transformed resources in a triplestore
 * 
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class MarburgIngester implements Ingester{
    private TripleStoreConnection triplestoreConnection;

    public MarburgIngester(TripleStoreConnection tripleStoreConn){
        this.triplestoreConnection=tripleStoreConn;
    }
    
    @Override
    public void ingestResources() throws ETLGenericException {
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworks");
        log.info("START: Ingest Artworks from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworks");
        log.info("FINISH: Ingest Artworks from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworks"));
        
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworkslvl2");
        log.info("START: Ingest Artworks LVL2 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL2), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworkslvl2");
        log.info("FINISH: Ingest Artworks from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworkslvl2"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworkslvl3");
        log.info("START: Transform Artworks LVL3 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL3), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworkslvl3");
        log.info("FINISH: Transform Artworks from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworkslvl3"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworkslvl4");
        log.info("START: Transform Artworks LVL4 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL4), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworkslvl4");
        log.info("FINISH: Transform Artworks from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.artworkslvl4"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworks");
        log.info("START: Transform Builtworks from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworks");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworks"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworkslvl2");
        log.info("START: Transform Builtworks LVL2 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL2), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworkslvl2");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworkslvl2"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworkslvl3");
        log.info("START: Transform Builtworks LVL3 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL3), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworkslvl3");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworkslvl3"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworkslvl4");
        log.info("START: Transform Builtworks LVL4 from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL4), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworkslvl4");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.builtworkslvl4"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.photographs");
        log.info("START: Transform Photographs from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.photographs");
        log.info("FINISH: Transform Photographs from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.photographs"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.actors");
        log.info("START: Transform Actors from Marburg");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ACTORS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.actors");
        log.info("FINISH: Transform Actors from Marburg in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.actors"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.works_fc_fr");
        log.info("START: Transform Works from Marburg using FCs FRs");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_WORKS_FC_FR), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG_FC_FR, false);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.works_fc_fr");
        log.info("FINISH: Transform Works from Marburg using FCs FRs in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.works_fc_fr"));

        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.photographs_fc_fr");
        log.info("START: Transform Photographs from Marburg using FCs FRs");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS_FC_FR), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG_FC_FR, false);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.photographs_fc_fr");
        log.info("FINISH: Transform Works from Marburg using FCs FRs in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.marburg.marburgingester.ingest.photographs_fc_fr"));
    }
    
    public static MarburgIngester create(TripleStoreConnection tripleStoreConnection){
        return new MarburgIngester(tripleStoreConnection);
    }
}
