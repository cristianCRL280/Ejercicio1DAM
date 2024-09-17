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
public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private LocalDate anyoFabricacion;
    private int kmAutonomiaRestantes;
    
    public abstract void repostar();

    public Vehiculo(String marca, String modelo, LocalDate anyoFabricacion, int kmAutonomiaRestantes) {
        this.marca = marca;
        this.modelo = modelo;
        this.anyoFabricacion = anyoFabricacion;
        this.kmAutonomiaRestantes = kmAutonomiaRestantes;
    }

    public int getKmAutonomiaRestantes() {
        return kmAutonomiaRestantes;
    }

    public void setKmAutonomiaRestantes(int kmAutonomiaRestantes) {
        this.kmAutonomiaRestantes = kmAutonomiaRestantes;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAnyoFabricacion() {
        return anyoFabricacion;
    }

    public void setAnyoFabricacion(LocalDate anyoFabricacion) {
        this.anyoFabricacion = anyoFabricacion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", anyoFabricacion=" + anyoFabricacion + ", kmAutonomiaRestantes=" + kmAutonomiaRestantes + '}';
    }
    
    
}
