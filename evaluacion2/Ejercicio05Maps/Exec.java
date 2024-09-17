/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio05Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Articulo> articulos = new LinkedHashMap<String, Articulo>();
        String menu;
        do {
            menu = menu(sc);

            if (menu.equals("1")) {
                introducirDatos(articulos, sc);

            } else if (menu.equals("2")) {

                listar(articulos);

            } else if (menu.equals("3")) {
                consultaVideojuegoByPrecioAlquiler(articulos, sc);

            } else if (menu.equals("4")) {

                consultaByTipoArticulo(articulos, sc);

            } else if (menu.equals("5")) {

                consultaByCodigo(articulos, sc);

            }

        } while (!menu.equalsIgnoreCase("S"));
        System.out.println("Adios!!");

    }

    public static void consultaByCodigo(LinkedHashMap<String, Articulo> articulos, Scanner sc) {

        System.out.println("Dame el codigo del articulo a consultar: ");

        String codigo = sc.nextLine();
        if (articulos.containsKey(codigo)) {
            System.out.println(articulos.get(codigo));
        } else {

            System.out.println("No hay articulos asociados a ese codigo");

        }

    }

    public static void consultaByTipoArticulo(LinkedHashMap<String, Articulo> articulos, Scanner sc) {

        String opcion;
        System.out.println("-------------Dame el tipo de articulo que quieres consultar--------");
        System.out.println("Tipo de articulo");
        System.out.println("1.-Videojuego");
        System.out.println("2.-Videoconsola");
        System.out.println("3.-accesorio");
        do {
            System.out.println("Introduzca una opcion");
            opcion = sc.nextLine();

        } while (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3"));

        for (Map.Entry<String, Articulo> entry : articulos.entrySet()) {
            String key = entry.getKey();
            Articulo val = entry.getValue();
            if (opcion.equals(1) && val instanceof Videojuego) {

                System.out.println(val);
            } else if (opcion.equals(2) && val instanceof Videoconsola) {
                System.out.println(val);

            } else if (opcion.equals(3) && val instanceof Accesorio) {

                System.out.println(val);
            }
        }

    }

    public static void consultaVideojuegoByPrecioAlquiler(LinkedHashMap<String, Articulo> articulos, Scanner sc) {

        System.out.println("-------Consulta videojuegos por precio de alquiler------");
        System.out.println("Precio minimo: ");
        double min = Double.parseDouble(sc.nextLine());
        System.out.println("Precio maximo: ");
        double max = Double.parseDouble(sc.nextLine());

        for (Map.Entry<String, Articulo> entry : articulos.entrySet()) {
            String key = entry.getKey();
            Articulo val = entry.getValue();

            if (val instanceof Videojuego) {

                Videojuego tmp = (Videojuego) val;
                if (tmp.getPrecioAlquiler() >= min && tmp.getPrecioAlquiler() <= max) {

                    System.out.println(tmp);

                }
            }

        }
    }

    public static void listar(LinkedHashMap<String, Articulo> articulos) {
        System.out.println("---------Listado de articulos--------------");
        for (Map.Entry<String, Articulo> entry : articulos.entrySet()) {
            String key = entry.getKey();
            Articulo val = entry.getValue();
            System.out.println(val);

        }

    }

    public static void introducirDatos(LinkedHashMap<String, Articulo> articulos, Scanner sc) {
        String opcion;
        System.out.println("-------------Introduccion de datos--------");
        System.out.println("Tipo de articulo");
        System.out.println("1.-Videojuego");
        System.out.println("2.-Videoconsola");
        System.out.println("3.-accesorio");
        do {
            System.out.println("Introduzca una opcion");
            opcion = sc.nextLine();

        } while (!opcion.equals("1") || !opcion.equals("2") || !opcion.equals("3"));

        System.out.println("codigo: ");
        String codigo = sc.nextLine();
        System.out.println("Marca: ");
        String marca = sc.nextLine();
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Precio de venta: ");
        double precioVenta = Double.parseDouble(sc.nextLine());

        if (opcion.equals("1")) {
            System.out.println("Categoria");
            String categoria = sc.nextLine();
            System.out.println("Precio de alquiler: ");
            double precioAlquiler = Double.parseDouble(sc.nextLine());
            Videojuego vj = new Videojuego(categoria, precioAlquiler, codigo, marca, nombre, precioVenta);
            articulos.put(codigo, vj);

        } else if (opcion.equals("2")) {
            System.out.print("Año de fabricacion:");

            int anyoFabricacion = Integer.parseInt(sc.nextLine());

            Videoconsola vc = new Videoconsola(anyoFabricacion, codigo, marca, nombre, precioVenta);
            articulos.put(codigo, vc);
        } else if (opcion.equals("3")) {
            System.out.println("Descripcion");

            String descripcion = sc.nextLine();
            Accesorio a = new Accesorio(descripcion, codigo, marca, nombre, precioVenta);
            articulos.put(codigo, a);

        }
    }

    public static String menu(Scanner sc) {
        String opcion = "";
        System.out.println("-----------------Menu---------------");
        System.out.println("1.-Introducir articulos");
        System.out.println("2.-Listar de forma ordenada seugn se hayan insertado los articulos");
        System.out.println("3.-Consulta de videojuegos por el preico de alquiler");
        System.out.println("4.-Consulta  por tipo de articulo");
        System.out.println("5.-Consulta por codigo");

        System.out.println("S.- Para salir");

        do {
            System.out.println("Introduzca una opcion");
            opcion = sc.nextLine();

        } while (!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4")
                || opcion.equals("5") || opcion.equals("S")));

        return opcion;
    }
}
