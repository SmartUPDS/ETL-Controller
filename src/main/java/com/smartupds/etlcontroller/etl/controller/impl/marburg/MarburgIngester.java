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
    private final TripleStoreConnection triplestoreConnection;

    private MarburgIngester(TripleStoreConnection tripleStoreConn){
        this.triplestoreConnection=tripleStoreConn;
    }
    
    @Override
    public void ingestResources() throws ETLGenericException {
        log.info("START: Ingest Artworks from Marburg");
        Timer.start(MarburgIngester.class+".artworks");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop(MarburgIngester.class+".artworks");
        log.info("FINISH: Ingest Artworks from Marburg in "+Timer.reportHumanFriendly(MarburgIngester.class+".artworks"));
        
        log.info("START: Ingest Artworks LVL2 from Marburg");
        Timer.start(MarburgIngester.class+".artworks-lv2");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL2), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop(MarburgIngester.class+".artworks-lv2");
        log.info("FINISH: Ingest Artworks from Marburg in "+Timer.reportHumanFriendly(MarburgIngester.class+".artworks-lv2"));

        log.info("START: Transform Artworks LVL3 from Marburg");
        Timer.start(MarburgIngester.class+".artworks-lv3");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL3), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop(MarburgIngester.class+".artworks-lv3");
        log.info("FINISH: Transform Artworks from Marburg in "+Timer.reportHumanFriendly(MarburgIngester.class+".artworks-lv3"));

        log.info("START: Transform Artworks LVL4 from Marburg");
        Timer.start(MarburgIngester.class+".artworks-lv4");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL4), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop(MarburgIngester.class+".artworks-lv4");
        log.info("FINISH: Transform Artworks from Marburg in "+Timer.reportHumanFriendly(MarburgIngester.class+".artworks-lv4"));

        log.info("START: Transform Builtworks from Marburg");
        Timer.start(MarburgIngester.class+".builtworks");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop(MarburgIngester.class+".builtworks");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly(MarburgIngester.class+".builtworks"));

        log.info("START: Transform Builtworks LVL2 from Marburg");
        Timer.start(MarburgIngester.class+".builtworks-lv2");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL2), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop(MarburgIngester.class+".builtworks-lv2");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly(MarburgIngester.class+".builtworks-lv2"));

        log.info("START: Transform Builtworks LVL3 from Marburg");
        Timer.start(MarburgIngester.class+".builtworks-lv3");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL3), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop(MarburgIngester.class+".builtworks-lv3");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly(MarburgIngester.class+".builtworks-lv3"));

        log.info("START: Transform Builtworks LVL4 from Marburg");
        Timer.start(MarburgIngester.class+".builtworks-lv4");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL4), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop(MarburgIngester.class+".builtworks-lv4");
        log.info("FINISH: Transform Builtworks from Marburg in "+Timer.reportHumanFriendly(MarburgIngester.class+".builtworks-lv4"));

        log.info("START: Transform Photographs from Marburg");
        Timer.start(MarburgIngester.class+".photographs");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop(MarburgIngester.class+".photographs");
        log.info("FINISH: Transform Photographs from Marburg in "+Timer.reportHumanFriendly(MarburgIngester.class+".photographs"));

        log.info("START: Transform Actors from Marburg");
        Timer.start(MarburgIngester.class+".actors");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ACTORS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG, true);
        }
        Timer.stop(MarburgIngester.class+".actors");
        log.info("FINISH: Transform Actors from Marburg in "+Timer.reportHumanFriendly(MarburgIngester.class+".actors"));

        log.info("START: Transform Works from Marburg using FCs FRs");
        Timer.start(MarburgIngester.class+".works-fc-fr");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_WORKS_FC_FR), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG_FC_FR, false);
        }
        Timer.stop(MarburgIngester.class+".works-fc-fr");
        log.info("FINISH: Transform Works from Marburg using FCs FRs in "+Timer.reportHumanFriendly(MarburgIngester.class+".works-fc-fr"));

        log.info("START: Transform Photographs from Marburg using FCs FRs");
        Timer.start(MarburgIngester.class+".photographs-fc-fr");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS_FC_FR), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_MARBURG_FC_FR, false);
        }
        Timer.stop(MarburgIngester.class+".photographs-fc-fr");
        log.info("FINISH: Transform Works from Marburg using FCs FRs in "+Timer.reportHumanFriendly(MarburgIngester.class+".photographs-fc-fr"));
        
        log.info("Marburg Ingest Time: "+Timer.reportHumanFriendly(MarburgIngester.class.toString()));
    }
    
    public static MarburgIngester create(TripleStoreConnection tripleStoreConnection){
        return new MarburgIngester(tripleStoreConnection);
    }
}
