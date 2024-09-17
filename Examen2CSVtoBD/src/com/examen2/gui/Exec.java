/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2.gui;

import com.examen2.implementations.CasaDAOimpl;
import com.examen2.pojo.Casa;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) throws Exception {
        Casa casa;
        String nombreFichero = "./casa.csv";
        String[] datos;
        int cont = 0;
        try (CasaDAOimpl c = new CasaDAOimpl();
             Scanner scFile = new Scanner(new File(nombreFichero))) {

            c.deleteCasas();
            while (scFile.hasNextLine()) {
                datos = scFile.nextLine().split(",");
                casa = new Casa(datos[0], datos[1], datos[2], datos[3]);
                c.insertarCasas(casa);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

    }

}
