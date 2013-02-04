package ca.uqam.inf2015.equipe2.gestionreclamation;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
 

//TODO Test du constructeur avec les erreurs possible


public class ClientTest {
    
    Client clientBon;
    Client clientBad;
    
    
    public ClientTest() {
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
            clientBon = new Client("123456", "A");
        } catch(Exception e) {
            fail("Le bon constructeur retourne une erreur!");
        }
    }
    
    @After
    public void tearDown() {
        clientBon = null;
        clientBad = null;
    }


    
    @Test
    public void testConstructeurNoClientMauvaisNbreDigit() {

        try {
            clientBon = new Client("12345", "A");
            fail("NoClient pas 6 digit donne pas d'erreur.");
        } catch(Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testConstructeurNoClientPasTouteDigit() {

        try {
            clientBon = new Client("12345A", "A");
            fail("NoClient pas toute en digit donne pas d'erreur.");
        } catch(Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testConstructeurMauvaisTypeContrat() {

        try {
            clientBon = new Client("123456", "E");
            fail("Mauvais contrat donne pas d'erreur.");
        } catch(Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetNoClient() {

        assertEquals("123456", clientBon.getNoClient());
    }


    @Test
    public void testGetTypeContrat() {

        assertEquals("A", clientBon.getTypeContrat());
    }
}





