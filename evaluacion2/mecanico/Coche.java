/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanico;

import java.time.LocalDate;

/**
 *
 * @author dev
 */
public class Coche extends Vehiculo{
    private int numeroPasajeros;

    public Coche(int numeroPasajeros, String marca, String modelo, LocalDate anyoFabricacion, int kmAutonomiaRestantes) throws IncorrectPasajerosCoche {
        super(marca, modelo, anyoFabricacion, kmAutonomiaRestantes);
        this.setNumeroPasajeros(numeroPasajeros);
    }
    
    @Override
    public void repostar() {
        super.setKmAutonomiaRestantes(550);
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) throws IncorrectPasajerosCoche {
        if (numeroPasajeros > 8 || numeroPasajeros < 2) {
            throw new IncorrectPasajerosCoche(super.getMarca() + " " + super.getModelo() + " -> tiene un número incorrecto de pasajeros");
        } else {
            this.numeroPasajeros = numeroPasajeros;
        }
        
    }

    @Override
    public String toString() {
        return super.toString() + "Coche{" + "numeroPasajeros=" + numeroPasajeros + '}';
    }
    
    
}
