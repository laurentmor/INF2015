package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.text.NumberFormat;
import org.apache.commons.validator.routines.LongValidator;

public class SoinReclame {

    private String typeSoin = null;
    private String dateSoin = null;
    private String montantSoinEntrant = null;
    private double montantSoinConverti = 0;
    private int typeSoinConverti = 0;
    private Reclamations reclamationsAssociee = null;

    public SoinReclame(Reclamations reclamations, String typeSoin, String dateSoin, String montantSoin) throws Exception {
        this.typeSoin = typeSoin;
        this.dateSoin = dateSoin;
        this.montantSoinEntrant = montantSoin;
        this.reclamationsAssociee = reclamations;

        //TODO CR-LM Ne pas appeller de méthodes dans le constructeur
        //Si on créer une classe hériatant de celle ci, modifier les méthodes
        // pourrait rendre le comportement et rendre l'état de l'objet
        // Ou faire de la classe une classe finale
        ValiderTypeSoin();
        ValiderMontantSoin();
        validerDateDuSoins();
    }

     void ValiderTypeSoin() throws Exception {
        try {
            typeSoinConverti = Integer.parseInt(typeSoin);
        } catch (Exception e) {
            throw new Exception("Le type de soin doit etre numerique.");
        }

        if (!isValidTypeSoin()) {
            throw new Exception("Le type de soin est inexistant.");
        }
    }

    //TODO CR-LM : Ai mis cette méthode en visibilité package pour pouvoir la tester
    boolean isValidTypeSoin() {
        switch (this.typeSoinConverti) {
            case 0:
                return true;
            case 100:
                return true;
            case 200:
                return true;
            case 400:
                return true;
            case 500:
                return true;
            case 600:
                return true;
            case 700:
                return true;
            default:
                return LongValidator.getInstance().isInRange(typeSoinConverti, 300, 399);
        }




    }

    //TODO CR-LM les méthodes doivent toutes débuter par une minuscules
     void ValiderMontantSoin() throws Exception {
        montantSoinEntrant = montantSoinEntrant.substring(0, montantSoinEntrant.indexOf("$"));


        try {
            montantSoinConverti = Double.parseDouble(montantSoinEntrant);
            NumberFormat.getCurrencyInstance().format(montantSoinConverti);
        } catch (Exception e) {
        }

    }

   
    
    void validerDateDuSoins() throws Exception {
        
        String moisReclamation = reclamationsAssociee.getMoisReclamation();
        if(!DateUtil.areTwoDatesInSameMonth(moisReclamation, dateSoin)){
         throw new Exception("la date de sins " + dateSoin + " doit être à l'intérieur de : " + moisReclamation);    
        }
        
    }
     public String getDateSoin() {
        return dateSoin;
    }

    public double getMontantSoinConverti() {
        return montantSoinConverti;
    }

    public int getTypeSoinConverti() {
        return typeSoinConverti;
    }
}
