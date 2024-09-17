/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExamenDawAceptaElReto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class CasaExec {
    public static void main(String[] args) {
        ArrayList<casas> al = new ArrayList<casas>();
        Scanner sc = new Scanner(System.in);
        String nombreCasa;
        int hrasSol;
        double precio,metros;
        
        do {
            System.out.println("Nombre de la casa: ");
            nombreCasa = sc.nextLine();
            if (!nombreCasa.equals("*")) {
                System.out.println("Precio: ");
                precio = Double.parseDouble(sc.nextLine());
                System.out.println("Metros: ");
                metros = Double.parseDouble(sc.nextLine());
                System.out.println("Horas de Sol: ");
                hrasSol = Integer.parseInt(sc.nextLine());
                casas c = new casas(nombreCasa, precio, metros, hrasSol);
                al.add(c);
            }
            
        } while (!nombreCasa.equals("*"));
        Collections.sort(al);
        
        System.out.println("Salida");
        for (casas object : al) {
            System.out.println(object);
        }
    }
}
