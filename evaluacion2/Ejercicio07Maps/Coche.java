/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio07Maps;

/**
 *
 * @author dev
 */
public class Coche implements Comparable {
    
    String marca;
    String modelo;
    int anyoFabricacion;
    double LitrosRepostados;
    double kmRecorridos;

    public Coche(String marca, String modelo, int anyoFabricacion, double LitrosRepostados, double kmRecorridos) {
        this.marca = marca;
        this.modelo = modelo;
        this.anyoFabricacion = anyoFabricacion;
        this.LitrosRepostados = LitrosRepostados;
        this.kmRecorridos = kmRecorridos;
    }

    @Override
    public String toString() {
        return "Coche{" + "marca=" + marca + ", modelo=" + modelo + ", anyoFabricacion=" + anyoFabricacion + ", LitrosRepostados=" + LitrosRepostados + ", kmRecorridos=" + kmRecorridos + '}';
    }
    
    public double getconsumo100km(){
        
        return LitrosRepostados * 100 / kmRecorridos;
    }

    @Override
    public int compareTo(Object o) {

        Coche otro = (Coche)o;
        
        if (this.getconsumo100km() != otro.getconsumo100km()) {
            
            
            return Double.compare(this.getconsumo100km(), otro.getconsumo100km());
            
        } else if (this.anyoFabricacion != otro.anyoFabricacion){
            
            return Integer.compare(otro.anyoFabricacion, this.anyoFabricacion);
        } else if (this.marca.equals(otro.marca)){
            
            return this.marca.compareTo(otro.marca);
        } else {
            return this.modelo.compareTo(otro.modelo);
        }

    }
}
