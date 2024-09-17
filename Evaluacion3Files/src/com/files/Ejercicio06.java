/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.files;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Ejercicio06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreFichero = "./test.data";
        File f = new File(nombreFichero);
        String sobreescribeS = "S";
        boolean sobreescribeB = true;

        if (f.exists()) {

            System.out.println("El fichero ya existe, quieres sobreescribirlo? S/N");
            sobreescribeS = sc.nextLine();
            if (sobreescribeS.equalsIgnoreCase("S")) {
                sobreescribeB = false;
            }
        }
        try (
                FileOutputStream fos = new FileOutputStream(f, sobreescribeB); 
                DataOutputStream dos = new DataOutputStream(fos);) 
        
        {
            ArrayList<Persona> al = listaPersonas(sc);
            for (Persona p : al) {
                dos.writeUTF(p.getCodigo());
                dos.writeUTF(p.getNombre());
                dos.writeUTF(p.getApellidos());
                dos.writeDouble(p.getSalario());
            }
        } catch (Exception e){
            
            System.out.println("Se ha producido un error");
            e.printStackTrace();
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
