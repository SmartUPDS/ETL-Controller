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
    public static final String FOLDER_MAPPINGS=FOLDER_WORKSPACE+"/"+"2_Mappings";
    public static final String FOLDER_OUTPUT=FOLDER_WORKSPACE+"/"+"3_Output";
    public static final String FOLDER_OUTPUT_TRANSFORMED=FOLDER_OUTPUT+"/"+"1_Transformed";
    public static final String FOLDER_OUTPUT_NORMALIZED=FOLDER_OUTPUT+"/"+"2_Normalized";
    
    /* Sources names */
    public static final String HERTZIANA="Hertziana";
    public static final String MARBURG="Marburg";
    public static final String ZERI="Zeri";
    public static final String FRICK="Frick";
    public static final String VILLA_I_TATTI="VillaITatti";
    
    /* Mapping resources */
    public static final String MAPPINGS_HERTZIANA_ALL=FOLDER_MAPPINGS+"/"+"mappings-hertziana.x3ml";
    public static final String GENERATOR_POLICY_HERTZIANA=FOLDER_MAPPINGS+"/"+"generator-policy-hertziana.xml";
    
    /* HERTZIANA resources */
    public static final String HERTZIANA_COMBINED_RESOURCES_ROOT_ELEMENT="root";
    public static final String HERTZIANA_COMBINED_RESOURCES_OBJ_ELEMENT="obj";
    
    /* Misc Resources */
    public static final int MAX_FILESIZE_INPUT_RESOURCES_IN_MB=10;
}
