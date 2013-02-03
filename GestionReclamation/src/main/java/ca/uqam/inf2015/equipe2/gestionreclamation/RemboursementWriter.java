package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RemboursementWriter {
    Document outputDocument;
    
    
    public RemboursementWriter (Arraylist<String> reclamations) 
            throws ParserConfigurationException, SAXException, IOException {
        parseDocument(inputFileName);
    }
    
    public void createRemboursement(Arraylist<String> reclamations) {
        Element lesRembousrements = outputDocument.createElement("remboursements");
        Element unClient = outputDocument.createElement("client");
        Element moisRemboursement = outputDocument.createElement("mois");
        outputDocument.getDocumentElement().appendChild(lesRembousrements);
        outputDocument.getDocumentElement().appendChild(unClient);
        outputDocument.getDocumentElement().appendChild(moisRemboursement);
    }

    

    
    
    private void parseDocument(String pathToDocument) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory builderFactory = init();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        outputDocument = builder.parse(pathToDocument);
    }

    //Design Pattern Singleton - Un seul Object.
    private DocumentBuilderFactory init() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        return builderFactory;
    }
    
    public void saveFile(String pathToFile) throws TransformerConfigurationException, TransformerException {
        Source domSource = new DOMSource(outputDocument);
        File file = new File(pathToFile);
        Result result = new StreamResult(file);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(domSource, result);
    }
    
}

