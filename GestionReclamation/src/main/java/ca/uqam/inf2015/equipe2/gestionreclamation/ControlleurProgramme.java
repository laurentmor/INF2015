package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ControlleurProgramme {

    ReclamationReader reclamationReader;
    RemboursementWriter remboursementWriter;
    CalculateurRemboursement calculateurRemboursement;
    Reclamations reclamations;
    Remboursements remboursements;
    String inputFileName;
    String outputFileName;
    Client client;

    public ControlleurProgramme(String inputFileName, String outputFileName) throws Exception {
        reclamationReader = new ReclamationReader(inputFileName);
        remboursementWriter = new RemboursementWriter(outputFileName);
        calculateurRemboursement = new CalculateurRemboursement();
    }

    public void Run()  {
        
//        reclamationReader.DisplayAllReclamations();
        reclamations = reclamationReader.getReclamations();
        
        if (!reclamations.isReclamationsValid()) {
            try {
                this.remboursementWriter.SaveDonneInvalideOnDisk();
            } catch (Exception ex) {
                Logger.getLogger(ControlleurProgramme.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        PreparationDesRemboursements();
 
        for (SoinReclame s : this.reclamations.getListeSoinsReclame()) {
//            Double montantRemboursement = enginRegle.CalculerMontantRemboursement(s.getTypeSoinConverti(), client.getTypeContrat(), s.getMontantSoinConverti());
            Double montantRemboursement = calculateurRemboursement.calculer(client.getTypeContrat(), s);

            remboursements.addNewRemboursement(s.getTypeSoinConverti(), s.getDateSoin(), montantRemboursement);
        }
        try {
            this.remboursementWriter.SaveRemboursementsOnDisk();
        } catch (Exception ex) {
            Logger.getLogger(ControlleurProgramme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PreparationDesRemboursements() {
        reclamations = reclamationReader.getReclamations();
        client = reclamations.getClient();
        remboursements = new Remboursements(client, reclamations.getMoisReclamation());
        remboursementWriter.setRemboursement(remboursements);
    }
}
