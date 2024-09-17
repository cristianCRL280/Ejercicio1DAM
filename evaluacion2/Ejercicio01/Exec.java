/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio01;

/**
 *
 * @author dev
 */
public class Exec {

    public static void main(String[] args) {

        Componente[] cs = new Componente[4];
        cs[0] = new Componente("ruedas", 40d);
        cs[1] = new Componente("amortiguador", 20d);
        cs[2] = new Componente("timbre", 10d);
        cs[3] = new Componente("sillin", 20d);

        Bicicleta b1 = new Bicicleta("Orbea", "montera", "rojo", "montaña", "353634", cs);

        System.out.println("marca: " + b1.getMarca());
        System.out.println("modelo: " + b1.getModelo());
        System.out.println("peso " + b1.getSumaPesoComponentes());

    }

}
