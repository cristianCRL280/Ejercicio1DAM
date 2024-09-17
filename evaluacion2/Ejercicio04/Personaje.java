/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04;

/**
 *
 * @author dev
 */
public abstract class Personaje {

    private String codigo;
    private String nombre;
    private int puntosVida;
    private int puntosExperiencia;
    private boolean muerto;

    public Personaje(String codigo, String nombre, int puntosVida, int puntosExperiencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.puntosExperiencia = puntosExperiencia;

    }

    public void herir(int herida){
        this.puntosVida -= herida;
        
    }
    
    public abstract void pocimaSanadora();
    
    @Override
    public String toString() {
        return "Personaje{" + "codigo=" + codigo + ", nombre=" + nombre + ", puntosVida=" + puntosVida + ", puntosExperiencia=" + puntosExperiencia + ", muerto=" + this.isMuerto() + '}';
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

    public void setPuntosExperiencia(int puntosExperiencia) {
        this.puntosExperiencia = puntosExperiencia;
    }

    public boolean isMuerto() {

        if (this.puntosVida < 0) {

            return true;

        } else {

            return false;
        }
    }

}
