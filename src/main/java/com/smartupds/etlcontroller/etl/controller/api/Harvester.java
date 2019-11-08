package com.smartupds.etlcontroller.etl.controller.api;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;

/** A generic harvester interface, that fetches remote resources 
 * using various methods (e.g. HTTP GET, SPARQL, SQL, etc.). 
 * The particular details for harvesting data (e.g. URL for HTTP available resources
 * will be defined from the particular classes implementing the interface, as needed).
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
public interface Harvester {
    
    /** This method harvest the remote resources and stores them locally.
     *  The details for harvesting resources (e.g. the actual location, ports, credentials, etc.)
     *  will be defined the corresponding classes implementing the interface.
     * 
     * @throws ETLGenericException for any error that might be thrown will harvesting resources */
    public void fetchResources() throws ETLGenericException;
}