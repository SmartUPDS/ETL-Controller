/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartupds.etlcontroller.etl.controller.api;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;

/** This class is responsible for deleting graphs
 *
 * @author Manolis Fragiadoulakis <fragiadoulakis at smartupds.com>
 */
public interface Deleter {
    /** This method is responsible for deleting RDF resources (graphs) from a particular 
     * knowledge base (e.g. a triplestore). The knowledge base-related information (e.g. host, port, graphspace, etc.)
     * will be provided from the classes implementing the interface
     * 
     * @throws ETLGenericException for any error that might occur while deleting RDF resoruces. */
    public void deleteResources() throws ETLGenericException;
}
