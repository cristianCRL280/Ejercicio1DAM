/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parquemovil.vehiculos;

import com.parquemovil.excepciones.kgCargaMaxInvalida;

/**
 *
 * @author dev
 */
public class Tractor extends Vehiculo {

    private double kgCargaMaxima;

    public Tractor(double kgCargaMaxima, String codigo, String marca, String modelo, double kmAutonomia) throws kgCargaMaxInvalida {
        super(codigo, marca, modelo, kmAutonomia);
        this.setKgCargaMaxima(kgCargaMaxima);
    }

    @Override
    public void repostar() {
        super.setKmAutonomia(super.getKmAutonomia() + super.getKmAutonomia() * 20 / 100);
    }

    public double getKgCargaMaxima() {
        return kgCargaMaxima;
    }

    public void setKgCargaMaxima(double kgCargaMaxima) throws kgCargaMaxInvalida {
        if (kgCargaMaxima < 100 || kgCargaMaxima > 5000) {
            throw new com.parquemovil.excepciones.kgCargaMaxInvalida(super.getCodigo()+":" + " " + super.getMarca() + " " + super.getModelo() + " -> tiene una Carga Máxima inválida ");
        } else {
            this.kgCargaMaxima = kgCargaMaxima;
        }

    }

    @Override
    public String toString() {
        return super.toString() + "Tractor{" + "kgCargaMaxima=" + kgCargaMaxima + '}';
    }

}
