package com.smartupds.etlcontroller.etl.controller.api;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.model.TripleStoreConnection;

/** This class is responsible for ingesting RDF resources into a knowledge base (e.g. triplestore)
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
public interface Ingester {

    /** This method is responsbile for adding the RDF resources in a particular 
     * knowledge base (e.g. a triplestore). The knowledge base-related information (e.g. host, port, graphspace, etc.)
     * will be provided from the classes implementing the interface
     * 
     * @throws ETLGenericException for any error that might occur while ingesting RDF resoruces. */
    public void ingestResources() throws ETLGenericException;
}
