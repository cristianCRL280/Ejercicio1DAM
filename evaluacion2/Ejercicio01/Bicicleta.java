/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio01;

/**
 *
 * @author dev
 */
public class Bicicleta {
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private String nSerie;
    private Componente[]cs;

    public Bicicleta(String marca, String modelo, String color, String tipo, String nSerie, Componente[] cs) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.nSerie = nSerie;
        this.cs = cs;
    }
 

    
 
    
    
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public Componente[] getCs() {
        return cs;
    }

    public void setCs(Componente[] cs) {
        this.cs = cs;
    }
    
      
public double getSumaPesoComponentes(){
    
    double r = 0;
    
    for (Componente c : cs) {
        r+= c.getPeso();
    }
    
    return r;
    
}
    
    
    
    
    
    
}
