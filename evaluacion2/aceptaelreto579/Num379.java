/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aceptaelreto579;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Num379 {

    public static void main(String[] args) {

        (new Num379()).run();

    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        ArrayList<tareas> al = new ArrayList<tareas>();
        int numTareas;
        int PrioridadTarea;
        int DuracionTarea;
        
   

        while (true) {

            numTareas = sc.nextInt();

            if (numTareas == 0) {

                break;

            }
            for (int i = 0; i < numTareas; i++) {

                PrioridadTarea = sc.nextInt();
                DuracionTarea = sc.nextInt();

                al.add(new tareas(PrioridadTarea, DuracionTarea));
            }

            Collections.sort(al);

            for (tareas Tareas : al) {

                System.out.println(Tareas.PrioridadTarea + " " + Tareas.DuracionTarea);

              
            }
            
            System.out.println("---");
            al.clear();
           
        }

    }

    class tareas implements Comparable {

        int PrioridadTarea;
        int DuracionTarea;

        public tareas(int PrioridadTarea, int DuracionTarea) {
            this.PrioridadTarea = PrioridadTarea;
            this.DuracionTarea = DuracionTarea;
        }

        @Override
        public String toString() {
            return "tareas{" + "PrioridadTarea=" + PrioridadTarea + ", DuracionTarea=" + DuracionTarea + '}';
        }

        @Override
        public int compareTo(Object o) {

            tareas otro = (tareas) o;

            if (otro.PrioridadTarea != this.PrioridadTarea) {

                return otro.PrioridadTarea - this.PrioridadTarea;

            } else {

                return this.DuracionTarea - otro.DuracionTarea;

            }

        }

    }

}
