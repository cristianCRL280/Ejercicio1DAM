/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio05Maps;

/**
 *
 * @author dev
 */
public class Videojuego  extends Articulo{
    String categoria;
    double precioAlquiler;

    public Videojuego(String categoria, double precioAlquiler, String codigo, String marca, String nombre, double precioVenta) {
        super(codigo, marca, nombre, precioVenta);
        this.categoria = categoria;
        this.precioAlquiler = precioAlquiler;
    }

    

    @Override
    public String toString() {
        return "Videojuego{" + "categoria=" + categoria + ", precioAlquiler=" + precioAlquiler + '}';
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
    
}
