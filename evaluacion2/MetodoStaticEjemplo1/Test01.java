/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetodoStaticEjemplo1;

/**
 *
 * @author dev
 */
public class Test01 {
    public static void main(String[] args) {
        Punto p1 = new Punto(4,6);
        Punto p3 = new Punto(4,6);
        Punto p4 = new Punto(4,6);
        Punto p5 = new Punto(4,6);
        
        System.out.println(p1);
        Punto3D p2 = new Punto3D(4,5,6);
        System.out.println("El numero del contador es: " + Punto.contador);
        System.out.println("Numero de millas en 5kms: " + UtilConversor.kmToMi(5));
        System.out.println("Numero de millas en 5kms: " + UtilConversor.miToKm(3));
        
        funci1();
        
        
    }
    public  static void funci1(){
        System.out.println("Estoy en funcionalidad");
        
    }
}
