package ca.uqam.inf2015.equipe2.gestionreclamation;




public class GestionReclamations {

    public static final int RIGHT_NUMBER_OF_ARGUMENTS = 2;
    private static String inputFileName;
    private static String outputFileName;
    
    
    /**
     * @param args Reclamation.xml Remboussement.xml
     */
    public static void main(String[] args) {

        DisplayIntroduction();

        if (args.length != RIGHT_NUMBER_OF_ARGUMENTS) {
            DisplayHelpAndExit();
        }

        inputFileName = args[0];
        outputFileName = args[1];

        try {
//          ControlleurProgramme prg = new ControlleurProgramme(inputFileName, outputFileName);
//          prg.Run();

//            ReclamationReader reclamationReader = new ReclamationReader(inputFileName);
//            reclamationReader.DisplayAllReclamations();
            Client client = new Client("100323", "A");
            Remboursements rem = new Remboursements(client, "2013-01");
            
            rem.addNewRemboursement(100, "2013-01-11", 58.50);
            rem.addNewRemboursement(200, "2013-01-13", 22.50);
            rem.addNewRemboursement(334, "2013-01-23", 0.0);
            
            RemboursementWriter rw = new RemboursementWriter("output.xml");
            rw.setRemboursement(rem);
            rw.SaveRemboursementsOnDisk();
//            rw.SaveDonneInvalideOnDisk();
            
            System.out.println("Fin!");
        } catch (Exception e) {
            System.out.println("Erreur");
            System.out.println(e.getMessage());
        }
    
    
    }
    
    
    private static void DisplayIntroduction() {
        System.out.println("");
        System.out.println("Gestion Reclamations v1.0");
        System.out.println("fait par l'equipe 2!");
        System.out.println("");
    }

    
    private static void DisplayHelpAndExit() {
        System.out.println("Usage:");
        System.out.println("");
        System.out.println("Java -jar GestionReclamations.jar Reclamations.xml Remboursements.xml ");
        System.out.println("");
        System.exit(-1);
    }
    
}
