/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csvtodata;

/**
 *
 * @author dev
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvtoData {

    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        String archivoCSV = "hola.csv";
        String archivoData = "datos.data";

        // Leer datos desde el archivo CSV y almacenarlos en la lista de personas
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            // Leer cada línea del archivo CSV
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                // Crear un objeto Persona con los datos de cada línea y añadirlo a la lista
                Persona persona = new Persona(campos[0], campos[1], Integer.parseInt(campos[2]));
                personas.add(persona);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escribir los datos en el archivo .data
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoData))) {
            // Escribir cada persona en el archivo .data
            for (Persona persona : personas) {
                bw.write(persona.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Datos escritos en el archivo " + archivoData);
    }

    static class Persona {
        private String nombre;
        private String apellido;
        private int edad;

        public Persona(String nombre, String apellido, int edad) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
        }

        @Override
        public String toString() {
            return nombre + " " + apellido + " " + edad;
        }
    }
}


