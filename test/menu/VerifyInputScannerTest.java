/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import formatMessage.VerifyInputScanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter
 */
public class VerifyInputScannerTest {
    
    public VerifyInputScannerTest() {
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
     * Test of verifyString method, of class VerifyInputScanner.
     * http://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
     */
    @Test
    public void testVerifyString() {
        System.out.println("verifyString");
        String expResult = "";
        String result = VerifyInputScanner.verifyString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifyInt method, of class VerifyInputScanner.
     */
    @Test
    public void testVerifyInt() {
        System.out.println("verifyInt");
        int expResult = 0;
        int result = VerifyInputScanner.verifyInt();
        assertEquals(expResult, result);
    }

    /**
     * Test of verifyDouble method, of class VerifyInputScanner.
     */
    @Test
    public void testVerifyDouble() {
        System.out.println("verifyDouble");
        double expResult = 0.0;
        double result = VerifyInputScanner.verifyDouble();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of verifyEmail method, of class VerifyInputScanner.
     */
    @Test
    public void testVerifyEmail() {
        System.out.println("verifyEmail");
        String expResult = "aap@noot.mies";
        String result = VerifyInputScanner.verifyEmail();
        assertEquals(expResult, result);
        
    }
    
}
