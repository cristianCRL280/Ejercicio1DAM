/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.casas.dao.ui;

import com.casas.dao.implementations.CasaOrigenDAOimpl;
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
public class ExecUI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion, nombreFichero;
        int numeroModify = 0;
        ArrayList<Casas> cs = new ArrayList<Casas>();
        do {
            opcion = menu(sc);
            if (!opcion.equalsIgnoreCase("s")) {
                if (opcion.equals("1")) {
                    try (CasaOrigenDAOimpl cdi = new CasaOrigenDAOimpl();) {

                        cdi.borrarDatos();
                    } catch (Exception ex) {
                        System.out.println("Error al borrar los datos" + ex.getMessage());
                    }
                } else if (opcion.equals("2")) {
                    System.out.println("-------------------------------------------------");
                    System.out.print("Nombre del fichero DATA: ");
                    nombreFichero = sc.nextLine();
                    System.out.println("-----------CONTENIDO-DEL-FICHERO-DATA-------------");
                    try (CasaOrigenDAOimpl cdi = new CasaOrigenDAOimpl();) {

                        cs = cargarDatos(sc, nombreFichero);
                        numeroModify = cdi.insertarDatos(cs);
                        for (Casas c : cs) {
                            System.out.println(c);
                        }
                    } catch (Exception ex) {
                        System.out.println("Error" + ex.getMessage());
                        ex.printStackTrace();
                    }
                } else if (opcion.equals("3")) {
                    System.out.println("-------------------------------------------------");
                    System.out.println("Numero de inserciones -> " + numeroModify);
                }
            }
        } while (!opcion.equalsIgnoreCase("s"));
    }

    public static String menu(Scanner sc) {
        String opcion;
        System.out.println("------------------MENU------------------------");
        System.out.println("1- Borrar Datos de la base");
        System.out.println("2- Insertar datos a la base");
        System.out.println("3- Mostrar numero de registros insertados");
        System.out.println("S- Salir");
        System.out.println("----------------------------------------------");
        System.out.print("Elija una opcion---> ");
        opcion = sc.nextLine();
        return opcion;
    }

    public static ArrayList<Casas> cargarDatos(Scanner sc, String nombreFichero) throws Exception {
        ArrayList<Casas> al = new ArrayList<Casas>();
        File file = new File(nombreFichero);
        Casas cs;
        String codigo, direccion, poblacion, provincia;
        try (
                FileInputStream fis = new FileInputStream(file); DataInputStream dis = new DataInputStream(fis);) {

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

        return al;
    }
}
