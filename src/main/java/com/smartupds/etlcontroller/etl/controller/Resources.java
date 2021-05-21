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
    public static final String FOLDER_INPUT_FETCHED_ZERI_ARTWORKS_ZIPS=FOLDER_INPUT_FETCHED_ZERI+"/"+Resources.ARTWORKS+"_ZIPS";
    public static final String FOLDER_INPUT_FETCHED_ZERI_PHOTOGRAPHS=FOLDER_INPUT_FETCHED_ZERI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_INPUT_FETCHED_ZERI_PHOTOGRAPHS_ZIPS=FOLDER_INPUT_FETCHED_ZERI+"/"+Resources.PHOTOGRAPHS+"_ZIPS";
    public static final String FOLDER_INPUT_FETCHED_MARBURG=FOLDER_INPUT_FETCHED+"/"+Resources.MARBURG;
    public static final String FOLDER_INPUT_FETCHED_KHI=FOLDER_INPUT_FETCHED+"/"+Resources.KHI;
    public static final String FOLDER_INPUT_FETCHED_MIDAS_VOCS=FOLDER_INPUT_FETCHED+"/"+Resources.MIDAS_VOCS;
    public static final String FOLDER_INPUT_FETCHED_MIDAS_VOCS_ARTISTS=FOLDER_INPUT_FETCHED_MIDAS_VOCS+"/"+Resources.ARTISTS;
    public static final String FOLDER_INPUT_FETCHED_MIDAS_VOCS_PLACES=FOLDER_INPUT_FETCHED_MIDAS_VOCS+"/"+Resources.PLACES;
    public static final String FOLDER_INPUT_FETCHED_MIDAS_VOCS_THESAURUS=FOLDER_INPUT_FETCHED_MIDAS_VOCS+"/"+Resources.THESAURUS;
    
    public static final String FOLDER_INPUT_FETCHED_NYPL=FOLDER_INPUT_FETCHED+"/"+Resources.NYPL;
    public static final String FOLDER_INPUT_FETCHED_NYPL_ADDRESS=FOLDER_INPUT_FETCHED_NYPL+"/"+ Resources.ADDRESS;
    public static final String FOLDER_INPUT_FETCHED_NYPL_BIOGRAPHY=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.BIOGRAPHY;
    public static final String FOLDER_INPUT_FETCHED_NYPL_COLLECTION=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.COLLECTION.toLowerCase()+"s";
    public static final String FOLDER_INPUT_FETCHED_NYPL_CONSTITUENTS=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.CONSTITUENTS;
    public static final String FOLDER_INPUT_FETCHED_NYPL_GENDER=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.GENDER;
    public static final String FOLDER_INPUT_FETCHED_NYPL_NATIONALITY=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.NATIONALITY;
    public static final String FOLDER_INPUT_FETCHED_NYPL_PROCESS=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.PROCESS;
    public static final String FOLDER_INPUT_FETCHED_NYPL_ROLE=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.ROLE;
    public static final String FOLDER_INPUT_FETCHED_NYPL_BIOGRAPHIES=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.BIOGRAPHY + "."+ Resources.EXTENSION_XML;
    public static final String FOLDER_INPUT_FETCHED_NYPL_COLLECTIONS=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.COLLECTION.toLowerCase()+"s" + "."+ Resources.EXTENSION_XML;
    public static final String FOLDER_INPUT_FETCHED_NYPL_COUNTRIES=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.COUNTRIES + "."+ Resources.EXTENSION_XML;
    public static final String FOLDER_INPUT_FETCHED_NYPL_COUNTRIES_WOF=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.COUNTRIES_WOF + "."+ Resources.EXTENSION_XML;
    public static final String FOLDER_INPUT_FETCHED_NYPL_FORMAT=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.FORMAT + "."+ Resources.EXTENSION_XML;
    public static final String FOLDER_INPUT_FETCHED_NYPL_FORMATS=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.FORMAT+ "s" + "."+ Resources.EXTENSION_XML;
    public static final String FOLDER_INPUT_FETCHED_NYPL_GENDERS=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.GENDER + "."+ Resources.EXTENSION_XML;
    public static final String FOLDER_INPUT_FETCHED_NYPL_NATIONALITIES=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.NATIONALITY + "."+ Resources.EXTENSION_XML;
    public static final String FOLDER_INPUT_FETCHED_NYPL_PROCESSES=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.PROCESS + "."+ Resources.EXTENSION_XML;
    public static final String FOLDER_INPUT_FETCHED_NYPL_ROLES=FOLDER_INPUT_FETCHED_NYPL+"/"+Resources.ROLE + "."+ Resources.EXTENSION_XML;
    
    public static final String FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI=FOLDER_INPUT_NORMALIZED+"/"+Resources.VILLA_I_TATTI;
    public static final String FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF=FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF;
    public static final String FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI_FOTOINDEX=FOLDER_INPUT_NORMALIZED_VILLA_I_TATTI+"/"+Resources.FOTOINDEX;
    public static final String FOLDER_INPUT_NORMALIZED_FRICK=FOLDER_INPUT_NORMALIZED+"/"+Resources.FRICK;
    public static final String FOLDER_INPUT_NORMALIZED_ZERI=FOLDER_INPUT_NORMALIZED+"/"+Resources.ZERI;
    public static final String FOLDER_INPUT_NORMALIZED_ZERI_ARTWORKS=FOLDER_INPUT_NORMALIZED_ZERI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_INPUT_NORMALIZED_ZERI_PHOTOGRAPHS=FOLDER_INPUT_NORMALIZED_ZERI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_INPUT_NORMALIZED_MARBURG=FOLDER_INPUT_NORMALIZED+"/"+Resources.MARBURG;
    public static final String FOLDER_INPUT_NORMALIZED_KHI=FOLDER_INPUT_NORMALIZED+"/"+Resources.KHI;
    public static final String FOLDER_INPUT_NORMALIZED_MIDAS_VOCS=FOLDER_INPUT_NORMALIZED+"/"+Resources.MIDAS_VOCS;
    public static final String FOLDER_INPUT_NORMALIZED_MIDAS_VOCS_ARTISTS=FOLDER_INPUT_NORMALIZED_MIDAS_VOCS+"/"+Resources.ARTISTS;
    public static final String FOLDER_INPUT_NORMALIZED_MIDAS_VOCS_PLACES=FOLDER_INPUT_NORMALIZED_MIDAS_VOCS+"/"+Resources.PLACES;
    public static final String FOLDER_INPUT_NORMALIZED_MIDAS_VOCS_THESAURUS=FOLDER_INPUT_NORMALIZED_MIDAS_VOCS+"/"+Resources.THESAURUS;
    public static final String FOLDER_MAPPINGS=FOLDER_WORKSPACE+"/"+"2_Mappings";
    public static final String FOLDER_OUTPUT=FOLDER_WORKSPACE+"/"+"3_Output";
    public static final String FOLDER_OUTPUT_TRANSFORMED=FOLDER_OUTPUT+"/"+"1_Transformed";
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.VILLA_I_TATTI;
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.FOTOINDEX;
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_FOTOINDEX_FC_FR=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.FOTOINDEX+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF;
    public static final String FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF_ULAN=FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF+Resources._ULAN;
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
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_ARTWORKS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.ARTWORKS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_HERTZIANA_BUILTWORKS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_HERTZIANA+"/"+Resources.BUILTWORKS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_FRICK=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.FRICK;
    public static final String FOLDER_OUTPUT_TRANSFORMED_FRICK_ALL=FOLDER_OUTPUT_TRANSFORMED_FRICK+"/"+"All";
    public static final String FOLDER_OUTPUT_TRANSFORMED_FRICK_WORKS=FOLDER_OUTPUT_TRANSFORMED_FRICK+"/"+Resources.WORKS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_FRICK_INSTITUTIONS=FOLDER_OUTPUT_TRANSFORMED_FRICK+"/"+Resources.INSTITUTIONS;
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
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_ARTWORKS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.ARTWORKS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_KHI_BUILTWORKS_FC_FR=FOLDER_OUTPUT_TRANSFORMED_KHI+"/"+Resources.BUILTWORKS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS=FOLDER_OUTPUT_TRANSFORMED+"/"+Resources.MIDAS_VOCS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_ARTISTS=FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS+"/"+Resources.ARTISTS;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_ARTISTS_KHI=FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_ARTISTS+"/"+Resources.KHI;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_ARTISTS_MARBURG=FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_ARTISTS+"/"+Resources.MARBURG;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_ARTISTS_HERTZIANA=FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_ARTISTS+"/"+Resources.HERTZIANA;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_PLACES=FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS+"/"+Resources.PLACES;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_PLACES_KHI=FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_PLACES+"/"+Resources.KHI;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_PLACES_MARBURG=FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_PLACES+"/"+Resources.MARBURG;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_PLACES_HERTZIANA=FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_PLACES+"/"+Resources.HERTZIANA;
    public static final String FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS_THESAURUS=FOLDER_OUTPUT_TRANSFORMED_MIDAS_VOCS+"/"+Resources.THESAURUS;
    public static final String FOLDER_OUTPUT_NORMALIZED=FOLDER_OUTPUT+"/"+"2_Normalized";
    public static final String FOLDER_OUTPUT_NORMALIZED_VILLA_I_ITATTI=FOLDER_OUTPUT_NORMALIZED+"/"+Resources.VILLA_I_TATTI;
    public static final String FOLDER_OUTPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF=FOLDER_OUTPUT_NORMALIZED_VILLA_I_ITATTI+"/"+Resources.SHAREDSHELF;
    public static final String FOLDER_OUTPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF_ULAN=FOLDER_OUTPUT_NORMALIZED_VILLA_I_ITATTI+"/"+Resources.SHAREDSHELF+Resources._ULAN;
    public static final String FOLDER_OUTPUT_NORMALIZED_VILLA_I_TATTI_SHAREDSHELF_FC_FR=FOLDER_OUTPUT_NORMALIZED_VILLA_I_ITATTI+"/"+Resources.SHAREDSHELF+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_NORMALIZED_VILLA_I_TATTI_FOTOINDEX_FC_FR=FOLDER_OUTPUT_NORMALIZED_VILLA_I_ITATTI+"/"+Resources.FOTOINDEX+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA=FOLDER_OUTPUT_NORMALIZED+"/"+Resources.HERTZIANA;
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ACTORS=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.ACTORS;
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ARTWORKS=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ARTWORKS_LVL2=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.ARTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ARTWORKS_LVL3=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.ARTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ARTWORKS_LVL4=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.ARTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_BUILTWORKS=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.BUILTWORKS;
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_BUILTWORKS_LVL2=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.BUILTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_BUILTWORKS_LVL3=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.BUILTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_BUILTWORKS_LVL4=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.BUILTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_PHOTOGRAPHS=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_ARTWORKS_FC_FR=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.ARTWORKS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_BUILTWORKS_FC_FR=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.BUILTWORKS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_NORMALIZED_HERTZIANA_PHOTOGRAPHS_FC_FR=FOLDER_OUTPUT_NORMALIZED_HERTZIANA+"/"+Resources.PHOTOGRAPHS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG=FOLDER_OUTPUT_NORMALIZED+"/"+Resources.MARBURG;
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_ACTORS=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.ACTORS;
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_ARTWORKS=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_ARTWORKS_LVL2=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.ARTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_ARTWORKS_LVL3=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.ARTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_ARTWORKS_LVL4=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.ARTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_BUILTWORKS=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.BUILTWORKS;
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_BUILTWORKS_LVL2=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.BUILTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_BUILTWORKS_LVL3=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.BUILTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_BUILTWORKS_LVL4=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.BUILTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_PHOTOGRAPHS=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_PHOTOGRAPHS_FC_FR=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.PHOTOGRAPHS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_NORMALIZED_MARBURG_WORKS_FC_FR=FOLDER_OUTPUT_NORMALIZED_MARBURG+"/"+Resources.WORKS+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_NORMALIZED_ZERI=FOLDER_OUTPUT_NORMALIZED+"/"+Resources.ZERI;
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI=FOLDER_OUTPUT_NORMALIZED+"/"+Resources.KHI;
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_ACTORS=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.ACTORS;
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_ARTWORKS=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_ARTWORKS_LVL2=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.ARTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_ARTWORKS_LVL3=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.ARTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_ARTWORKS_LVL4=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.ARTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_BUILTWORKS=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.BUILTWORKS;
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_BUILTWORKS_LVL2=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.BUILTWORKS+"_lvl2";
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_BUILTWORKS_LVL3=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.BUILTWORKS+"_lvl3";
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_BUILTWORKS_LVL4=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.BUILTWORKS+"_lvl4";
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_PHOTOGRAPHS=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_ARTWORKS_FC_FR=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.ARTWORKS+"/"+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_BUILTWORKS_FC_FR=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.BUILTWORKS+"/"+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_NORMALIZED_KHI_PHOTOGRAPHS_FC_FR=FOLDER_OUTPUT_NORMALIZED_KHI+"/"+Resources.PHOTOGRAPHS+"/"+Resources._FC_FR;
    public static final String FOLDER_OUTPUT_NORMALIZED_ZERI_ARTWORKS=FOLDER_OUTPUT_NORMALIZED_ZERI+"/"+Resources.ARTWORKS;
    public static final String FOLDER_OUTPUT_NORMALIZED_ZERI_PHOTOGRAPHS=FOLDER_OUTPUT_NORMALIZED_ZERI+"/"+Resources.PHOTOGRAPHS;
    public static final String FOLDER_OUTPUT_NORMALIZED_MIDAS_VOCS=FOLDER_OUTPUT_NORMALIZED+"/"+Resources.MIDAS_VOCS;
    
    public static final String FOLDER_OUTPUT_INSTANCE_MATCHING=FOLDER_OUTPUT+"/"+"3_Instance_Matching";
    public static final String FOLDER_OUTPUT_INSTANCE_MATCHING_ARTISTS=FOLDER_OUTPUT_INSTANCE_MATCHING+"/"+"Artists";
    public static final String FOLDER_OUTPUT_INSTANCE_MATCHING_INSTITUTIONS=FOLDER_OUTPUT_INSTANCE_MATCHING+"/"+"Institutions";
    public static final String FOLDER_OUTPUT_INSTANCE_MATCHING_PLACES=FOLDER_OUTPUT_INSTANCE_MATCHING+"/"+"Places";
    public static final String FOLDER_OUTPUT_INSTANCE_MATCHING_PHOTOGRAPHERS=FOLDER_OUTPUT_INSTANCE_MATCHING+"/"+"Photographers";
    public static final String FOLDER_OUTPUT_INSTANCE_MATCHING_TYPES=FOLDER_OUTPUT_INSTANCE_MATCHING+"/"+"Types";
    public static final String FOLDER_OUTPUT_INSTANCE_MATCHING_WORKS=FOLDER_OUTPUT_INSTANCE_MATCHING+"/"+"Works";
    public static final String FOLDER_OUTPUT_INSTANCE_MATCHING_WORKS_HASHED = FOLDER_OUTPUT_INSTANCE_MATCHING_WORKS+"/"+"Hashed";
    public static final String FOLDER_OUTPUT_INSTANCE_MATCHING_WORKS_MATCHED = FOLDER_OUTPUT_INSTANCE_MATCHING_WORKS+"/"+"Matched";
    
    public static final String FOLDER_OUTPUT_INDEXING=FOLDER_OUTPUT+"/"+"4_Indexing";
    public static final String FOLDER_OUTPUT_INDEXING_WORKS=FOLDER_OUTPUT_INDEXING +"/"+Resources.WORKS;
    
