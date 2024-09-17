/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aceptaelreto291;

import java.util.*;

public class Num291 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineas;
        String[] palabras;
        TreeMap<String, TreeSet<Integer>> cruzadas;
        do {
            lineas = Integer.parseInt(sc.nextLine());
            if (lineas != 0) {
              
                cruzadas = new TreeMap<>();
                for (int i = 1; i <= lineas; i++) {
                    palabras = sc.nextLine().split(" ");
                    for (int j = 0; j < palabras.length; j++) {
                        if (palabras[j].length() > 2) {
                            if (!cruzadas.containsKey(palabras[j])) {
                                cruzadas.put(palabras[j], new TreeSet<Integer>());
                            } else {
                                TreeSet<Integer> aux = cruzadas.get(palabras[j]);
                                aux.add(i);
                                cruzadas.put(palabras[j], aux);
                            }
                        }
                    }
                }
                for (Map.Entry<String, TreeSet<Integer>> entry : cruzadas.entrySet()) {
                    System.out.print(entry.getKey());
                    for (Integer n : entry.getValue()) {
                        System.out.print(" " + n);
                    }
                    System.out.println();
                }
                System.out.println("----");
            }
        } while (lineas != 0);
    }
}
