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
public class Alumno {
 private String nombre;
private LocalDate fecNacimiento;  
 private Double nota;

    public Alumno(String nombre, LocalDate fecNacimiento, Double nota) {
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(LocalDate fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }
 

   
 



}