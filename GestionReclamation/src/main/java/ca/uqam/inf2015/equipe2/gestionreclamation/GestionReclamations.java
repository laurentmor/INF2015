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
            ControlleurProgramme prg = new ControlleurProgramme(inputFileName, outputFileName);
            prg.Run();

            System.out.println("Fin!");

        } catch (Exception e) {
            System.out.println("Erreur!");
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
        System.exit(0);
    }
}
