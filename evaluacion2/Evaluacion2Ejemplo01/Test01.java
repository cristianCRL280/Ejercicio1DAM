package Evaluacion2Ejemplo01;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dev
 */
public class Test01 {
    public static void main(String[] args) {
        Persona p1;
        Persona p2;
        
        p1 = new Persona("Pepe","Perez",55.4d,165,100,90,80,75);
//        
//        p1.nombre = "Pepe";
//        p1.apellidos = "Perez";
//        p1.peso = 55.4d;
//        p1.altura = 165;
//        p1.energia = 100;
//        p1.tiroLibre = 90;
//        p1.manejo = 80;
//        p1.tiroTriple = 75;
//        
        
        
        
        
        System.out.println("La persona p1 se llama " + p1.getNombre());
        p1.dormir(3);
        p1.andar(2);
        p1.correr(5);
    System.out.println("La persona p1 se llama " + p1.getEnergia());
    
    
        if (p1.getTiroTriple() > 60) {
            
            System.out.println("Metió el triple!!!!");
            System.out.println("Tiene  " + p1.getTiroTriple() + "de tiro triple");
        } else {
            
            System.out.println("Es un paquete");
              System.out.println("Tiene  " + p1.getTiroTriple() + "de tiro triple");
        }
        
       
     
        
    
    Persona[] pArray = new Persona[2];
    pArray[0] = new Persona();
    pArray[0].setNombre("Juan");
    pArray[0].dormir(2);
    pArray[1] = new Persona();
        
        

        
    }
}
