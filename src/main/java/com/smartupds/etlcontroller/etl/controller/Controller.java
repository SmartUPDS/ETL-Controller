package com.smartupds.etlcontroller.etl.controller;

import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.frick.FrickHomogenizer;
import com.smartupds.etlcontroller.etl.controller.impl.frick.FrickIngester;
import com.smartupds.etlcontroller.etl.controller.impl.frick.FrickNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.frick.FrickTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.hertziana.HertzianaIngester;
import com.smartupds.etlcontroller.etl.controller.impl.hertziana.HertzianaNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.hertziana.HertzianaTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiIngester;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.khi.KhiHomogenizer;
import com.smartupds.etlcontroller.etl.controller.impl.khi.KhiIngester;
import com.smartupds.etlcontroller.etl.controller.impl.khi.KhiNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.khi.KhiTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.marburg.MarburgIngester;
import com.smartupds.etlcontroller.etl.controller.impl.marburg.MarburgNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.marburg.MarburgTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.zeri.ZeriHomogenizer;
import com.smartupds.etlcontroller.etl.controller.impl.zeri.ZeriIngester;
import com.smartupds.etlcontroller.etl.controller.impl.zeri.ZeriNormalizer;
import com.smartupds.etlcontroller.etl.controller.impl.zeri.ZeriTransformer;
import com.smartupds.etlcontroller.etl.controller.model.TripleStoreConnection;
import java.io.File;
import lombok.extern.log4j.Log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** The entry point of the ETL Controller. The class is responsible for 
 * executing the entire ETL workflow.
 * 
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class Controller {
    
    public static void executeWorkflow() throws ETLGenericException{
        /* Harvest Resources */
        //none (?)
        
        /* Normalize/Clean Input Resources */
//        ItattiNormalizer.create().normalizeResources();
        FrickNormalizer.create().normalizeResources();
//        HertzianaNormalizer.create().normalizeResources();
//        ZeriNormalizer.create().normalizeResources();
//        MarburgNormalizer.create().normalizeResources();
//        KhiNormalizer.create().normalizeResources();
        
        /* Transform Resources */
//        ItattiTransformer.create().transformResources();
//        HertzianaTransformer.create().transformResources();
        FrickTransformer.create().transformResources();
//        ZeriTransformer.create().transformResources();
//        MarburgTransformer.create().transformResources();
//        KhiTransformer.create().transformResources();

        /* Homogenize Output Resources */ 
//        FrickHomogenizer.create().homogenizeResources();
//        ZeriHomogenizer.create().homogenizeResources();
//        KhiHomogenizer.create().homogenizeResources();
        
        /* Ingest Resources */
//        ApplicationContext context=new ClassPathXmlApplicationContext(Resources.SPRING_BEANS_FILENAME);
//        TripleStoreConnection triplestoreConnection=context.getBean(Resources.TRIPLESTORE_BEAN_ID, TripleStoreConnection.class);
//        
//        ItattiIngester.create(triplestoreConnection).ingestResources();
        
//        HertzianaIngester.create(triplestoreConnection).ingestResources();
//        FrickIngester.create(triplestoreConnection).ingestResources();
//        ZeriIngester.create(triplestoreConnection).ingestResources();
//        MarburgIngester.create(triplestoreConnection).ingestResources();
//        KhiIngester.create(triplestoreConnection).ingestResources();
        
        /* Test Resources */
//        none (?)

        Utils.reportTimeStatistics();
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
        new File(Resources.FOLDER_INPUT_FETCHED_ZERI_ARTWORKS_ZIPS).mkdir();
        new File(Resources.FOLDER_INPUT_FETCHED_ZERI_PHOTOGRAPHS_ZIPS).mkdir();
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
        new File(Resources.MAPPINGS_VILLA_I_TATTI).mkdir();
        new File(Resources.MAPPINGS_VILLA_I_TATTI_SHAREDSHELF).mkdir();
        new File(Resources.MAPPINGS_VILLA_I_TATTI_FOTOINDEX).mkdir();
        new File(Resources.MAPPINGS_HERTZIANA).mkdir();
        new File(Resources.MAPPINGS_FRICK).mkdir();
        new File(Resources.MAPPINGS_KHI).mkdir();
        new File(Resources.MAPPINGS_ZERI).mkdir();
        new File(Resources.MAPPINGS_MARBURG).mkdir();
        
        log.debug("Create OUTPUT folders");
        new File(Resources.FOLDER_OUTPUT).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF_FC_FR).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX_FC_FR).mkdir();
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
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS_FC_FR).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_WORKS_FC_FR).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_ARTWORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS_FC_FR).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_ZERI_WORKS_FC_FR).mkdir();
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
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS_FC_FR).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_MARBURG_WORKS_FC_FR).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK_ALL).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_FRICK_FC_FR).mkdir();
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
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS_FC_FR).mkdir();
        new File(Resources.FOLDER_OUTPUT_TRANSFORMED_KHI_WORKS_FC_FR).mkdir();
        new File(Resources.FOLDER_OUTPUT_NORMALIZED).mkdir();
        new File(Resources.FOLDER_OUTPUT_NORMALIZED_ZERI).mkdir();
        new File(Resources.FOLDER_OUTPUT_NORMALIZED_ZERI_ARTWORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_NORMALIZED_ZERI_PHOTOGRAPHS).mkdir();
        new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING).mkdir();
        new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_ARTISTS).mkdir();
        new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_INSTITUTIONS).mkdir();
        new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_PLACES).mkdir();
        new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_TYPES).mkdir();
        new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_WORKS).mkdir();
        new File(Resources.FOLDER_OUTPUT_INSTANCE_MATCHING_PHOTOGRAPHERS).mkdir();
        new File(Resources.FOLDER_OUTPUT_VOCABULARIES).mkdir();
        new File(Resources.FOLDER_OUTPUT_VOCABULARIES_NYPL_PIC).mkdir();
        new File(Resources.FOLDER_OUTPUT_VOCABULARIES_ULAN).mkdir();
        new File(Resources.FOLDER_OUTPUT_VOCABULARIES_WIKIDATA).mkdir();
        new File(Resources.FOLDER_OUTPUT_VOCABULARIES_AAT).mkdir();
        new File(Resources.FOLDER_OUTPUT_VOCABULARIES_GEONAMES).mkdir();
        new File(Resources.FOLDER_OUTPUT_VOCABULARIES_MIDAS).mkdir();
        
    }
    
    public static void main(String[] args) throws ETLGenericException{
        /* INITIALIZATION ONLY */
//        Controller.createFoldersStructure();
        
        Controller.executeWorkflow();
    }
}