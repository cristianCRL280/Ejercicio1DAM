/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motogp;

/**
 *
 * @author dev
 */
public abstract class Corredores {

    private int Dorsal;
    private String nombre;
    private int mundiales;
    private int vueltasRecorridas;

    public Corredores(int Dorsal, String nombre, int mundiales, int vueltasRecorridas) {
        this.Dorsal = Dorsal;
        this.nombre = nombre;
        this.mundiales = mundiales;
        this.vueltasRecorridas = vueltasRecorridas;
    }

    @Override
    public String toString() {
        return "Corredores{" + "Dorsal=" + Dorsal + ", nombre=" + nombre + ", mundiales=" + mundiales + ", vueltasRecorridas=" + vueltasRecorridas + '}';
    }

    public int getMundiales() {
        return mundiales;
    }

    public void setMundiales(int mundiales) {
        this.mundiales = mundiales;
    }

    public int getDorsal() {
        return Dorsal;
    }

    public void setDorsal(int Dorsal) {
        this.Dorsal = Dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVueltasRecorridas() {
        return vueltasRecorridas;
    }

    public void setVueltasRecorridas(int vueltasRecorridas) {
        this.vueltasRecorridas = vueltasRecorridas;
    }

}
