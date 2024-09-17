/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aceptaelreto185;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author dev
 */
public class Num185v2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> siGustan = new TreeSet<String>();
        TreeSet<String> noGustan = new TreeSet<String>();
        String ingredientes = "";
        String[] ingredientesSeparados;
        int numLineas = 0;
        do {
            numLineas = Integer.parseInt(sc.nextLine());
            if (numLineas != 0) {
                for (int i = 0; i < numLineas; i++) {
                    ingredientes = sc.nextLine();
                    ingredientesSeparados = ingredientes.split(" ");
                    if (ingredientesSeparados[0].equals("SI:")) {
                        for (int j = 1; j < ingredientesSeparados.length - 1; j++) {
                            siGustan.add(ingredientesSeparados[j]);
                        }
                    } else if (ingredientesSeparados[0].equals("NO:")) {
                        for (int j = 1; j < ingredientesSeparados.length - 1; j++) {
                            noGustan.add(ingredientesSeparados[j]);
                        }
                    }
                }
                String salida = "";
                for (String ingrediente : noGustan) {
                    if (!siGustan.contains(ingrediente)) {
                        salida += ingrediente + " ";
                    }
                }
                System.out.println(salida.trim());
                siGustan.clear();
                noGustan.clear();
            }
        } while (numLineas != 0);
    }

}
