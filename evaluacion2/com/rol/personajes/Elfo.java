/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rol.personajes;

import com.exceptions.TooLowNumberException;

/**
 *
 * @author dev
 */
public class Elfo extends Personajes {

    private int flechasPorSegundo;
    private double longitudOrejas;

    public Elfo(int flechasPorSegundo, double longitudOrejas, String codigo, String nombre, int puntosVida, int puntosExperiencia) throws TooLowNumberException {
        super(codigo, nombre, puntosVida, puntosExperiencia);
        this.setFlechasPorSegundo(flechasPorSegundo); 
        this.setLongitudOrejas(longitudOrejas); 
    }

    @Override
    public void pocimaSanadora() {
        super.setPuntosVida(super.getPuntosVida());
        if (super.getPuntosVida() > 100) {
            super.setPuntosVida(100);

        }
    }

    @Override
    public String toString() {
        return super.toString() + "Elfo{" + "flechasPorSegundo=" + flechasPorSegundo + ", longitudOrejas=" + longitudOrejas + '}';
    }

    public int getFlechasPorSegundo() {
        return flechasPorSegundo;
    }

    public void setFlechasPorSegundo(int flechasPorSegundo) throws TooLowNumberException {
        this.flechasPorSegundo = flechasPorSegundo;
            if (flechasPorSegundo <= 0) {
            throw new com.exceptions.TooLowNumberException(this.getCodigo() + "Valor demasiado bajo");

        } else {
            this.flechasPorSegundo = flechasPorSegundo;

        }
    }

    public double getLongitudOrejas() {
        return longitudOrejas;
    }

    public void setLongitudOrejas(double longitudOrejas) throws TooLowNumberException  {
        this.longitudOrejas = longitudOrejas;
            if (longitudOrejas <= 0) {
            throw new com.exceptions.TooLowNumberException(this.getCodigo() + "Valor demasiado bajo");

        } else {
            this.longitudOrejas = longitudOrejas;

        }
    }

}
