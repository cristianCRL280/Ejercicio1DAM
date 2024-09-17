/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio08Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Exec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> hs = new HashMap<String,Integer>();
        
        String nombreGata;
        
        System.out.println("Introduzca los nombres de la gata");
        
        do {
            
            nombreGata = sc.nextLine();
            
            if (!nombreGata.equalsIgnoreCase("FIN")) {
                
                addVoto(hs, nombreGata, 1);
                
            }
            
            
            
        } while (!nombreGata.equalsIgnoreCase("FIN"));
        
        System.out.println("SALIDA");
        
        for (Map.Entry<String, Integer> entry : hs.entrySet()) {
            Object key = entry.getKey();
            int val = entry.getValue();
            
            System.out.println(key + " -> " + val);
        }
        
        System.out.println("---------------------------");
        
        System.out.println("El ganado es: " + ganador(hs));
    }
    
    
    public static String ganador(HashMap<String, Integer> hs){
        String ganador  = "";
         int votosGanador = 0;
        
         for (Map.Entry<String, Integer> entry : hs.entrySet()) {
           String key = entry.getKey();
            int val = entry.getValue();
            
             if (votosGanador  < val ) {
                 
                 votosGanador = val;
                 ganador = key;
             } 
            
        }
        return ganador;
        
    }
    
    
    public static void addVoto(HashMap<String,Integer>hs, String key, int votos){
        
        if (hs.containsKey(key)) {
            
            int votosAnteriores = hs.get(key);
            hs.put(key, votos + votosAnteriores);
            
        } else {
            
            hs.put(key, votos);
            
        }
        
    }
}
