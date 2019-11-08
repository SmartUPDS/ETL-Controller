package com.smartupds.etlcontroller.etl.controller.exception;

/** A generic exception class
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
public class ETLGenericException extends Exception{
    public ETLGenericException(String message, Throwable thr){
        super(message,thr);
    }
    
    public ETLGenericException(String message){
        super(message);
    }

}
