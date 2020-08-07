package com.smartupds.etlcontroller.etl.controller.impl.marburg;

import com.smartupds.etlcontroller.etl.controller.api.Ingester;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.model.TripleStoreConnection;
import java.io.File;
import lombok.extern.log4j.Log4j;

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
        Utils.uploadFile(triplestoreConnection, new File("C:/Repositories/Github/X3ML/output.trig"), "http%3A%2F%2Fyannis_smartup", true);
    }
    
    public static MarburgIngester create(TripleStoreConnection tripleStoreConnection){
        return new MarburgIngester(tripleStoreConnection);
    }
}
