/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartupds.etlcontroller.etl.controller.impl.itatti;

import com.smartupds.etlcontroller.etl.controller.Resources;
import com.smartupds.etlcontroller.etl.controller.Utils;
import com.smartupds.etlcontroller.etl.controller.api.Deleter;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.model.TripleStoreConnection;
import gr.forth.ics.isl.timer.Timer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author Manolis Fragiadoulakis <fragiadoulakis at smartupds.com>
 */
@Log4j
public class ItattiDeleter implements Deleter {
    
    private final TripleStoreConnection triplestoreConnection;
    
    private ItattiDeleter(TripleStoreConnection tripleStoreConn){
        this.triplestoreConnection=tripleStoreConn;
    }
    
    @Override
    public void deleteResources() throws ETLGenericException {
        OutputStreamWriter writer = null;
        try {
            
//            Utils.test("C:\\Users\\mafragias\\Documents\\WORKSPACE\\GitHub\\ETL-Controller\\workspace\\3_Output\\1_Transformed\\VillaITatti\\SharedShelf_FC_FR\\2021-05-19T11-25-59-474_merged_files.nt","C:\\Users\\mafragias\\Documents\\WORKSPACE\\GitHub\\ETL-Controller\\workspace\\3_Output\\1_Transformed\\VillaITatti\\SharedShelf_FC_FR\\to_upload.nt");
            log.info("START: Delete SharedShelf resources from VillaITatti");
            Timer.start(ItattiIngester.class.getCanonicalName()+".sharedshelf");
            HashSet<String> graphs = Utils.getGraphs(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF,"http://www.cidoc-crm.org/cidoc-crm/E22_Man-Made_Object");
            log.info("Number of Graphs to delete : ".concat(""+graphs.size()));
            int counter = 0;
            writer = new OutputStreamWriter(new FileOutputStream(new File(Resources.FOLDER_OUTPUT_TRANSFORMED_VILLA_I_TATTI_SHAREDSHELF).getParent().toString() + "/deletedgraphs.txt", true), "UTF-8");
            for (String graph: graphs ){
                counter++;
                log.info("Deleting " + counter +" out of " + graphs.size() + " | Graph :" + graph);
                Utils.deleteGraph(triplestoreConnection, graph);
                writer.append(graph+"\n");
            }
            writer.close();
            Timer.stop(ItattiIngester.class.getCanonicalName()+".sharedshelf");
            log.info("FINISH: Delete SharedShelf resources from VillaITatti in "+Timer.reportHumanFriendly(ItattiIngester.class.getCanonicalName()+".sharedshelf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItattiDeleter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ItattiDeleter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItattiDeleter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(ItattiDeleter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static ItattiDeleter create(TripleStoreConnection triplestoreConnection){
        return new ItattiDeleter(triplestoreConnection);
    }   
}
