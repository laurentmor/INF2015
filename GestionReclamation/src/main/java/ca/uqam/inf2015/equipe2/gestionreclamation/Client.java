package ca.uqam.inf2015.equipe2.gestionreclamation;
 

public class Client {

    public static final int NUMEROCLIENT_LENGHT = 6;

    private String noClient;
    private String typeContrat;

    
    //Constructeur
    public Client(String noClient, String typeContrat) throws Exception {

        this.noClient = noClient;
        this.typeContrat = typeContrat;
        
        ValidateNoClient();
        ValidateTypeContrat();
    }

    
    private void ValidateNoClient() throws Exception {

        if (this.noClient.length() != NUMEROCLIENT_LENGHT) {
            throw new Exception("Le numero de client doit avoir une longueur de " + NUMEROCLIENT_LENGHT);
        }

        if (!isNumeric(this.noClient)) {
            throw new Exception("Le numero de client doit etre numerique.");
        }
    }

    
    private void ValidateTypeContrat() throws Exception {

        if (this.typeContrat.length() != 1) {
            throw new Exception("Le type de contrat doit etre une lettre.");
        }
 
        String validation = "ABCD";
        if(validation.indexOf(this.typeContrat) == -1) {
            throw new Exception("Le type de contrat doit etre A,B,C,D.");
        }
    }
    
    
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    
    public String getNoClient() {
        return noClient;
    }

    
    public String getTypeContrat() {
        return typeContrat;
    }
}





