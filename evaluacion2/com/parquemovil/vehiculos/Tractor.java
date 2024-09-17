/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parquemovil.vehiculos;

/**
 *
 * @author dev
 */
public class Tractor extends Vehiculo {

    private double kgCargaMaxima;

    public Tractor(double kgCargaMaxima, String codigo, String marca, String modelo, double kmAutonomia) {
        super(codigo, marca, modelo, kmAutonomia);
        this.kgCargaMaxima = kgCargaMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + "Tractor{" + "kgCargaMaxima=" + kgCargaMaxima + '}';
    }

    @Override
    public void repostar() {
        super.setKmAutonomia(super.getKmAutonomia() + (super.getKmAutonomia() * 0.20));

    }

    public double getKgCargaMaxima() {
        return kgCargaMaxima;
    }

    public void setKgCargaMaxima(double kgCargaMaxima) {
        this.kgCargaMaxima = kgCargaMaxima;
    }

}
