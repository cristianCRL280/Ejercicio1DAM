/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio03Maps;

import java.util.*;

/**
 *
 * @author dev
 */
public class Ejercicio03Maps {

    public static void main(String[] args) {
        Map<String, Integer> m;
        m = new HashMap<String, Integer>();
        m.put("a", 3);
        m.put("b", -3);
        m.put("c", -8);
        m.put("d", 6);
        m.put("e", 4);

        System.out.println(m);
        borrarNegativos(m);
        System.out.println(m);
    }

    public static void borrarNegativos(Map<String, Integer> m) {

        //recorrer el map y apuntarnos las claves que hay que borrrar en un list
        // recorrer ese list y hacer los borrados en el map
        ArrayList<String> keyBorrar = new ArrayList<String>();

        for (String key : m.keySet()) {

            if (m.get(key) < 0) {
                keyBorrar.add(key);
            }

        }
        for (String key : keyBorrar) {
            m.remove(key);
        }

    }
    public static void borrarNegativos2(HashMap<String, Integer>m){
        
        HashMap<String, Integer> hsTmp = new HashMap<String,Integer>();
        
        for (String key : m.keySet()) {
            
            if (m.get(key) >= 0) {
                
                hsTmp.put(key, m.get(key));
            }
        }
        
        m = hsTmp;
        
    }

}
