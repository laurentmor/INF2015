package ca.uqam.inf2015.equipe2.gestionreclamation;

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

public class ReclamationReader {
    Document inputDocument;
    
    public ReclamationReader (String inputFileName) 
            throws ParserConfigurationException, SAXException, IOException {
        parseDocument(inputFileName);
    }
    
    private void parseDocument(String inputFileName) 
            throws ParserConfigurationException, SAXException, IOException{
        DocumentBuilderFactory builderFactory = init();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        inputDocument = builder.parse(inputFileName);
    }
    
    private DocumentBuilderFactory init(){
        DocumentBuilderFactory builderFactory = 
                DocumentBuilderFactory.newInstance();
        return builderFactory;
    }
    
    private String loadElementFromDocumentByTag(String inputFileName) {
        NodeList nodes = inputDocument.getElementsByTagName(inputFileName);

        if (nodes.getLength() == 0) {
            return null;
        }

        Element reclamationItem = (Element) nodes.item(0);
        return reclamationItem.getTextContent();
    }

    
    private ArrayList<String> loadArrayListElementsFromDocumentByTag
            (String inputFileName) {
        ArrayList<String> retour = new ArrayList();
        NodeList nodes = inputDocument.getElementsByTagName(inputFileName);

        for (int i = 0; i < nodes.getLength(); i++) {
            Element item = (Element) nodes.item(i);

            retour.add(item.getTextContent());
        }

        return retour;
    }
    
    
}

