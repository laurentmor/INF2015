package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public final class RemboursementWriter {

    Remboursements remboursement;
    Document outputDocument;
    String outputFileName;

    public RemboursementWriter(String outputFileName) throws Exception {
        this.outputFileName = outputFileName;

        validateOutputFileName(outputFileName);
    }

    public void setRemboursement(Remboursements remboursement) {
        this.remboursement = remboursement;
    }

    private Document CreateNewXmlDocument() throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        return builder.newDocument();
    }

    private Element AddXmlCategory(String tagName, Node parent) {
        Element childItem = outputDocument.createElement(tagName);
        parent.appendChild(childItem);

        return childItem;
    }

    private void AddXmlField(String fieldName, String fieldValue, Node parent) {

        Element newField = outputDocument.createElement(fieldName);
        newField.appendChild(outputDocument.createTextNode(fieldValue));
        parent.appendChild(newField);
    }

    private void WriteDocumentToXml() throws Exception {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(outputDocument);

        StreamResult result = new StreamResult(new File(this.outputFileName));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        outputDocument.setXmlStandalone(true);

        transformer.transform(source, result);
    }

    public void SaveRemboursementsOnDisk() throws Exception {

        Client client = this.remboursement.getClient();
        ArrayList<SoinRembourse> listeRembourse = this.remboursement.getListeSoinsRembourse();

        outputDocument = CreateNewXmlDocument();

        Element baliseRemboursements = AddXmlCategory("remboursements", outputDocument);

        AddXmlField("client", client.getNoClient(), baliseRemboursements);
        AddXmlField("mois", this.remboursement.getMoisRemboursement(), baliseRemboursements);

        for (SoinRembourse s : listeRembourse) {
            Element baliseRemboursement = AddXmlCategory("remboursement", baliseRemboursements);

            AddXmlField("soin", s.getTypeSoin(), baliseRemboursement);
            AddXmlField("date", s.getDate(), baliseRemboursement);
            AddXmlField("montant", s.getMontantRembourseFormate(), baliseRemboursement);
        }

        WriteDocumentToXml();

    }

    public void SaveDonneInvalideOnDisk() throws Exception {

        outputDocument = CreateNewXmlDocument();

        Element baliseRemboursements = AddXmlCategory("remboursements", outputDocument);
        AddXmlField("message", "Données invalides", baliseRemboursements);
        WriteDocumentToXml();

    }

    private static void validateOutputFileName(String outputFileName) throws Exception {
        File f = new File(outputFileName);

        if (f.isDirectory()) {
            throw new RuntimeException("Le fichier de sortie est un repertoire.");
        }
    }
}
