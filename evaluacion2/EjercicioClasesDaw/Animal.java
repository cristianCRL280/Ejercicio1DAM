/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioClasesDaw;

/**
 *
 * @author dev
 */
public  abstract class Animal {
    private String nombre;
    private String codigo;
    private Double energia;

    public Animal(String nombre, String codigo, Double energia) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.energia = energia;
    }
  public abstract void dormir();

    @Override
    public String toString() {
        return "Animal{" + "nombre=" + nombre + ", codigo=" + codigo + ", energia=" + energia + '}';
    }

    public Double getEnergia() {
        return energia;
    }

    public void setEnergia(Double energia) {
        this.energia = energia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    void setEnergia(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
