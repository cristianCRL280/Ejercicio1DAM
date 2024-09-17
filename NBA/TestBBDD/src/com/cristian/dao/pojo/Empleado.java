/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristian.dao.pojo;

/**
 *
 * @author dev
 */
public class Empleado {
    private int id;
    private String nombre;
    private String dni;
    private int idJefe;

    public Empleado(int id, String nombre, String dni, int idJefe) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.idJefe = idJefe;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", idJefe=" + idJefe + '}';
    }
    
    

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
}
