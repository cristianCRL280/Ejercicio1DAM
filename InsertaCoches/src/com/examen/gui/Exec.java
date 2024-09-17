/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.gui;

import com.examen.implementations.RestoCocheDAOimpl;
import com.examen.implementations.RojoCocheDAOimpl;
import com.examen.implementations.VerdeCocheDAOimpl;
import com.examen.pojo.Coche;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String matricula;
        String marca;
        String modelo;
        String color;
        String volver;
       
        do {

            System.out.print("Matricula: ");
            matricula = sc.nextLine();
            System.out.print("Marca: ");
            marca = sc.nextLine();
            System.out.print("Modelo: ");
            modelo = sc.nextLine();
            System.out.print("Color: ");
            color = sc.nextLine();
            Coche coches = new Coche(matricula, marca, modelo, color);
            try (RestoCocheDAOimpl c = new RestoCocheDAOimpl(); 
                    RojoCocheDAOimpl r = new RojoCocheDAOimpl(); 
                    VerdeCocheDAOimpl v = new VerdeCocheDAOimpl()) {

                if (coches.getColor().equals("verde")) {

                    v.insertarCochesVerdes(coches);

                } else if (color.equals("rojo")) {

                    r.insertarCochesRojos(coches);
                } else if (!color.equals("verde") && !color.equals("rojo")) {
                    c.insertarRestoCoches(coches);
                }

            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
            System.out.println("Quieres volver a generar un coche?");
            volver = sc.nextLine();

        } while (volver.equals("si"));

    }

}
