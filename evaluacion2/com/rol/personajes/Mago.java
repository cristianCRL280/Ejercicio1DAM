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
public class Mago extends Personajes implements Comparable {

    private String colorToga;
    private double largoVarita;

    public Mago(String colorToga, double largoVarita, String codigo, String nombre, int puntosVida, int puntosExperiencia) throws TooLowNumberException {
        super(codigo, nombre, puntosVida, puntosExperiencia);
        this.setColorToga(colorToga); 
        this.setLargoVarita(largoVarita);
    }

    @Override
    public String toString() {
        return super.toString() + "Mago{" + "colorToga=" + colorToga + ", largoVarita=" + largoVarita + '}';
    }

    @Override
    public void pocimaSanadora() {

        super.setPuntosVida(super.getPuntosVida() * 4);
        if (super.getPuntosVida() > 150) {
            super.setPuntosVida(150);

        }
    }

    public String getColorToga() {
        return colorToga;
    }

    public void setColorToga(String colorToga) throws TooLowNumberException {
        this.colorToga = colorToga;
        if (!((colorToga.equalsIgnoreCase("gris" ) || colorToga.equalsIgnoreCase("blanco" ) || colorToga.equalsIgnoreCase("verde" )))) {
            
            throw new com.exceptions.TooLowNumberException(this.getCodigo() + "no es ni gris ni blanco ni verde");
            
        } else {
            
            this.colorToga = colorToga;
        }
        
        
    }

    public double getLargoVarita() {
        return largoVarita;
    }

    public void setLargoVarita(double largoVarita) throws TooLowNumberException {
        this.largoVarita = largoVarita;

        if (largoVarita <= 0) {
            throw new com.exceptions.TooLowNumberException(this.getCodigo() + "Valor demasiado bajo");

        } else {
            this.largoVarita = largoVarita;

        }

    }

    @Override
    public int compareTo(Object o) {

        return Double.compare(this.largoVarita, ((Mago) o).largoVarita);
    }

}
