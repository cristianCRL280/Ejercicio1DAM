/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parquemovil.exec;

import com.parquemovil.excepciones.*;
import com.parquemovil.vehiculos.*;
import java.util.*;

/**
 *
 * @author dev
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        Map<String, Vehiculo> v = new HashMap<>();

        try {
            Coche c1 = new Coche("rojo", "01", "Seat", "Ibiza", 200.3);
            v.put(c1.getCodigo(), c1);
        } catch (InvalidColor e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Coche c4 = new Coche("rojo", "07", "Seat", "Cordoba", 600.9);
            v.put(c4.getCodigo(), c4);
        } catch (InvalidColor e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Coche c2 = new Coche("negro", "02", "Seat", "Panda", 432.5);
            v.put(c2.getCodigo(), c2);
        } catch (InvalidColor e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Coche c3 = new Coche("azul", "03", "Chevrolet", "Camaro", 432.5);
            v.put(c3.getCodigo(), c3);
        } catch (InvalidColor e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Tractor t1 = new Tractor(300, "04", "Iveco", "Daily", 553.3);
            v.put(t1.getCodigo(), t1);
        } catch (kgCargaMaxInvalida e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Tractor t2 = new Tractor(1000, "05", "Mercedes", "Gama Actros", 100);
            v.put(t2.getCodigo(), t2);
        } catch (kgCargaMaxInvalida e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Tractor t3 = new Tractor(5300, "06", "Volvo", "Gama FH", 553.3);
            v.put(t3.getCodigo(), t3);
        } catch (kgCargaMaxInvalida e) {
            System.out.println("Error: " + e.getMessage());
        }

        listar(v);
        repostarTractoresKgMaxSuperior750(v);
        mediaKmAutonomiaCocheByColor(v);
        borrarCochesBlancos(v);
        listar(v);
    }

    public static void listar(Map<String, Vehiculo> v) {
        System.out.println("------------- Listado de Vehiculos -------------");
        for (Map.Entry<String, Vehiculo> entry : v.entrySet()) {
            String key = entry.getKey();
            Vehiculo val = entry.getValue();
            System.out.println(key + " -> " + val);
        }
    }

    public static void repostarTractoresKgMaxSuperior750(Map<String, Vehiculo> v) {
        System.out.println("------------- Repostar Tractores con Carga Max Superior a 750 -------------");
        for (Vehiculo vehiculo : v.values()) {
            if (vehiculo instanceof Tractor) {
                Tractor tractor = (Tractor) vehiculo;
                if (tractor.getKgCargaMaxima() > 750) {
                    tractor.repostar();
                }
            }
        }
    }

    public static void mediaKmAutonomiaCocheByColor(Map<String, Vehiculo> v) {
        System.out.println("------------- Media de Km de Autonomia Restantes Por Tipo de Vehículo -------------");
        double kmCoche = 0;
        int cochesTotal = 0;
        double kmCocheBlanco = 0;
        int cochesBlancosTotal = 0;
        double kmCocheNegro = 0;
        int cochesNegrosTotal = 0;

        for (Vehiculo vehiculo : v.values()) {
            if (vehiculo instanceof Coche) {
                if (((Coche) vehiculo).getColor().equals("blanco")) {
                    kmCocheBlanco += vehiculo.getKmAutonomia();
                    cochesBlancosTotal++;
                }
                if (((Coche) vehiculo).getColor().equals("negro")) {
                    kmCocheNegro += vehiculo.getKmAutonomia();
                    cochesNegrosTotal++;
                }
            }
        }

        double mediaCocheBlancos = kmCocheBlanco / cochesBlancosTotal;
        double mediaCocheNegros = kmCocheNegro / cochesNegrosTotal;

        System.out.println("Media de km de autonomía restantes de los Coches Blancos: " + mediaCocheBlancos);
        System.out.println("Media de km de autonomía restantes de los Coches Negros: " + mediaCocheNegros);
    }

    public static void borrarCochesBlancos(Map<String, Vehiculo> v) {
        System.out.println("------------- Eliminar Coches de Color Blanco -------------");
        ArrayList<String> borrar = new ArrayList<>();
        for (Map.Entry<String, Vehiculo> entry : v.entrySet()) {
            String key = entry.getKey();
            Vehiculo vehiculo = entry.getValue();
            if (vehiculo instanceof Coche) {
                Coche coche = (Coche) vehiculo;
                if (coche.getColor().equals("blanco")) {
                    borrar.add(key);
                }
            }
        }
        for (String n : borrar) {
            v.remove(n);
        }
    }
}
