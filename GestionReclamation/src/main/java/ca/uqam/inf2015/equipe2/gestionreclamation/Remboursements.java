package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.util.ArrayList;



public class Remboursements {

    private Client client;
    private String moisRemboursement;
    private ArrayList<SoinRembourse> listeSoinsRembourse;

    
    public Remboursements(Client client, String moisRembourssement) {
        this.client = client;
        this.moisRemboursement = moisRembourssement;
        listeSoinsRembourse = new ArrayList<>();
    }

    
    public void addNewRemboursement(Integer typeSoin, String dateSoin, Double montantRembourse) {
        SoinRembourse remboussementTemp = new SoinRembourse(typeSoin, dateSoin, montantRembourse);
        this.listeSoinsRembourse.add(remboussementTemp);
    }

    
    public Client getClient() {
        return client;
    }

    
    public String getMoisRemboursement() {
        return moisRemboursement;
    }

    
    public ArrayList<SoinRembourse> getListeSoinsRembourse() {
        return listeSoinsRembourse;
    }
    
}



