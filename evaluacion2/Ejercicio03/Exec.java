/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio03;

import java.time.LocalDate;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[10];

        alumnos[0] = new Alumno("Pepe", LocalDate.parse("2002-03-21"), 5.6d);
        alumnos[1] = new Alumno("Juan", LocalDate.parse("2005-03-21"), 8.6d);
        alumnos[2] = new Alumno("Carla", LocalDate.parse("2006-03-21"), 7.6d);
        alumnos[3] = new Alumno("Sara", LocalDate.parse("2001-04-21"), 4.6d);
        alumnos[4] = new Alumno("Roberto", LocalDate.parse("2001-05-21"), 2.6d);
        alumnos[5] = new Alumno("Manuel", LocalDate.parse("2001-06-21"), 6.6d);
        alumnos[6] = new Alumno("Laura", LocalDate.parse("2001-07-21"), 3.6d);
        alumnos[7] = new Alumno("Paca", LocalDate.parse("2001-08-21"), 1.6d);
        alumnos[8] = new Alumno("Pepa", LocalDate.parse("2001-09-21"), 9.6d);
        alumnos[9] = new Alumno("Pepo", LocalDate.parse("2001-10-21"), 5.6d);

        
        GrupoAlumnos ga = new GrupoAlumnos("Desarrollo de aplicaciones multiplataforma", 2, "Tarde", alumnos);
        System.out.println("El alumno con mejor nota es: " + ga.getBestAlumno().getNombre() );
        System.out.println("La  edad media en dias es: " + ga.getEdadMediaDias());
        
        
        
        
    }
}
