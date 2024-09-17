/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristian.cesar.exec;

import com.cristian.cesar.utils.Utils;

/**
 *
 * @author dev
 */
public class DescifrarSinCesar {
    public static void main(String[] args) {
         int clave = 0;
         String nombreFicheroOriginal="";
         String nombreFicheroFinal="";
        if (args.length == 1) {
            System.out.println("Descifrado sin clave...");
            nombreFicheroOriginal = args[0];
            try{
                clave = Utils.calcularClave(nombreFicheroOriginal);
                nombreFicheroFinal = nombreFicheroOriginal + "uncfr";
                System.out.println("Calculo de clave " + clave);
                System.out.println("Fichero de origen" + nombreFicheroOriginal);
                System.out.println("Fichero destino " + nombreFicheroFinal);
                Utils.tratarFicheros(nombreFicheroOriginal, nombreFicheroFinal, clave *-1);
                
            } catch(Exception e){
                
                System.out.println("Se ha producido un error en el tratamiento de los ficheros");
            }
        } else {
            
            System.out.println("Numeros de parametros incorrecto");
            
        }
    }
}
