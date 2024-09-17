/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04;

/**
 *
 * @author dev
 */
public class Mago extends Personaje {
   private String colorToga;
   private double largoVarita;

    public Mago(String colorToga, double largoVarita, String codigo, String nombre, int puntosVida, int puntosExperiencia) {
        super(codigo, nombre, puntosVida, puntosExperiencia);
        this.colorToga = colorToga;
        this.largoVarita = largoVarita;
    }

    @Override
    public String toString() {
        return super.toString() + "Mago{" + "colorToga=" + colorToga + ", largoVarita=" + largoVarita + '}';
    }
   
   
   
   
   @Override
   public void pocimaSanadora(){

super.setPuntosVida(super.getPuntosVida() * 4);
       if (super.getPuntosVida() > 150) {
           super.setPuntosVida(150);
           
       }
}

    public String getColorToga() {
        return colorToga;
    }

    public void setColorToga(String colorToga) {
        this.colorToga = colorToga;
    }

    public double getLargoVarita() {
        return largoVarita;
    }

    public void setLargoVarita(double largoVarita) {
        this.largoVarita = largoVarita;
    }


   
}

