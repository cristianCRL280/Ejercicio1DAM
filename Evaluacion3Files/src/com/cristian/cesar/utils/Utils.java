/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristian.cesar.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Utils {

    private final static String abc = "abcdefghijklmnopqrstuwxyzABCDEFGHIJKLMNOPQRSTUWXYZ";

    public static void tratarFicheros(String nombreFicheroOriginal, String nombreFicheroFinal, int clave) throws FileNotFoundException, Exception {
        File fIni = new File(nombreFicheroOriginal);
        File fFin = new File(nombreFicheroFinal);
        Scanner scFile = null;
        FileWriter fw = null;
        String linea = "";
        String fin = "";
        if (!fIni.exists()) {
            throw new FileNotFoundException();
        } else {
            try {
                scFile = new Scanner(fIni);
                fw = new FileWriter(fFin);
                while (scFile.hasNextLine()) {
                    fin = "";
                    linea = scFile.nextLine();
                    for (int i = 0; i < linea.length(); i++) {
                        fin += cifrarLetra(linea.charAt(i), clave);
                    }
                    fin += "\n";
                    fw.write(fin);
                }
            } catch (Exception e) {

                throw e;

            } finally {

                if (scFile != null) {
                    scFile.close();
                }
                if (fw != null) {
                    try {

                        fw.close();
                    } catch (Exception e) {
                        throw e;
                    }

                }
            }

        }

    }

    public static char cifrarLetra(char c, int clave) {

        clave = clave % (abc.length() / 2);
        char charResultado;
        int posResultado;
        if (abc.indexOf(c) == -1) {
            charResultado = c;
        } else {

            posResultado = abc.indexOf(c) + clave;
            if (posResultado >= abc.length()) {
                posResultado = posResultado % abc.length();
            } else if (posResultado < 0) {
                posResultado = abc.length() + posResultado;
            }
            charResultado = abc.charAt(posResultado);

        }
        return charResultado;
    }

    public static int calcularClave(String nombreFicheroOriginal) throws Exception {

        int clave = 0;
        int[] cuentas = new int[abc.length() / 2];
        File f = new File(nombreFicheroOriginal);
        Scanner scFile = null;
        String linea = "";
        if (!f.exists()) {
            throw new FileNotFoundException();
        } else {
            try {

                scFile = new Scanner(f);
                while (scFile.hasNextLine()) {
                    linea = scFile.nextLine().toLowerCase();
                    for (int i = 0; i < linea.length(); i++) {
                        if (abc.indexOf(linea.charAt(i)) != -1) {
                            cuentas[abc.indexOf(linea.charAt(i))]++;
                        }
                    }
                }

            } catch (Exception e) {

                throw e;
            } finally {
                if (scFile != null) {
                    scFile.close();
                }

            }
            int mayor = cuentas[0];
            int posMayor = 0;
            for (int i = 0; i < cuentas.length; i++) {
                if (cuentas[i] > mayor) {
                    mayor = cuentas[i];
                    posMayor = i;
                }
            }
            clave = posMayor - 4;
        }
        return clave;
    }

}
