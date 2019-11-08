package com.smartupds.etlcontroller.etl.controller;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.hertziana.HertzianaNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.hertziana.HertzianaTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.zeri.ZeriNormalizer;
import lombok.extern.log4j.Log4j;

/** The entry point of the ETL Controller. The class is responsible for 
 * executing the entire ETL workflow.
 * 
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class Controller {
    
    public static void executeWorkflow() throws ETLGenericException{
        /* Harvest Resources */
        
        
        /* Normalize/Clean Input Resources */
//        HertzianaNormalizer.create().normalizeResources();
        ZeriNormalizer.create().normalizeResources();
        
        /* Transform Resources */
//        HertzianaTransformer.create().transformResources();
        
        
        /* Homogenize Output Resources */ 
        
        /* Ingest Resources */
        
        /* Test Resources */
    }
    
    public static void main(String[] args) throws ETLGenericException{
        Controller.executeWorkflow();
    }
}