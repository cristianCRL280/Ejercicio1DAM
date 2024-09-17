/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrecuenciaPalabras {

    public static void main(String[] args) {
        String archivo = "texto.txt";  // Especifica el nombre del archivo aquí
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            
            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Dividir cada línea en palabras utilizando espacios como delimitador
                String[] palabras = linea.split("\\s+");
                
                // Procesar cada palabra
                for (String palabra : palabras) {
                    // Convertir la palabra a minúsculas y eliminar caracteres no alfabéticos
                    palabra = palabra.toLowerCase().replaceAll("[^a-z]", "");
                    
                    // Actualizar la frecuencia de la palabra en el mapa
                    if (!palabra.isEmpty()) {
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
            
            // Imprimir la frecuencia de cada palabra
            for (Map.Entry<String, Integer> entry : frecuenciaPalabras.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
