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
public class GrupoAlumnos {
    private String titulacion;
    private int curso;
    private String turno;
    private Alumno[] alumnos;

    public GrupoAlumnos(String titulacion, int curso, String turno, Alumno[] alumnos) {
        this.titulacion = titulacion;
        this.curso = curso;
        this.turno = turno;
        this.alumnos = alumnos;
    }

    
    public Alumno getBestAlumno(){
        double mejorNota = Integer.MIN_VALUE;
        Alumno bestAlumno = null;
        for (Alumno alumno : this.alumnos) {
            if (alumno.getNota()> mejorNota) {
                mejorNota = alumno.getNota();
                bestAlumno = alumno;
                
            }
            
        }
        return bestAlumno;
    }
    
    public double getEdadMediaDias(){
        double suma = 0;
        
        for (Alumno alumno : this.alumnos) {
            suma += LocalDate.now().toEpochDay() - alumno.getFecNacimiento().toEpochDay();
        }
        return 1.0d * suma / this.alumnos.length;
    }
    
    

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }
    
    
    
}
