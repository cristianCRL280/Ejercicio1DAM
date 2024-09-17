/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author dev
 */
public class Descomprimir {

    public static void main(String[] args) {
        int contador;
        int numero;
        String nombreFileInput;
        String nombreFileOutput;
        if (args.length == 1) {
            nombreFileInput = args[0];
            nombreFileOutput = args[0] + ".comprimido";
        } else {
            nombreFileInput = "./numbers.dat.comprimido";
            nombreFileOutput = ".numbers.dat.result";
        }
        try (FileInputStream fis = new FileInputStream(nombreFileInput);
                FileOutputStream fos = new FileOutputStream(nombreFileOutput);
                DataInputStream dis = new DataInputStream(fis); 
                DataOutputStream dos = new DataOutputStream(fos);) {
            while (dis.available() != 0) {
                contador = dis.readInt();
                numero = dis.readInt();
                for (int i = 0; i < contador; i++) {
                    dos.writeInt(numero);
                }

            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
