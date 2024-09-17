/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio05Maps;

/**
 *
 * @author dev
 */
public class Videoconsola extends Articulo{
    private int anyoFabricacion;

    public Videoconsola(int anyoFabricacion, String codigo, String marca, String nombre, double precioVenta) {
        super(codigo, marca, nombre, precioVenta);
        this.anyoFabricacion = anyoFabricacion;
    }

    @Override
    public String toString() {
        return "Videoconsola{" + "anyoFabricacion=" + anyoFabricacion + '}';
    }

    public int getAnyoFabricacion() {
        return anyoFabricacion;
    }

    public void setAnyoFabricacion(int anyoFabricacion) {
        this.anyoFabricacion = anyoFabricacion;
    }
    
    
    
    
}
