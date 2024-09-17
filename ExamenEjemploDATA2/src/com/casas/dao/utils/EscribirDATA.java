/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.casas.dao.utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class EscribirDATA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreFile;
        String codigo, direccion, poblacion, provincia;
        File f;
        System.out.println("-----------------------");
        System.out.print("Nombre del fichero.data: ");
        nombreFile = sc.nextLine();
        System.out.println("-----------------------");
        f = new File(nombreFile);
        do {
            System.out.print("Codigo: ");
            codigo = sc.nextLine();
            if (!codigo.equalsIgnoreCase("FIN")) {
                System.out.print("Direccion: ");
                direccion = sc.nextLine();
                System.out.print("Poblacion: ");
                poblacion = sc.nextLine();
                System.out.print("Provincia: ");
                provincia = sc.nextLine();
                try (
                        FileOutputStream fos = new FileOutputStream(f, true); 
                        DataOutputStream dos = new DataOutputStream(fos);
                        ) {
                    dos.writeUTF(codigo);
                    dos.writeUTF(direccion);
                    dos.writeUTF(poblacion);
                    dos.writeUTF(provincia);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

        } while (!codigo.equalsIgnoreCase("FIN"));

    }
}
