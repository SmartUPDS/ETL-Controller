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
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX_FC_FR=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.FOTOINDEX+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF;
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF_FC_FR=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.HERTZIANA;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ACTORS=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ACTORS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ARTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ARTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ARTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_PHOTOGRAPHS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.PHOTOGRAPHS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.BUILTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.BUILTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.BUILTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.BUILTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_WORKS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.WORKS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_FRICK=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.FRICK;
    public static final String FOLDER_OUTPUT_TRANSFORMED_FRICK_ALL=FOLDER_OUTPUT_TRANSFORMED_FRICK+"/"+"All";
    public static final String FOLDER_OUTPUT_TRANSFORMED_FRICK_FC_FR=FOLDER_OUTPUT_TRANSFORMED_FRICK+"/"+Resources.FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.ZERI;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI_ARTWORKS=FOLDER_OUTPUT_TRANSFORMED_ZERI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS=FOLDER_OUTPUT_TRANSFORMED_ZERI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI_PHOTOGRAPHS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_ZERI+"/"+Resources.PHOTOGRAPHS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_ZERI_WORKS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_ZERI+"/"+Resources.WORKS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.MARBURG;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ACTORS=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ACTORS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ARTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ARTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_ARTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.ARTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_PHOTOGRAPHS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.PHOTOGRAPHS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.BUILTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.BUILTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.BUILTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_BUILTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.BUILTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_MARBURG_WORKS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_MARBURG+"/"+Resources.WORKS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.KHI;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ARTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ARTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ARTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_PHOTOGRAPHS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.PHOTOGRAPHS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.BUILTWORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL2=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.BUILTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL3=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.BUILTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_LVL4=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.BUILTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ACTORS=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ACTORS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_WORKS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.WORKS+Resources._FC_FR;
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
    
    /* Other names */
    public static final String _FC_FR="_FC_FR";
    public static final String FC_FR="FC_FR";
    
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
    public static final String MAPPINGS_HERTZIANA_ACTORS=MAPPINGS_HERTZIANA+"/"+"mappings-actors.x3ml";
    public static final String MAPPINGS_HERTZIANA_ARTWORKS=MAPPINGS_HERTZIANA+"/"+"mappings-artworks.x3ml";
    public static final String MAPPINGS_HERTZIANA_ARTWORKS_LVL2=MAPPINGS_HERTZIANA+"/"+"mappings-artworks-lvl2.x3ml";
    public static final String MAPPINGS_HERTZIANA_ARTWORKS_LVL3=MAPPINGS_HERTZIANA+"/"+"mappings-artworks-lvl3.x3ml";
    public static final String MAPPINGS_HERTZIANA_ARTWORKS_LVL4=MAPPINGS_HERTZIANA+"/"+"mappings-artworks-lvl4.x3ml";
    public static final String MAPPINGS_HERTZIANA_BUILTWORKS=MAPPINGS_HERTZIANA+"/"+"mappings-buildworks.x3ml";
    public static final String MAPPINGS_HERTZIANA_BUILTWORKS_LVL2=MAPPINGS_HERTZIANA+"/"+"mappings-buildworks-lvl2.x3ml";
    public static final String MAPPINGS_HERTZIANA_BUILTWORKS_LVL3=MAPPINGS_HERTZIANA+"/"+"mappings-buildworks-lvl3.x3ml";
    public static final String MAPPINGS_HERTZIANA_BUILTWORKS_LVL4=MAPPINGS_HERTZIANA+"/"+"mappings-buildworks-lvl4.x3ml";
    public static final String MAPPINGS_HERTZIANA_PHOTOGRAPHS=MAPPINGS_HERTZIANA+"/"+"mappings-photos.x3ml";
    public static final String MAPPINGS_HERTZIANA_PHOTOGRAPHS_FC_FR=MAPPINGS_HERTZIANA+"/"+"mappings-photos-fc-fr.x3ml";
    public static final String MAPPINGS_HERTZIANA_WORKS_FC_FR=MAPPINGS_HERTZIANA+"/"+"mappings-works-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_HERTZIANA=MAPPINGS_HERTZIANA+"/"+"generator-policy.xml";
    public static final String MAPPINGS_FRICK=FOLDER_MAPPINGS+"/"+Resources.FRICK;
    public static final String MAPPINGS_FRICK_ALL=MAPPINGS_FRICK+"/"+"mappings.x3ml";
    public static final String MAPPINGS_FRICK_FC_FR=MAPPINGS_FRICK+"/"+"mappings-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_FRICK=MAPPINGS_FRICK+"/"+"generator-policy.xml";
    public static final String MAPPINGS_ZERI=FOLDER_MAPPINGS+"/"+Resources.ZERI;
    public static final String MAPPINGS_ZERI_ARTWORKS=MAPPINGS_ZERI+"/"+"mappings-artworks.x3ml";
    public static final String MAPPINGS_ZERI_PHOTOGRAPHS=MAPPINGS_ZERI+"/"+"mappings-photographs.x3ml";
    public static final String MAPPINGS_ZERI_PHOTOGRAPHS_FC_FR=MAPPINGS_ZERI+"/"+"mappings-photographs-fc-fr.x3ml";
    public static final String MAPPINGS_ZERI_WORKS_FC_FR=MAPPINGS_ZERI+"/"+"mappings-works-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_ZERI=FOLDER_MAPPINGS+"/"+"generator-policy.xml";
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
    public static final String MAPPINGS_KHI_ACTORS=MAPPINGS_KHI+"/"+"mappings-actors.x3ml";
    public static final String MAPPINGS_KHI_ARTWORKS=MAPPINGS_KHI+"/"+"mappings-artworks.x3ml";
    public static final String MAPPINGS_KHI_ARTWORKS_LVL2=MAPPINGS_KHI+"/"+"mappings-artworks-lvl2.x3ml";
    public static final String MAPPINGS_KHI_ARTWORKS_LVL3=MAPPINGS_KHI+"/"+"mappings-artworks-lvl3.x3ml";
    public static final String MAPPINGS_KHI_ARTWORKS_LVL4=MAPPINGS_KHI+"/"+"mappings-artworks-lvl4.x3ml";
    public static final String MAPPINGS_KHI_BUILTWORKS=MAPPINGS_KHI+"/"+"mappings-buildworks.x3ml";
    public static final String MAPPINGS_KHI_BUILTWORKS_LVL2=MAPPINGS_KHI+"/"+"mappings-buildworks-lvl2.x3ml";
    public static final String MAPPINGS_KHI_BUILTWORKS_LVL3=MAPPINGS_KHI+"/"+"mappings-buildworks-lvl3.x3ml";
    public static final String MAPPINGS_KHI_BUILTWORKS_LVL4=MAPPINGS_KHI+"/"+"mappings-buildworks-lvl4.x3ml";
    public static final String MAPPINGS_KHI_PHOTOGRAPHS=MAPPINGS_KHI+"/"+"mappings-photos.x3ml";
    public static final String MAPPINGS_KHI_PHOTOGRAPHS_FC_FR=MAPPINGS_KHI+"/"+"mappings-photos-fc-fr.x3ml";
    public static final String MAPPINGS_KHI_WORKS_FC_FR=MAPPINGS_KHI+"/"+"mappings-works-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_KHI=MAPPINGS_KHI+"/"+"generator-policy.xml";
    
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
    public static final int TIME_OUT_REQUESTS=30000;
    
    /* Spring beans resources */
    public static final String SPRING_BEANS_FILENAME="beans.xml";
    public static final String TRIPLESTORE_BEAN_ID="triplestoreConnection";
    
    /* Default graphspaces */
    public static final String GRAPHSPACE_FRICK="http://frick/";
    public static final String GRAPHSPACE_FRICK_FC_FR="http://frick_fc_fr/";
    public static final String GRAPHSPACE_HERTZIANA="http://hertziana/";
    public static final String GRAPHSPACE_HERTZIANA_FC_FR="http://hertziana_fc_fr/";
    public static final String GRAPHSPACE_KHI="http://khi/";
    public static final String GRAPHSPACE_KHI_FC_FR="http://khi_fc_fr/";
    public static final String GRAPHSPACE_MARBURG="http://marburg/";
    public static final String GRAPHSPACE_MARBURG_FC_FR="http://marburg_fc_fr/";
    public static final String GRAPHSPACE_VILLA_I_TATTI="http://itatti/";
    public static final String GRAPHSPACE_VILLA_I_TATTI_FC_FR="http://itatti_fc_fr/";
    public static final String GRAPHSPACE_ZERI="http://zeri/";
    public static final String GRAPHSPACE_ZERI_FC_FR="http://zeri_fc_fr/";
    
}
