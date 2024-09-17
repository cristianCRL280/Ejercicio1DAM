/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioClasesDaw;

/**
 *
 * @author dev
 */
public class Leon extends Animal {

    private String color;

    public Leon(String color, String nombre, String codigo, Double energia) {
        super(nombre, codigo, energia);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "Leon{" + "color=" + color + '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void dormir() {
            super.setEnergia(super.getEnergia() * 2.5);


    }
}
