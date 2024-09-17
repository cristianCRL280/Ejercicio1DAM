/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrdenacionArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author dev
 */
public class Ordenacion2 {

    public static void main(String[] args) {
        ArrayList<Persona> al = new ArrayList<Persona>();
        al.add(new Persona("pepe", 29, 1.80d));
        al.add(new Persona("juan", 22, 1.81d));
        al.add(new Persona("antonio", 18, 1.78d));
        al.add(new Persona("miguel", 19, 1.79d));

        Comparator porAltura = new Comparator(){
            public int compare(Object o1, Object o2){
               Persona p1 = (Persona) o1;
               Persona p2 = (Persona) o2;
                Double p1Altura = p1.getAltura();
                Double p2Altura = p2.getAltura();
                return p1Altura.compareTo(p2Altura);
                
            }
            
        };
        
        
//        
//        Collections.sort(al);
        
Collections.sort(al, porAltura);

        for (Persona persona : al) {
            System.out.println(persona);
        }
        
        
    }
}
