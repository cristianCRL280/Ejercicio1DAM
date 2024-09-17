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
public class Empresa {
    private String nombre;
    private MiembrosConsejo[] miembrosConsejo;

    public Empresa(String nombre, MiembrosConsejo[] miembrosConsejo) {
        this.nombre = nombre;
        this.miembrosConsejo = miembrosConsejo;
    }
    public MiembrosConsejo getSecretario(){
        LocalDate cercana = this.miembrosConsejo[0].getfNac();
        MiembrosConsejo secretario = this.miembrosConsejo[0];
        for (MiembrosConsejo nc : miembrosConsejo) {
            if (nc.getfNac().isAfter(cercana)) {
                cercana = nc.getfNac();
                secretario = nc;
                
            }
            
            
        }
        
        
        return secretario;
        
    }

    public MiembrosConsejo[] getMiembrosConsejo() {
        return miembrosConsejo;
    }

    public void setMiembrosConsejo(MiembrosConsejo[] miembrosConsejo) {
        this.miembrosConsejo = miembrosConsejo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
