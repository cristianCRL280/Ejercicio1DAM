/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.obj.gui;

import com.obj.DAO.implementations.ProductoDAOimpl;
import com.obj.biz.Producto;
import com.obj.utils.MiObjectOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dev
 */
//IMPORTANTER IMPLEMENTS SERIALIZABLE EN EL POJO
////CREATE TABLE producto (
//    codigo TEXT,
//    nombre TEXT,
//    categoria TEXT,
//    precio REAL
//);
public class Exec {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        System.out.print("Nombre del fichero: ");
        String fichero = sc.nextLine();
        ArrayList<Producto> al = null;

        do {
            System.out.println("-----MENU------------");
            System.out.println("Que quieres hacer:");
            System.out.println(" 1- Añadir productos");
            System.out.println(" 2- Insertar productos a .obj");
            System.out.println(" 3- Leer productos del .obj");
            System.out.println(" 4- Borrar productos del .obj");
            System.out.println(" 5- Insertar productos a la BD");
            System.out.println(" 6- Ver productos de la BD");
            System.out.println(" 77- Leer productos del .obj de otra manera");
            System.out.println("FIN para acabar");
            opcion = sc.nextLine();

            if (!opcion.equalsIgnoreCase("FIN")) {
                switch (opcion) {
                    case "1":
                        al = listarProductos(sc);
                        break;
                    case "2":
                        crearFichero(fichero, sc, al);
                        break;
                    case "3":
                        leerProductosOfObject(fichero);
                        break;
                    case "4":
                        borrarProductos(fichero);
                        System.out.println("Contenido del archivo .obj borrado correctamente.");
                        break;
                    case "5":
                        insertarProductosToBD(fichero);
                        break;
                    case "6":
                        try (ProductoDAOimpl p = new ProductoDAOimpl(); Scanner scFile = new Scanner(new File(fichero))) {
                        System.out.println(p.getProductos());
                    } catch (Exception e) {
                    }

                    break;
                    case "77":
                        listarProductosManera2(sc, fichero);
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            }
        } while (!opcion.equalsIgnoreCase("FIN"));

    }

    public static void insertarProductosToBD(String fichero) throws Exception {
        ArrayList<Producto> al = new ArrayList<>();
        Producto p = null;
        ProductoDAOimpl productoDAOimpl = new ProductoDAOimpl();
        try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis);) {
            do {
                p = (Producto) ois.readObject();
                al.add(p);
            } while (true);
        } catch (EOFException e) {
            System.out.println("Fichero terminado");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        for (Producto producto : al) {
            productoDAOimpl.insertProductos(p);
        }

    }

    private static void crearFichero(String fichero, Scanner sc, ArrayList<Producto> al) {
        boolean sobreescribe = false;
        File f = new File(fichero);
        if (f.exists()) {
            System.out.println("El fichero ya existe, ¿quiere sobreescribirlo (S/N)?");
            String respuesta = sc.nextLine();
            sobreescribe = respuesta.equalsIgnoreCase("S");
        }

        try (FileOutputStream fos = new FileOutputStream(f, !sobreescribe); 
                ObjectOutputStream oos = sobreescribe ? new ObjectOutputStream(fos) : new MiObjectOutputStream(fos);) {
            for (Producto producto : al) {
                oos.writeObject(producto);
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
            e.printStackTrace();
        }
    }

    private static ArrayList<Producto> listarProductos(Scanner sc) {
        ArrayList<Producto> al = new ArrayList<Producto>();
        String codigo;
        String nombre;
        String categoria;
        double precio;
        Producto p;
        do {
            System.out.println("Codigo (FIN para acabar): ");
            codigo = sc.nextLine();
            if (!codigo.equalsIgnoreCase("FIN")) {
                System.out.println("Nombre: ");
                nombre = sc.nextLine();
                System.out.println("Categoria: ");
                categoria = sc.nextLine();
                System.out.println("Precio: ");
                precio = Double.parseDouble(sc.nextLine());
                p = new Producto(codigo, nombre, categoria, precio);
                al.add(p);

            }
        } while (!codigo.equalsIgnoreCase("FIN"));
        return al;
    }

    private static void listarProductosManera2(Scanner sc, String fichero) {
        ArrayList<Producto> al = new ArrayList<>();
        Producto p;
        try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis);) {
            do {
                p = (Producto) ois.readObject();
                al.add(p);
            } while (true);
        } catch (EOFException e) {
            System.out.println("Fichero terminado");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        for (Producto producto : al) {
            System.out.println(producto);
        }
    }

    private static void leerProductosOfObject(String fichero) {
        ArrayList<Producto> al = new ArrayList<>();
        Producto p;
        try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis);) {
            do {
                p = (Producto) ois.readObject();
                al.add(p);
            } while (true);
        } catch (EOFException e) {
            System.out.println("Fichero terminado");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        for (Producto producto : al) {
            System.out.println(producto);
        }
    }

    private static void borrarProductos(String fichero) throws IOException {
        try (FileWriter fw = new FileWriter(fichero, false)) {
        }
    }

}
