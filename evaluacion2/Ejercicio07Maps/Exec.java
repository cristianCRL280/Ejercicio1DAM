/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio07Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Coche> al = new ArrayList<Coche>();

        String marca;
        String modelo;
        int anyoFabricacion;
        double LitrosRepostados;
        double kmRecorridos;

        do {
            System.out.println("Introduzca los datos del coche");
            System.out.println("Marca");
            marca = sc.nextLine();

            if (!marca.equalsIgnoreCase("FIN")) {

                System.out.println("Modelo: ");
                modelo = sc.nextLine();
                System.out.println("Año de fabricacion: ");
                anyoFabricacion = Integer.parseInt(sc.nextLine());
                System.out.println("Litros repostados: ");
                LitrosRepostados = Double.parseDouble(sc.nextLine());
                System.out.println("Kilpometros recorridos: ");
                kmRecorridos = Double.parseDouble(sc.nextLine());

                Coche c = new Coche(marca, modelo, anyoFabricacion, LitrosRepostados, kmRecorridos);
                al.add(c);
            }

        } while (!marca.equalsIgnoreCase("FIN"));
        
        Collections.sort(al);
        
        for (Coche coche : al) {
            
            System.out.println(coche);
            
        }
    }
}
