/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datatotxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataToTxt {

    public static void main(String[] args) {
        String archivoData = "datos.data";
        String archivoTxt = "datos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoData));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTxt))) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Datos escritos en el archivo " + archivoTxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
