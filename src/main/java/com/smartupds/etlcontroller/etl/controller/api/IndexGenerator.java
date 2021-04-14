/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartupds.etlcontroller.etl.controller.api;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;

/** This class is responsible for indexing resources
 *
 * @author Manolis Fragiadoulakis <fragiadoulakis at smartupds.com>
 */
public interface IndexGenerator {
    
    /** This method is responsible for adding indexes to resources for a particular 
     * knowledge base (e.g. a triplestore).
     * 
     * @throws ETLGenericException for any error that might occur while ingesting RDF resoruces. */
    public void indexResources() throws ETLGenericException;
}
