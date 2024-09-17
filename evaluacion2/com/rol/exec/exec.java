/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rol.exec;

import com.exceptions.TooLowNumberException;
import com.rol.personajes.Clan;
import com.rol.personajes.Elfo;
import com.rol.personajes.Mago;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author dev
 */
public class exec {

    public static void main(String[] args) throws TooLowNumberException {

        Clan c1 = new Clan("c1", "buenos");
        Clan c2 = new Clan("c2", "malos");

        try {
            Mago m0 = new Mago("roja", 2.5d, "R2D2", "Pepe", 120, 100);
            c1.addPersonaje(m0);
        } catch (TooLowNumberException e) {
            System.out.println(e.getMessage());
        }
        try {
            Elfo e1 = new Elfo(5, 2.18d, "R3D3", "Juan", 120, 100);
            c1.addPersonaje(e1);
        } catch (TooLowNumberException e) {
            System.out.println(e.getMessage());
        }
        try {
            Mago m2 = new Mago("verde", 13.8d, "R4D4", "Pepa", 121, 101);
            c1.addPersonaje(m2);
        } catch (TooLowNumberException e) {
            System.out.println(e.getMessage());
        }
        try {
            Elfo e2 = new Elfo(6, 3.18d, "R5D5", "Juana", 121, 101);
            c2.addPersonaje(e2);
        } catch (TooLowNumberException e) {
            System.out.println(e.getMessage());
        }
        try {
            Mago m3 = new Mago("blanco", 14.8d, "R2D2", "ana", 125, 100);
            c2.addPersonaje(m3);
        } catch (TooLowNumberException e) {
            System.out.println(e.getMessage());
        }
        try {
            Elfo e3 = new Elfo(8, 2.18d, "R3D3", "pedro", 125, 80);
            c2.addPersonaje(e3);
        } catch (TooLowNumberException e) {
            System.out.println(e.getMessage());
        }
        try {
            Mago m4 = new Mago("gris", 15.8d, "R7D7", "Pepo", 15, 1);
            c1.addPersonaje(m4);
        } catch (TooLowNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            Elfo e4 = new Elfo(1, 4.18d, "R6D6", "Juano", 110, 75);
            c2.addPersonaje(e4);
        } catch (TooLowNumberException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Clan> cl = new ArrayList<Clan>(); // con arrayList
        //      HashMap<String, Clan> cl = new HashMap<String, Clan>();
        cl.add(c1);
        cl.add(c2);

        listar(cl);

        darPocimaSanadoraTogaGris(cl);

        try{
            cambiarColorToga(cl);
        }catch(TooLowNumberException e){
            System.out.println("esto está mal");
        }
        listar(cl);

        mostrarPuntosVidaMedioElfos(cl);

        mostrarPuntosVidaMediosPorTipo(cl);

        mostrarMagoVaritaMasLarga(cl);

        herirTodos20(cl);

        listar(cl);
        borrarElfosOrejas20(cl);
        listar(cl);
    }
    //para que sea arraylist tiene que quitarse el values y el hashmap de .los metodos

    public static void borrarElfosOrejas20(ArrayList<Clan> cl) {

        for (Clan c : cl) {

            c.borarElfosByLargOrejas(20);
        }

    }

    public static void herirTodos20(ArrayList<Clan> cl) {

        for (Clan c : cl) {

            c.herir(20);
        }

    }

    public static void mostrarMagoVaritaMasLarga(ArrayList<Clan> cl) {

        ArrayList<Mago> ms = new ArrayList<Mago>();

        for (Clan c : cl) {

            ms.add(c.getBestMago());
        }
        Mago best = Collections.max(ms);
        System.out.println("El mago con la varita mas larga es " + best.toString());
    }

    public static void mostrarPuntosVidaMediosPorTipo(ArrayList<Clan> cl) {

        int numElfosTotal = 0;
        int numMagosTotal = 0;
        int vidaElfosTotal = 0;
        int vidaMagosTotal = 0;
        double mediaElfos = 0;
        double mediaMagos = 0;

        for (Clan c : cl) {
            numElfosTotal += c.getNumPersonajesByTipo("Elfo");

            vidaElfosTotal += c.getSumaPuntosVidaByTipo("Elfo");
            numMagosTotal += c.getNumPersonajesByTipo("Mago");
            vidaMagosTotal += c.getSumaPuntosVidaByTipo("Mago");

        }
        mediaElfos = 1.0d * vidaElfosTotal / numElfosTotal;
        mediaMagos = 1.0d * vidaMagosTotal / numMagosTotal;

        System.out.println("-------------------------------");
        System.out.println("Vida media de los elfos de todos los clanes: " + mediaElfos);
        System.out.println("Vida media de los magos de todos los clanes: " + mediaMagos);

    }
//para que sea arraylist tiene que quitarse el values y el hashmap 

    public static void mostrarPuntosVidaMedioElfos(ArrayList<Clan> cl) {

        System.out.println("-------------------");

        double media;
        for (Clan c : cl) {

            System.out.println("Clan: " + c.getNombre());
            media = 1.0d * c.getSumaPuntosVidaByTipo("Elfo") / c.getNumPersonajesByTipo("Elfo");
            System.out.println("Elfos " + media);
        }
    }

    public static void cambiarColorToga(ArrayList<Clan> cl) throws TooLowNumberException {

        for (Clan c : cl) {

            c.cambiarColorTogaMagos("verde", "blanco");
        }

    }

    public static void darPocimaSanadoraTogaGris(ArrayList<Clan> cl) {

        for (Clan c : cl) {

            c.pocimaSanadoraMagos("gris");

        }

    }

    public static void listar(ArrayList<Clan> cl) {

        System.out.println("--------------------------");

        for (Clan c : cl) {
            System.out.println(c);
        }

    }

}
