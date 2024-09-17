/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scFile = null;
        Scanner scFile2 = null;
        String linea;
        String linea2;
        String archivotxt = "datos1.txt";
        String archivotxt2 = "datos2.txt";
        String archivoTxtSalida = "datosSalida4.txt";
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTxtSalida));) {
            scFile = new Scanner(new File(archivotxt));
            scFile2 = new Scanner(new File(archivotxt2));

            while (scFile.hasNextLine() || scFile2.hasNextLine()) {

                if (scFile.hasNextLine()) {
                    linea = scFile.nextLine();
                    bw.write(linea);
                    bw.newLine();

                }
                if (scFile2.hasNextLine()) {

                    linea2 = scFile2.nextLine();

                    bw.write(linea2);
                    bw.newLine();
                }
            }
            System.out.println("Datos escritos en el archivo " + archivoTxtSalida);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scFile != null) {
                try {
                    scFile.close();
                } catch (Exception e) {
                    System.out.println("Error al cerrar el scFile");
                } finally {
                    if (scFile2 != null) {
                        try {
                            scFile.close();
                        } catch (Exception e) {
                            System.out.println("Error al cerrar el scFile");
                        }

                    }

                }
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2 {

    public static void main(String[] args) {
        String archivoSalida = "datosSalida4.txt";
        String archivo1 = "datos1.txt";
        String archivo2 = "datos2.txt";

        try (
            BufferedReader br = new BufferedReader(new FileReader(archivoSalida));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(archivo1));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(archivo2))
        ) {
            String linea;
            int contador = 1;

            // Leemos las líneas del archivo de salida y las escribimos alternadamente en datos1.txt y datos2.txt
            while ((linea = br.readLine()) != null) {
                if (contador % 2 != 0) {
                    bw1.write(linea);
                    bw1.newLine();
                } else {
                    bw2.write(linea);
                    bw2.newLine();
                }
                contador++;
            }

            System.out.println("Se han distribuido las líneas del archivo de salida en " + archivo1 + " y " + archivo2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
