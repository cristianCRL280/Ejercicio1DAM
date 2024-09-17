/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danielm.mh.pojo;

import com.danielm.mh.utils.Utils;

/**
 *
 * @author Daniel Marin y Cristian Rodriguez
 */
public class Helado {
    private String posicion;
    private String nombre;
    private double precio;
    private String tipo;
    private int cantidad;

    public Helado(String posicion, String nombre, double precio, String tipo) {
        this.posicion = posicion;
        this.nombre = nombre;
        this.precio = Utils.redondeoDecimales(precio);
        this.tipo = tipo;
    }
    
    public Helado(String posicion, String nombre, double precio, String tipo, int cantidad) {
        this.posicion = posicion;
        this.nombre = nombre;
        this.precio = Utils.redondeoDecimales(precio);
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return  posicion + " :: " + nombre + " :: " + precio + "€ :: " + tipo + " :: " + cantidad ;
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPosicion() {
        return posicion;
    }
}
