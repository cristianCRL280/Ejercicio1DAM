/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aceptaelreto366.niños;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Num366 {

    public static void main(String[] args) {

        (new Num366()).run();

    }

    public void run() {

        Scanner sc = new Scanner(System.in);

        ArrayList<Ninyo> al = new ArrayList<Ninyo>();
        int numNinyos;
        int bueno = 0;
        int pesoRegalos = 0;
       

        while (true) {

            numNinyos = sc.nextInt();

            if (numNinyos == 0) {
                break;
            }

            
            for (int i = 0; i < numNinyos; i++) {

                bueno = sc.nextInt();
                pesoRegalos = sc.nextInt();

                al.add(new Ninyo(bueno, pesoRegalos));
            }
            Collections.sort(al);

            for (Ninyo ninyo : al) {

                System.out.println(ninyo);

            }

            al.clear();
            System.out.println();

        }

    }

    class Ninyo implements Comparable {

        int bueno;
        int pesoRegalos;

        public Ninyo(int bueno, int pesoRegalos) {
            this.bueno = bueno;
            this.pesoRegalos = pesoRegalos;
        }

        @Override
        public String toString() {
            return bueno + " " + pesoRegalos;
        }
//metodo para ordenar primero cogiendo un tipo de dato y si es empate por otro

        @Override
        public int compareTo(Object o) {
            Ninyo otro = (Ninyo) o;

            if (otro.bueno != this.bueno) {

                return otro.bueno - this.bueno;

            } else {

                return this.pesoRegalos - otro.pesoRegalos;

            }

        }

    }
}
