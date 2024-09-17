/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aceptaelreto416;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author dev
 */
public class Num416 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> fechasSet = new TreeSet<String>();
        int numCasos;
        String fechas, diaMes;
        String[] fechasSeparadas, diaMesAnyo;
        boolean cumple;
        do {
            numCasos = Integer.parseInt(sc.nextLine());
            if (numCasos != 0) {
                cumple = false;
                fechas = sc.nextLine();
                fechasSeparadas = fechas.split(" ");
                for (int i = 0; i < fechasSeparadas.length; i++) {
                    diaMesAnyo = fechasSeparadas[i].split("/");
                    diaMes = diaMesAnyo[0] + "/" + diaMesAnyo[1];
                    if (fechasSet.contains(diaMes)) {
                        cumple = true;
                        break;
                    } else {
                        fechasSet.add(diaMes);
                    }
                }
                if (cumple == true) {
                    System.out.println("SI");
                } else {
                    System.out.println("NO");
                }
                fechasSet.clear();
            }
        } while (numCasos != 0);
    }
}
