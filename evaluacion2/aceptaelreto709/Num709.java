/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aceptaelreto709;

import java.util.*;


/**
 *
 * @author dev
 */
public class Num709 {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        int numCasos;
        String equipos, ganador;
        
        do {
            numCasos = sc.nextInt();
            if (numCasos != 0) {
                hs.clear();
                 for (int i = 0; i < numCasos; i++) {
                    equipos = sc.next();
                    if (hs.containsKey(equipos)) {
                        hs.put(equipos, hs.get(equipos) + 1);
                    } else {
                        hs.put(equipos, 1);
                    }
                }   
                  ganador = getGanador(hs);
                   System.out.println(ganador);
            }
        } while (numCasos != 0);
    }
    
    
    public static String getGanador(HashMap<String, Integer> hs) {
        int temp = 0;
        String ganador = "EMPATE";

        for (Map.Entry<String, Integer> entry : hs.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();

            if (val > temp) {
                ganador = key;
                temp = val;
            } else if (val == temp) {
                ganador = "EMPATE";
            }
        }

        return ganador;
    }
}
