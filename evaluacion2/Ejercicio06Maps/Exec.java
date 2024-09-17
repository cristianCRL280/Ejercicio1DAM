/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio06Maps;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu;
        Set<Empleado> e = new HashSet<Empleado>();

        do {

            menu = menu(sc);
            if (menu.equals("1")) {
                insertarEmpleado(e, sc);

            } else if (menu.equals("2")) {

                listarEmpleados(e);

            } else if (menu.equals("3")) {

                mostrarNumEmpleados(e);

            }

        } while (!menu.equalsIgnoreCase("S"));

        System.out.println("Adios!!");

    }

    public static void mostrarNumEmpleados(Set<Empleado> e) {

        System.out.println("Numero de empleados " + e.size());
        System.out.println("Numero de empleados: " + Empleado.contadorEmpleados);

    }

    public static void insertarEmpleado(Set<Empleado> e, Scanner sc) {
        String tipo;
        System.out.println("-----Insertar empleado-----");
        System.out.println("Dime el tipo de empleado");
        System.out.println("1.-Tecnico");
        System.out.println("2.-Comercial");

        do {
            System.out.print("Introduce una opcion: ");
            tipo = sc.nextLine();
        } while (!tipo.equals("1") || tipo.equals("2"));

        System.out.println("Codigo: ");

        String codigo = sc.nextLine();
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Apellidos:");
        String apellidos = sc.nextLine();
        System.out.println("Fecha de nacimiento(yyyy-mm-dd");
        LocalDate fNac = LocalDate.parse(sc.nextLine());

        if (tipo.equals("1")) {
            System.out.println("Especialidad: ");
            String especialidad = sc.nextLine();
            Tecnico t = new Tecnico(especialidad, codigo, nombre, apellidos, fNac);
            e.add(t);
        } else {
            System.out.println("Zona: ");
            String zona = sc.nextLine();
            Comercial c = new Comercial(zona, codigo, nombre, apellidos, fNac);
            e.add(c);
        }

    }

    public static void listarEmpleados(Set<Empleado> e) {

        System.out.println("------Lista de empleados-----");
        for (Empleado empleado : e) {

            System.out.println(empleado);
        }
    }

    public static String menu(Scanner sc) {
        String opcion = "";
        System.out.println("-----------------Menu---------------");
        System.out.println("1.-Insertar empleados");
        System.out.println("2.-Listar empleados");
        System.out.println("3.-Mostrar numero de empleados");

        System.out.println("S.- Para salir");

        do {
            System.out.println("Introduzca una opcion");
            opcion = sc.nextLine();

        } while (!(opcion.equals("1") || opcion.equals("2") || opcion.equals("3")
                || opcion.equalsIgnoreCase("S")));

        return opcion;
    }
}
