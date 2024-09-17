/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.files;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public class Ejemplo09DATA {

    public static void main(String[] args) {
        ArrayList<Persona> al = new ArrayList<>();

        String codigo;
        String nombre;
        String apellidos;
        double salario;
        Persona p;
        try (
                FileInputStream fis = new FileInputStream("./ejemploDataEj6.data"); 
                DataInputStream dis = new DataInputStream(fis);) {
            while (dis.available() > 0) {
                codigo = dis.readUTF();
                nombre = dis.readUTF();
                apellidos = dis.readUTF();
                salario = dis.readDouble();
                p = new Persona(codigo, nombre, apellidos, salario);
                al.add(p);

            }

        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        }
        for (Persona persona : al) {
            System.out.println(persona);
        }
    }
}
