/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioA;

import java.time.LocalDate;

/**
 *
 * @author dev
 */
public class jugadorCampo extends persona implements Comparable {

    private int golesMarcados;

    public jugadorCampo(int golesMarcados, String identificador, String nombre, String apellidos, LocalDate fecha_nac, double energia) {
        super(identificador, nombre, apellidos, fecha_nac, energia);
        this.golesMarcados = golesMarcados;
    }

    public jugadorCampo(String identificador, String nombre, String apellidos, LocalDate fecha_nac, double energia) {
        super(identificador, nombre, apellidos, fecha_nac, energia);
    }

    @Override
    public String toString() {
        return super.toString() + "jugadorCampo{" + "golesMarcados=" + golesMarcados + '}';
    }

    @Override
    public void doping() {
        super.setEnergia(super.getEnergia() * 0.20);
        if (super.getEnergia() > 100) {
            super.setEnergia(100);
        }
    }

    public int getGolesMarcados() {
        return golesMarcados;
    }

    public void setGolesMarcados(int golesMarcados) {
        this.golesMarcados = golesMarcados;
    }

    @Override
    public int compareTo(Object o) {
        jugadorCampo otro = (jugadorCampo) o;

      return otro.golesMarcados - this.golesMarcados;
        
        
    }

}
