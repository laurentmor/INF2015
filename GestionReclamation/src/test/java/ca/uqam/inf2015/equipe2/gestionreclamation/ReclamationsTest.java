/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laurent
 */
public class ReclamationsTest {
    
    public ReclamationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isReclamationsValid method, of class Reclamations.
     */
    @Test
    public void testIsReclamationsValid() {
        System.out.println("isReclamationsValid");
        Reclamations instance = null;
        Boolean expResult = null;
        Boolean result = instance.isReclamationsValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClient method, of class Reclamations.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        Reclamations instance = null;
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoisReclamation method, of class Reclamations.
     */
    @Test
    public void testGetMoisReclamation() {
        System.out.println("getMoisReclamation");
        Reclamations instance = null;
        String expResult = "";
        String result = instance.getMoisReclamation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListeSoinsReclame method, of class Reclamations.
     */
    @Test
    public void testGetListeSoinsReclame() {
        System.out.println("getListeSoinsReclame");
        Reclamations instance = null;
        List expResult = null;
        List result = instance.getListeSoinsReclame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewReclamation method, of class Reclamations.
     */
    @Test
    public void testAddNewReclamation() {
        System.out.println("addNewReclamation");
        String typeSoin = "";
        String dateSoin = "";
        String montantSoin = "";
        Reclamations instance = null;
        instance.addNewReclamation(typeSoin, dateSoin, montantSoin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValiderMois method, of class Reclamations.
     */
    @Test
    public void testValiderMois() {
        System.out.println("ValiderMois");
        Reclamations instance = new Reclamations("09", "B", "2013-19");
        instance.ValiderMois();
        assertFalse(instance.isReclamationsValid());
        
    }
}
