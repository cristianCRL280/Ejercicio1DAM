/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioAceptaElRetoExamen;

import java.util.*;

import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Ejercicio01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> hs = new TreeMap<String, Integer>();
        String nombreCandidato;
        String clase;
        int votos;
        do {
            System.out.print("Identificador de clase: ");
            clase = sc.nextLine();
            if (!clase.equals("FIN")) {
                do {
                    System.out.print("Nombre candidato: ");
                    nombreCandidato = sc.nextLine();
                    if (!nombreCandidato.equals("FIN")) {
                        System.out.print("Numero de votos: ");
                        votos = Integer.parseInt(sc.nextLine());
                        addVoto(hs, nombreCandidato, votos);
                    }
                } while (!nombreCandidato.equals("FIN"));
            }
        } while (!clase.equals("FIN"));
        System.out.println("-------------------");
        System.out.println("SALIDA");
        for (Map.Entry<String, Integer> entry : hs.entrySet()) {
            Object key = entry.getKey();
            int val = entry.getValue();
            System.out.println(key + " " + val + " votos");
        }
    }



    public static void addVoto(TreeMap<String, Integer> hs, String key, int votos) {
        if (hs.containsKey(key)) {
            int votosAnteriores = hs.get(key);
            hs.put(key, votos + votosAnteriores);
        } else {
            hs.put(key, votos);
        }

    }

}
