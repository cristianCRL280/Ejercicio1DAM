/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aceptaelreto215;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Num215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        int numCasos;
        String nombreRey = " ";
        do {
            numCasos = Integer.parseInt(sc.next());
            if (numCasos != 0) {
                for (int i = 0; i < numCasos; i++) {
                    nombreRey = sc.next();
                    if (hs.containsKey(nombreRey)) {
                        hs.put(nombreRey, hs.get(nombreRey) + 1);
                    } else {
                        hs.put(nombreRey, 1);
                    } 
                }
            }            
        } while (numCasos != 0);      
         for (Map.Entry<String, Integer> entry : hs.entrySet()) {
              int val = entry.getValue();
               System.out.println(val);
            }
          System.out.println();
    }
}
