/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motogp;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) {
        Corredores[] equipo = new Corredores[3];

        equipo[0] = new Corredor1(2.6d, "Medios", 93, "MarcMarquez", 8, 7);
        equipo[1] = new Corredor2("Azul", "Akrapovic", 20, "FabioQuartararo", 1, 4);
        equipo[2] = new Corredor3(3.6d, "Medios", 73, "AlexMarquez", 0, 2);
        
        
        for (Corredores Corredores : equipo) {
            
            System.out.println(Corredores);
            
        }
    }
}
