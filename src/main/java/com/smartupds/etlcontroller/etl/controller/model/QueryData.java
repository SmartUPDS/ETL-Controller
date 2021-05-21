package com.smartupds.etlcontroller.etl.controller.model;

import com.smartupds.etlcontroller.etl.controller.Resources;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.log4j.Log4j;
import org.eclipse.rdf4j.query.Binding;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sparql.SPARQLRepository;
//import org.eclipse.rdf4j.rio.ParserConfig;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Class for querying data of a specific endpoint
 *
 * @author Manolis Fragiadoulakis <fragiadoulakis at smartupds.com>
 */
@Log4j
public class QueryData {
    private final SPARQLRepository repo;
    private final String query;
    private final String format;
    
    public QueryData(String endpoint, String query, String format){
        repo = new SPARQLRepository(endpoint);
        this.query = query;
        this.format = format;
    }
    
    public void download(){
        log.info("Endpoint : " + repo.toString());
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(Resources.FOLDER_OUTPUT_INDEXING_WORKS+"/"+Resources.SUBJECT), "UTF-8")) {
            log.info("Initializing repository");
            repo.initialize();
            log.info("Getting repository connection");
            try (RepositoryConnection conn = repo.getConnection()) {
                log.info("Preparing select query : \n" + query);
                TupleQuery select = conn.prepareTupleQuery(QueryLanguage.SPARQL,query);
                ArrayList<String> columns = new ArrayList<>();
                String[] tmp_names = this.query.split(" ");
                boolean start = false;
                for(String name:tmp_names){
                    if(name.toLowerCase().trim().contains("where"))
                        break;
                    if(start && !name.trim().equalsIgnoreCase("distinct"))
                        columns.add(name.replace("?", ""));
                    if(name.toLowerCase().trim().contains("select"))
                        start = true;
                }
                log.info("Evaluationg select query");
                TupleQueryResult result = select.evaluate();
                log.info("Successful query evaluation");
                int count = 0;
                while (result.hasNext()){
                    BindingSet set = result.next();
                    Iterator<Binding> it = set.iterator();
                    if(count==0 && columns.size()<1){
                        set.getBindingNames().forEach(name->{
                            columns.add(name);
                        });
                    }
                    if (count==0){
                        for (String name:columns)
                            writer.append(name+"\t");
                        writer.append("\n");
                    }
                    columns.forEach(name->{
                        try {
                            if(set.getBinding(name)!=null)
                                writer.append(set.getBinding(name).getValue()+"\t");
                            else
                                writer.append("-\t");
                        } catch (IOException ex) {
                            Logger.getLogger(QueryData.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    });
                    writer.append("\n");
                    count ++;
                }
                log.info("File Saved at: ".concat(Resources.FOLDER_OUTPUT_INDEXING_WORKS+"/"+Resources.SUBJECT));
                log.info("Shutting down repository");
                writer.close();
            }
            repo.shutDown();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(QueryData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QueryData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(QueryData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void configure(String username, String password){
        System.out.println("Configuring endpoint");
        repo.setUsernameAndPassword(username, password);
    }
}
