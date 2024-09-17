 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parquemovil.vehiculos;

/**
 *
 * @author dev
 */
public abstract class Vehiculo {

    private String codigo;
    private String marca;
    private String modelo;
    private double kmAutonomia;

    public abstract void repostar();

    public Vehiculo(String codigo, String marca, String modelo, double kmAutonomia) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.kmAutonomia = kmAutonomia;
    }

    public double getKmAutonomia() {
        return kmAutonomia;
    }

    public void setKmAutonomia(double kmAutonomia) {
        this.kmAutonomia = kmAutonomia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return "Vehiculo{" + "codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", kmAutonomia=" + kmAutonomia + '}';
    }
    
    

}
