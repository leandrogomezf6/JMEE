
package com.jmee.parser;

import com.jmee.parser.Parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class ParserTest {
    
    public ParserTest() {
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

    @Test
    public void testInfixToPostfix() {
        System.out.println("infixToPostfix");
        List<String> expression = 
                Arrays.asList
        ("sin", "(", "2", ")", "+", "ln", "(", "4", ")", "x", "3", "-", "cos", "(", "1", ")");
        Parser parser = new Parser(expression);
        List<String> expResult = 
                Arrays.asList("2", "sin", "4","ln", "3", "x", "+","1", "cos", "-");
        List<String> result = parser.infixToPostfix();
        assertEquals(expResult, result);
    }
    
}
