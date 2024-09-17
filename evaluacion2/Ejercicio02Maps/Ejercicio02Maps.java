/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02Maps;

//Aquí os dejo el enunciado:
//Genera un List de Integer y rellénalo con valores positivos y negativos. 
//Posteriormente recorre el ArrayList y borra los valores negativos,
//y finalmente muestra por pantalla el contenido del ArrayList.
//(prueba con varias alternativas,
//incluyendo una que tenga todo número positivos,
//y otra que tenga todo número negativos)
import java.util.*;

/**
 *
 * @author dev
 */
public class Ejercicio02Maps {
    public static void main(String[] args) {
        
       ArrayList<Integer> al = new ArrayList<Integer>(); //crear una lista n ueva
       al.add(2);
       al.add(3);
       al.add(-1);
       al.add(3);
       al.add(-2);
       
        System.out.println(al);
        borrarNegativos(al);
        System.out.println(al);
    }
    
    public static void borrarNegativos(ArrayList<Integer> al){
        
        for (int i = 0; i < al.size(); i++) {
            
            if (al.get(i) < 0) {
                al.remove(i);
                i--;
            }
            
        }
        
        
    }
    
    
    
}
