/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioClasesDaw;

/**
 *
 * @author dev
 */
public class perro extends Animal {

    private Double largoPatas;

    public perro(Double largoPatas, String nombre, String codigo, Double energia) {
        super(nombre, codigo, energia);
        this.largoPatas = largoPatas;
    }

    @Override
    public String toString() {
        return super.toString() + "perro{" + "largoPatas=" + largoPatas + '}';
    }

    public Double getLargoPatas() {
        return largoPatas;
    }

    public void setLargoPatas(Double largoPatas) {
        this.largoPatas = largoPatas;
    }

    @Override
    public void dormir() {

        super.setEnergia(super.getEnergia() + (super.getEnergia() * 3.0d));

        if (super.getEnergia() > 100) {
            super.setEnergia(100);

        }

    }

}
