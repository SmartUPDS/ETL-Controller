package com.smartupds.etlcontroller.etl.controller;

//import com.hp.hpl.jena.rdf.model.Resource;

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
    public static final String FOLDER_INPUT_FETCHED_VILLA_I_TATTI_SHAREDSHELF=FOLDER_INPUT_FETCHED_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF;
    public static final String FOLDER_INPUT_FETCHED_VILLA_I_TATTI_FOTOINDEX=FOLDER_INPUT_FETCHED_VILLA_I_TATTI+"/"+Resources.FOTOINDEX;
    public static final String FOLDER_INPUT_FETCHED_FRICK=FOLDER_INPUT_FETCHED+"/"+Resources.FRICK;
    public static final String FOLDER_INPUT_FETCHED_ZERI=FOLDER_INPUT_FETCHED+"/"+Resources.ZERI;
    public static final String FOLDER_INPUT_FETCHED_ZERI_ARTWORKS=FOLDER_INPUT_FETCHED_ZERI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_INPUT_FETCHED_ZERI_PHOTOGRAPHS=FOLDER_INPUT_FETCHED_ZERI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_INPUT_FETCHED_MARBURG=FOLDER_INPUT_FETCHED+"/"+Resources.MARBURG;
    public static final String FOLDER_INPUT_FETCHED_KHI=FOLDER_INPUT_FETCHED+"/"+Resources.KHI;
    public static final String FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI=FOLDER_INPUT_NORMALIZED+"/"+Resources.VILLA_I_TATTI;
    public static final String FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF=FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF;
    public static final String FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_FOTOINDEX=FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI+"/"+Resources.FOTOINDEX;
    public static final String FOLDER_INPUT_NORMALIZED_FRICK=FOLDER_INPUT_NORMALIZED+"/"+Resources.FRICK;
    public static final String FOLDER_INPUT_NORMALIZED_ZERI=FOLDER_INPUT_NORMALIZED+"/"+Resources.ZERI;
    public static final String FOLDER_INPUT_NORMALIZED_ZERI_ARTWORKS=FOLDER_INPUT_NORMALIZED_ZERI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_INPUT_NORMALIZED_ZERI_PHOTOGRAPHS=FOLDER_INPUT_NORMALIZED_ZERI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_INPUT_NORMALIZED_MARBURG=FOLDER_INPUT_NORMALIZED+"/"+Resources.MARBURG;
    public static final String FOLDER_INPUT_NORMALIZED_KHI=FOLDER_INPUT_NORMALIZED+"/"+Resources.KHI;
    public static final String FOLDER_MAPPINGS=FOLDER_WORKSPACE+"/"+"2_Mappings";
    public static final String FOLDER_OUTPUT=FOLDER_WORKSPACE+"/"+"3_Output";
    public static final String FOLDER_OUTPUT_TRANSFORMED=FOLDER_OUTPUT+"/"+"1_Transformed";
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.VILLA_I_TATTI;
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.FOTOINDEX;
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX_FC_FR=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.FOTOINDEX+"_FC_FR";
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF;
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF_FC_FR=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF+"_FC_FR";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.HERTZIANA;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ARTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ARTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ARTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.BUILTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.BUILTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.BUILTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.BUILTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ACTORS=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ACTORS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_FRICK=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.FRICK;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.ZERI;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI_ARTWORKS=FOLDER_OUTPUT_TRANSFORMED_ZERI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS=FOLDER_OUTPUT_TRANSFORMED_ZERI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.MARBURG;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ACTORS=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ACTORS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ARTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ARTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ARTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.PHOTOGRAPHS+"_fc_fr";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.BUILTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.BUILTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.BUILTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.BUILTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_WORKS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.WORKS+"_fc_fr";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.KHI;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ARTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ARTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ARTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.BUILTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.BUILTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.BUILTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.BUILTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ACTORS=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ACTORS;
    public static final String FOLDER_OUTPUT_NORMALIZED=FOLDER_OUTPUT+"/"+"2_Normalized";
    public static final String FOLDER_OUTPUT_NORMALIZED_ZERI=FOLDER_OUTPUT_NORMALIZED+"/"+Resources.ZERI;
    public static final String FOLDER_OUTPUT_NORMALIZED_ZERI_ARTWORKS=FOLDER_OUTPUT_NORMALIZED_ZERI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_NORMALIZED_ZERI_PHOTOGRAPHS=FOLDER_OUTPUT_NORMALIZED_ZERI+"/"+Resources.PHOTOGRAPHS;
    
    /* Sources names */
    public static final String HERTZIANA="Hertziana";
    public static final String KHI="KHI";
    public static final String MARBURG="Marburg";
    public static final String ZERI="Zeri";
    public static final String FRICK="Frick";
    public static final String VILLA_I_TATTI="VillaITatti";
    public static final String FOTOINDEX="FotoIndex";
    public static final String SHAREDSHELF="SharedShelf";
    
    /* Entities names */
    public static final String ACTORS="actors";
    public static final String ARTIST="Artist";
    public static final String ARTWORKS="artworks";
    public static final String BUILTWORKS="builtworks";
    public static final String COLLECTION="Collection";
    public static final String INSTITUTION="Institution";
    public static final String PHOTOGRAPH="Photograph";
    public static final String PHOTOGRAPHS="photographs";
    public static final String L2V="l2v";
    public static final String LVL2="lvl2";
    public static final String WORK="Work";
    public static final String WORKS="works";
    
    /* Mapping resources */
    public static final String MAPPINGS_VILLA_I_TATTI=FOLDER_MAPPINGS+"/"+Resources.VILLA_I_TATTI;
    public static final String MAPPINGS_VILLA_I_TATTI_SHAREDSHELF=MAPPINGS_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF;
    
    public static final String MAPPINGS_VILLA_I_TATTI_SHAREDSHELF_ALL=MAPPINGS_VILLA_I_TATTI_SHAREDSHELF+"/"+"mappings.x3ml";
    public static final String MAPPINGS_VILLA_I_TATTI_SHAREDSHELF_FC_FR=MAPPINGS_VILLA_I_TATTI_SHAREDSHELF+"/"+"mappings-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_VILLA_I_TATTI_SHAREDSHELF=MAPPINGS_VILLA_I_TATTI_SHAREDSHELF+"/"+"generator-policy.xml";
    public static final String MAPPINGS_VILLA_I_TATTI_FOTOINDEX=MAPPINGS_VILLA_I_TATTI+"/"+Resources.FOTOINDEX;
    public static final String MAPPINGS_VILLA_I_TATTI_FOTOINDEX_ARTIST=MAPPINGS_VILLA_I_TATTI_FOTOINDEX+"/"+"mappings_artist.x3ml";
    public static final String MAPPINGS_VILLA_I_TATTI_FOTOINDEX_COLLECTION=MAPPINGS_VILLA_I_TATTI_FOTOINDEX+"/"+"mappings_collection.x3ml";
    public static final String MAPPINGS_VILLA_I_TATTI_FOTOINDEX_INSTITUTION=MAPPINGS_VILLA_I_TATTI_FOTOINDEX+"/"+"mappings_institution.x3ml";
    public static final String MAPPINGS_VILLA_I_TATTI_FOTOINDEX_PHOTO=MAPPINGS_VILLA_I_TATTI_FOTOINDEX+"/"+"mappings_photo.x3ml";
    public static final String MAPPINGS_VILLA_I_TATTI_FOTOINDEX_WORK=MAPPINGS_VILLA_I_TATTI_FOTOINDEX+"/"+"mappings_work.x3ml";
    public static final String MAPPINGS_VILLA_I_TATTI_FOTOINDEX_FC_FR=MAPPINGS_VILLA_I_TATTI_FOTOINDEX+"/"+"mappings-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_VILLA_I_TATTI_FOTOINDEX=MAPPINGS_VILLA_I_TATTI_FOTOINDEX+"/"+"generator-policy.xml";
    public static final String MAPPINGS_HERTZIANA=FOLDER_MAPPINGS+"/"+Resources.HERTZIANA;
    public static final String MAPPINGS_HERTZIANA_ALL=FOLDER_MAPPINGS+"/"+"mappings-hertziana.x3ml";
    public static final String MAPPINGS_HERTZIANA_ACTORS=FOLDER_MAPPINGS+"/"+"mappings-hertziana-actors.x3ml";
    public static final String MAPPINGS_HERTZIANA_ARTWORKS=FOLDER_MAPPINGS+"/"+"mappings-hertziana-artworks.x3ml";
    public static final String MAPPINGS_HERTZIANA_ARTWORKS_LVL2=FOLDER_MAPPINGS+"/"+"mappings-hertziana-artworks-lvl2.x3ml";
    public static final String MAPPINGS_HERTZIANA_ARTWORKS_LVL3=FOLDER_MAPPINGS+"/"+"mappings-hertziana-artworks-lvl3.x3ml";
    public static final String MAPPINGS_HERTZIANA_ARTWORKS_LVL4=FOLDER_MAPPINGS+"/"+"mappings-hertziana-artworks-lvl4.x3ml";
    public static final String MAPPINGS_HERTZIANA_BUILTWORKS=FOLDER_MAPPINGS+"/"+"mappings-hertziana-builtworks.x3ml";
    public static final String MAPPINGS_HERTZIANA_BUILTWORKS_LVL2=FOLDER_MAPPINGS+"/"+"mappings-hertziana-builtworks-lvl2.x3ml";
    public static final String MAPPINGS_HERTZIANA_BUILTWORKS_LVL3=FOLDER_MAPPINGS+"/"+"mappings-hertziana-builtworks-lvl3.x3ml";
    public static final String MAPPINGS_HERTZIANA_BUILTWORKS_LVL4=FOLDER_MAPPINGS+"/"+"mappings-hertziana-builtworks-lvl4.x3ml";
    public static final String MAPPINGS_HERTZIANA_PHOTOGRAPHS=FOLDER_MAPPINGS+"/"+"mappings-hertziana-photographs.x3ml";
    public static final String MAPPINGS_HERTZIANA_LVL2=FOLDER_MAPPINGS+"/"+"mappings-hertziana-lvl2.x3ml";
    public static final String GENERATOR_POLICY_HERTZIANA=FOLDER_MAPPINGS+"/"+"generator-policy-hertziana.xml";
    public static final String MAPPINGS_FRICK=FOLDER_MAPPINGS+"/"+Resources.ZERI;
    public static final String MAPPINGS_FRICK_ALL=FOLDER_MAPPINGS+"/"+"mappings-fricks.x3ml";
    public static final String GENERATOR_POLICY_FRICK=FOLDER_MAPPINGS+"/"+"generator-policy-fricks.xml";
    public static final String MAPPINGS_ZERI=FOLDER_MAPPINGS+"/"+Resources.ZERI;
    public static final String MAPPINGS_ZERI_ARTWORKS=FOLDER_MAPPINGS+"/"+"mappings-zeri-artworks.x3ml";
    public static final String MAPPINGS_ZERI_PHOTOGRAPHS=FOLDER_MAPPINGS+"/"+"mappings-zeri-photographs.x3ml";
    public static final String GENERATOR_POLICY_ZERI=FOLDER_MAPPINGS+"/"+"generator-policy-zeri.xml";
    public static final String MAPPINGS_MARBURG=FOLDER_MAPPINGS+"/"+Resources.MARBURG;
    public static final String MAPPINGS_MARBURG_ACTORS=MAPPINGS_MARBURG+"/"+"mappings-actors.x3ml";
    public static final String MAPPINGS_MARBURG_ARTWORKS=MAPPINGS_MARBURG+"/"+"mappings-artworks.x3ml";
    public static final String MAPPINGS_MARBURG_ARTWORKS_LVL2=MAPPINGS_MARBURG+"/"+"mappings-artworks-lvl2.x3ml";
    public static final String MAPPINGS_MARBURG_ARTWORKS_LVL3=MAPPINGS_MARBURG+"/"+"mappings-artworks-lvl3.x3ml";
    public static final String MAPPINGS_MARBURG_ARTWORKS_LVL4=MAPPINGS_MARBURG+"/"+"mappings-artworks-lvl4.x3ml";
    public static final String MAPPINGS_MARBURG_BUILTWORKS=MAPPINGS_MARBURG+"/"+"mappings-buildworks.x3ml";
    public static final String MAPPINGS_MARBURG_BUILTWORKS_LVL2=MAPPINGS_MARBURG+"/"+"mappings-buildworks-lvl2.x3ml";
    public static final String MAPPINGS_MARBURG_BUILTWORKS_LVL3=MAPPINGS_MARBURG+"/"+"mappings-buildworks-lvl3.x3ml";
    public static final String MAPPINGS_MARBURG_BUILTWORKS_LVL4=MAPPINGS_MARBURG+"/"+"mappings-buildworks-lvl4.x3ml";
    public static final String MAPPINGS_MARBURG_PHOTOGRAPHS=MAPPINGS_MARBURG+"/"+"mappings-photos.x3ml";
    public static final String MAPPINGS_MARBURG_PHOTOGRAPHS_FC_FR=MAPPINGS_MARBURG+"/"+"mappings-photos-fc-fr.x3ml";
    public static final String MAPPINGS_MARBURG_WORKS_FC_FR=MAPPINGS_MARBURG+"/"+"mappings-works-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_MARBURG=MAPPINGS_MARBURG+"/"+"generator-policy.xml";
    public static final String MAPPINGS_KHI=FOLDER_MAPPINGS+"/"+Resources.KHI;
    public static final String MAPPINGS_KHI_ACTORS=FOLDER_MAPPINGS+"/"+"mappings-khi-actors.x3ml";
    public static final String MAPPINGS_KHI_ARTWORKS=FOLDER_MAPPINGS+"/"+"mappings-khi-artworks.x3ml";
    public static final String MAPPINGS_KHI_ARTWORKS_LVL2=FOLDER_MAPPINGS+"/"+"mappings-khi-artworks-lvl2.x3ml";
    public static final String MAPPINGS_KHI_ARTWORKS_LVL3=FOLDER_MAPPINGS+"/"+"mappings-khi-artworks-lvl3.x3ml";
    public static final String MAPPINGS_KHI_ARTWORKS_LVL4=FOLDER_MAPPINGS+"/"+"mappings-khi-artworks-lvl4.x3ml";
    public static final String MAPPINGS_KHI_BUILTWORKS=FOLDER_MAPPINGS+"/"+"mappings-khi-builtworks.x3ml";
    public static final String MAPPINGS_KHI_BUILTWORKS_LVL2=FOLDER_MAPPINGS+"/"+"mappings-khi-builtworks-lvl2.x3ml";
    public static final String MAPPINGS_KHI_BUILTWORKS_LVL3=FOLDER_MAPPINGS+"/"+"mappings-khi-builtworks-lvl3.x3ml";
    public static final String MAPPINGS_KHI_BUILTWORKS_LVL4=FOLDER_MAPPINGS+"/"+"mappings-khi-builtworks-lvl4.x3ml";
    public static final String MAPPINGS_KHI_PHOTOGRAPHS=FOLDER_MAPPINGS+"/"+"mappings-khi-photographs.x3ml";
    public static final String GENERATOR_POLICY_KHI=FOLDER_MAPPINGS+"/"+"generator-policy-khi.xml";
    
    /* HERTZIANA resources */
    public static final String HERTZIANA_COMBINED_RESOURCES_ROOT_ELEMENT="root";
    public static final String HERTZIANA_COMBINED_RESOURCES_OBJ_ELEMENT="obj";
     
    /* KHI resources */
    public static final String KHI_COMBINED_RESOURCES_ROOT_ELEMENT="root";
    public static final String KHI_COMBINED_RESOURCES_OBJ_ELEMENT="obj";
    
    /* MARBURG resources */
    public static final String MARBURG_COMBINED_RESOURCES_ROOT_ELEMENT="root";
    public static final String MARBURG_COMBINED_RESOURCES_OBJ_ELEMENT="obj";
    
    /* Misc Resources */
    public static final int MAX_FILESIZE_INPUT_RESOURCES_IN_MB=1;
    public static final int MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB=4;
}
