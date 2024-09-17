/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class CrearFichero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        String nombreFile = "";
        String datosString;
        int datoInt;
        if (args.length == 1) {
            nombreFile = args[0];
        } else {
            nombreFile = "./numbers.dat";
        }
        try (FileOutputStream fos = new FileOutputStream(nombreFile); DataOutputStream dos = new DataOutputStream(fos);) {
            do {
                System.out.println("Introduzca un numero (* para terminar)");
                datosString = sc.nextLine();
                if (!datosString.equals("*")) {
                    datoInt = Integer.parseInt(datosString);
                    dos.writeInt(datoInt);
                }
            } while (!datosString.equals("*"));
        } catch (Exception e) {
            System.out.println("Ha ocurrido un problema");
        }
    }
}
