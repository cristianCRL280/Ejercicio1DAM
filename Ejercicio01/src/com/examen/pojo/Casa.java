/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.pojo;

/**
 *
 * @author dev
 */
public class Casa {
    private String identificador;
    private String direccion;
    private String poblacion;
    private String provincia;

    public Casa(String identificador, String direccion, String poblacion, String provincia) {
        this.identificador = identificador;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Casa{" + "identificador=" + identificador + ", direccion=" + direccion + ", poblacion=" + poblacion + ", provincia=" + provincia + '}';
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
    
    
    
}
