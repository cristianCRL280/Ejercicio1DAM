/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerenciaEjemplo01;

import java.util.Objects;

/**
 *
 * @author dev
 */
public abstract class Animal {

    private String nombre;
    double peso;
    private int energia;
    private String genero;

    public Animal(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public Animal(String nombre, int energia) {
        this.nombre = nombre;
        this.energia = energia;
    }

    public Animal() {
        this.nombre = "sin nombre";
        this.genero = "desconocido";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
        final Animal other = (Animal) obj;
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    
    
    
    @Override
    public String toString() {
        return "Animal{" + "nombre=" + nombre + ", peso=" + peso + ", energia=" + energia + ", genero=" + genero + '}';
    }

    
    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso < 0.5d) {
            this.peso = 0.5d;
        } else {
            this.peso = peso;
        }

        this.peso = peso;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
