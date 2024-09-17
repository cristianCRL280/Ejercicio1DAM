/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.files;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Ejercicio05 {

    public static void main(String[] args) {
        String nombre;
        String[] linea;
        if (args.length == 0) {
            nombre = "./test.csv";
        } else {
            nombre = args[0]; 
        }
        File f = new File(nombre);
        if (!f.exists()) {
            System.out.println("El fichero no existe");
        } else {
            Scanner scFile = null;
            try {
                scFile = new Scanner(f);
                while (scFile.hasNextLine()) {

                    linea = scFile.nextLine().split(",");

                    for (String campo : linea) {
                        System.out.println(campo + "\t");
                    }
                    System.out.println("");
                }

            } catch (Exception e) {
                System.out.println("Se ha producido un error");
                e.printStackTrace();

            } finally {
                if (scFile != null) {
                    scFile.close();
                }
            }

        }
    }
}
