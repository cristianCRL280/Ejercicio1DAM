/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerenciaEjemplo01;

/**
 *
 * @author dev
 */
public class Ave  extends Animal{
    String tipoPlumaje;
    
    
    
    public Ave(){
        super();
    }
    
     public Ave(String nombre, String genero) {
       super(nombre,genero);
    }

     
     
     
    public Ave(String nombre, int energia) {
     super(nombre,energia);
    }
    
    public void setPeso(double peso){
        
        if (peso < 0.01d) {
            super.peso = 0.01d;
            
            
        } else {
            super.peso = peso;
            
        }
        
    }
    
    
}
