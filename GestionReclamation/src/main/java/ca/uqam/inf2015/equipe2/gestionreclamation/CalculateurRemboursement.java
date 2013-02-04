package ca.uqam.inf2015.equipe2.gestionreclamation;

import org.apache.commons.validator.routines.LongValidator;



public class CalculateurRemboursement {

    int typeSoin = 0;
    double montant = 0;
//    private static CalculateurRemboursement instance = null;

    public CalculateurRemboursement() {
    }

//    public static CalculateurRemboursement getInstance() {
//        if (instance == null) {
//            instance = new CalculateurRemboursement();
//        }
//        return instance;
//    }

    public double calculer(String typeContrat, SoinReclame soin) {
        typeSoin = soin.getTypeSoinConverti();
        montant = soin.getMontantSoinConverti();
        switch (typeContrat) {
            case "A":
                return caculerPourContratA();
            case "B":
                return caculerPourContratB();
            case "C":
                return caculerPourContratC();
            case "D":
                return caculerPourContratD();
            default:
                return 0;
        }
    }

    double caculerPourContratA() {

        if ((typeSoin == 0) || (typeSoin == 100) || (typeSoin == 200) || (typeSoin == 500)) {
            return (0.25 * montant);
        } else if (typeSoin == 600) {
            return (0.4 * montant);
        }
        return 0;

    }

    double caculerPourContratB() {
        switch (typeSoin) {
            case 0:
                return appliquerCouvertureMaximale(0.5, 40);

            case 100:
                return appliquerCouvertureMaximale(0.5, 50);
            case 200:
                return appliquerCouvertureMaximale(1, 70);
            case 400:
                return 0;
            case 500:
                return appliquerCouvertureMaximale(0.5, 50);
            case 600:
                return montant; // couvert à 100%
            case 700:
                return (0.7 * montant);
            default:
                if (LongValidator.getInstance().isInRange(typeSoin, 300, 399)) {
                    return 0.5 * montant;
                } else {
                    return 0;
                }
        }
    }

    double caculerPourContratC() {
        return (0.9 * montant);
    }

    double caculerPourContratD() {
        switch (typeSoin) {
            case 0:
                return appliquerCouvertureMaximale(1, 85);

            case 100:
                return appliquerCouvertureMaximale(1, 75);
            case 200:
                return appliquerCouvertureMaximale(1, 100);
            case 400:
                return appliquerCouvertureMaximale(1, 65);
            case 500:
                return appliquerCouvertureMaximale(1, 75);
            case 600:
                return appliquerCouvertureMaximale(1, 100);
            case 700:
                return appliquerCouvertureMaximale(1, 90);
            default:
                if (LongValidator.getInstance().isInRange(typeSoin, 300, 399)) {
                    return montant;
                } else {
                    return 0;
                }
        }
    }

    double appliquerCouvertureMaximale(double pourcentage, double montantLimite) {
        if (montant >= montantLimite) {
            return montantLimite;
        } else {
            return pourcentage * montant;
        }
    }
}
