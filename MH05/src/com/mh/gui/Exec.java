/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.gui;

import com.mh.exceptions.*;
import java.util.*;
import com.mh.biz.*;
import com.mh.dao.pojo.*;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        MaquinaHelado mh = new MaquinaHelado();

        do {
            opcion = menu(sc);
            do {
                if (!(opcion.equalsIgnoreCase("1") || opcion.equalsIgnoreCase("2") || opcion.equalsIgnoreCase("3")
                        || opcion.equalsIgnoreCase("s"))) {
                    System.out.println("Texto no válido.");
                    System.out.print("Introduce otra vez: ");
                    opcion = sc.nextLine();
                }

            } while (!(opcion.equalsIgnoreCase("1") || opcion.equalsIgnoreCase("2") || opcion.equalsIgnoreCase("3")
                    || opcion.equalsIgnoreCase("s")));
            if (!opcion.equalsIgnoreCase("s")) {
                if (opcion.equalsIgnoreCase("1")) {
                    verHelados(mh);
                } else if (opcion.equalsIgnoreCase("2")) {
                    introDinero(sc, mh);
                } else if (opcion.equalsIgnoreCase("3")) {
                    comprarHelado(sc, mh);
                }
            }
        } while (!opcion.equalsIgnoreCase("s"));
        salir(mh);
    }

    public static void verHelados(MaquinaHelado mh) {

        System.out.println("-----Listado de helados------");
        System.out.println(mh);
        System.out.println("-----------------------------");
        System.out.println("Dispones de " + mh.getMonedero() + "€");
        System.out.println("-----------------------------");
    }

   public static String mostrarMonedas(Scanner sc) {
        String opcion;
        do {
            System.out.println("Introduzca dinero.");
            System.out.println("'A' Para introducir: 0,05€");
            System.out.println("'B' Para introducir: 0,10€");
            System.out.println("'C' Para introducir: 0,20€");
            System.out.println("'D' Para introducir: 0,50€");
            System.out.println("'E' Para introducir: 1,00€");
            System.out.println("'F' Para introducir: 2,00€");
            System.out.println("'S' Para volver al menú principal.");
            System.out.println("¿Que quieres realizar?");
            opcion = sc.nextLine();

            if (!(opcion.equalsIgnoreCase("A") || opcion.equalsIgnoreCase("B") || opcion.equalsIgnoreCase("C")
                    || opcion.equalsIgnoreCase("D") || opcion.equalsIgnoreCase("E") || opcion.equalsIgnoreCase("F")
                    || opcion.equalsIgnoreCase("S"))) {
                System.out.println("Opciones Incorrectas");
            }
        } while (!(opcion.equalsIgnoreCase("A") || opcion.equalsIgnoreCase("B") || opcion.equalsIgnoreCase("C")
                || opcion.equalsIgnoreCase("D") || opcion.equalsIgnoreCase("E") || opcion.equalsIgnoreCase("F") || opcion.equalsIgnoreCase("S")));

        return opcion;
    }

    public static void introDinero(Scanner sc, MaquinaHelado mh) {
        String opcion = "";
        do {
            opcion = mostrarMonedas(sc);

            if (!opcion.equalsIgnoreCase("S")) {
                double cantidad = 0;
                switch (opcion.toUpperCase()) {
                    case "A":
                        cantidad = 0.05;
                        break;
                    case "B":
                        cantidad = 0.10;
                        break;
                    case "C":
                        cantidad = 0.20;
                        break;
                    case "D":
                        cantidad = 0.50;
                        break;
                    case "E":
                        cantidad = 1.00;
                        break;
                    case "F":
                        cantidad = 2.00;
                        break;
                }
                mh.setMonedero(mh.getMonedero() + cantidad);
                System.out.println("Has introducido " + mh.getMonedero() + "€");
            }
            System.out.println("------------------------------------------------------------------");

        } while (!opcion.equalsIgnoreCase("S"));

        System.out.println("Total introducido " + mh.getMonedero() + "€");
        System.out.println("------------------------------------------------------------------");
    }

    public static String menu(Scanner sc) {
        String opcion = "";
        System.out.println("--------------Menú principal-----------");
        System.out.println("1.- Mostrar helados");
        System.out.println("2.- Introducir monedas");
        System.out.println("3.- Pedir helado");
        System.out.println("S.- Salir y apagar máquina de helados");
        do {
            System.out.println("--------------------------------------");
            System.out.print("Introduzca una opción: ");
            opcion = sc.nextLine();
        } while (!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equalsIgnoreCase("S")));
        return opcion;
    }

    public static void comprarHelado(Scanner sc, MaquinaHelado mh) throws Exception {
        String opcion;
        Helado heladoComprado;
        System.out.println("Hola, vas a realizar una compra. ");
        System.out.print("Introduce la posición del helado que deseas: ");
        opcion = sc.nextLine();
        try {
            heladoComprado = mh.pedirHelado(opcion);
            System.out.println("Coja su helado de tipo: " + heladoComprado);
            System.out.println("Recoga su cambio " + mh.getMonedero() + "€");

        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        } catch (NotValidPositionException | QuantityExceededException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void salir(MaquinaHelado mh) {
        System.out.println("-----------------------------");
        System.out.println("Apagando máquina de helados.....");
        System.out.println("No olvide recoger su cambio: " + mh.getMonedero() + "€");
        System.out.println("Ingresos totales de la máquina de helados: " + mh.getIngresos() + "€");
        System.out.println("-----------------------------");
    }
}
