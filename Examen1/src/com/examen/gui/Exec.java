/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.gui;

import com.examen.implementations.CocheDAOimpl;
import com.examen.pojo.Coche;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev
 */
public class Exec {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fichero(sc);
    }
    
    public static void fichero(Scanner sc) {
        String fichero;
        String volver;
        String matricula;
        String marca;
        String modelo;
        String color;
        do {
            
            System.out.print("Nombre del csv:");
            fichero = sc.nextLine();
            System.out.println("Introduzca los filtros");
            System.out.print("Matricula: ");
            matricula = sc.nextLine();
            System.out.print("Marca: ");
            marca = sc.nextLine();
            System.out.print("Modelo: ");
            modelo = sc.nextLine();
            System.out.print("Color: ");
            color = sc.nextLine();
            llevarDatosToCSV(fichero, matricula, marca, modelo, color);
            System.out.println("Quieres volver a generar un fichero?");
            volver = sc.nextLine();
        } while (volver.equalsIgnoreCase("si"));
    }
    
    private static void llevarDatosToCSV(String fichero, String matricula, String marca, String modelo, String color) {
        try (CocheDAOimpl cocheImpl = new CocheDAOimpl(); FileWriter fw = new FileWriter(new File(fichero))) {
            List<Coche> al = cocheImpl.getCocheByFilter(fichero, matricula, marca, modelo, color);
            
            
            for (Coche coche : al) {
                fw.write(coche.toString() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
