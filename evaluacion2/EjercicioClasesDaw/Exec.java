/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioClasesDaw;

import java.util.ArrayList;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) {
        ArrayList<Animal> An = new ArrayList<Animal>();
        perro p1 = new perro(19d, "Paco", "R33", 56d);
        An.add(p1);
        Leon l3 = new Leon("azul", "pepe", "S15", 37d);
        An.add(l3);
        perro p3 = new perro(48d, "Pacazo", "R35", 58d);
        An.add(p3);
        Leon l1 = new Leon("rojo", "pepe", "S14", 30d);
        An.add(l1);
        perro p2 = new perro(47d, "Paca", "R34", 55d);
        An.add(p2);
        Leon l2 = new Leon("amarillo", "pepe", "S15", 34d);
        An.add(l2);

        listar(An);
        dormirLeonAmarillo(An);
        listar(An);
        cambiarNombrePepeLeones(An);
        listar(An);
        borrarLargoPatasMenos20(An);
         listar(An);
    }

    public static void listar(ArrayList<Animal> An) {
        System.out.println("--------------------------");

        for (Animal a : An) {
            System.out.println(a);
        }
    }

    public static void dormirLeonAmarillo(ArrayList<Animal> An) {
        for (Animal a : An) {
            if (a instanceof Leon) {
                Leon leon = (Leon) a;
                if (leon.getColor().equalsIgnoreCase("amarillo")) {
                    leon.dormir();
                }
            }
        }

    }

    public static void cambiarNombrePepeLeones(ArrayList<Animal> An) {
        String nuevoNombre = "Antonio";
        System.out.println("------------- Cambiar de Nombre al Leon Pepe -------------");
        for (Animal animal : An) {
            if (animal instanceof Leon) {
                Leon leon = (Leon) animal;
                if (leon.getNombre().equalsIgnoreCase("Pepe")) {
                    leon.setNombre(nuevoNombre);
                    System.out.println("El nombre del animal llamado Pepe ha sido cambiado a: " + nuevoNombre);
                }
            }
        }
    }

public static void borrarLargoPatasMenos20(ArrayList<Animal> An) {
    for (int i = An.size() - 1; i >= 0; i--) {
        Animal animal = An.get(i);
        if (animal instanceof perro) {
            perro Perro = (perro) animal;
            if (Perro.getLargoPatas() < 20) {
                An.remove(i);
            }
        }
    }
}
}

//Este metodo cambia de nombre al PRIMER PEPE LEONES que se encuentra
//    public static void cambiarNombrePepePrimerLeon(ArrayList<Animal> p, String nuevoNombre) {
//    System.out.println("------------- Cambiar de Nombre al Leon Pepe -------------");
//    for (Animal animal : p) {
//        if (animal instanceof Leon) {
//            Leon leon = (Leon) animal;
//            if (leon.getNombre().equals("Pepe")) {
//                leon.setNombre(nuevoNombre);
//                System.out.println("El nombre del león llamado Pepe ha sido cambiado a: " + nuevoNombre);
//                return; // Salir del bucle después de cambiar el nombre del primer león llamado "Pepe"
//            }
//        }
//    }
//Este metodo cambia de nombre al ULTIMO PEPE LEONES que se encuentra
//    public static void cambiarNombreUltimoPepeLeones(ArrayList<Animal> p, String nuevoNombre) {
//    System.out.println("------------- Cambiar de Nombre al Ultimo Leon Pepe -------------");
//    Leon ultimoPepe = null;
//    for (Animal animal : p) {
//        if (animal instanceof Leon) {
//            Leon leon = (Leon) animal;
//            if (leon.getNombre().equals("Pepe")) {
//                ultimoPepe = leon;
//            }
//        }
//    }
//    
//    if (ultimoPepe != null) {
//        ultimoPepe.setNombre(nuevoNombre);
//        System.out.println("El nombre del ultimo león llamado Pepe ha sido cambiado a: " + nuevoNombre);
//    } else {
//        System.out.println("No se encontró ningún león llamado Pepe.");
//    }
//}
//Este metodo cambia de nombre al TODOS LOS PEPES que se encuentra
//    public static void cambiarNombrePepeCualquierAnimal(ArrayList<Animal> p, String nuevoNombre) {
//    System.out.println("------------- Cambiar de Nombre al Animal Pepe -------------");
//    for (Animal animal : p) {
//        if (animal.getNombre().equals("Pepe")) {
//            animal.setNombre(nuevoNombre);
//            System.out.println("El nombre del animal llamado Pepe ha sido cambiado a: " + nuevoNombre);
//        }
//    }

