/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio06Maps;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author dev
 */
public class Empleado  {
   static int contadorEmpleados = 0;
    private String codigo;
    private String nombre;
    private String apellidos;
    private LocalDate fNac;

    public Empleado(String codigo, String nombre, String apellidos, LocalDate fNac) {
        contadorEmpleados++;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fNac = fNac;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    
    
    
    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fNac=" + fNac + '}';
    }

    
    public LocalDate getfNac() {
        return fNac;
    }

    public void setfNac(LocalDate fNac) {
        this.fNac = fNac;
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
