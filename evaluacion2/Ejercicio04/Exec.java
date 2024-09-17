/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04;

/**
 *
 * @author dev
 */
public class Exec {
    public static void main(String[] args) {
 //       Personaje p = new Personaje("a", "pepe", 10,10 ); no se puede instanciar al ser una clase abstracta
 Personaje[] clan = new Personaje[2];
 clan[0] = new Mago("gris", 12.2d, "m01", "merlin", 10,0);
 clan[1] = new Elfo(3, 13.3d, "c01", "legolas", 10, 0);
 
        for (Personaje personaje : clan) {
            personaje.pocimaSanadora();
            
        }

        for (Personaje personaje : clan) {
            
            
            System.out.println(personaje);
        }
        
        
        
        
    }
}
