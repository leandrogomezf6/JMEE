/**
 * Clase padre la cual gestiona las precedencias de los operadores y funciones más 
 * los metodos de verificación.
 */
package com.jmee.parser;

import java.util.HashMap;

/**
 *
 * @author Leandro Gómez.
 * @version 1.0.0
 */
public class ExpressionHandler {
    
    protected static final HashMap<String, Integer> precedence = new HashMap<>();

    // Bloque estatico de inicialización.
    static {
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("x", 2);
        precedence.put("÷", 2);
        precedence.put("^", 3);
        precedence.put("√", 3);

        precedence.put("sin", 4);
        precedence.put("cos", 4);
        precedence.put("tan", 4);
        precedence.put("csc", 4);
        precedence.put("sec", 4);
        precedence.put("cot", 4);
        precedence.put("arcsin", 4);
        precedence.put("arccos", 4);
        precedence.put("arctan", 4);

        precedence.put("log", 4);
        precedence.put("ln", 4);
    }

    /**
     * Verifica si el token en cuestion esta dentro de la precedencia.
     * @param token Signo, numero o funcion de la expresion a evluar.
     * @return TRUE en caso de que si exista y FALSE en caso de que no exista.
     * @since 1.0.0
     */
    protected boolean isToken(String token){
        return precedence.containsKey(token);
    }
    
    /**
     * Verifica si el token en cuestion es un numero.
     * @param token Signo, numero o funcion de la expresion a evluar.
     * @return TRUE en caso de que sea un numero y FALSE en caso de que no lo sea.
     * @since 1.0.0
     */
    protected boolean isNumber(String token) {
        try {
            Double.valueOf(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Verifica si el token en cuestion es un operador aritmetico ordinario.
     * @param token Signo, numero o funcion de la expresion a evluar.
     * @return TRUE en caso de que sea un operador y FALSE en caso de que no lo sea.
     * @since 1.0.0
     */
    protected boolean isOperator(String token) {
        return switch (token) {
            case "+" ->
                true;
            case "-" ->
                true;
            case "x" ->
                true;
            case "÷" ->
                true;
            case "^" ->
                true;
            default ->
                false;
        };
    }

    /**
     * Verifica si la "función" en cuestión esta dentro de las funciones del programa.
     * @param function Funcion de la expresion a evluar.
     * @return TRUE en caso de que sea una función y FALSE en caso de que no lo sea.
     * @since 1.0.0
     */
    protected boolean isFunction(String function) {
        return switch (function) {
            case "sqrt" ->
                true;
                
            // Funciones trigonometricas.
            case "sin" ->
                true;
            case "cos" ->
                true;
            case "tan" ->
                true;
            case "csc" ->
                true;
            case "sec" ->
                true;
            case "cot" ->
                true;
            case "arcsin" ->
                true;
            case "arccos" ->
                true;
            case "arctan" ->
                true;
                
            // Funciones logaritmicas.
            case "log" ->
                true;
            case "ln" ->
                true;
            default ->
                false;
        };
    }
}
