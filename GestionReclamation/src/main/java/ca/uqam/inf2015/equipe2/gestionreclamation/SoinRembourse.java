package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.text.DecimalFormat;

public class SoinRembourse {

    int typeSoin;
    String date;
    double montantRembourse;

    String montantRembourseFormate;

    
    
    public SoinRembourse(int typeSoin, String date, double montantRembourse) {
        this.typeSoin = typeSoin;
        this.date = date;
        this.montantRembourse = montantRembourse;
        //TODO  CR-LM selon le système, 
        //DecimalFormat va remplacer le '.' par une ","
        //Donc, on court-circuite le problème en forçant le '.'
        
        montantRembourseFormate = new DecimalFormat("0.00$").format(montantRembourse).toString().replace(',', '.');
      System.out.println("SoinRembourse:"+montantRembourseFormate);
    }

    
    public String getTypeSoin() {
        return Integer.toString(typeSoin);
    }

    
    public String getDate() {
        return date;
    }

    
    public String getMontantRembourseFormate() {
        return montantRembourseFormate;
    }
}
