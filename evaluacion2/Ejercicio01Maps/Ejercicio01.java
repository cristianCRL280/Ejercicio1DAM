/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio01Maps;
//
//Aquí os dejo el enunciado:

import static EjercicioStatic1.Utils.*;
import java.util.List;

//En la una clase Utils, genera los siguientes métodos:
//- Método estático llamado listaPrimos, que reciba un número entero y devuelva un List de enteros con los números primos desde el número dos hasta el número recibido.
//- Método estático llamado fibonnaci que reciba un número entero n y devuelva en un List los primeros n números de la serie fibonnacci.
//En un programa ejecutable haz pruebas de este método.

/**
 *
 * @author dev
 */
public class Ejercicio01 {
    public static void main(String[] args) {
        List <Integer> l = listaPrimos(37);
        for (Integer n : l) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("----------------------------");
        List<Integer> k = fibonacci(12);
        for (int i = 0; i < k.size(); i++) {
            System.out.print(k.get(i) + "");
            
        }
        System.out.println();
    }
}
