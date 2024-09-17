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
public class Camion extends Vehiculo {

    private int numeroEjes;
    private int pesoMaximoAutorizado;

    public Camion(int numeroEjes, int pesoMaximoAutorizado, String marca, String modelo, LocalDate anyoFabricacion, int kmAutonomiaRestantes) throws IncorrectEjesCamion {
        super(marca, modelo, anyoFabricacion, kmAutonomiaRestantes);
        this.setNumeroEjes(numeroEjes);
        this.pesoMaximoAutorizado = pesoMaximoAutorizado;
    }

    @Override
    public void repostar() {
        super.setKmAutonomiaRestantes(800);
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) throws IncorrectEjesCamion {
        if (numeroEjes > 12 || numeroEjes < 2) {
            throw new IncorrectEjesCamion(super.getMarca() +" " + super.getModelo() + " -> tiene un número incorrecto de ejes");
        } else {
            this.numeroEjes = numeroEjes;
        }
    }

    public int getPesoMaximoAutorizado() {
        return pesoMaximoAutorizado;
    }

    public void setPesoMaximoAutorizado(int pesoMaximoAutorizado) {
        this.pesoMaximoAutorizado = pesoMaximoAutorizado;
    }

    @Override
    public String toString() {
        return super.toString() + "Camion{" + "numeroEjes=" + numeroEjes + ", pesoMaximoAutorizado=" + pesoMaximoAutorizado + '}';
    }
    
    
}
