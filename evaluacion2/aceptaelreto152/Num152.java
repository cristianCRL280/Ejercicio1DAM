/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aceptaelreto152;

import java.util.*;

/**
 *
 * @author dev
 */
public class Num152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        int numCasos;
        int numeros;
        do {
            numCasos = sc.nextInt();
            if (numCasos != 0) {
                hs.clear();
                for (int i = 0; i < numCasos; i++) {
                    numeros = sc.nextInt();
                    if (hs.containsKey(numeros)) {
                        hs.put(numeros, hs.get(numeros) + 1);
                    } else {
                        hs.put(numeros, 1);
                    }
                }
                System.out.println(ganador(hs));
            }
        } while (numCasos != 0);
    }
    public static int ganador(HashMap<Integer, Integer> hs) {
        int ganador = 0;
        int votosGanador = 0;
        for (Map.Entry<Integer, Integer> entry : hs.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (votosGanador < val) {
                votosGanador = val;
                ganador = key;
            }
        }
        return ganador;
    }
}
