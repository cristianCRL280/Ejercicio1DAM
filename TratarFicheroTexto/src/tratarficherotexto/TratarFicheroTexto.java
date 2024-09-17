/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tratarficherotexto;

import java.io.File;
import java.util.Scanner;

public class TratarFicheroTexto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fichero = "";
        Scanner scFile = null;

        String linea = "";
        String cambiado = "";

        int contLineas = 0;
        int contCaracteres = 0;
        int suma = 0;
        int maxNumeros = 0;
        String lineaConMasNumeros = "";

        System.out.println("Introduce el fichero");
        fichero = sc.nextLine();
        File fIni = new File(fichero);
        System.out.println("Introduce el número de carácter desde el cual empezar a procesar (0 para el principio):");
        int startChar = Integer.parseInt(sc.nextLine());

        if (!fIni.exists()) {
            System.out.println("No existe el fichero");
        } else {
            try {
                scFile = new Scanner(fIni);
                while (scFile.hasNextLine()) {
                    linea = scFile.nextLine();

                    // Verificar y ajustar el índice de inicio
                    if (startChar < 0 || startChar >= linea.length()) {
                        startChar = 0;
                    }
                    String lineaProcesada = linea.substring(startChar);
                    cambiado = lineaProcesada.replace("o", "4");
                    int contadorNumerosLinea = 0;

                    for (int i = 0; i < lineaProcesada.length(); i++) {
                        if (Character.isDigit(lineaProcesada.charAt(i))) {
                            contCaracteres++;
                            suma += Character.getNumericValue(lineaProcesada.charAt(i));
                            contadorNumerosLinea++;
                        }
                    }

                    if (contadorNumerosLinea > maxNumeros) {
                        maxNumeros = contadorNumerosLinea;
                        lineaConMasNumeros = lineaProcesada;
                    }

                    contLineas++;
                    System.out.println(cambiado);
                }
                System.out.println("Numero de lineas " + contLineas);
                System.out.println("Total de caracteres numericos " + contCaracteres);
                System.out.println("Suma de los valores de los caracteres numericos " + suma);
                System.out.println("Linea con mas numeros: " + lineaConMasNumeros);
            } catch (Exception e) {
                System.out.println("Error");
            } finally {
                if (scFile != null) {
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
