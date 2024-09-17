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
public abstract class Personajes {

    private String codigo;
    private String nombre;
    private int puntosVida;
    private int puntosExperiencia;
    private boolean muerto;

    public Personajes(String codigo, String nombre, int puntosVida, int puntosExperiencia) throws TooLowNumberException {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
      this.setPuntosExperiencia(puntosExperiencia);
        
    }

    public void herir(int herida) {
        this.puntosVida -= herida;

    }

    public abstract void pocimaSanadora();

    public boolean isMuerto() {

        if (this.puntosVida < 0) {

            return true;

        } else {

            return false;
        }
    }

    @Override
    public String toString() {
        return "Personajes{" + "codigo=" + codigo + ", nombre=" + nombre + ", puntosVida=" + puntosVida + ", puntosExperiencia=" + puntosExperiencia + ", muerto=" + muerto + '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getPuntosExperiencia() {
        return puntosExperiencia;
    }

    public void setPuntosExperiencia(int puntosExperiencia) throws TooLowNumberException {
        this.puntosExperiencia = puntosExperiencia;
        
         if (puntosExperiencia < 0) {
            throw new com.exceptions.TooLowNumberException(this.getCodigo() + "Valor demasiado bajo");

        } else {
            this.puntosExperiencia = puntosExperiencia;

        }
        
    }

   

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }

}
