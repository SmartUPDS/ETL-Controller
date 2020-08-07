package com.smartupds.etlcontroller.etl.controller.impl.itatti;

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
public class ItattiIngester implements Ingester{
    private TripleStoreConnection triplestoreConnection;
    
    private ItattiIngester(TripleStoreConnection tripleStoreConn){
        this.triplestoreConnection=tripleStoreConn;
    }
    
    @Override
    public void ingestResources() throws ETLGenericException {
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.sharedshelf");
        log.info("START: Ingest SharedShelf resources from VillaITatti");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_VILLA_I_TATTI, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.sharedshelf");
        log.info("FINISH: Ingest SharedShelf resources from VillaITatti in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.sharedshelf"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.fotoindex");
        log.info("START: Ingest FotoIndex resources from VillaITatti");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_VILLA_I_TATTI, true);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.fotoindex");
        log.info("FINISH: Ingest FotoIndex resources from VillaITatti in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.fotoindex"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.sharedshelf-fc-fr");
        log.info("START: Ingest SharedShelf resources using FCs FRs from VillaITatti");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF_FC_FR), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_VILLA_I_TATTI_FC_FR, false);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.sharedshelf-fc-fr");
        log.info("FINISH: Ingest SharedShelf resources using FCs FRs from VillaITatti in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.sharedshelf-fc-fr"));
        
        Timer.start("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.fotoindex-fc-fr");
        log.info("START: Ingest FotoIndex resources using FCs FRs from VillaITatti");
        for(File file: FileUtils.listFiles(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX_FC_FR), null, true)){
            Utils.uploadFile(this.triplestoreConnection, file, Resources.GRAPHSPACE_VILLA_I_TATTI_FC_FR, false);
        }
        Timer.stop("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.fotoindex-fc-fr");
        log.info("FINISH: Ingest FotoIndex resources using FCs FRs from VillaITatti in "+Timer.reportHumanFriendly("com.smartupds.etlcontroller.etl.controller.impl.itatti.itatttiingester.ingest.fotoindex-fc-fr"));
    }
    
    public static ItattiIngester create(TripleStoreConnection triplestoreConnection){
        return new ItattiIngester(triplestoreConnection);
    }
}