/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package insertardatostxtrestricciones;

/**
 *
 * @author dev
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuardarMayoresDe30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String archivoTxt = "personas_mayores_de_30.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTxt))) {
            while (true) {
                System.out.println("Ingrese el nombre (o escriba 'fin' para salir):");
                String nombre = scanner.nextLine();
                if (nombre.equalsIgnoreCase("fin")) {
                    break;  // Salir del bucle si el usuario escribe 'fin'
                }

                System.out.println("Ingrese la edad:");
                int edad = scanner.nextInt();
                scanner.nextLine();  // Consumir la nueva línea pendiente

                if (edad > 30) {
                    bw.write("Nombre: " + nombre + ", Edad: " + edad);
                    bw.newLine();
                }
            }
            System.out.println("Datos de personas mayores de 30 guardados en " + archivoTxt);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
