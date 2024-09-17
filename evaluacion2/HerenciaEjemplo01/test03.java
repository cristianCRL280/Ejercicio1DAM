/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerenciaEjemplo01;

/**
 *
 * @author dev
 */
public class test03 {
    public static void main(String[] args) {
        Gato g = new Gato();
        g.setNombre("Pepe");
        g.setGenero("Macho");
        g.setPeso(2.8d);
        
        System.out.println(g);
        
        Perro p = new Perro("Pepe", "Hembra");
        p.setPeso(2.8d);
        
        if (g.equals(p)) {
            System.out.println("Son el mismo");
            
        } else {
            
            System.out.println("No son el mismo");
            
        }
        Animal a = new Pajaro();
        
        if (a instanceof Pajaro) {
            System.out.println("lo que tengo es un pajaro");
            
        }
        if(a.getClass().getSimpleName().equals("Pajaro")){
            
            System.out.println("Tenemos un pajaro");
        }
    }
}
