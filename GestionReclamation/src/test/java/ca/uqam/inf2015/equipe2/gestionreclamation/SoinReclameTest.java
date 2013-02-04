package ca.uqam.inf2015.equipe2.gestionreclamation;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




public class SoinReclameTest {
    
    SoinReclame soinReclameBon1;
    SoinReclame soinReclameBon2;
    SoinReclame soinReclameBon3;
    SoinReclame soinReclameBad;
    
    
    public SoinReclameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            soinReclameBon1 = new SoinReclame("2013-01","0","2013-01-11","234.00$");
            soinReclameBon2 = new SoinReclame("2008-02","300","2008-02-29","234.00$");
            soinReclameBon3 = new SoinReclame("2013-01","399","2013-01-11","234.00$");
        } catch(Exception e) {
            fail("Un bon contructeur doit pas retourner d'erreur");
        }
    }
    
    @After
    public void tearDown() {
        soinReclameBon1 = null;
        soinReclameBon2 = null;
        soinReclameBon3 = null;
        soinReclameBad = null;
    }

    
     
    @Test
    public void testConstructeurTypeDeSoin800() {
        
        try {
            soinReclameBad = new SoinReclame("2013-01","800","2013-01-11","234.00$");
            fail("Un mauvais type de soin devrait donner un erreur.");
        } catch(Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testConstructeurMontantSansDollars() {
        
        try {
            soinReclameBad = new SoinReclame("2013-01","399","2013-01-11","234.00");
            fail("Montant sans le $ devrait donner un erreur.");
        } catch(Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testConstructeurMontantInvalide() {
        
        try {
            soinReclameBad = new SoinReclame("2013-01","399","2013-01-11","23A.00$");
            fail("Montant invalide devrait donner un erreur.");
        } catch(Exception e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testConstructeurDateEtMoisDifferent() {
        
        try {
            soinReclameBad = new SoinReclame("2013-01","399","2012-01-11","23A.00$");
            fail("La date et le mois different devrait donner un erreur.");
        } catch(Exception e) {
            assertTrue(true);
        }
    }

    
    @Test
    public void testGetDateSoin() {
        
        assertEquals("2013-01-11", soinReclameBon1.getDateSoin());
        assertEquals("2008-02-29", soinReclameBon2.getDateSoin()); //test annee bisextile

    }

    
    @Test
    public void testGetMontantSoinConverti() {
        
        assertEquals(234.00, soinReclameBon1.getMontantSoinConverti(), 0);
    }
     
    
    @Test
    public void testGetTypeSoinConverti() {
        
        assertEquals(0, soinReclameBon1.getTypeSoinConverti());
        assertEquals(300, soinReclameBon2.getTypeSoinConverti());
        assertEquals(399, soinReclameBon3.getTypeSoinConverti());
        
    }
}




