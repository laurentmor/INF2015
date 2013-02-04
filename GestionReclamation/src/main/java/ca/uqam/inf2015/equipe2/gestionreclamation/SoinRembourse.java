package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.text.DecimalFormat;

public class SoinRembourse {

    Integer typeSoin;
    String date;
    Double montantRembourse;

    String montantRembourseFormate;

    
    
    public SoinRembourse(Integer typeSoin, String date, Double montantRembourse) {
        this.typeSoin = typeSoin;
        this.date = date;
        this.montantRembourse = montantRembourse;
        
        montantRembourseFormate = new DecimalFormat("0.00$").format(montantRembourse).toString();
    }

    
    public String getTypeSoin() {
        return typeSoin.toString();
    }

    
    public String getDate() {
        return date;
    }

    
    public String getMontantRembourseFormate() {
        return montantRembourseFormate;
    }
}
