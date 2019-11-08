package com.smartupds.etlcontroller.etl.controller;

import lombok.extern.log4j.Log4j;

/** The entry point of the ETL Controller. The class is responsible for 
 * executing the entire ETL workflow.
 * 
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class Controller {
    
    public static void executeWorkflow(){
        //Harvest Resources
        //Canonicalize/Clean Resources
        //Transform Resources
        //Normalize Resources
        //Ingest Resources
        //Test Resources
    }
    
    public static void main(String[] args){
        Controller.executeWorkflow();
    }
}