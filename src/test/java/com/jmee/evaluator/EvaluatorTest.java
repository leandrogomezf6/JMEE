
package com.jmee.evaluator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leandro Gómez.
 * @version 1.0.0
 */
public class EvaluatorTest {
    
    public EvaluatorTest() {
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
     * Test of getAns method, of class Evaluator.
     */
    @Test
    public void testGetAns() {
        System.out.println("getAns");
        Evaluator instance = null;
        double expResult = 0.0;
        double result = instance.getAns();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of evaluateExpression method, of class Evaluator.
     */
    @Test
    public void testEvaluateExpression() {
        System.out.println("evaluateExpression");
        Evaluator instance = null;
        double expResult = 0.0;
        double result = instance.evaluateExpression();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
