package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SoinRembourse {

    int typeSoin;
    String date;
    double montantRembourse;
    String montantRembourseFormate;

    public SoinRembourse(int typeSoin, String date, double montantRembourse) {
        this.typeSoin = typeSoin;
        this.date = date;
        this.montantRembourse = montantRembourse;

        montantRembourseFormate = NumberFormat.getCurrencyInstance().format(montantRembourse);
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
