/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import java.util.*;

/**
 *
 * @author dev
 */
public class Lista2 {

    public static void main(String[] args) {

        Set<String> s;

        //s = new HashSet<String>();
        s = new TreeSet<String>();
        s.add("pepe");
        s.add("juan");
        s.add("sara");
        s.add("pepe");
        s.add("juan");
        System.out.println(s);
        if (s.contains("pepe"))  System.out.println("Pepe está");
        s.remove("pepe");
        System.out.println(s);
        System.out.println("Longitud: " + s.size());

        for (String nombre : s) {
            System.out.println("Nombre: " + nombre);
        }
        
        s.clear();
    }
}
