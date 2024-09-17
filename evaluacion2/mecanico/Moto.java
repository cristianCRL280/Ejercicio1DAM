/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author dev
 */
public class Moto extends Vehiculo {

    private int cantidadRuedas;

    public Moto(int cantidadRuedas, String marca, String modelo, LocalDate anyoFabricacion, int kmAutonomiaRestantes) {
        super(marca, modelo, anyoFabricacion, kmAutonomiaRestantes);
        this.cantidadRuedas = cantidadRuedas;
    }

    @Override
    public void repostar() {
        super.setKmAutonomiaRestantes(300);
    }

    @Override
    public String toString() {
        return super.toString() + "Moto{" + "cantidadRuedas=" + cantidadRuedas + '}';
    }
    
    public int getCantidadRuedas() {
        return cantidadRuedas;
    }

    public void setCantidadRuedas(int cantidadRuedas) {
        this.cantidadRuedas = cantidadRuedas;
    }
    
    
}