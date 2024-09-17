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
public class DescifrarCesar {

    public static void main(String[] args) {
        int clave = 0;
        String nombreFicheroOriginal = "";
        String nombreFicheroFinal = "";
        if (args.length == 2) {
            nombreFicheroOriginal = args[0];
            clave = Integer.parseInt(args[1]);
            System.out.println("Descifrado con clave....");
            clave = clave * -1;
            nombreFicheroFinal = nombreFicheroOriginal + ".uncfr";
            System.out.println("Fichero origen " + nombreFicheroOriginal);
            System.out.println("Fichero destino " + nombreFicheroFinal);

            try {

                Utils.tratarFicheros(nombreFicheroOriginal, nombreFicheroFinal, clave);

            } catch (Exception ex) {

                System.out.println("Se ha producido un error en el tratamiento de los ficheros");

            }

        } else {

            System.out.println("Numero de parametros incorrectos");

        }

    }
}
