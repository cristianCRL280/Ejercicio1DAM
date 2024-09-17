/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio05Maps;

/**
 *
 * @author dev
 */
public class Accesorio extends Articulo {
    
    private String descripcion;

    public Accesorio(String descripcion, String codigo, String marca, String nombre, double precioVenta) {
        super(codigo, marca, nombre, precioVenta);
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Accesorio{" + "descripcion=" + descripcion + '}';
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
