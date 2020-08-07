package com.smartupds.etlcontroller.etl.controller;

import com.google.common.io.Files;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import gr.forth.Labels;
import gr.forth.ics.isl.x3ml.X3MLEngine;
import static gr.forth.ics.isl.x3ml.X3MLEngine.exception;
import gr.forth.ics.isl.x3ml.X3MLEngineFactory;
import gr.forth.ics.isl.x3ml.X3MLGeneratorPolicy;
import gr.forth.ics.isl.x3ml.engine.Generator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.Charset;
import javax.xml.parsers.DocumentBuilderFactory;
import lombok.extern.log4j.Log4j;
import org.w3c.dom.Element;
//import org.apache.jena.rdf.model.Model;
//import org.apache.jena.rdf.model.ModelFactory;

/** Various utility facilities
 * 
 * @author Yannis Marketakis (marketakis 'at' smartupds 'dot' com)
 */
@Log4j
public class Utils {
    
    public static void lineUpdater(File fromFile, File toFile, String initialLine, String finalLine) throws IOException{
        log.info("Updating occurences of \""+initialLine+"\" to\""+finalLine+"\" from file "+fromFile.getAbsolutePath()+" and export to file "+toFile.getAbsolutePath());
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(fromFile), "UTF8"));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(toFile), "UTF8"));
        String line="";
        int lineCounter=0;
        while((line=bufferedReader.readLine())!=null){
            lineCounter+=1;
            if(line.trim().equals(initialLine.trim())){
                bufferedWriter.append(finalLine).append("\n");
                log.info("Found line for replace in line number "+lineCounter);
            }else{
                bufferedWriter.append(line).append("\n");
            }
        }
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        fromFile.delete();
        toFile.renameTo(fromFile);
    }
    
    public static void textUpdater(File fromFile, File toFile, String initialText, String finalText) throws IOException{
        log.info("Updating occurences of \""+initialText+"\" to\""+finalText+"\" from file "+fromFile.getAbsolutePath()+" and export to file "+toFile.getAbsolutePath());
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(fromFile), "UTF8"));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(toFile), "UTF8"));
        String line="";
        int lineCounter=0;
        while((line=bufferedReader.readLine())!=null){
            lineCounter+=1;
            if(line.contains(initialText)){
                bufferedWriter.append(line.replace(initialText, finalText)).append("\n");
                log.info("Found line for replace in line number "+lineCounter);
            }else{
                bufferedWriter.append(line).append("\n");
            }
        }
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    
    public static void N3Validator(File folder) throws FileNotFoundException{
         Model model = ModelFactory.createDefaultModel() ;
        for(File file : folder.listFiles()){
            log.info("Parsing file "+file.getName());
            model.read(new FileReader(file), "N3","N3");
        }
    }
   
    public static void consolidateN3Resources(File initialFolder, File outputFolder, String outputResourceName, int maxsize) throws IOException{
        StringBuilder fileBuilder=new StringBuilder();
        int fileCounter=1;
        for(File file : initialFolder.listFiles()){
            for(String line : Files.readLines(file, Charset.forName("UTF8"))){
                fileBuilder.append(line)
                           .append("\n");
            }
            if(fileBuilder.length()>=Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB*1024*1024){
                File outputFile=new File(outputFolder.getAbsoluteFile()+"/"+outputResourceName+"-"+fileCounter+".n3");
                log.info("Export consolidated file "+outputFile.getAbsolutePath());
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile),"UTF8"));
                writer.append(fileBuilder.toString());
                writer.flush();
                writer.close();
                fileCounter+=1;
                fileBuilder=new StringBuilder();
            }
        }
        File outputFile=new File(outputFolder.getAbsoluteFile()+"/"+outputResourceName+"-"+fileCounter+".n3");
        log.info("Export consolidated file "+outputFile.getAbsolutePath());
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile),"UTF8"));
        writer.append(fileBuilder.toString());
        writer.flush();
        writer.close();
    }
    
    /** Transforms the given resources using X3ML engine.
     * 
     * @param inputFile the XML input file
     * @param mappingsFile the X3ML mapping definition file
     * @param generatorPolicyFile the generator policy file
     * @param outputFormat the format of the transformed resources
     * @param outputFolder the folder where the transformed contents will be exported. */
    public static void transformFile(File inputFile, File mappingsFile, File generatorPolicyFile, File outputFolder, X3MLEngineFactory.OutputFormat outputFormat) throws ETLGenericException{
        String extension="";
        String mimetype="";
        switch(outputFormat){
            case RDF_XML:
                extension=".rdf";
                mimetype=Labels.OUTPUT_MIME_TYPE_RDF_XML;
                break;
            case RDF_XML_PLAIN:
                extension=".rdf";
                mimetype=Labels.OUTPUT_MIME_TYPE_RDF_XML_ABBREV;
                break;
            case NTRIPLES:
                extension=".nt";
                mimetype=Labels.OUTPUT_MIME_TYPE_NTRIPLES;
                break;
            case TURTLE:
                extension=".ttl";
                mimetype=Labels.OUTPUT_MIME_TYPE_TURTLE;
                break;
            case TRIG:
                extension=".ttl";
                mimetype=Labels.OUTPUT_MIME_TYPE_TRIG;
                break;
        }
        try{
            File outputFile=new File(outputFolder.getAbsolutePath()+"/"+inputFile.getName().replace(".xml", extension));
            log.debug("Transforming file "+inputFile.getAbsolutePath()+" to file "+outputFile.getAbsolutePath());
            X3MLEngine engine=X3MLEngine.load(new FileInputStream(mappingsFile));
            Generator policy=X3MLGeneratorPolicy.load(new FileInputStream(generatorPolicyFile), X3MLGeneratorPolicy.createUUIDSource(-1));
            X3MLEngine.Output output = engine.execute(document(inputFile), policy);
            output.write(new PrintStream(outputFile),mimetype);
        }catch(FileNotFoundException ex){
            log.error("An error occured while transforming data resources",ex);
            throw new ETLGenericException("An error occured while transforming data resources",ex);
        }
    }
    
    private static Element document(File file) {
        try {
            return documentBuilderFactory().newDocumentBuilder().parse(file).getDocumentElement();
        }
        catch (Exception e) {
            throw exception("Unable to parse " + file.getAbsolutePath()+"\n"+e.toString());
        }
    }
    
    private static DocumentBuilderFactory documentBuilderFactory() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory;
    }
}