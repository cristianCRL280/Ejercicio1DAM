/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristian.gui;

import com.cristian.implementations.JugadorDAOimpl;
import com.cristian.pojo.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el codigo ");
        String codigo = sc.nextLine();

        System.out.println("Dime el nombre ");
        String nombre = sc.nextLine();
        System.out.println("Dime la procedencia ");
        String procedencia = sc.nextLine();
        System.out.println("Dime la altura ");
        String altura = sc.nextLine();
        System.out.println("Dime el peso ");
        String peso = sc.nextLine();
        System.out.println("Dime la posicion ");
        String posicion = sc.nextLine();
        System.out.println("Dime el equipo");
        String Nombre_equipo = sc.nextLine();

        try (JugadorDAOimpl jug = new JugadorDAOimpl();) {
            ArrayList<Jugador> al = (ArrayList) jug.getJugadorByFilter(
                    codigo,
                    nombre,
                    procedencia,
                    altura,
                    peso,
                    posicion,
                    Nombre_equipo);
            for (Jugador jugador : al) {
                System.out.println(jugador);
            }
        } catch (Exception e) {
            System.out.println("se ha producido un error");
            e.printStackTrace();
        }
        sc.close();
    }
}
