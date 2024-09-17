/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.dam.gestorpalabras;

import com.dam.Excepciones.*;

/**
 *
 * @author dev
 */
public class GestorPalabras {

    public boolean esPalindromo(String palabra) throws TooShortWordException, NoNumberException, SymbolException {
        String palabraFormateada = palabra.replaceAll("\\s+", "").toLowerCase();

        if (palabra.length() <= 2) {
            throw new TooShortWordException("Palabra demasiado corta, por favor introduce una palabra de más longitud");
        } else if (recorrerPalabra(palabra)) {
            throw new SymbolException("No están admitidos símbolos");
        } else {
            for (int i = 0; i < palabraFormateada.length(); i++) {
                if (Character.isDigit(palabra.charAt(i))) {
                    throw new NoNumberException("No vale un número, tienes que poner una palabra");
                }
            }
        }
        palabraFormateada = palabraFormateada.replace('á', 'a').replace('é', 'e').replace('í', 'i').replace('ó', 'o').replace('ú', 'u');
        for (int i = 0; i < palabraFormateada.length() / 2; i++) {
            if (palabraFormateada.charAt(i) != palabraFormateada.charAt(palabraFormateada.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public int contarVocales(String palabra) throws NoNumberException, SymbolException {
        int contador = 0;
        boolean p;
        for (int i = 0; i < palabra.length(); i++) {
            char caracter = Character.toLowerCase(palabra.charAt(i));
            p = Character.isDigit(palabra.charAt(i));
            if (p == true) {
                throw new NoNumberException("No vale un numero, tienes que poner una palabra");
            } else if (recorrerPalabra(palabra)) {
                throw new SymbolException("No están admitidos símbolos");
            } else {
                if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u' || caracter == 'á' || caracter == 'é' || caracter == 'í' || caracter == 'ó' || caracter == 'ú') {
                    contador++;
                }
            }
        }
        return contador;
    }

    public String invertirPalabra(String palabra) throws NoNumberException, SymbolException {
        StringBuilder resultado = new StringBuilder();
        boolean p;
        for (int i = palabra.length() - 1; i >= 0; i--) {
            p = Character.isDigit(palabra.charAt(i));
            if (p == true) {
                throw new NoNumberException("No vale un numero, tienes que poner una palabra");
            } else if (recorrerPalabra(palabra)) {
                throw new SymbolException("No están admitidos símbolos");

            } else {
                resultado.append(palabra.charAt(i));
            }
        }
        return resultado.toString();
    }

    public static boolean recorrerPalabra(String palabra) {
        Character p;
        for (int i = 0; i < palabra.length(); i++) {
            p = palabra.charAt(i);
            if (p.equals('@') || p.equals('%') || p.equals('/') || p.equals('*') || p.equals('+')
                    || p.equals('=') || p.equals('~') || p.equals('$') || p.equals('&')) {
                return true;
            }
        }
        return false;
    }
}