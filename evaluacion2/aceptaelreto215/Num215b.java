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
public class Num215b {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        int numCasos, numRespuestas;
        String nombreRey = "";
        do {
            hs.clear();
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

                numRespuestas = Integer.parseInt(sc.next());
                for (int i = 0; i < numRespuestas; i++) {
                    nombreRey = sc.next();
                    if (hs.containsKey(nombreRey)) {
                        hs.put(nombreRey, hs.get(nombreRey) + 1);
                    } else {
                        hs.put(nombreRey, 1);
                    }
                    System.out.println(hs.get(nombreRey));
                }

                System.out.println();
            }

        } while (numCasos != 0);
    }
}
