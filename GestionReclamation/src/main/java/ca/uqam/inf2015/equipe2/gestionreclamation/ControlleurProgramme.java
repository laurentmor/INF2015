package ca.uqam.inf2015.equipe2.gestionreclamation;;


public class ControlleurProgramme {

    ReclamationsReader reclamationsReader;
    RemboursementsWriter remboursementsWriter;
    EnginRegle enginRegle;
    Reclamations reclamations;
    Remboursements remboursements;
    String inputFileName;
    String outputFileName;
    Client client;

    public ControlleurProgramme(String inputFileName, String outputFileName) {
        try {
            reclamationsReader = new ReclamationsReader(inputFileName);
            remboursementsWriter = new RemboursementsWriter(outputFileName);
            enginRegle = new EnginRegle();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Run() throws Exception {
        
//        reclamationsReader.DisplayAllReclamations();
        
        if (!reclamationsReader.isDocumentValid()) {
            this.remboursementsWriter.SaveDonneInvalideOnDisk();
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
