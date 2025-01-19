/**
 * Clase encargada del formateo y tokenización de la expresion original utilizando
 * un algoritmo propio titulado Sorting Buffer.
 */
package com.jmee.parser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro Gómez.
 * @version 1.0.0
 */
public class Tokenizer {

    private static String expression = "";

    /**
     * Constructor de clase.
     * @param expression Expresión a evaluar.
     * @since 1.0.0
     */
    public Tokenizer(String expression) {
        this.expression = expression;
    }

    // Formatea la expresion corectamente.
    private String formatter(String expression) {
        expression = expression.replaceAll("\\s+", "");
        expression = expression.toLowerCase();

        return expression;
    }

    /**
     * Algoritmo de tokenización "Sorting Buffer".
     * @return Retorna una lista de tipo String la cual contiene la expresion original dividida en tokens.
     * @since 1.0.0
     */ 
    public List<String> tokenize() {

        expression = formatter(expression);

        List<String> tokens = new ArrayList<>();
        int length = expression.length();

        for (int i = 0; i < length; i++) {
            char currentChar = expression.charAt(i);

            // Buffer para numeros.
            if (Character.isDigit(currentChar)) {
                StringBuilder buffer = new StringBuilder();

                // Agregar todos los digitos y posibles puntos decimales.
                while (i < length && (Character.isDigit(expression.charAt(i))
                        || expression.charAt(i) == '.')) {

                    buffer.append(expression.charAt(i));
                    i++;
                }

                tokens.add(buffer.toString());
                i--; // Retrocede para no saltar el sigiente caracter.

                // Buffer para funciones.
            } else 
                if (Character.isLetter(currentChar) && currentChar != 'x') {
                StringBuilder buffer = new StringBuilder();

                while (i < length && (Character.isLetter(expression.charAt(i)))) {

                    buffer.append(expression.charAt(i));
                    i++;
                }

                tokens.add(buffer.toString());
                i--;

            } else {
                tokens.add(String.valueOf(currentChar));
            }
        }
        return tokens;
    }
}
