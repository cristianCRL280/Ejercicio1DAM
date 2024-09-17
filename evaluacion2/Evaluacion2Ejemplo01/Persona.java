package Evaluacion2Ejemplo01;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dev
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private double peso;
    private int altura;
    private double energia;
    private int tiroLibre;
    private int manejo;
    private int tiroTriple;
    
   public Persona(){
        
        
    }
    public void dormir(int horas){
        this.energia = this.energia + (5 * horas);
        
           
    }
    public void andar(double km){
        this.energia = this.energia - (1 * km);
        
        
    }
    public void correr(double km){
        this.andar(km);
        this.andar(km);
        
    }
 
  
    public Persona(String nombre, String apellidos, double peso, int altura, double energia, int tiroLibre, int manejo, int tiroTriple) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.peso = peso;
        this.altura = altura;
        this.energia = energia;
        this.tiroLibre = tiroLibre;
        this.manejo = manejo;
        this.tiroTriple = tiroTriple;
    }

    public int getTiroTriple() {
        return tiroTriple;
    }

    public void setTiroTriple(int tiroTriple) {
        this.tiroTriple = tiroTriple;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public int getTiroLibre() {
        return tiroLibre;
    }

    public void setTiroLibre(int tiroLibre) {
        this.tiroLibre = tiroLibre;
    }

    public int getManejo() {
        return manejo;
    }

    public void setManejo(int manejo) {
        this.manejo = manejo;
    }
    
}
