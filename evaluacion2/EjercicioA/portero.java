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
public class portero extends persona {

    private double porcentajeParadas;

    public portero(double porcentajeParadas, String identificador, String nombre, String apellidos,
     LocalDate fecha_nac, double energia) throws PorteroException {
        super(identificador, nombre, apellidos, fecha_nac, energia);
        this.setPorcentajeParadas(porcentajeParadas);
    }

    public portero(String identificador, String nombre, String apellidos, LocalDate fecha_nac, double energia) {
        super(identificador, nombre, apellidos, fecha_nac, energia);
    }

    @Override
    public String toString() {
        return super.toString() + "portero{" + "porcentajeParadas=" + porcentajeParadas + '}';
    }

    @Override
    public void doping() {

        super.setEnergia(super.getEnergia() + (super.getEnergia() * 0.10));

        if (super.getEnergia() > 100) {
            super.setEnergia(100);

        }

        this.porcentajeParadas = this.porcentajeParadas + (this.porcentajeParadas * 0.05d);
        if (this.porcentajeParadas > 100) {
            this.porcentajeParadas = 100;
        }
    }

    public void setPorcentajeParadas(double porcentajeParadas) throws PorteroException {
        this.porcentajeParadas = porcentajeParadas;
        if (porcentajeParadas > 100 || porcentajeParadas < 0) {
            throw new PorteroException(this.getIdentificador() + "no puede tener mas de 100");
        } else {
            this.porcentajeParadas = porcentajeParadas;
        }
    }

    public double getPorcentajeParadas() {
        return porcentajeParadas;
    }

    public double porteroTo(Object o) {
        portero otro = (portero) o;

        return 1.0d * this.porcentajeParadas - otro.porcentajeParadas;
    }

   

}
