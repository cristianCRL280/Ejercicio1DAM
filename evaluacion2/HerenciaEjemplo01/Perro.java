/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerenciaEjemplo01;

/**
 *
 * @author dev
 */
public class Perro extends Animal {

    int numDientes;

    public Perro(String nombre, String genero) {
        super(nombre, genero);
    }

    
    
    
    public void comer() {
        super.setEnergia(this.getEnergia() + 5);

    }
    
    
    
    
}
