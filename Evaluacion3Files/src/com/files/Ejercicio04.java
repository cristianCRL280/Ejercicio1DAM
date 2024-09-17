/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.files;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FileWriter fw = null;
        File f = new File("./test.csv");
        String sobreescribe = "S";
        if (f.exists()) {
            System.out.println("El fichero ya existe, quiere sobreescribirlo(S/N)?");
            sobreescribe = sc.nextLine();
        }
        try {

            if (sobreescribe.equals("S")) {
                fw = new FileWriter(f);
            } else {

                fw = new FileWriter(f, true);
            }
            ArrayList<Persona> al = listaPersonas(sc);
            for (Persona p : al) {
                fw.write(p.getCodigo() + "," + p.getNombre() + "," + p.getApellidos() + "," + p.getSalario() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar");
                }
            }
        }
    }

    public static ArrayList<Persona> listaPersonas(Scanner sc) {
        ArrayList<Persona> al = new ArrayList<Persona>();
        String codigo;
        String nombre;
        String apellidos;
        double salario;
        Persona p;
        do {
            System.out.println("Codigo: ");
            codigo = sc.nextLine();
            if (!codigo.equalsIgnoreCase("FIN")) {
                System.out.println("Nombre: ");
                nombre = sc.nextLine();
                System.out.println("Apellidos: ");
                apellidos = sc.nextLine();
                System.out.println("Salario: ");
                salario = Double.parseDouble(sc.nextLine());
                p = new Persona(codigo, nombre, apellidos, salario);
                al.add(p);
            }

        } while (!codigo.equalsIgnoreCase("FIN"));
        return al;
    }
}
