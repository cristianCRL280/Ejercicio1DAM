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
public class Lista3 {

    public static void main(String[] args) {
        Map<String, Integer> ciudades;
        //ciudades = new HashMap<String, Integer>(); //desordenado
        // ciudades = new LinkedHashMap<String, Integer>(); // en el orden de insercion
        ciudades = new TreeMap<String, Integer>(); // ordenado por la clave
        ciudades.put("Madrid", 3300000);
        ciudades.put("Barcelona", 1600000);
        ciudades.put("Zaragoza", 725000);
        ciudades.put("Zaragoza", 750000);
        ciudades.put("no Existe", 10000);
        System.out.println(ciudades);
        System.out.println("Numero de habitantes de madrid: " + ciudades.get("Madrid"));
        ciudades.remove("no Existe");
        System.out.println(ciudades);
        if (ciudades.containsKey("Madrid")) {
            System.out.println("Madrid esta entre las ciudades guardadas" + ciudades.get("Madrid") + "habitantes");
        } else {
            System.out.println("No está");
        }
        sumaHabitantes(ciudades, "Zaragoza", 20000);
        System.out.println("Habitantes de zaragoza: " + ciudades.get("Zaragoza"));

        recorrer1(ciudades);
        recorrer2(ciudades);
        recorrer3(ciudades);
        Map<String, TreeSet<String>> barrios = new TreeMap<>();
        barrios.put("Madrid", new TreeSet<String>());
        barrios.get("Madrid").add("Villaverde");
        barrios.get("Madrid").add("Vallecas");
        barrios.get("Madrid").add("aluche");
        System.out.println(barrios);
    }
    public static void recorrer3(Map<String, Integer> c) {
        System.out.println("-----------------------");
        for (Integer value : c.values()) {

            System.out.println("Habitantes: " + value);

        }

    }

    public static void recorrer2(Map<String, Integer> c) {
        System.out.println("-------------------------------");
        for (String key : c.keySet()) {

            System.out.println("Ciudad: " + key + "--- habitantes: " + c.get(key));
        }

    }

    public static void recorrer1(Map<String, Integer> c) {
        for (Map.Entry<String, Integer> entry : c.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            System.out.println("Ciudad: " + key + "--- habitantes" + val);

        }

    }

    public static void sumaHabitantes(Map<String, Integer> c, String ciudad, int suma) {

        c.put(ciudad, suma + c.get(ciudad));

    }

}
