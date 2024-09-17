/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2.gui;

import com.examen2.implementations.CasaDAOimpl;
import com.examen2.pojo.Casa;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        fichero(sc);
    }

    public static void fichero(Scanner sc) throws Exception {
        String fichero;
        String volver;
        String identificador;
        String direccion;
        String poblacion;
        String provincia;
        do {
            System.out.print("Nombre del fichero .data:");
            fichero = sc.nextLine();
            System.out.println("Introduzca los filtros");
            System.out.print("identificador: ");
            identificador = sc.nextLine();
            System.out.print("direccion: ");
            direccion = sc.nextLine();
            System.out.print("poblacion: ");
            poblacion = sc.nextLine();
            System.out.print("provincia: ");
            provincia = sc.nextLine();
            llevarDatosToDATA(fichero, identificador, direccion, poblacion, provincia);
            System.out.println("Quieres volver a generar un fichero?");
            volver = sc.nextLine();
        } while (volver.equalsIgnoreCase("si"));
    }

    private static void llevarDatosToDATA(String fichero, String identificador, String direccion, String poblacion, String provincia) throws Exception {

        try (CasaDAOimpl casaDAOimpl = new CasaDAOimpl(); 
                FileOutputStream fos = new FileOutputStream(fichero); 
                DataOutputStream dos = new DataOutputStream(fos);) {

            List<Casa> casas = casaDAOimpl.getCasaByFilter(identificador, direccion, poblacion, provincia);
            for (Casa casa : casas) {
                dos.writeUTF(casa.getIdentificador());
                dos.writeUTF(casa.getDireccion());
                dos.writeUTF(casa.getPoblacion());
                dos.writeUTF(casa.getProvincia());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
