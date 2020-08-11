package com.smartupds.etlcontroller.etl.controller.impl.khi;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Ingester;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.model.TripleStoreConnection;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import lombok.extern.log4j.Log4j;

/** This class is responsible for ingesting the transformed resources in a triplestore
 * 
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class KhiIngester implements Ingester{
    private final TripleStoreConnection triplestoreConnection;
    
    private KhiIngester(TripleStoreConnection tripleStoreConn){
        this.triplestoreConnection=tripleStoreConn;
    }
    
    @Override
    public void ingestResources() throws ETLGenericException {
        log.info("START: Ingest artworks from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".artworks");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI, true);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".artworks");
        log.info("FINISH: Ingest artworks from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".artworks"));

        log.info("START: Ingest artworks LVL2 from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".artworks-lv2");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL2).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI, true);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".artworks-lv2");
        log.info("FINISH: Ingest artworks from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".artworks-lv2"));

        log.info("START: Ingest artworks LVL3 from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".artworks-lv3");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL3).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI, true);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".artworks-lv3");
        log.info("FINISH: Ingest artworks from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".artworks-lv3"));

        log.info("START: Ingest artworks LVL4 from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".artworks-lv4");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL4).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI, true);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".artworks-lv4");
        log.info("FINISH: Ingest artworks from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".artworks-lv4"));
        
        log.info("START: Ingest Builtworks from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".builtworks");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI, true);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".builtworks");
        log.info("FINISH: Ingest Builtworks from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".builtworks"));

        log.info("START: Ingest Builtworks LVL2 from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".builtworks-lv2");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL2).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI, true);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".builtworks-lv2");
        log.info("FINISH: Ingest Builtworks from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".builtworks-lv2"));

        log.info("START: Ingest Builtworks LVL3 from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".builtworks-lv3");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL3).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI, true);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".builtworks-lv3");
        log.info("FINISH: Ingest Builtworks from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".builtworks-lv3"));
        
        log.info("START: Ingest Builtworks LVL4 from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".builtworks-lv4");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL4).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI, true);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".builtworks-lv4");
        log.info("FINISH: Ingest Builtworks from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".builtworks-lv4"));

        log.info("START: Ingest photographs from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".photographs");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI, true);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".photographs");
        log.info("FINISH: Ingest photographs from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".photographs"));

        log.info("START: Ingest Actors from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".actors");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ACTORS).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI, true);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".actors");
        log.info("FINISH: Ingest Builtworks from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".actors"));
        
        log.info("START: Ingest photographs using FCs FRs from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".photographs-fc-fr");        
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS_FC_FR).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI_FC_FR, false);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".photographs-fc-fr");
        log.info("FINISH: Ingest photographs using FCs FRs from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".photographs-fc-fr"));
        
        log.info("START: Ingest Works using FCs FRs from KHI");
        Timer.start(KhiIngester.class.getCanonicalName()+".works-fc-fr");
        for(File file: new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_WORKS_FC_FR).listFiles()){
            Utils.uploadFile(this.triplestoreConnection,file,Resources.GRAPHSPACE_KHI_FC_FR, false);
        }
        Timer.stop(KhiIngester.class.getCanonicalName()+".works-fc-fr");
        log.info("FINISH: Ingest Works using FCs FRs from KHI in "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()+".works-fc-fr"));
        
        log.info("KHI Ingest Time: "+Timer.reportHumanFriendly(KhiIngester.class.getCanonicalName()));
    }
    
    public static KhiIngester create(TripleStoreConnection triplestoreConnection){
        return new KhiIngester(triplestoreConnection);
    }
}
