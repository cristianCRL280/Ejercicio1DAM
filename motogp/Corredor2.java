/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motogp;

/**
 *
 * @author dev
 */
public class Corredor2 extends Corredores{
    
    private String colorMoto;
    private String nombreEscape;

    public Corredor2(String colorMoto, String nombreEscape, int Dorsal, String nombre, int mundiales, int vueltasRecorridas) {
        super(Dorsal, nombre, mundiales,vueltasRecorridas);
        this.colorMoto = colorMoto;
        this.nombreEscape = nombreEscape;
    }
 @Override
    public String toString() {
   return super.toString() + "Corredor2{" + "colorMoto=" + colorMoto + ", nombreEscape=" + nombreEscape + '}';
    }
   
  

    public String getColorMoto() {
        return colorMoto;
        
    
        
    }

   

    public void setColorMoto(String colorMoto) {
        this.colorMoto = colorMoto;
    }

    public String getNombreEscape() {
        return nombreEscape;
    }

    public void setNombreEscape(String nombreEscape) {
        this.nombreEscape = nombreEscape;
    }

   
    
    
}
