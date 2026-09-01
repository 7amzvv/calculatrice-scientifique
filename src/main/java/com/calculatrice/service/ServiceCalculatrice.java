
package com.calculatrice.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceCalculatrice {

    public double calculer(String expression) throws Exception {
        if (expression == null) {
            throw new IllegalArgumentException("L'expression ne peut pas être null");
        }

        expression = expression.trim().replaceAll("\\s+", "");

        if (expression.isEmpty()) {
            throw new IllegalArgumentException("L'expression ne peut pas être vide");
        }

        Parser parser = new Parser(expression);
        double resultat = parser.parseExpression();

        if (!parser.estTermine()) {
            throw new IllegalArgumentException("Expression invalide");
        }

        return resultat;
    }

    /**
     * Parser récursif permettant de respecter la priorité des opérateurs.
     *
     * Priorités :
     * 1. Parenthèses et fonctions
     * 2. Puissance ^
     * 3. Multiplication et division
     * 4. Addition et soustraction
     */
    private static class Parser {

        private final String expression;
        private int position = 0;

        public Parser(String expression) {
            this.expression = expression;
        }

        /**
         * Addition et soustraction.
         */
        public double parseExpression() {
            double resultat = parseTerme();

            while (position < expression.length()) {
                char operateur = expression.charAt(position);

                if (operateur == '+') {
                    position++;
                    resultat += parseTerme();

                } else if (operateur == '-') {
                    position++;
                    resultat -= parseTerme();

                } else {
                    break;
                }
            }

            return resultat;
        }

        /**
         * Multiplication et division.
         */
        private double parseTerme() {
            double resultat = parsePuissance();

            while (position < expression.length()) {
                char operateur = expression.charAt(position);

                if (operateur == '*') {
                    position++;
                    resultat *= parsePuissance();

                } else if (operateur == '/') {
                    position++;

                    double droite = parsePuissance();

                    if (droite == 0) {
                        throw new ArithmeticException(
                                "Division par zéro impossible"
                        );
                    }

                    resultat /= droite;

                } else {
                    break;
                }
            }

            return resultat;
        }

        /**
         * Puissance.
         */
        private double parsePuissance() {
            double resultat = parseFacteur();

            if (position < expression.length()
                    && expression.charAt(position) == '^') {

                position++;

                double exposant = parsePuissance();

                resultat = Math.pow(resultat, exposant);
            }

            return resultat;
        }

        /**
         * Nombres, parenthèses et fonctions scientifiques.
         */
        private double parseFacteur() {

            if (position >= expression.length()) {
                throw new IllegalArgumentException("Expression invalide");
            }

            // Gestion du signe -
            if (expression.charAt(position) == '-') {
                position++;
                return -parseFacteur();
            }

            // Gestion du signe +
            if (expression.charAt(position) == '+') {
                position++;
                return parseFacteur();
            }

            // Parenthèses
            if (expression.charAt(position) == '(') {

                position++;

                double resultat = parseExpression();

                if (position >= expression.length()
                        || expression.charAt(position) != ')') {

                    throw new IllegalArgumentException(
                            "Parenthèse fermante manquante"
                    );
                }

                position++;

                return resultat;
            }

            // Fonctions scientifiques
            if (expression.startsWith("sqrt", position)) {
                position += 4;

                double valeur = parseFonction();

                if (valeur < 0) {
                    throw new IllegalArgumentException(
                            "Racine carrée d'un nombre négatif impossible"
                    );
                }

                return Math.sqrt(valeur);
            }

            if (expression.startsWith("sin", position)) {
                position += 3;

                double valeur = parseFonction();

                return Math.sin(Math.toRadians(valeur));
            }

            if (expression.startsWith("cos", position)) {
                position += 3;

                double valeur = parseFonction();

                return Math.cos(Math.toRadians(valeur));
            }

            if (expression.startsWith("tan", position)) {
                position += 3;

                double valeur = parseFonction();

                return Math.tan(Math.toRadians(valeur));
            }

            if (expression.startsWith("log", position)) {
                position += 3;

                double valeur = parseFonction();

                return Math.log10(valeur);
            }

            if (expression.startsWith("ln", position)) {
                position += 2;

                double valeur = parseFonction();

                return Math.log(valeur);
            }

            return parseNombre();
        }

        /**
         * Analyse l'argument d'une fonction.
         *
         * Exemple :
         * sqrt(16)
         * sin(0)
         * log(100)
         */
        private double parseFonction() {

            if (position >= expression.length()
                    || expression.charAt(position) != '(') {

                throw new IllegalArgumentException(
                        "Parenthèses attendues après la fonction"
                );
            }

            position++;

            double resultat = parseExpression();

            if (position >= expression.length()
                    || expression.charAt(position) != ')') {

                throw new IllegalArgumentException(
                        "Parenthèse fermante manquante"
                );
            }

            position++;

            return resultat;
        }

        /**
         * Analyse un nombre décimal.
         */
        private double parseNombre() {

            int debut = position;
            boolean point = false;

            while (position < expression.length()) {

                char caractere = expression.charAt(position);

                if (Character.isDigit(caractere)) {
                    position++;

                } else if (caractere == '.') {

                    if (point) {
                        throw new IllegalArgumentException(
                                "Nombre décimal invalide"
                        );
                    }

                    point = true;
                    position++;

                } else {
                    break;
                }
            }

            if (debut == position) {
                throw new IllegalArgumentException(
                        "Expression invalide à la position " + position
                );
            }

            return Double.parseDouble(
                    expression.substring(debut, position)
            );
        }

        /**
         * Vérifie que toute l'expression a été analysée.
         */
        public boolean estTermine() {
            return position == expression.length();
        }
    }
}
