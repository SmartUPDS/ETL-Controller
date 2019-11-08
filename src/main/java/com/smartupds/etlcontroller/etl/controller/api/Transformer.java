package com.smartupds.etlcontroller.etl.controller.api;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;

/** This class is responsible for transforming input resources from XML
 *  format to RDF w.r.t. the corresponding X3ML mappings. 
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
public interface Transformer {

    /** This method transforms data resources w.r.t. the given X3ML mapping definition files
     *  and the corresponding generator policy files. The actual location of the resources 
     *  to be used (i.e. input data, X3ML mappings, generator policy files) as well as 
     *  the output data will be defined from the classes implementing this interface. 
     * 
     * @throws ETLGenericException for any error that might occur while transforming resources. */
    public void transformResources() throws ETLGenericException;
}
