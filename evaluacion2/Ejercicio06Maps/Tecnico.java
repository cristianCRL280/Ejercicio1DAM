/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio06Maps;

import java.time.LocalDate;

/**
 *
 * @author dev
 */
public class Tecnico extends Empleado {
   private String especialidad;

    public Tecnico(String especialidad, String codigo, String nombre, String apellidos, LocalDate fNac) {
        super(codigo, nombre, apellidos, fNac);
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + "Tecnico{" + "especialidad=" + especialidad + '}';
    }

    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
   
}
