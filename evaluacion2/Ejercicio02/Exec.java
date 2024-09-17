/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02;

import java.time.LocalDate;

/**
 *
 * @author dev
 */
public class Exec {
    public static void main(String[] args) {
        MiembrosConsejo[] miembrosConsejo = new MiembrosConsejo[3];
        miembrosConsejo[0] = new MiembrosConsejo("Pepe", LocalDate.parse("2001-05-20"));
        miembrosConsejo[1] = new MiembrosConsejo("Sara", LocalDate.parse("2001-05-19"));
        miembrosConsejo[2] = new MiembrosConsejo("Antonia", LocalDate.parse("2001-05-21"));
        Empresa e = new Empresa("los informaticos S.A", miembrosConsejo);
        
        System.out.println("El secretario es: " + e.getSecretario().getNombre());
        
    }
    
}
