/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daniel.entregable;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author daniel marin y cristian rodriguez
 */
public class execPGM {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File pgm = null;
        String opcion;
        String nombreFichero;
        boolean carga = false;

        do {
            System.out.println("Introduce el nombre del fichero: ");
            nombreFichero = sc.nextLine();
            try {
                pgm = new File(nombreFichero);
                carga = true;
            } catch (NumberFormatException e) {
                System.out.println("Formato de fichero incorrecto");
            } catch (Exception e) {
                System.out.println("Se ha producido un error. Vuelva a intentarlo.");
            }
        } while (!carga);

        Utilsmetodos metodos = new Utilsmetodos();
        metodos.cargarImagen(nombreFichero);
        do {
            opcion = menu(sc);
            if (opcion.equals("1")) {
                metodos.filtroGirarIzquierda();
            } else if (opcion.equals("2")) {
                metodos.filtroGirarDerecha();
            } else if (opcion.equals("3")) {
                metodos.filtroFlipHorizontal();
            } else if (opcion.equals("4")) {
                metodos.filtroFlipVertical();
            } else if (opcion.equals("5")) {
                metodos.filtroNegativo();
            } else if (opcion.equals("6")) {
                metodos.filtroCaja();
            } else if (opcion.equalsIgnoreCase("G")) {
                metodos.guardarImagen(opcion);
            } else {
                if (!opcion.equalsIgnoreCase("S")) {
                    System.out.println("Valor no válido, vuelve a inntroducir uno nuevo");
                }
            }
        } while (!opcion.equalsIgnoreCase("S"));
    }

    public static String menu(Scanner sc) {
        String opcion;
        System.out.println("----------- Editor de imágenes -----------");
        System.out.println("1. ** Aplicar filtro girar izquierda <-- **");
        System.out.println("2. ** Aplicar filtro girar derecha --> **");
        System.out.println("3. ** Aplicar filtro horizontal _ **");
        System.out.println("4. ** Aplicar filtro vertical | **");
        System.out.println("5. ** Aplicar filtro negativo **");
        System.out.println("6. ** Aplicar filtro caja **");
        System.out.println("G.  ** ¿Deseas guardar el archivo? **");
        System.out.println("S. ** Salir del programa **");
        System.out.print("Escoge una opción: ");
        opcion = sc.nextLine();
        return opcion;
    }
}

