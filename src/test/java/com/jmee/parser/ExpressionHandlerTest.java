
package com.jmee.parser;

import com.jmee.parser.ExpressionHandler;
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
public class ExpressionHandlerTest {
    
    public ExpressionHandlerTest() {
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
     * Test of isToken method, of class ExpressionHandler.
     */
    @Test
    public void testIsToken() {
        System.out.println("isToken");
        
        String token = "^";
        ExpressionHandler expressionHandler = new ExpressionHandler();
        
        boolean expResult = true;
        boolean result = expressionHandler.isToken(token);
        assertEquals(expResult, result);
        
        token = "arsin";
        expResult = false;
        result = expressionHandler.isToken(token);
        assertEquals(expResult, result);
        
        token = "log";
        expResult = true;
        result = expressionHandler.isToken(token);
        assertEquals(expResult, result);
        
        token = "x";
        expResult = false;
        result = expressionHandler.isToken(token);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNumber method, of class ExpressionHandler.
     */
    @Test
    public void testIsNumber() {
        System.out.println("isNumber");
        
        String token = "1.3564";
        ExpressionHandler expressionHandler = new ExpressionHandler();
        
        boolean expResult = true;
        boolean result = expressionHandler.isNumber(token);
        assertEquals(expResult, result);
        
        token = "100";
        expResult = true;
        result = expressionHandler.isNumber(token);
        assertEquals(expResult, result);
        
        token = "1,000";
        expResult = false;
        result = expressionHandler.isNumber(token);
        assertEquals(expResult, result);
        
        token = "-100";
        expResult = true;
        result = expressionHandler.isNumber(token);
        assertEquals(expResult, result);
    }

    /**
     * Test of isOperator method, of class ExpressionHandler.
     */
    @Test
    public void testIsOperator() {
        System.out.println("isOperator");
        
        String token = "tan";
        ExpressionHandler expressionHandler = new ExpressionHandler();
        
        boolean expResult = false;
        boolean result = expressionHandler.isOperator(token);
        assertEquals(expResult, result);
        
        token = "+";
        expResult = true;
        result = expressionHandler.isOperator(token);
        assertEquals(expResult, result);
        
        token = "x";
        expResult = true;
        result = expressionHandler.isOperator(token);
        assertEquals(expResult, result);
        
        token = ".";
        expResult = false;
        result = expressionHandler.isOperator(token);
        assertEquals(expResult, result);
    }

    /**
     * Test of isFunction method, of class ExpressionHandler.
     */
    @Test
    public void testIsFunction() {
        System.out.println("isFunction");
        
        String function = "sin";
        ExpressionHandler expressionHandler = new ExpressionHandler();
        
        boolean expResult = true;
        boolean result = expressionHandler.isFunction(function);
        assertEquals(expResult, result);
        
        function = "cos";
        expResult = true;
        result = expressionHandler.isFunction(function);
        assertEquals(expResult, result);
        
        function = "tac";
        expResult = false;
        result = expressionHandler.isFunction(function);
        assertEquals(expResult, result);
        
        function = "con";
        expResult = false;
        result = expressionHandler.isFunction(function);
        assertEquals(expResult, result);
    }
    
}
