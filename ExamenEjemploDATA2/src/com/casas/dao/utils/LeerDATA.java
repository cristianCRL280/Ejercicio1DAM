/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.casas.dao.utils;

import com.casas.dao.pojo.Casas;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class LeerDATA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Casas> al = new ArrayList<Casas>();
        Casas cs;
        String codigo, direccion, poblacion, provincia;
        String nombreFile;
        File f;
        System.out.println("--------------------");
        System.out.print("Nombre del fichero.data: ");
        nombreFile = sc.nextLine();
        System.out.println("--------------------");
        f = new File(nombreFile);
        if (f.exists()) {
            System.out.println("Leyendo fichero....");
        } else {
            System.out.println("No existe el fichero");
            System.exit(0);
        }

        try (
                FileInputStream fis = new FileInputStream(f); DataInputStream dis = new DataInputStream(fis);) {

            while (dis.available() > 0) {
                codigo = dis.readUTF();
                direccion = dis.readUTF();
                poblacion = dis.readUTF();
                provincia = dis.readUTF();
                cs = new Casas(codigo, direccion, poblacion, provincia);
                al.add(cs);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        for (Casas casas : al) {
            System.out.println(casas);
        }
    }
}
