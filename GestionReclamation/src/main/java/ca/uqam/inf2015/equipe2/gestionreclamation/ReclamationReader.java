package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public final class ReclamationReader {

    private Document inputDocument;
    
    private String numeroClient;
    private String typeContrat;
    private String moisReclamation;

    private ArrayList<String> lesSoins;
    private ArrayList<String> lesDates;
    private ArrayList<String> lesMontants;
    
    private Reclamations reclamations;
    
    

    public ReclamationReader(String inputFileName) throws Exception {
        
        parseXmlDocument(inputFileName);
        
        LoadReclamationsData();
    }


        private void LoadReclamationsData() {
        
        this.numeroClient = loadElementFromDocumentByTag("client");
        this.typeContrat = loadElementFromDocumentByTag("contrat");
        this.moisReclamation = loadElementFromDocumentByTag("mois");

        reclamations = new Reclamations(numeroClient, typeContrat, moisReclamation);

        this.lesSoins = loadArrayListElementsFromDocumentByTag("soin");
        this.lesDates = loadArrayListElementsFromDocumentByTag("date");
        this.lesMontants = loadArrayListElementsFromDocumentByTag("montant");
        
        for (int i = 0; i < lesSoins.size(); i++) {
            reclamations.addNewReclamation(lesSoins.get(i), lesDates.get(i), lesMontants.get(i));
        }
        
    }

    
    
    
    private void parseXmlDocument(String inputFileName) throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        inputDocument = builder.parse(inputFileName);
    }


    private String loadElementFromDocumentByTag(String inputFileName) {
        NodeList nodes = inputDocument.getElementsByTagName(inputFileName);

        if (nodes.getLength() == 0) {
            return null;
        }

        Element reclamationItem = (Element) nodes.item(0);
        return reclamationItem.getTextContent();
    }

    
    private ArrayList<String> loadArrayListElementsFromDocumentByTag(String inputFileName) {
        ArrayList<String> retour = new ArrayList();
        NodeList nodes = inputDocument.getElementsByTagName(inputFileName);

        for (int i = 0; i < nodes.getLength(); i++) {
            Element item = (Element) nodes.item(i);

            retour.add(item.getTextContent());
        }

        return retour;
    }

    
    /**
     * Affiche toutes réclamations à la console. Utilisé comme outil de
     * validation/troubleshooting.
     */
    public void DisplayAllReclamations() {
        System.out.println("Document Valide: " + this.reclamations.isReclamationsValid());
        System.out.println("Numero de client: " + this.numeroClient);
        System.out.println("Type de Contrat : " + this.typeContrat);
        System.out.println("Mois Reclamation: " + this.moisReclamation);

        for (int i = 0; i < lesSoins.size(); i++) {
            System.out.println("Type de soin: " + this.lesSoins.get(i).toString());
            System.out.println("Date        : " + this.lesDates.get(i));
            System.out.println("Montant     : " + this.lesMontants.get(i).toString());
        }
    }
    
}
