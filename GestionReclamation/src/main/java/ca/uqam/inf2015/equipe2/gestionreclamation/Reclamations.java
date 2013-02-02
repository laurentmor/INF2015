package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reclamations {

    private boolean isReclamationsValid = false;
    private Client client = null;
    private String moisReclamation = null;
    ;
    private ArrayList<SoinReclame> listeSoinsReclame = null;

    // Constructor
    public Reclamations(String noClient, String typeContrat, String moisReclamation) {
        listeSoinsReclame = new ArrayList<>();
        client = null;

        try {
            this.client = new Client(noClient, typeContrat);
            this.isReclamationsValid = true;

        } catch (Exception e) {
            this.isReclamationsValid = false;
            System.out.println(e.getMessage());
        }


        this.moisReclamation = moisReclamation;
        ValiderMois();
    }

    void ValiderMois() {
        try {
            //On ajout un jour bidon pour valider le mois
            GregorianCalendar gc = DateUtil.getParsedDate(moisReclamation + "-01");
           
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM");
            dateFormat.setCalendar(gc);
            dateFormat.setLenient(false);
            isReclamationsValid=true;
        } catch (Exception ex) {
          isReclamationsValid=false;
        }
      
      
    }

    public Boolean isReclamationsValid() {
        return isReclamationsValid;
    }

    public Client getClient() {
        return client;
    }

    public String getMoisReclamation() {
        return moisReclamation;
    }

    public List<SoinReclame> getListeSoinsReclame() {
        return Collections.unmodifiableList(listeSoinsReclame);
    }

    public void addNewReclamation(String typeSoin, String dateSoin, String montantSoin) {
        try {
            SoinReclame soinTemp = new SoinReclame(typeSoin, dateSoin, montantSoin);
            this.listeSoinsReclame.add(soinTemp);

        } catch (Exception e) {
            this.isReclamationsValid = false;
        }
    }
}
