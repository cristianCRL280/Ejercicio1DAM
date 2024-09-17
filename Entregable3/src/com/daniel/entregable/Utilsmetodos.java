/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daniel.entregable;

/**
 *
 * @author daniel marin y cristian rodriguez
 */
import java.io.*;
import java.util.Scanner;

public class Utilsmetodos {

    private int alto;
    private int ancho;
    private int[][] imagen;

    public void cargarImagen(String archivo) {
        try (Scanner sc = new Scanner(new File(archivo))) {
            sc.nextLine();
            sc.nextLine();

            ancho = sc.nextInt();
            alto = sc.nextInt();
            sc.nextLine();

            imagen = new int[alto][ancho];

            int valorMaximo = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    imagen[i][j] = sc.nextInt() * 255 / valorMaximo;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void guardarImagen(String archivo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del archivo para guardar la imagen:");
        String nombreFile = sc.nextLine();
        try (FileWriter fw = new FileWriter(nombreFile)) {
            fw.write("P2\n");
            fw.write("# " + nombreFile + "\n");
            fw.write(ancho + " " + alto + "\n");
            fw.write("255\n");
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    fw.write(imagen[i][j] + " ");
                }
                fw.write("\n");
            }
            System.out.println("Imagen guardada correctamente en " + nombreFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filtroNegativo() {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                imagen[i][j] = 255 - imagen[i][j];
            }
        }

    }

    public void filtroGirarIzquierda() {
        int[][] imagenIzquierda = new int[ancho][alto];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                imagenIzquierda[j][alto - i - 1] = imagen[i][j];
            }
        }
        this.imagen = imagenIzquierda;
        int temp = ancho;
        ancho = alto;
        alto = temp;
    }

    public void filtroGirarDerecha() {
        int[][] imagenDerecha = new int[ancho][alto];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                imagenDerecha[ancho - j - 1][i] = imagen[i][j];
            }
        }
        this.imagen = imagenDerecha;
        int temp = ancho;
        ancho = alto;
        alto = temp;
    }

    public void filtroFlipHorizontal() {
        int[][] imagenHorizontal = new int[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                imagenHorizontal[i][ancho - j - 1] = imagen[i][j];
            }
        }
        this.imagen = imagenHorizontal;
    }

    public void filtroFlipVertical() {
        int[][] imagenVertical = new int[alto][ancho];
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                imagenVertical[alto - i - 1][j] = imagen[i][j];
            }
        }
        this.imagen = imagenVertical;
    }

    public void filtroCaja() {
        int alto = this.imagen.length;
        int ancho = this.imagen[0].length;
        int[][] nuevaImagen = new int[alto][ancho];

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                int suma = 0;
                int cantidad = 0;

                for (int k = Math.max(0, i - 1); k <= Math.min(alto - 1, i + 1); k++) {
                    for (int l = Math.max(0, j - 1); l <= Math.min(ancho - 1, j + 1); l++) {
                        suma += this.imagen[k][l];
                        cantidad++;
                    }
                }

                nuevaImagen[i][j] = suma / cantidad;
            }
        }
        this.imagen = nuevaImagen;
    }

}


