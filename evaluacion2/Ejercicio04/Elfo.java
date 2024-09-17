/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04;

/**
 *
 * @author dev
 */
public class Elfo extends Personaje {
    private int flechasPorSegundo;
    private double longitudOrejas;

    public Elfo(int flechasPorSegundo, double longitudOrejas, String codigo, String nombre, int puntosVida, int puntosExperiencia) {
        super(codigo, nombre, puntosVida, puntosExperiencia);
        this.flechasPorSegundo = flechasPorSegundo;
        this.longitudOrejas = longitudOrejas;
    }

    @Override
   public void pocimaSanadora(){
       super.setPuntosVida(super.getPuntosVida());
        if (super.getPuntosVida() > 100) {
            super.setPuntosVida(100);
            
        }
   }

    @Override
    public String toString() {
        return super.toString() +  " Elfo{" + "flechasPorSegundo=" + flechasPorSegundo + ", longitudOrejas=" + longitudOrejas + '}';
    }
   
   

    public int getFlechasPorSegundo() {
        return flechasPorSegundo;
    }

    public void setFlechasPorSegundo(int flechasPorSegundo) {
        this.flechasPorSegundo = flechasPorSegundo;
    }

    public double getLongitudOrejas() {
        return longitudOrejas;
    }

    public void setLongitudOrejas(double longitudOrejas) {
        this.longitudOrejas = longitudOrejas;
    }
   
    
}
