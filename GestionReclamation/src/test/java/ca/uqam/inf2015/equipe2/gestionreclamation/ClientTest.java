package ca.uqam.inf2015.equipe2.gestionreclamation;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
 

//TODO Test du constructeur avec les erreurs possible



public class ClientTest {
    
    Client client;
    
    
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
            client = new Client("111111", "A");
        } catch(Exception e) {
            fail(e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
        client = null;
    }


    
    @Test
    public void testGetNoClient() {
        System.out.println("getNoClient");

        assertEquals("111111", client.getNoClient());
    }


    @Test
    public void testGetTypeContrat() {
        System.out.println("getTypeContrat");

        assertEquals("A", client.getTypeContrat());
    }
}





