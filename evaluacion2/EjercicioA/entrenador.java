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
public class entrenador extends persona  implements Comparable{

    private int anyoComienzoActividad;

    public entrenador(int anyoComienzoActividad, String identificador, String nombre, String apellidos, LocalDate fecha_nac, double energia) {
        super(identificador, nombre, apellidos, fecha_nac, energia);
        this.anyoComienzoActividad = anyoComienzoActividad;
    }

    public entrenador(String identificador, String nombre, String apellidos, LocalDate fecha_nac, double energia) {
        super(identificador, nombre, apellidos, fecha_nac, energia);
    }

    @Override
    public String toString() {
        return  super.toString() + "entrenador{" + "anyoComienzoActividad=" + anyoComienzoActividad + '}';
    }

    
    @Override
    public void doping() {
    }

    public int getAnyoComienzoActividad() {
        return anyoComienzoActividad;
    }

    public void setAnyoComienzoActividad(int anyoComienzoActividad) {
        this.anyoComienzoActividad = anyoComienzoActividad;
    }

    @Override
    public int compareTo(Object o) {
entrenador otro = (entrenador) o;
        return this.anyoComienzoActividad - otro.anyoComienzoActividad;
        
    }

}
