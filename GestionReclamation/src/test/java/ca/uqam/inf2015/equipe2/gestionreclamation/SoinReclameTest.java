/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author laurent
 */

@Ignore public class SoinReclameTest {
  private  static SoinReclame instanceConforme=null;
  private  static SoinReclame instanceMontantIncorrect=null;
  private  static SoinReclame instanceTypeSoinIncorrect=null;
  private  static  Reclamations reclamations=null;
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
             reclamations=new Reclamations("123456", "A", "2013-09");
            instanceConforme=new SoinReclame(reclamations,"340", "2013-09-09", "123.00$");
            instanceMontantIncorrect=new SoinReclame(reclamations,"340", "2013-09-09", "xxx.00$");
            instanceTypeSoinIncorrect=new SoinReclame(reclamations,"1000", "2013-09-09", "123.00$");
        } catch (Exception ex) {
            Logger.getLogger(SoinReclameTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDateSoin method, of class SoinReclame.
     */
    @Test
    public void testGetDateSoin() {
        System.out.println("getDateSoin");
       
        
        String expResult = "2013-09-09";
        String result = instanceConforme.getDateSoin();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMontantSoinConverti method, of class SoinReclame.
     */
    @Test
    public void testGetMontantSoinConverti() {
        System.out.println("getMontantSoinConverti");
        
        double expResult = 123;
        double result = instanceConforme.getMontantSoinConverti();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of getTypeSoinConverti method, of class SoinReclame.
     */
    @Test
    public void testGetTypeSoinConverti() {
        System.out.println("getTypeSoinConverti");
        int expResult = 340;
        int result = instanceConforme.getTypeSoinConverti();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isValidTypeSoin method, of class SoinReclame.
     */
    @Test
    public void testIsValidTypeSoin() {
        System.out.println("isValidTypeSoin");
        assertTrue(instanceConforme.isValidTypeSoin());
    }

     
   
    /**
     * Test of validerDateDuSoins method, of class SoinReclame.
     */
    @Test
    public void testValiderDateDuSoins() throws Exception {
        System.out.println("validerDateDuSoins");
        SoinReclame instance = new SoinReclame(reclamations, "300", "2011-09-09", "200$");
        assertNull(instance);
        
    }
}
