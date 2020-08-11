package com.smartupds.etlcontroller.etl.controller.impl.zeri;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Ingester;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
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
public class ZeriIngester implements Ingester{
    private final TripleStoreConnection triplestoreConnection;
    
    private ZeriIngester(TripleStoreConnection tripleStoreConn){
        this.triplestoreConnection=tripleStoreConn;
    }
    
    @Override
    public void ingestResources() throws ETLGenericException {
        log.info("START: Ingest Artworks from Zeri");
        Timer.start(ZeriIngester.class.getCanonicalName()+".artworks");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_ARTWORKS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_ZERI, true);
        }
        Timer.stop(ZeriIngester.class.getCanonicalName()+".artworks");
        log.info("FINISH: Ingest artworks from Zeri in "+Timer.reportHumanFriendly(ZeriIngester.class.getCanonicalName()+".artworks"));
        
        log.info("START: Ingest Photographs from Zeri");
        Timer.start(ZeriIngester.class.getCanonicalName()+".photographs");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_ZERI, true);
        }
        Timer.stop(ZeriIngester.class.getCanonicalName()+".photographs");
        log.info("FINISH: Ingest photographs from Zeri in "+Timer.reportHumanFriendly(ZeriIngester.class.getCanonicalName()+".photographs"));
        
        log.info("START: Ingest Photographs using FCs FRs from Zeri");
        Timer.start(ZeriIngester.class.getCanonicalName()+".photographs-fc-fr");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS_FC_FR), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_ZERI_FC_FR, false);
        }
        Timer.stop(ZeriIngester.class.getCanonicalName()+".photographs-fc-fr");
        log.info("FINISH: Ingest photographs using FCs FRs from Zeri in "+Timer.reportHumanFriendly(ZeriIngester.class.getCanonicalName()+".photographs-fc-fr"));
        
        log.info("START: Ingest Works using FCs FRs from Zeri");
        Timer.start(ZeriIngester.class.getCanonicalName()+".works-fc-fr");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_WORKS_FC_FR), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_ZERI_FC_FR, false);
        }
        Timer.stop(ZeriIngester.class.getCanonicalName()+".works-fc-fr");
        log.info("FINISH: Ingest Works using FCs FRs from Zeri in "+Timer.reportHumanFriendly(ZeriIngester.class.getCanonicalName()+".works-fc-fr"));
        
        log.info("Zeri Ingest Time: "+Timer.reportHumanFriendly(ZeriIngester.class.getCanonicalName()));
    }
    
    public static ZeriIngester create(TripleStoreConnection tripleStoreConnection){
        return new ZeriIngester(tripleStoreConnection);
    }
}
