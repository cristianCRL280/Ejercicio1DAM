/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package muchasrestricciones;

/**
 *
 * @author dev
 */
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class FicheroPlano {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Integers
        int numLineas = 0, numericos = 0, suma = 0, maxNumericos = Integer.MIN_VALUE, lineaNumericos;
        int numLetras = 0, alfabeticos = 0, mayusculas = 0, minusculas = 0, espacios = 0;
        int vocales = 0, consonantes = 0;
        int maxVocales = 0, maxConsonantes = 0, maxEspacios = 0, maxMayusculas = 0;
        int maxMinusculas = 0, maxPalabras = 0, maxDigitosPares = 0, maxDigitosImpares = 0;
        int maxSimbolos = 0, maxPalabrasLargas = 0;

        // Strings
        String nombreFile, linea, lineaMaxNumericos = "", lineaConGuiones = "";
        String lineaMaxVocales = "", lineaMaxConsonantes = "", lineaMaxEspacios = "";
        String lineaMaxMayusculas = "", lineaMaxMinusculas = "", lineaMaxPalabras = "";
        String lineaMaxDigitosPares = "", lineaMaxDigitosImpares = "", lineaMaxSimbolos = "";
        String lineaMaxPalabrasLargas = "";

        System.out.print("Introduce el nombre del fichero: ");
        nombreFile = sc.nextLine();

        try (Scanner scFile = new Scanner(new File(nombreFile))) {
            while (scFile.hasNextLine()) {
                linea = scFile.nextLine();
                lineaConGuiones = linea.replace(' ', '-');
                numLineas++;
                lineaNumericos = 0;
                int lineaVocales = 0, lineaConsonantes = 0, lineaEspacios = 0;
                int lineaMayusculas = 0, lineaMinusculas = 0, lineaPalabras = 0;
                int lineaDigitosPares = 0, lineaDigitosImpares = 0, lineaSimbolos = 0;
                int lineaPalabrasLargas = 0;

                for (int i = 0; i < linea.length(); i++) {
                    char currentChar = linea.charAt(i);

                    // Ejemplos usando isDigit
                    if (Character.isDigit(currentChar)) {
                        numericos++;
                        lineaNumericos++;
                        suma += Character.getNumericValue(currentChar);
                        if (Character.getNumericValue(currentChar) % 2 == 0) {
                            lineaDigitosPares++;
                        } else {
                            lineaDigitosImpares++;
                        }
                    }

                    // Ejemplos usando isLetter
                    if (Character.isLetter(currentChar)) {
                        numLetras++;
                    }

                    // Ejemplos usando isAlphabetic
                    if (Character.isAlphabetic(currentChar)) {
                        alfabeticos++;
                    }

                    // Ejemplos usando isUpperCase y isLowerCase
                    if (Character.isUpperCase(currentChar)) {
                        mayusculas++;
                        lineaMayusculas++;
                    } else if (Character.isLowerCase(currentChar)) {
                        minusculas++;
                        lineaMinusculas++;
                    }

                    // Ejemplos usando isWhitespace
                    if (Character.isWhitespace(currentChar)) {
                        espacios++;
                        lineaEspacios++;
                    }

                    // Ejemplos de vocales y consonantes
                    char c = Character.toLowerCase(currentChar);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vocales++;
                        lineaVocales++;
                    } else if (Character.isLetter(c)) {
                        consonantes++;
                        lineaConsonantes++;
                    }

                    // Ejemplos adicionales
                    if (currentChar == '@' || currentChar == '#' || currentChar == '.' || currentChar == ',' || currentChar == ';' || currentChar == ':') {
                        lineaSimbolos++;
                    }
                }

                // Contar palabras
                String[] palabras = linea.split("\\s+");
                lineaPalabras = palabras.length;

                // Contar palabras largas (más de 5 caracteres)
                for (String palabra : palabras) {
                    if (palabra.length() > 5) {
                        lineaPalabrasLargas++;
                    }
                }

                // Actualizar línea con más caracteres numéricos
                if (lineaNumericos > maxNumericos) {
                    maxNumericos = lineaNumericos;
                    lineaMaxNumericos = linea;
                }

                // Actualizar línea con más vocales
                if (lineaVocales > maxVocales) {
                    maxVocales = lineaVocales;
                    lineaMaxVocales = linea;
                }

                // Actualizar línea con más consonantes
                if (lineaConsonantes > maxConsonantes) {
                    maxConsonantes = lineaConsonantes;
                    lineaMaxConsonantes = linea;
                }

                // Actualizar línea con más espacios
                if (lineaEspacios > maxEspacios) {
                    maxEspacios = lineaEspacios;
                    lineaMaxEspacios = linea;
                }

                // Actualizar línea con más mayúsculas
                if (lineaMayusculas > maxMayusculas) {
                    maxMayusculas = lineaMayusculas;
                    lineaMaxMayusculas = linea;
                }

                // Actualizar línea con más minúsculas
                if (lineaMinusculas > maxMinusculas) {
                    maxMinusculas = lineaMinusculas;
                    lineaMaxMinusculas = linea;
                }

                // Actualizar línea con más palabras
                if (lineaPalabras > maxPalabras) {
                    maxPalabras = lineaPalabras;
                    lineaMaxPalabras = linea;
                }

                // Actualizar línea con más dígitos pares
                if (lineaDigitosPares > maxDigitosPares) {
                    maxDigitosPares = lineaDigitosPares;
                    lineaMaxDigitosPares = linea;
                }

                // Actualizar línea con más dígitos impares
                if (lineaDigitosImpares > maxDigitosImpares) {
                    maxDigitosImpares = lineaDigitosImpares;
                    lineaMaxDigitosImpares = linea;
                }

                // Actualizar línea con más símbolos
                if (lineaSimbolos > maxSimbolos) {
                    maxSimbolos = lineaSimbolos;
                    lineaMaxSimbolos = linea;
                }

                // Actualizar línea con más palabras largas
                if (lineaPalabrasLargas > maxPalabrasLargas) {
                    maxPalabrasLargas = lineaPalabrasLargas;
                    lineaMaxPalabrasLargas = linea;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------------");
        System.out.println("El número de líneas que tiene el fichero es de: " + numLineas);
        System.out.println("Total de caracteres numéricos: " + numericos);
        System.out.println("Suma de caracteres numéricos: " + suma);
        System.out.println("Línea con más caracteres numéricos: " + lineaMaxNumericos);
        System.out.println("Total de letras: " + numLetras);
        System.out.println("Total de caracteres alfabéticos: " + alfabeticos);
        System.out.println("Total de mayúsculas: " + mayusculas);
        System.out.println("Total de minúsculas: " + minusculas);
        System.out.println("Total de espacios en blanco: " + espacios);
        System.out.println("Línea con guiones: " + lineaConGuiones);
        System.out.println("Total de vocales: " + vocales);
        System.out.println("Total de consonantes: " + consonantes);
        System.out.println("Línea con más vocales: " + lineaMaxVocales);
        System.out.println("Línea con más consonantes: " + lineaMaxConsonantes);
        System.out.println("Línea con más espacios: " + lineaMaxEspacios);
        System.out.println("Línea con más mayúsculas: " + lineaMaxMayusculas);
        System.out.println("Línea con más minúsculas: " + lineaMaxMinusculas);
        System.out.println("Línea con más palabras: " + lineaMaxPalabras);
        System.out.println("Línea con más dígitos pares: " + lineaMaxDigitosPares);
        System.out.println("Línea con más dígitos impares: " + lineaMaxDigitosImpares);
        System.out.println("Línea con más símbolos: " + lineaMaxSimbolos);
        System.out.println("Línea con más palabras largas: " + lineaMaxPalabrasLargas);
    }
}