package com.smartupds.etlcontroller.etl.controller;

import com.google.common.io.Files;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.smartupds.etlcontroller.etl.controller.exception.ETLGenericException;
import com.smartupds.etlcontroller.etl.controller.impl.frick.FrickTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.hertziana.HertzianaTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.itatti.ItattiTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.khi.KhiTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.marburg.MarburgTransformer;
import com.smartupds.etlcontroller.etl.controller.impl.zeri.ZeriTransformer;
import com.smartupds.etlcontroller.etl.controller.model.TripleStoreConnection;
import gr.forth.Labels;
import gr.forth.ics.isl.timer.Timer;
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
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.stream.Stream;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilderFactory;
import lombok.extern.log4j.Log4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Element;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

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
   
    public static void consolidateN3Resources(File initialFolder, File outputFolder, String outputResourceName, int maxsize, String extension) throws IOException{
        StringBuilder fileBuilder=new StringBuilder();
        int fileCounter=1;
        for(File file : initialFolder.listFiles()){
            for(String line : Files.readLines(file, Charset.forName("UTF8"))){
                fileBuilder.append(line)
                           .append("\n");
            }
            if(fileBuilder.length()>=Resources.MAX_FILESIZE_OUTPUT_N3_RESOURCES_IN_MB*1024*1024){
                File outputFile=new File(outputFolder.getAbsoluteFile()+"/"+outputResourceName+"-"+fileCounter+"."+extension);
                log.info("Export consolidated file "+outputFile.getAbsolutePath());
                BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile),"UTF8"));
                writer.append(fileBuilder.toString());
                writer.flush();
                writer.close();
                fileCounter+=1;
                fileBuilder=new StringBuilder();
            }
        }
        File outputFile=new File(outputFolder.getAbsoluteFile()+"/"+outputResourceName+"-"+fileCounter+"."+extension);
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
                extension=Labels.OUTPUT_EXTENSION_RDF;
                mimetype=Labels.OUTPUT_MIME_TYPE_RDF_XML;
                break;
            case RDF_XML_PLAIN:
                extension=Labels.OUTPUT_EXTENSION_RDF;
                mimetype=Labels.OUTPUT_MIME_TYPE_RDF_XML_ABBREV;
                break;
            case NTRIPLES:
                extension=Labels.OUTPUT_EXTENSION_NTRIPLES;
                mimetype=Labels.OUTPUT_MIME_TYPE_NTRIPLES;
                break;
            case TURTLE:
                extension=Labels.OUTPUT_EXTENSION_TURTLE;
                mimetype=Labels.OUTPUT_MIME_TYPE_TURTLE;
                break;
            case TRIG:
                extension=Labels.OUTPUT_EXTENSION_TRIG;   //on purpose. TTL is the valid one
                mimetype=Labels.OUTPUT_MIME_TYPE_TRIG;
                break;
        }
        try{
            File outputFile=new File(outputFolder.getAbsolutePath()+"/"+inputFile.getName().replace(".xml", "."+extension));
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
    
    public static void uploadFile(TripleStoreConnection triplestore, File fileToUpload, String graphspace, boolean preserveNamedgraphs) throws ETLGenericException{
        if(FileUtils.sizeOf(fileToUpload)<10){
            log.warn("Skipping upload of file "+fileToUpload.getAbsolutePath()+" (empty?)");
            return;
        }
        try{
            String uploadServiceURL=triplestore.getConnectionURL()+"?graph="+graphspace;
            if(preserveNamedgraphs){
                uploadServiceURL+="&keepSourceGraphs=true";
            }
            HttpsURLConnection con = (HttpsURLConnection) new URL(uploadServiceURL).openConnection();
            con.setRequestMethod("POST");
            String userCredentials = triplestore.getUsername()+":"+triplestore.getPassword();
            String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
            con.setRequestProperty ("Authorization", basicAuth);
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64; rv:27.0) Gecko/20100101 Firefox/27.0.2 Waterfox/27.0");
            
            String mimeType="";
            switch(FilenameUtils.getExtension(fileToUpload.getAbsolutePath())){
                case Labels.OUTPUT_EXTENSION_RDF:
                    mimeType=Labels.OUTPUT_MIME_TYPE_RDF_XML;
                    break;
                case Labels.OUTPUT_EXTENSION_NTRIPLES:
                    mimeType=Labels.OUTPUT_MIME_TYPE_NTRIPLES;
                    break;
                case Labels.OUTPUT_EXTENSION_TURTLE:
                case Labels.OUTPUT_EXTENSION_TRIG:
                    mimeType=Labels.OUTPUT_MIME_TYPE_TURTLE;
                    break;  
            }
            if(preserveNamedgraphs){
                mimeType="application/x-trig";
            }
            con.setRequestProperty("Content-Type", mimeType);
            con.setDoOutput(true);
            IOUtils.copy(new FileInputStream(fileToUpload), con.getOutputStream());

            log.debug("Upload POST URL: "+uploadServiceURL+"\tMIME-TYPE: "+mimeType);
            
            int responseCode = con.getResponseCode();
            
            if (responseCode != HttpStatus.SC_OK && responseCode != HttpStatus.SC_CREATED) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                log.error("An error occured while uploading contents. Response Status Code: "+responseCode+"\tRespose Body: "+response.toString());
                throw new ETLGenericException("An error occured while uploading contents. Response Status Code: "+responseCode+"\tRespose Body: "+response.toString());
            }
            log.info("Resource "+fileToUpload.getAbsolutePath()+" was successfully uploaded");
        }catch(IllegalArgumentException | IOException ex){
            log.error("An error occured while uploading data",ex);
            throw new ETLGenericException("An error occured while uploading data",ex);
        }
    }
    
    private static String file2String(File file) throws ETLGenericException{
        StringBuilder stringBuilder = new StringBuilder();
        try(Stream stream = java.nio.file.Files.lines( Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8)) {     
            stream.forEach(s -> stringBuilder.append(s).append("\n"));
        }catch(IOException ex){
            log.error("An error occured while reading file",ex);
            throw new ETLGenericException("An error occured while reading file",ex);
        }
        return stringBuilder.toString();
    }
    
    public static void reportTimeStatistics(){
        log.info("OVERALL TIME STATISTICS (per source): ");
        log.info("Overal Time for VILLA I TATTI: "+Timer.reportHumanFriendly(ItattiTransformer.class.getPackage().getName()));
        log.info("Overal Time for HERTZIANA: "+Timer.reportHumanFriendly(HertzianaTransformer.class.getPackage().getName()));
        log.info("Overal Time for FRICK: "+Timer.reportHumanFriendly(FrickTransformer.class.getPackage().getName()));
        log.info("Overal Time for MARBURG: "+Timer.reportHumanFriendly(MarburgTransformer.class.getPackage().getName()));
        log.info("Overal Time for ZERI: "+Timer.reportHumanFriendly(ZeriTransformer.class.getPackage().getName()));
        log.info("Overal Time for KHI: "+Timer.reportHumanFriendly(KhiTransformer.class.getPackage().getName()));
    }
}