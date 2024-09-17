/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio05Maps;

/**
 *
 * @author dev
 */
public class Articulo {
    private String codigo;
    private String marca;
    private String nombre;
    private double precioVenta;

    public Articulo(String codigo, String marca, String nombre, double precioVenta) {
        this.codigo = codigo;
        this.marca = marca;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Articulo{" + "codigo=" + codigo + ", marca=" + marca + ", nombre=" + nombre + ", precioVenta=" + precioVenta + '}';
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
