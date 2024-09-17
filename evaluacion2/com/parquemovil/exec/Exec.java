/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parquemovil.exec;

import com.parquemovil.vehiculos.*;
import com.parquemovil.vehiculos.Vehiculo;
import java.util.*;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) {
        HashMap<String, Vehiculo> m = new HashMap<String, Vehiculo>();
        Coche c1 = new Coche("blanco", "codigo1", "seat", "ibiza", 150);
        Coche c2 = new Coche("negro", "codigo2", "alfaromeo", "julia", 50);
        Tractor t1 = new Tractor(751, "codigo3", "lamborghini", "murcielago", 60);
        Tractor t2 = new Tractor(550, "codigo4", "lamborghini", "svj", 600);

        m.put(c1.getCodigo(), c1);
        m.put(c2.getCodigo(), c2);
        m.put(t1.getCodigo(), t1);
        m.put(t2.getCodigo(), t2);

        recorrerVehiculos(m);
        recorrerVehiculos(m);
        repostarTractores750(m);
        recorrerVehiculos(m);
    }

    public static void recorrerVehiculos(HashMap<String, Vehiculo> m) {
        System.out.println("-----Listado Vehiculos------");

        for (Map.Entry<String, Vehiculo> entry : m.entrySet()) {
            String key = entry.getKey();
            Vehiculo val = entry.getValue();
            System.out.println(val);

        }

    }

    public static void repostarTractores750(HashMap<String, Vehiculo> m) {
        for (Map.Entry<String, Vehiculo> entry : m.entrySet()) {

            String key = entry.getKey();
            Vehiculo val = entry.getValue();

            if (val instanceof Tractor) {

                Tractor t = (Tractor) val;

                if (t.getKgCargaMaxima() > 750) {

                    t.repostar();

                }
            }

        }

    }

}
