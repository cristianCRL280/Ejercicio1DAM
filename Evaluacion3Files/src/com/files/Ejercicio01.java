/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.files;

import java.io.File;
//1.- Desarrollar un programa Java que utilice el método listFiles() para mostrar la lista de
//ficheros de un directorio cualquiera o el directorio actual. El nombre del directorio se pasará
//como argumento de main(). Si no se le pasase nada en main(), mostrar el listado de ficheros
//del directorio actual.

/**
 *
 * @author dev
 */
public class Ejercicio01 {
    public static void main(String[] args) {    
      
        String nombre;
        File directorio;
        if (args.length == 0) {
            
            nombre=".";
            
            
        } else {
            
            nombre = args[0];
            
        }
              directorio = new File(nombre);
        if (!directorio.exists()) {
            
            System.out.println("No existe");
        } else if (directorio.isFile()) {
            
            System.out.println("Es fichero");
        } else {
            
            File[] listaFicheros = directorio.listFiles();
            for (int i = 0; i < listaFicheros.length; i++) {
                
                System.out.println(listaFicheros[i].getName());
                
                System.out.println("lectura: " + listaFicheros[i].canRead());
                System.out.println("escritura: " + listaFicheros[i].canWrite());
                System.out.println("ejecucion: " + listaFicheros[i].canExecute());
                System.out.println("directorio: " + listaFicheros[i].isDirectory());
            }
        
        }
        
    }
}
