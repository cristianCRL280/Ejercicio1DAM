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
public class Comercial extends Empleado {
    
    String zona;

    public Comercial(String zona, String codigo, String nombre, String apellidos, LocalDate fNac) {
        super(codigo, nombre, apellidos, fNac);
        this.zona = zona;
    }

    @Override
    public String toString() {
        return super.toString() + "Comercial{" + "zona=" + zona + '}';
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
    
    
}
