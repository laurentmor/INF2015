package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.util.ArrayList;



public class Reclamations {

    private Boolean isReclamationsValid;
    private Client client;
    private String moisReclamation;
    private ArrayList<SoinReclame> listeSoinsReclame;
    
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

    
    private void ValiderMois() {
        //TODO valider le mois et ajuster isReclamationsValid
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

    public ArrayList<SoinReclame> getListeSoinsReclame() {
        return listeSoinsReclame;
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














