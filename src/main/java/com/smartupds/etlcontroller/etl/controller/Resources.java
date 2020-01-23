package com.smartupds.etlcontroller.etl.controller;

/** Various Common resources
 *
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
public class Resources {
    /* Local Folder resources */
    public static final String FOLDER_WORKSPACE="workspace";
    public static final String FOLDER_INPUT=FOLDER_WORKSPACE+"/"+"1_Input";
    public static final String FOLDER_INPUT_FETCHED=FOLDER_INPUT+"/"+"1_Fetched";
    public static final String FOLDER_INPUT_NORMALIZED=FOLDER_INPUT+"/"+"2_Normalized";
    public static final String FOLDER_INPUT_FETCHED_HERTZIANA=FOLDER_INPUT_FETCHED+"/"+Resources.HERTZIANA;
    public static final String FOLDER_INPUT_NORMALIZED_HERTZIANA=FOLDER_INPUT_NORMALIZED+"/"+Resources.HERTZIANA;
    public static final String FOLDER_INPUT_FETCHED_VILLA_I_TATTI=FOLDER_INPUT_FETCHED+"/"+Resources.VILLA_I_TATTI;
    public static final String FOLDER_INPUT_FETCHED_FRICK=FOLDER_INPUT_FETCHED+"/"+Resources.FRICK;
    public static final String FOLDER_INPUT_FETCHED_ZERI=FOLDER_INPUT_FETCHED+"/"+Resources.ZERI;
    public static final String FOLDER_INPUT_FETCHED_ZERI_ARTWORKS=FOLDER_INPUT_FETCHED_ZERI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_INPUT_FETCHED_ZERI_PHOTOGRAPHS=FOLDER_INPUT_FETCHED_ZERI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_INPUT_FETCHED_MARBURG=FOLDER_INPUT_FETCHED+"/"+Resources.MARBURG;
    public static final String FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI=FOLDER_INPUT_NORMALIZED+"/"+Resources.VILLA_I_TATTI;
    public static final String FOLDER_INPUT_NORMALIZED_FRICK=FOLDER_INPUT_NORMALIZED+"/"+Resources.FRICK;
    public static final String FOLDER_INPUT_NORMALIZED_ZERI=FOLDER_INPUT_NORMALIZED+"/"+Resources.ZERI;
    public static final String FOLDER_INPUT_NORMALIZED_ZERI_ARTWORKS=FOLDER_INPUT_NORMALIZED_ZERI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_INPUT_NORMALIZED_ZERI_PHOTOGRAPHS=FOLDER_INPUT_NORMALIZED_ZERI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_INPUT_NORMALIZED_MARBURG=FOLDER_INPUT_NORMALIZED+"/"+Resources.MARBURG;
    public static final String FOLDER_MAPPINGS=FOLDER_WORKSPACE+"/"+"2_Mappings";
    public static final String FOLDER_OUTPUT=FOLDER_WORKSPACE+"/"+"3_Output";
    public static final String FOLDER_OUTPUT_TRANSFORMED=FOLDER_OUTPUT+"/"+"1_Transformed";
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.VILLA_I_TATTI;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.HERTZIANA;
    public static final String FOLDER_OUTPUT_TRANSFORMED_FRICK=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.FRICK;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.ZERI;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI_ARTWORKS=FOLDER_OUTPUT_TRANSFORMED_ZERI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS=FOLDER_OUTPUT_TRANSFORMED_ZERI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.MARBURG;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_L2V=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.L2V;
    public static final String FOLDER_OUTPUT_NORMALIZED=FOLDER_OUTPUT+"/"+"2_Normalized";
    
    /* Sources names */
    public static final String HERTZIANA="Hertziana";
    public static final String MARBURG="Marburg";
    public static final String ZERI="Zeri";
    public static final String FRICK="Frick";
    public static final String VILLA_I_TATTI="VillaITatti";
    
    /* Entities names */
    public static final String ARTWORKS="artworks";
    public static final String PHOTOGRAPHS="photographs";
    public static final String L2V="l2v";
    
    /* Mapping resources */
    public static final String MAPPINGS_VILLA_I_TATTI=FOLDER_MAPPINGS+"/"+"mappings-itatti.x3ml";
    public static final String GENERATOR_POLICY_VILLA_I_TATTI=FOLDER_MAPPINGS+"/"+"generator-policy-itatti.xml";
    public static final String MAPPINGS_HERTZIANA_ALL=FOLDER_MAPPINGS+"/"+"mappings-hertziana.x3ml";
    public static final String GENERATOR_POLICY_HERTZIANA=FOLDER_MAPPINGS+"/"+"generator-policy-hertziana.xml";
    public static final String MAPPINGS_FRICK_ALL=FOLDER_MAPPINGS+"/"+"mappings-fricks.x3ml";
    public static final String GENERATOR_POLICY_FRICK=FOLDER_MAPPINGS+"/"+"generator-policy-fricks.xml";
    public static final String MAPPINGS_ZERI_ARTWORKS=FOLDER_MAPPINGS+"/"+"mappings-zeri-artworks.x3ml";
    public static final String MAPPINGS_ZERI_PHOTOGRAPHS=FOLDER_MAPPINGS+"/"+"mappings-zeri-photographs.x3ml";
    public static final String GENERATOR_POLICY_ZERI=FOLDER_MAPPINGS+"/"+"generator-policy-zeri.xml";
    public static final String MAPPINGS_MARBURG_ARTWORKS=FOLDER_MAPPINGS+"/"+"mappings-marburg-artworks.x3ml";
    public static final String MAPPINGS_MARBURG_PHOTOGRAPHS=FOLDER_MAPPINGS+"/"+"mappings-marburg-photographs.x3ml";
    public static final String MAPPINGS_MARBURG_L2V=FOLDER_MAPPINGS+"/"+"mappings-marburg-l2v.x3ml";
    public static final String GENERATOR_POLICY_MARBURG=FOLDER_MAPPINGS+"/"+"generator-policy-marburg.xml";
    
    /* HERTZIANA resources */
    public static final String HERTZIANA_COMBINED_RESOURCES_ROOT_ELEMENT="root";
    public static final String HERTZIANA_COMBINED_RESOURCES_OBJ_ELEMENT="obj";
    
    /* Misc Resources */
    public static final int MAX_FILESIZE_INPUT_RESOURCES_IN_MB=10;
}
