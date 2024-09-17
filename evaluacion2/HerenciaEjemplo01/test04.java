/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerenciaEjemplo01;

import java.util.Scanner;

/**
 *
 * @author dev
 */
public class test04 {
    public static void main(String[] args) {
        Gato g = new Gato();
        g.setNombre("Pepe");
        tratarGato(g);
        System.out.println(g);
    }
    
    
    public static void tratarGato(Gato gatete){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un nuombre para el gato: ");
        String nuevoNombre = sc.nextLine();
        Gato g2 = new Gato();
        g2.setNombre(nuevoNombre);
        gatete = g2;
        
    }
    
}
