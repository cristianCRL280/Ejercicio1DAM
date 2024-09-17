/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parquemovil.vehiculos;

/**
 *
 * @author dev
 */
public class Coche extends Vehiculo {

    private String color;

    public Coche(String color, String codigo, String marca, String modelo, double kmAutonomia) {
        super(codigo, marca, modelo, kmAutonomia);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "Coche{" + "color=" + color + '}';
    }

    @Override
    public void repostar() {
        super.setKmAutonomia(super.getKmAutonomia() + (super.getKmAutonomia() * 0.30));

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
