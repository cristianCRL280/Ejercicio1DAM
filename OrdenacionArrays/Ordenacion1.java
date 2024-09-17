/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrdenacionArrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author dev
 */
public class Ordenacion1 {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("2");
        al.add("6");
        al.add("4");
        al.add("8");
        al.add("1");
        al.add("9");
        al.add("-1");
        Collections.sort(al);
        for (String a : al) {
            
            System.out.println(a);
            
        }

    }
}
