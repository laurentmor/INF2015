package ca.uqam.inf2015.equipe2.gestionreclamation;
 
import org.apache.commons.lang.math.NumberUtils;


public class Client {

    public static final int NUMEROCLIENT_LENGHT = 6;

    private String noClient;
    private String typeContrat;

    
    //Constructeur
    public Client(String noClient, String typeContrat) throws Exception {

        this.noClient = noClient;
        this.typeContrat = typeContrat;
        
        validateNoClient();
        validateTypeContrat();
    }

    
    private void validateNoClient() throws Exception {

        if (this.noClient.length() != NUMEROCLIENT_LENGHT) {
            throw new Exception("Le numero de client doit avoir une longueur de " + NUMEROCLIENT_LENGHT);
        }

        if (!NumberUtils.isDigits(this.noClient)) {
            throw new Exception("Le numero de client doit etre numerique.");
        }
    }

    
    private void validateTypeContrat() throws Exception {

        if (this.typeContrat.length() != 1) {
            throw new Exception("Le type de contrat doit etre une lettre.");
        }
 
        String validation = "ABCD";
        if(!validation.contains(this.typeContrat)) {
            throw new Exception("Le type de contrat doit etre A,B,C,D.");
        }
    }
    
    
    
    public String getNoClient() {
        return noClient;
    }

    
    public String getTypeContrat() {
        return typeContrat;
    }
}





