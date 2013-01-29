package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.util.ArrayList;
import java.util.Arrays;


public class SoinReclame {

    private String typeSoin;
    private String dateSoin;
    private String montantSoinEntrant;
    private Double montantSoinConverti;
    private Integer typeSoinConverti;
    
    
    public SoinReclame(String typeSoin, String dateSoin, String montantSoin)  throws Exception {
        this.typeSoin = typeSoin;
        this.dateSoin = dateSoin;
        this.montantSoinEntrant = montantSoin;
        
        ValiderTypeSoin();
        ValiderMontantSoin();
    }

    
    private void ValiderTypeSoin() throws Exception{
        try {
            typeSoinConverti = Integer.parseInt(typeSoin);
        } catch (Exception e) {
            throw new Exception("Le type de soin doit etre numerique.");
        }

        if (!isValidTypeSoin()) {
            throw new Exception("Le type de soin est inexistant.");
        }
    }

    
    private boolean isValidTypeSoin() {
        boolean retour = false;

        // Deux ArrayList de Validation pour le for plus bas
        ArrayList<Integer> upperLimit = new ArrayList(Arrays.asList(-1,-1,-1,399,-1,-1,-1,-1));
        ArrayList<Integer> lowerLimitOrEqual = new ArrayList(Arrays.asList(0,100,200,300,400,500,600,700));

        //La boucle verifie si le soin est soin egal ou bien entre les valeurs des arraylist
        for (int i=0; i < lowerLimitOrEqual.size(); i++) {
            if (isTypeDeSoinEqualOrBetweenNumbers(lowerLimitOrEqual.get(i), upperLimit.get(i))) {
                retour = true;
            }
        }

        return retour;
    }

    
    private boolean isTypeDeSoinEqualOrBetweenNumbers(Integer lowerLimitOrEqual, Integer upperLimit) {

        int number = this.typeSoinConverti.intValue();
        int lower = lowerLimitOrEqual.intValue();
        int upper = upperLimit.intValue();
        
        // Donc == si upper est a -1, sinon on regarde si c'est entre les deux.
        return number == lower && upper == -1 || number >= lower &&  number <= upper;
    }
    
    
    private void ValiderMontantSoin() throws Exception {
        
            if (isMontantEntrantLastCharacterADollarSign()) {
                StripDollarSignAndConvertToDouble();
            } else {
                throw new Exception("Il faut un $ a la fin du montant.");
            }
    }
    
    
    private Boolean isMontantEntrantLastCharacterADollarSign() {
        int longueurChaine = montantSoinEntrant.length();
        String lastChar = montantSoinEntrant.substring(longueurChaine-1, longueurChaine);
        return lastChar.equals("$");
    }

    
    private void StripDollarSignAndConvertToDouble() throws Exception {
        String leftStr = montantSoinEntrant.substring(0, montantSoinEntrant.length()-1);

        try{
            this.montantSoinConverti = Double.parseDouble(leftStr);
        } catch(Exception e) {
            throw new Exception("Le montant est invalide.");
        }
    }

    
    

    public String getDateSoin() {
        return dateSoin;
    }

    
    public double getMontantSoinConverti() {
        return montantSoinConverti.doubleValue();
    }

    
    public int getTypeSoinConverti() {
        return typeSoinConverti.intValue();
    }
    
}













