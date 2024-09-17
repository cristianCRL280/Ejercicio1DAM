/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csvtotxt;

/**
 *
 * @author dev
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVToTxt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario los nombres de los archivos de entrada y salida
        System.out.println("Introduce el nombre del archivo CSV de entrada (con la extensión .csv):");
        String csvFile = sc.nextLine();

        System.out.println("Introduce el nombre del archivo TXT de salida (con la extensión .txt):");
        String txtFile = sc.nextLine();

        System.out.println("Introduce el número de carácter desde el cual empezar a escribir (0 para el principio):");
        int startChar = sc.nextInt();
        
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        String csvSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            bw = new BufferedWriter(new FileWriter(txtFile));
            
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(csvSplitBy);
                String lineaTexto = String.join(" ", datos);

                // Verificar y ajustar el índice de inicio
                if (startChar < 0 || startChar >= lineaTexto.length()) {
                    startChar = 0;
                }
                String substringTexto = lineaTexto.substring(startChar);
                
                bw.write(substringTexto);
                bw.newLine();
            }
            
            System.out.println("Datos transferidos de CSV a TXT exitosamente.");

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

