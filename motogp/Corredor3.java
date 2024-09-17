/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motogp;

/**
 *
 * @author dev
 */
public class Corredor3 extends Corredores {
    
    
    private double MejorVuelta;
    private String NeumaticosElegidos;

    public Corredor3(double MejorVuelta, String NeumaticosElegidos, int Dorsal, String nombre, int mundiales, int vueltasRecorridas) {
        super(Dorsal, nombre, mundiales, vueltasRecorridas);
        this.MejorVuelta = MejorVuelta;
        this.NeumaticosElegidos = NeumaticosElegidos;
    }

    @Override
    public String toString() {
        return super.toString() + "Corredor1{" + "MejorVuelta=" + MejorVuelta + ", NeumaticosElegidos=" + NeumaticosElegidos + '}';
    }
    
    

    public double getMejorVuelta() {
        return MejorVuelta;
    }

    public void setMejorVuelta(double MejorVuelta) {
        this.MejorVuelta = MejorVuelta;
    }

    public String getNeumaticosElegidos() {
        return NeumaticosElegidos;
    }

    public void setNeumaticosElegidos(String NeumaticosElegidos) {
        this.NeumaticosElegidos = NeumaticosElegidos;
    }

    
  

   
    
}
