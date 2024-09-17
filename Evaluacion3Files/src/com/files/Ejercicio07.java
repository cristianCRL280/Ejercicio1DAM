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
public class Ejercicio07 {
    public static void main(String[] args) {
        Persona p;
        ArrayList<Persona> al = new ArrayList<Persona>();
        try( FileInputStream fis = new FileInputStream(":/test.data");
                DataInputStream dis = new DataInputStream(fis);){
            while( dis.available()> 0){
                
                String codigo = dis.readUTF();
                String nombre = dis.readUTF();
                String apellidos = dis.readUTF();
                double salario = dis.readDouble();
                p = new Persona(codigo, nombre, apellidos, salario);
                al.add(p);
            }
            mostrarPersonas(al);
            
        }catch(Exception e){
            System.out.println("Se ha producido un error");
            e.printStackTrace();
        }
    }
    public static void mostrarPersonas(ArrayList<Persona> al){
        
        for (Persona persona : al) {
            System.out.println(persona);
        }
        
        
    }
}
