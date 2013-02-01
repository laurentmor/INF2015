package ca.uqam.inf2015.equipe2.gestionreclamation;

import java.text.NumberFormat;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.validator.routines.LongValidator;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     * 
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        double d=12;
       LongValidator validator=LongValidator.getInstance();
       assertFalse(validator.isInRange(d, 13,50));
       assertTrue(validator.isInRange(d, 9,12));
       String s=NumberFormat.getCurrencyInstance().format(d);
       System.out.println(s); 
    }
}
