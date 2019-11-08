package com.smartupds.etlcontroller.etl.controller.api;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;

/** Testing class for evaluating the resulting knowledge base and producing 
 * the corresponding metrics and scores.
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
public interface Tester {
    
    /** This method tests the constructed knowledge base by submitting particular 
     * SPARQL queries and evaluating the results. 
     * 
     * @throws ETLGenericException for any error that might occur while testing the knowledge base */
    public void testResourcesConnectivity() throws ETLGenericException;
}