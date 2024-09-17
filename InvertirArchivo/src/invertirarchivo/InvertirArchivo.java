/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package invertirarchivo;

/**
 *
 * @author dev
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InvertirArchivo {
    public static void main(String[] args) {
        // Ruta del archivo de entrada y salida
        String archivoEntrada = "texto.txt";
        String archivoSalida = "archivo_invertido.inv";

        try (FileReader reader = new FileReader(archivoEntrada);
            BufferedReader bufferedReader = new BufferedReader(reader);  
            FileWriter writer = new FileWriter(archivoSalida);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
){
            
            // Crea un objeto FileReader para leer el archivo de entrada
          

            // Crea un objeto FileWriter para escribir en el archivo de salida
          
            // Lee la primera línea del archivo de entrada
            String linea = bufferedReader.readLine();

            // Itera sobre todas las líneas del archivo de entrada
            while (linea != null) {
                // Invierte la línea y la escribe en el archivo de salida
                String lineaInvertida = invertirCadena(linea);
                bufferedWriter.write(lineaInvertida);
                bufferedWriter.newLine();

                // Lee la siguiente línea
                linea = bufferedReader.readLine();
            }

            // Cierra los BufferedReader y BufferedWriter
            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("Inversión completada. El archivo invertido se encuentra en " + archivoSalida);

        } catch (IOException e) {
            // Maneja las posibles excepciones de entrada/salida
            e.printStackTrace();
        }
    }

    // Función para invertir una cadena de caracteres
    private static String invertirCadena(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }
}
