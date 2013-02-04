package ca.uqam.inf2015.equipe2.gestionreclamation;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


//TODO Test du constructeur avec les erreurs possible


public class SoinRembourseTest {

    SoinRembourse soinRembourse1;
    SoinRembourse soinRembourse2;
    
    
    
    public SoinRembourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        soinRembourse1 = new SoinRembourse(100,"2013-01-11",111.111);
        soinRembourse2 = new SoinRembourse(100,"2013-01-11",0.0);
    }
    
    @After
    public void tearDown() {
        soinRembourse1 = null;
        soinRembourse2 = null;
    }


    
    @Test
    public void testGetTypeSoin() {
        System.out.println("getTypeSoin");

        assertEquals("100", soinRembourse1.getTypeSoin());
    }


    @Test
    public void testGetDate() {
        System.out.println("getDate");
        
        assertEquals("2013-01-11", soinRembourse1.getDate());
    }

    /**
     * Test of getMontantRembourseFormate method, of class SoinRembourse.
     */
    @Test
    public void testGetMontantRembourseFormate() {
        System.out.println("getMontantRembourseFormate");

        assertEquals("111.11$", soinRembourse1.getMontantRembourseFormate());
        assertEquals("0.00$", soinRembourse2.getMontantRembourseFormate());
    }
}
