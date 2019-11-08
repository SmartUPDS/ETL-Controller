package com.smartupds.etlcontroller.etl.controller.api;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;

/** Homogenizer is a class responsible for applying any normalization in 
 * the RDF resources, so that they are homogenized with other resources (from other sources)
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
public interface Homogenizer {

    /** This method normalizes the RDF resources (i.e. SPARQL materialization) as needed
     * for each source. 
     * 
     * @throws ETLGenericException for any error that might occur while normalizing RDF resources */
    public void homogenizeResources() throws ETLGenericException;
}
