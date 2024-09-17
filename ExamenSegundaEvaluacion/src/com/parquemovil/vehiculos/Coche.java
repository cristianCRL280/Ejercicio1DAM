/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parquemovil.vehiculos;

import com.parquemovil.excepciones.InvalidColor;

/**
 *
 * @author dev
 */
public class Coche extends Vehiculo {

    private String color;

    public Coche(String color, String codigo, String marca, String modelo, double kmAutonomia) throws InvalidColor {
        super(codigo, marca, modelo, kmAutonomia);
        this.setColor(color);

    }

    @Override
    public void repostar() {
        super.setKmAutonomia(super.getKmAutonomia() + super.getKmAutonomia() * 30 / 100);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws InvalidColor {
        if (!(color.equals("negro") || color.equals("blanco"))) {
            throw new com.parquemovil.excepciones.InvalidColor(super.getCodigo()+":" + " " + super.getMarca() + " " + super.getModelo() + " -> tiene un color inválido ");
        }else{
            this.color = color;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Coche{" + "color=" + color + '}';
    }

}
