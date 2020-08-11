package com.smartupds.etlcontroller.etl.controller.impl.frick;

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
public class FrickIngester implements Ingester{
    private final TripleStoreConnection triplestoreConnection;
    
    private FrickIngester(TripleStoreConnection tripleStoreConn){
        this.triplestoreConnection=tripleStoreConn;
    }
    
    @Override
    public void ingestResources() throws ETLGenericException {
        log.info("START: Ingest All resources from Frick");
        Timer.start(FrickIngester.class.getCanonicalName()+".all");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK_ALL), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_FRICK, true);
        }
        Timer.stop(FrickIngester.class.getCanonicalName()+".all");
        log.info("FINISH: Ingest All resources from Frick in "+Timer.reportHumanFriendly(FrickIngester.class.getCanonicalName()+".all"));
        
        log.info("START: Ingest All resources using FCs FRs from Frick");
        Timer.start(FrickIngester.class.getCanonicalName()+".all-fc-fr");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK_FC_FR), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_FRICK_FC_FR, false);
        }
        Timer.stop(FrickIngester.class.getCanonicalName()+".all-fc-fr");
        log.info("FINISH: Ingest All resources using FCs FRs from Frick in "+Timer.reportHumanFriendly(FrickIngester.class.getCanonicalName()+".all-fc-fr"));
        
        log.info("Frick Ingest Time: "+Timer.reportHumanFriendly(FrickIngester.class.getCanonicalName()));
    }
    
    public static FrickIngester create(TripleStoreConnection triplestoreConnection){
        return new FrickIngester(triplestoreConnection);
    }
}