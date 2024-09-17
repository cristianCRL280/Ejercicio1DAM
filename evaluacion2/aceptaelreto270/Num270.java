/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aceptaelreto270;

import java.util.*;

/**
 *
 * @author dev
 */
public class Num270 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TreeMap<String, TreeSet<Integer> hs;
        hs = new TreeMap<String, TreeSet<Integer>();
        int numCasos;
        String nombre = "", nota = "";
        do {
            numCasos = Integer.parseInt(sc.nextLine());
            if (numCasos != 0) {
                for (int i = 0; i < numCasos; i++) {
                    nombre = sc.nextLine();
                    nota = sc.nextLine();
                    if (hs.containsKey(nombre)) {
                        if (nota.equals("INCORRECTO")) {
                            hs.put(nombre, hs.get(nombre) - 1);
                        } else if (nota.equals("CORRECTO")) {
                            hs.put(nombre, hs.get(nombre) + 1);
                        }
                    } else {
                        if (nota.equals("INCORRECTO")) {
                            hs.put(nombre,  -1);
                        } else if (nota.equals("CORRECTO")) {
                            hs.put(nombre, 1);
                        }
                    }
                }
                for (Map.Entry<String, Integer> entry : hs.entrySet()) {
                    Object key = entry.getKey();
                    int val = entry.getValue();
                    if (val != 0) {
                        System.out.println(key + ", " + val);
                    }
                }
                System.out.println("---");
                hs.clear();
            }
        } while (numCasos != 0);
    }
}
