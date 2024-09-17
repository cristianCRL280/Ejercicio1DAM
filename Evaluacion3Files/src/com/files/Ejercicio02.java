/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.files;

import java.io.File;

/**
 *
 * @author dev
 */
public class Ejercicio02 {
       public static void main(String[] args) {

        String nombre;

        if (args.length > 0) {
            nombre = args[0];
        } else {
            nombre = ".";
        }

        File f = new File(nombre);

        File[] arrayFiles = f.listFiles();
        for (int i = 0; i < arrayFiles.length; i++) {
            System.out.println("-----" + i + "-----");
            System.out.println(arrayFiles[i].getName());
            System.out.println(arrayFiles[i].getPath());
            System.out.println(arrayFiles[i].getAbsolutePath());
            System.out.println(arrayFiles[i].canWrite());
            System.out.println(arrayFiles[i].length());
            System.out.println(arrayFiles[i].isDirectory());
            System.out.println(arrayFiles[i].isFile());
            System.out.println(arrayFiles[i].getParent());

        }
    }
}
