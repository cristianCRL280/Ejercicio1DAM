/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerenciaEjemplo01;

/**
 *
 * @author dev
 */
public class test02 {

    public static void main(String[] args) {
        Animal a = new Perro("pepe", "macho");
        Perro p = new Perro("pepe", "macho");
        System.out.println("El peso del perro pepe es de: " + p.getPeso());

        Rapaz r = new Rapaz();
        r.setNombre("Maria");
        r.setGenero("Hembra");
        r.tipoPlumaje = "largo";

        Animal[] zoo = new Animal[4];
        zoo[0] = p;
        zoo[1] = new Gato();
        zoo[2] = new Rapaz();
        zoo[3] = new Pajaro();

        for (Animal an : zoo) {
            an.setPeso(0.4d);

        }
        for (Animal an : zoo) {
            if (an instanceof Pajaro) {
                Pajaro tmp = (Pajaro)an;
                tmp.dormir();
                System.out.println("He puesto a dormir a un pajaro");
                
            }

        }

        Ave avechuco;
        avechuco = new Ave();
        avechuco = new Ave("Pepe", "Macho");
        avechuco = new Ave("pepe", 5);
        Pajaro pj = new Pajaro();
        pj.dormir(8);
        System.out.println("la energia del pajaro es: " + pj.getEnergia());
    }

}
