/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.files;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Ejercicio03TXT {
    
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File f = new File("./ejemploTexto.txt");
        String linea;

        try (FileWriter fw = new FileWriter(f,true)) {
            //fw = new FileWriter(f);
            System.out.println("Escriba texto para llevarlo al fichero ( * para terminar)");
            do {
                linea = sc.nextLine();
                if (!linea.equals("*")) {
                    fw.write(linea + "\n");
                }
            } while (!linea.equals("*"));
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        } 
    }
    
}
