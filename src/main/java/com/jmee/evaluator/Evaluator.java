/**
 * Esta programa Java esta diseñado para poder evaluar expresiones matematicas
 * aplicando algoritmos y procesos eficientes.
 */
package com.jmee.evaluator;

import java.util.List;
import java.util.Stack;
import com.jmee.parser.ExpressionHandler;
import com.jmee.parser.Parser;
import com.jmee.parser.Tokenizer;


/**
 *
 * @author Leandro Gómez.
 * @version 1.0.0
 */
public class Evaluator extends ExpressionHandler{

    private static List<String> posfixExpresion;
    private double ans = 0;

    /**
     *
     * @param expression Expresión en notacion infija (3+3-2*5/4...)
     * @since 1.0.0
     */
    public Evaluator(String expression) {
        Tokenizer tokenizer = new Tokenizer(expression);
        Parser parser = new Parser(tokenizer.tokenize());
        posfixExpresion = parser.infixToPostfix();
        
    }
    
    /**
     * Metodo get para optener el resultado de las operaciones.
     * @return Resultado de las operaciones.
     */
    public double getAns(){
        return ans;
    }

    /**
     * Metodo encargado de evaluar la expresión.
     * @return Retorna el resultado de la expresion evaluada en notación posfija.
     * @since 1.0.0
     */
    public double evaluateExpression() {
        Stack<Double> output = new Stack<>();

        for (String token : posfixExpresion) {
            if (isNumber(token)) {
                output.push(Double.valueOf(token));
            } else if (isOperator(token)) {

                double b = output.pop();
                double a = output.pop();

                switch (token) {
                    case "+" ->
                        output.push(a + b);
                    case "-" ->
                        output.push(a - b);
                    case "x" ->
                        output.push(a * b);
                    case "÷" ->
                        output.push(a / b);
                    case "^" ->
                        output.push(Math.pow(a, b));
                    default ->
                        throw new AssertionError();
                }
            } else if (token.equals("√")) {
                output.push(Math.sqrt(output.pop()));
                
            }  else if (isFunction(token)) {

                // Convierte el angulo a radianes.
                double radians = Math.toRadians(output.pop());

                switch (token) {
                    case "sin" ->
                        output.push(Math.sin(radians));
                    case "cos" ->
                        output.push(Math.cos(radians));
                    case "tan" ->
                        output.push(Math.tan(radians));
                    case "csc" ->
                        output.push(1 / Math.sin(radians));
                    case "sec" ->
                        output.push(1 / Math.cos(radians));
                    case "cot" ->
                        output.push(1 / Math.tan(radians));
                    case "arcsin" ->
                        output.push(Math.asin(radians));
                    case "arccos" ->
                        output.push(Math.acos(radians));
                    case "arctan" ->
                        output.push(Math.atan(radians));
                        
                    // Funciones logaritmicas.
                    case "log" ->
                        output.push(Math.log10(output.pop()));
                    case "ln" ->
                        output.push(Math.log(output.pop()));
                    default ->
                        throw new AssertionError();
                }

            }
        }// fin foreach.

        ans = output.pop();
        return ans;
    }
    
}
