/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.files;

/**
 *
 * @author dev
 */
public class Persona {
    private String codigo;
        private String nombre;
        private String apellidos;
        private double salario;

    public Persona(String codigo, String nombre, String apellidos, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Persona{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", salario=" + salario + '}';
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
        
}
