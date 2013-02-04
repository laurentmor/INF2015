package ca.uqam.inf2015.equipe2.gestionreclamation;


public class ControlleurProgramme {

    ReclamationReader reclamationReader;
    RemboursementWriter remboursementWriter;
    CalculateurRemboursement calculateurRemboursement;
    Reclamations reclamations;
    Remboursements remboursements;
    String inputFileName;
    String outputFileName;
    Client client;

    public ControlleurProgramme(String inputFileName, String outputFileName) {
        try {
            reclamationReader = new ReclamationReader(inputFileName);
            remboursementWriter = new RemboursementWriter(outputFileName);
//            calculateurRemboursement = new CalculateurRemboursement();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Run() throws Exception {
        
//        reclamationReader.DisplayAllReclamations();
        reclamations = reclamationReader.getReclamations();
        
        if (!reclamations.isReclamationsValid()) {
            this.remboursementWriter.SaveDonneInvalideOnDisk();
            return;
        }
        PreparationDesRemboursements();
 
        for (SoinReclame s : this.reclamations.getListeSoinsReclame()) {
            Double montantRemboursement = enginRegle.CalculerMontantRemboursement(s.getTypeSoinConverti(), client.getTypeContrat(), s.getMontantSoinConverti());
            remboursements.addNewRemboursement(s.getTypeSoinConverti(), s.getDateSoin(), montantRemboursement);
        }

        this.remboursementsWriter.SaveRemboursementsOnDisk();
    }

    public void PreparationDesRemboursements() {
        reclamations = reclamationsReader.getReclamations();
        client = reclamations.getClient();
        remboursements = new Remboursements(client, reclamations.getMoisReclamation());
        remboursementsWriter.setRemboursement(remboursements);
    }
}
