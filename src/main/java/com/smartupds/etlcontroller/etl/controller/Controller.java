package com.smartupds.etlcontroller.etl.controller;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.frick.FrickHomogenizer;
import com.smartupds.etlcontroller.etl.controller.impl.frick.FrickNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.frick.FrickTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.hertziana.HertzianaNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.hertziana.HertzianaTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.khi.KhiHomogenizer;
import com.smartupds.etlcontroller.etl.controller.impl.khi.KhiNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.khi.KhiTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.marburg.MarburgNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.marburg.MarburgTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.zeri.ZeriHomogenizer;
import com.smartupds.etlcontroller.etl.controller.impl.zeri.ZeriNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.zeri.ZeriTransformer;
import java.io.File;
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
        //none(?)
        
        /* Normalize/Clean Input Resources */
//        ItattiNormalizer.create().normalizeResources();
//        FrickNormalizer.create().normalizeResources();
//        HertzianaNormalizer.create().normalizeResources();
        ZeriNormalizer.create().normalizeResources();
//        MarburgNormalizer.create().normalizeResources();
//        KhiNormalizer.create().normalizeResources();
        
        /* Transform Resources */
//        ItattiTransformer.create().transformResources();
//        HertzianaTransformer.create().transformResources();
//        FrickTransformer.create().transformResources();
//        ZeriTransformer.create().transformResources();
//        MarburgTransformer.create().transformResources();
//        KhiTransformer.create().transformResources();

        /* Homogenize Output Resources */ 
//        FrickHomogenizer.create().homogenizeResources();
//        ZeriHomogenizer.create().homogenizeResources();
//        KhiHomogenizer.create().homogenizeResources();
        
        /* Ingest Resources */
        
        /* Test Resources */
    }
    
    private static void createFoldersStructure(){
        log.info("Creating workspace folders structure");
        log.debug("Create INPUT folders");
        new File(Resources.FOLDER_INPUT).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_VILLA_I_TATTI).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_VILLA_I_TATTI_FOTOINDEX).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_VILLA_I_TATTI_SHAREDSHELF).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_FRICK).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_HERTZIANA).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_ZERI).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_ZERI_ARTWORKS).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_ZERI_PHOTOGRAPHS).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_MARBURG).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_KHI).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_FOTOINDEX).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED_FRICK).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED_HERTZIANA).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_ARTWORKS).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED_ZERI_PHOTOGRAPHS).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED_MARBURG).mkdir();
        new File(Resources.FOLDER_INPUT_NORMALIZED_KHI).mkdir();
        
        log.debug("Create MAPPINGS folders");
        new File(Resources.FOLDER_MAPPINGS).mkdir();
        
        log.debug("Create OUTPUT folders");
        new File(Resources.FOLDER_OUTPUT).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL2).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL3).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL4).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL2).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL3).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL4).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ACTORS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_ARTWORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ACTORS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL2).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL3).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL4).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL2).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL3).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL4).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_ACTORS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ACTORS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL2).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL3).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL4).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL2).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL3).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL4).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS).mkdir();
        new File(Resources.FOLDER_OUTPUT_NORMALIZED).mkdir();
        new File(Resources.FOLDER_OUTPUT_NORMALIZED_ZERI).mkdir();
        new File(Resources.FOLDER_OUTPUT_NORMALIZED_ZERI_ARTWORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_NORMALIZED_ZERI_PHOTOGRAPHS).mkdir();
    }
    
    public static void main(String[] args) throws ETLGenericException{
        /* INITIALIZATION ONLY */
//        Controller.createFoldersStructure();
        
        Controller.executeWorkflow();
    }
}