//    public static final String FOLDER_OUTPUT_VOCABULARIES=FOLDER_OUTPUT+"/"+"4_Vocabularies";
//    public static final String FOLDER_OUTPUT_VOCABULARIES_NYPL_PIC=FOLDER_OUTPUT_VOCABULARIES+"/"+"NYPL-PIC";
//    public static final String FOLDER_OUTPUT_VOCABULARIES_ULAN=FOLDER_OUTPUT_VOCABULARIES+"/"+"ULAN";
//    public static final String FOLDER_OUTPUT_VOCABULARIES_WIKIDATA=FOLDER_OUTPUT_VOCABULARIES+"/"+"Wikidata";
//    public static final String FOLDER_OUTPUT_VOCABULARIES_AAT=FOLDER_OUTPUT_VOCABULARIES+"/"+"AAT";
//    public static final String FOLDER_OUTPUT_VOCABULARIES_GEONAMES=FOLDER_OUTPUT_VOCABULARIES+"/"+"Geonames";
//    public static final String FOLDER_OUTPUT_VOCABULARIES_MIDAS=FOLDER_OUTPUT_VOCABULARIES+"/"+"MIDAS";
    
    /* Sources names */
    public static final String HERTZIANA="Hertziana";
    public static final String KHI="KHI";
    public static final String MARBURG="Marburg";
    public static final String ZERI="Zeri";
    public static final String FRICK="Frick";
    public static final String VILLA_I_TATTI="VillaITatti";
    public static final String FOTOINDEX="FotoIndex";
    public static final String SHAREDSHELF="SharedShelf";
    public static final String MIDAS_VOCS="MIDAS" + "/" + Resources.VOCABULARIES;
    public static final String NYPL="NYPL";
    
    /* Entities names */
    public static final String VOCABULARIES="Vocabularies";
    public static final String ACTORS="actors";
    public static final String ARTIST="Artist";
    public static final String ARTISTS="Artists";
    public static final String PLACES="Places";
    public static final String THESAURUS="Thesaurus";
    public static final String ARTWORKS="artworks";
    public static final String BUILTWORKS="builtworks";
    public static final String COLLECTION="Collection";
    public static final String INSTITUTION="Institution";
    public static final String INSTITUTIONS="institutions";
    public static final String PHOTOGRAPH="Photograph";
    public static final String PHOTOGRAPHS="photographs";
    public static final String L2V="l2v";
    public static final String LVL2="lvl2";
    public static final String WORK="Work";
    public static final String WORKS="works";
    public static final String ASSET="Asset";
    public static final String ADDRESS="addresses";
    public static final String BIOGRAPHY="biographies";
    public static final String CONSTITUENTS="constituents";
    public static final String GENDER="genders";
    public static final String NATIONALITY="nationalities";
    public static final String PROCESS="processes";
    public static final String ROLE="roles";
    public static final String COUNTRIES="countries";
    public static final String COUNTRIES_WOF="countries_wof";
    public static final String FORMAT="format";
    
    /* Attribute names*/
    public static final String URI="uri";
    public static final String ID="id";
    public static final String NONE="None";
    
    /* Other names */
    public static final String _FC_FR="_FC_FR";
    public static final String FC_FR="FC_FR";
    public static final String _ULAN="_ulan";
    
    /* Extensions */
    public static final String EXTENSION_TRIG="trig";
    public static final String EXTENSION_N3="n3";
    public static final String EXTENSION_RDF="rdf";
    public static final String EXTENSION_XML="xml";
    
    /* Mapping resources */
    public static final String MAPPINGS_VILLA_I_TATTI=FOLDER_MAPPINGS+"/"+Resources.VILLA_I_TATTI;
    public static final String MAPPINGS_VILLA_I_TATTI_SHAREDSHELF=MAPPINGS_VILLA_I_TATTI+"/"+Resources.SHAREDSHELF;
    public static final String MAPPINGS_VILLA_I_TATTI_SHAREDSHELF_ALL=MAPPINGS_VILLA_I_TATTI_SHAREDSHELF+"/"+"mappings.x3ml";
    public static final String MAPPINGS_VILLA_I_TATTI_SHAREDSHELF_ULAN=MAPPINGS_VILLA_I_TATTI_SHAREDSHELF+"/"+"mappings_ulan.x3ml";
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
    public static final String MAPPINGS_HERTZIANA_ARTWORKS_FC_FR=MAPPINGS_HERTZIANA+"/"+"mappings-artworks-fc-fr.x3ml";
    public static final String MAPPINGS_HERTZIANA_BUILTWORKS_FC_FR=MAPPINGS_HERTZIANA+"/"+"mappings-buildworks-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_HERTZIANA=MAPPINGS_HERTZIANA+"/"+"generator-policy.xml";
    public static final String MAPPINGS_FRICK=FOLDER_MAPPINGS+"/"+Resources.FRICK;
    public static final String MAPPINGS_FRICK_WORK=MAPPINGS_FRICK+"/"+"mappings-work.x3ml";
    public static final String MAPPINGS_FRICK_INSTITUTION=MAPPINGS_FRICK+"/"+"mappings-institution.x3ml";
    public static final String MAPPINGS_FRICK_FC_FR=MAPPINGS_FRICK+"/"+"mappings-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_FRICK=MAPPINGS_FRICK+"/"+"generator-policy.xml";
    public static final String MAPPINGS_ZERI=FOLDER_MAPPINGS+"/"+Resources.ZERI;
    public static final String MAPPINGS_ZERI_ARTWORKS=MAPPINGS_ZERI+"/"+"mappings-artworks.x3ml";
    public static final String MAPPINGS_ZERI_PHOTOGRAPHS=MAPPINGS_ZERI+"/"+"mappings-photographs.x3ml";
    public static final String MAPPINGS_ZERI_PHOTOGRAPHS_FC_FR=MAPPINGS_ZERI+"/"+"mappings-photographs-fc-fr.x3ml";
    public static final String MAPPINGS_ZERI_WORKS_FC_FR=MAPPINGS_ZERI+"/"+"mappings-works-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_ZERI=MAPPINGS_ZERI+"/"+"generator-policy.xml";
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
    public static final String MAPPINGS_KHI_ARTWORKS_FC_FR=MAPPINGS_KHI+"/"+"mappings-artworks-fc-fr.x3ml";
    public static final String MAPPINGS_KHI_BUILTWORKS_FC_FR=MAPPINGS_KHI+"/"+"mappings-buildworks-fc-fr.x3ml";
    public static final String GENERATOR_POLICY_KHI=MAPPINGS_KHI+"/"+"generator-policy.xml";
    public static final String MAPPINGS_MIDAS_VOCS=FOLDER_MAPPINGS+"/"+Resources.MIDAS_VOCS;
    public static final String MAPPINGS_MIDAS_VOCS_THESAURUS=MAPPINGS_MIDAS_VOCS+ "/"+ "mappings-thesaurus.x3ml";
    public static final String MAPPINGS_MIDAS_VOCS_ARTISTS_KHI=MAPPINGS_MIDAS_VOCS+ "/"+ "mappings-artists-khi.x3ml";
    public static final String MAPPINGS_MIDAS_VOCS_ARTISTS_MARBURG=MAPPINGS_MIDAS_VOCS+ "/"+ "mappings-artists-marburg.x3ml";
    public static final String MAPPINGS_MIDAS_VOCS_ARTISTS_HERTZIANA=MAPPINGS_MIDAS_VOCS+ "/"+ "mappings-artists-hertziana.x3ml";
    public static final String MAPPINGS_MIDAS_VOCS_PLACES_KHI=MAPPINGS_MIDAS_VOCS+ "/"+ "mappings-places-khi.x3ml";
    public static final String MAPPINGS_MIDAS_VOCS_PLACES_MARBURG=MAPPINGS_MIDAS_VOCS+ "/"+ "mappings-places-marburg.x3ml";
    public static final String MAPPINGS_MIDAS_VOCS_PLACES_HERTZIANA=MAPPINGS_MIDAS_VOCS+ "/"+ "mappings-places-hertziana.x3ml";
    public static final String GENERATOR_POLICY_MIDAS_VOCS=MAPPINGS_MIDAS_VOCS+"/"+"generator-policy.xml";
    
    public static final String MAPPINGS_NYPL=FOLDER_MAPPINGS+"/"+Resources.NYPL;
    public static final String GENERATOR_POLICY_NYPL=MAPPINGS_NYPL+"/"+"generator-policy.xml";
    public static final String MAPPINGS_NYPL_ADDRESS=MAPPINGS_NYPL+"/"+"address_mappings.x3ml";
    public static final String MAPPINGS_NYPL_BIOGRAPHIES=MAPPINGS_NYPL+"/"+"biographies_mappings.x3ml";
    public static final String MAPPINGS_NYPL_BIOGRAPHY=MAPPINGS_NYPL+"/"+"biography_mappings.x3ml";
    public static final String MAPPINGS_NYPL_COLLECTION=MAPPINGS_NYPL+"/"+"collection_mappings.x3ml";
    public static final String MAPPINGS_NYPL_COLLECTIONS=MAPPINGS_NYPL+"/"+"collections_mappings.x3ml";
    public static final String MAPPINGS_NYPL_CONSTITUENTS=MAPPINGS_NYPL+"/"+"constituents_mappings.x3ml";
    public static final String MAPPINGS_NYPL_CONSTITUENTS_FC_FR=MAPPINGS_NYPL+"/"+"constituents_mappings-fc-fr.x3ml";
    public static final String MAPPINGS_NYPL_COUNTRIES=MAPPINGS_NYPL+"/"+"countries_mappings.x3ml";
    public static final String MAPPINGS_NYPL_COUNTRIES_WOF=MAPPINGS_NYPL+"/"+"countries_wof_mappings.x3ml";
    public static final String MAPPINGS_NYPL_FORMAT=MAPPINGS_NYPL+"/"+"format_mappings.x3ml";
    public static final String MAPPINGS_NYPL_FORMATS=MAPPINGS_NYPL+"/"+"formats_mappings.x3ml";
    public static final String MAPPINGS_NYPL_GENDER=MAPPINGS_NYPL+"/"+"gender_mappings.x3ml";
    public static final String MAPPINGS_NYPL_GENDER_FC_FR=MAPPINGS_NYPL+"/"+"gender_mappings-fc-fr.x3ml";
    public static final String MAPPINGS_NYPL_GENDERS=MAPPINGS_NYPL+"/"+"genders_mappings.x3ml";
    public static final String MAPPINGS_NYPL_NATIONALITIES=MAPPINGS_NYPL+"/"+"nationalities_mappings.x3ml";
    public static final String MAPPINGS_NYPL_NATIONALITY=MAPPINGS_NYPL+"/"+"nationality_mappings.x3ml";
    public static final String MAPPINGS_NYPL_NATIONALITY_FC_FR=MAPPINGS_NYPL+"/"+"nationality_mappings-fc-fr.x3ml";
    public static final String MAPPINGS_NYPL_PROCESS=MAPPINGS_NYPL+"/"+"process_mappings.x3ml";
    public static final String MAPPINGS_NYPL_PROCESSES=MAPPINGS_NYPL+"/"+"processes_mappings.x3ml";
    public static final String MAPPINGS_NYPL_ROLE=MAPPINGS_NYPL+"/"+"role_mappings.x3ml";
    public static final String MAPPINGS_NYPL_ROLES=MAPPINGS_NYPL+"/"+"roles_mappings.x3ml";
    
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
    public static final int MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB=6;
    public static final int TIME_OUT_REQUESTS=30000;
    
    /* Spring beans resources */
    public static final String SPRING_BEANS_FILENAME="beans.xml";
    public static final String TRIPLESTORE_BEAN_ID="triplestoreConnection";
    
    /* Default graphspaces */
    public static final String GRAPHSPACE_FRICK="http://frick/";
    public static final String GRAPHSPACE_FRICK_FC_FR="https://pharos.artresearch.net/resource/frick/fcrs";
    public static final String GRAPHSPACE_HERTZIANA="http://hertziana/";
    public static final String GRAPHSPACE_HERTZIANA_FC_FR="https://pharos.artresearch.net/resource/hertziana/fcrs";
    public static final String GRAPHSPACE_KHI="http://khi/";
    public static final String GRAPHSPACE_KHI_FC_FR="https://pharos.artresearch.net/resource/khi/fcrs";
    public static final String GRAPHSPACE_MARBURG="http://marburg/";
    public static final String GRAPHSPACE_MARBURG_FC_FR="https://pharos.artresearch.net/resource/marburg/fcrs";
    public static final String GRAPHSPACE_VILLA_I_TATTI="http://itatti/";
    public static final String GRAPHSPACE_VILLA_I_TATTI_FC_FR="https://pharos.artresearch.net/resource/itatti/fcrs";
    public static final String GRAPHSPACE_ZERI="http://zeri/";
    public static final String GRAPHSPACE_ZERI_FC_FR="https://pharos.artresearch.net/resource/zeri/fcrs";
    // Instance Matchings
    public static final String GRAPHSPACE_MATCHINGS_ARTISTS="https://pharos.artresearch.net/resource/matchings/artists";
    public static final String GRAPHSPACE_MATCHINGS_INSTITUTIONS="https://pharos.artresearch.net/resource/matchings/institutions";
    public static final String GRAPHSPACE_MATCHINGS_PLACES="https://pharos.artresearch.net/resource/matchings/places";
    public static final String GRAPHSPACE_MATCHINGS_PHOTOGRAPHERS="https://pharos.artresearch.net/resource/matchings/photographers";
    public static final String GRAPHSPACE_MATCHINGS_TYPES="https://pharos.artresearch.net/resource/matchings/types";
    public static final String GRAPHSPACE_MATCHINGS_WORKS="https://pharos.artresearch.net/resource/matchings/works";
    // Vocabularies
    public static final String GRAPHSPACE_VOCAB_NYPL_PIC="https://pharos.artresearch.net/resource/pic";
    public static final String GRAPHSPACE_VOCAB_ULAN="https://pharos.artresearch.net/resource/ulan";
    public static final String GRAPHSPACE_VOCAB_WIKIDATA="https://pharos.artresearch.net/resource/wikidata";
    public static final String GRAPHSPACE_VOCAB_AAT="https://pharos.artresearch.net/resource/aat";
    public static final String GRAPHSPACE_VOCAB_GEONAMES="https://pharos.artresearch.net/resource/gnames";
    public static final String GRAPHSPACE_MIDAS_VOCS="https://pharos.artresearch.net/resource/midas/vocabularies/enrichment/graph";
    
    //Resources
    public static final String NO_TYPE = "https://pharos.artresearch.net/custom/noType";
    public static final String MAN_MADE_OBJECT = "http://www.cidoc-crm.org/cidoc-crm/E22_Man-Made_Object";
    public static final String CUSTOM_FC_WORK = "https://pharos.artresearch.net/resource/custom/fc/work";
    public static final String CUSTOM_FC_PHOTO = "https://pharos.artresearch.net/resource/custom/fc/photo";
    public static final String SELECT = "SELECT";
    public static final String SUBJECT = "subject";
    public static final String TYPE_WORK = "https://pharos.artresearch.net/resource/fc/work";
    public static final String CONFIGURATION_FILE = "./src/main/resources/authentication.xml";
    
}
