/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package txttocsv;

/**
 *
 * @author dev
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.Scanner;

public class TxtToCsv {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Solicitar el nombre del archivo TXT de entrada y el archivo CSV de salida
        System.out.println("Introduce el nombre del archivo TXT de entrada (con la extensión .txt):");
        String txtFile = sc.nextLine();
        
        System.out.println("Introduce el nombre del archivo CSV de salida (con la extensión .csv):");
        String csvFile = sc.nextLine();
        
        System.out.println("Introduce el número de carácter desde el cual empezar a procesar (0 para el principio):");
        int startChar = sc.nextInt();

        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(txtFile));
            bw = new BufferedWriter(new FileWriter(csvFile));
            
            while ((line = br.readLine()) != null) {
                // Verificar y ajustar el índice de inicio
                if (startChar < 0 || startChar >= line.length()) {
                    startChar = 0;
                }
                String lineaProcesada = line.substring(startChar);
                
                // Aquí asumimos que los campos en el TXT están separados por espacios
                // Si están separados por otro delimitador, cambiar el " " por el delimitador correspondiente
                String[] datos = lineaProcesada.split(" ");
                String lineaCsv = String.join(",", datos);
                
                bw.write(lineaCsv);
                bw.newLine();
            }
            
            System.out.println("Datos transferidos de TXT a CSV exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

