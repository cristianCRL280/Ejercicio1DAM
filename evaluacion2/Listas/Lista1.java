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
public class Lista1 {

    public static void main(String[] args) {
        List<String> l;

        //l = new LinkedList<String>();
        l = new ArrayList<String>();

        l.add("pepe");
        l.add("juan");
        l.add("antonio");
        l.add("sara");

        l.add(1, "maria");
        System.out.println(l);
        l.set(3, "ANTONIO");
        System.out.println("Posicion 3: " + l.get(3));

        l.remove("ANTONIO");
        System.out.println(l);
        
        l.remove(0);
        System.out.println(l);
        
        System.out.println("Tamaño: " + l.size());
        
        
       

        if (l.contains("juan")) {
            System.out.println("Juan está");
            
             System.out.println(l);
            
            
            
        }
        recorrerList(l);
        recorrerList2(l);
        ArrayList<Integer> al = new ArrayList<>(); //no se puede poner int o char no puede ser primitivo
    }
    
    public static void recorrerList(List<String> l){
        System.out.println("-----------------------------");
        for (int i = 0; i < l.size(); i++) {
            System.out.println("Posicion: " + i + "       valor " + l.get(i) );
            
        }
        
    }
    
    public static void recorrerList2(List<String> l){
        System.out.println("--------------------------------");
        
        for (String s : l) {
            System.out.println("Valor: " + s);
        }
    }
}
