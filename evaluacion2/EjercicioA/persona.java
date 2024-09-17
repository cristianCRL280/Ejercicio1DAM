/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioA;

import java.time.LocalDate;

/**
 *
 * @author dev
 */
public  abstract class persona {
    private String identificador;
    private String nombre;
    private String apellidos;
    private LocalDate fecha_nac;
    private double energia;

    public persona(String identificador, String nombre, String apellidos, LocalDate fecha_nac, double energia) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
        this.energia = energia;
    }

    @Override
    public String toString() {
        return "persona{" + "identificador=" + identificador + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_nac=" + fecha_nac + ", energia=" + energia + '}';
    }

     public abstract void doping();

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public double getEnergia() {
        return energia;
    }
    
    
    
    
    
    
    
}
