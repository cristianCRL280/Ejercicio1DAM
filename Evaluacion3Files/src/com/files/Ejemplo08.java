/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Ejemplo08 {

   public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File f = new File("./datosEj8.obj");
        String sobreescribe = "S";
        if (f.exists()) {
            System.out.println("El fichero ya existe, ¿quiere sobreescribirlo (S/N)?");
            sobreescribe = sc.nextLine();
        }
        ArrayList<Persona> al = listarPersonas(sc);

        if (sobreescribe.equals("S")) {
            try (FileOutputStream fos = new FileOutputStream(f, false); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
                for (Persona persona : al) {
                    oos.writeObject(persona);
                }
            } catch (Exception e) {
                System.out.println("Se ha producido un error");
                e.printStackTrace();
            }

        } else {
            try (FileOutputStream fos = new FileOutputStream(f, true); ObjectOutputStream oos = new MiObjectOutputStream(fos);) {
                for (Persona persona : al) {
                    oos.writeObject(persona);
                }
            } catch (Exception e) {
                System.out.println("Se ha producido un error");
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Persona> listarPersonas(Scanner sc) {
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
                System.out.println("Apellido: ");
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
