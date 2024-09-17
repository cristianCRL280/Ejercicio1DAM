/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristian.pojo;

import com.cristian.implementations.JugadorDAOimpl;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public class Jugador {
    private String codigo;
    private String nombre;
    private String procedencia;
    private String altura;
    private String peso;
    private String posicion;
    private String Nombre_equipo;

    public Jugador(String codigo, String nombre, String procedencia, String altura,String peso, String posicion, String Nombre_equipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.procedencia = procedencia;
        this.altura = altura;
        this.peso = peso;
        this.posicion = posicion;
        this.Nombre_equipo = Nombre_equipo;
    }

   

     public ArrayList<Jugador> recogerJugadores() throws Exception {
        JugadorDAOimpl impl = new JugadorDAOimpl();
        ArrayList<Jugador> al = (ArrayList<Jugador>) impl.getJugadorByFilter(codigo, nombre, procedencia, altura, peso, posicion, Nombre_equipo);
        return al;
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "codigo=" + codigo + ", nombre=" + nombre + ", procedencia=" + procedencia + ", altura=" + altura + ", peso=" + peso + ", posicion=" + posicion + ", Nombre_equipo=" + Nombre_equipo + '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombre_equipo() {
        return Nombre_equipo;
    }

    public void setEquipo(String Nombre_equipo) {
        this.Nombre_equipo = Nombre_equipo;
    }
    
    
 

}
