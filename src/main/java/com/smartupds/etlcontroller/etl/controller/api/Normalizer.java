package com.smartupds.etlcontroller.etl.controller.api;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;

/** A generic interface for normalizing input resources (e.g. syntax normalizers, split large files, etc.)
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
public interface Normalizer {
    
    /** The method normalizes the input resources from their original format 
     *  to a more appropriate and useful for transforming them. 
     * 
     * @throws ETLGenericException for any error that might occur while normalizing input resources */
    public void normalizeResources() throws ETLGenericException;

}