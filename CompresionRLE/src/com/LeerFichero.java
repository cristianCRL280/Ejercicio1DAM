/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 *
 * @author dev
 */
public class LeerFichero {
    public static void main(String[] args) {
     String nombreFile="";
        if (args.length == 1) {
            nombreFile = args[0];
        } else {
            nombreFile = ".numbers.dat";
            
        }
        try (FileInputStream fis = new FileInputStream(nombreFile);
                DataInputStream dis = new DataInputStream(fis);){
            while(dis.available() != 0 ){
                
                System.out.println(dis.readInt());
            }
            
            
        } catch (Exception e){
            
            System.out.println("Se ha producido un problema");
        }
    }
}
