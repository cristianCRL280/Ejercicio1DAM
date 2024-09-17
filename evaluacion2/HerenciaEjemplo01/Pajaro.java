/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerenciaEjemplo01;

/**
 *
 * @author dev
 */
public class Pajaro extends Animal {
    String insectosFavoritos;
    
    public void dormir(){
        
        super.setEnergia(100);
        
    }
    public void dormir(int horas){
        
        super.setEnergia((40 * horas));
        
    }
}
