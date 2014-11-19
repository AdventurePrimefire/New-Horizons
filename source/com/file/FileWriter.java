package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class FileWriter {
    private File file;
    private Document xmlDoc;
    
    public FileWriter(File file) {
        if (file != null) {
            this.file = file;
        } else {
            file = new File("NewFile.txt");
        }
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        // DocumentBuilder
        DocumentBuilder docBuilder;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return;
        }
        // Document
        this.xmlDoc = docBuilder.newDocument();
    }
    
    /**
     * . Saves the information.
     * 
     * @param save
     *            The save to save.
     */
    public void save(XMLEntry root) {
        
        writeDocument(this.xmlDoc, root);
        
        // Set Output Format
        OutputFormat outFormat = new OutputFormat(this.xmlDoc);
        outFormat.setIndenting(true);
        
        // Declare file
        File xmlFile = this.file;
        // Declare file output
        FileOutputStream outStream;
        try {
            outStream = new FileOutputStream(xmlFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        // XMLSerializer to serialize the data
        XMLSerializer serializer = new XMLSerializer(outStream, outFormat);
        try {
            serializer.serialize(this.xmlDoc);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
    
    private void writeDocument(Document xmlDoc, XMLEntry root) {
        xmlDoc.appendChild(root.makeNode(xmlDoc));
    }
    
    public Document getDoc() {
        return this.xmlDoc;
    }
}
