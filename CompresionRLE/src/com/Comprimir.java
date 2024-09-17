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
public class Comprimir {

    public static void main(String[] args) {
        String nombreFileInput;
        String nombreFileOutput;
        boolean inicio = true;
        int numero;
        int anterior = 0;
        int contador = 0;
        if (args.length == 1) {
            nombreFileInput = args[0];
            nombreFileOutput = args[0] + ".comprimido";
        } else {
            nombreFileInput = "./numbers.dat";
            nombreFileOutput = "./numbers.dat.comprimido";
        }
        try (FileInputStream fis = new FileInputStream(nombreFileInput); FileOutputStream fos = new FileOutputStream(nombreFileOutput); DataInputStream dis = new DataInputStream(fis); DataOutputStream dos = new DataOutputStream(fos);) {

            while (dis.available() != 0) {
                numero = dis.readInt();
                if (inicio == true) {
                    inicio = false;
                    anterior = numero;
                    contador = 1;
                } else {
                    if (numero == anterior) {
                        contador++;
                    } else {

                        dos.writeInt(contador);
                        dos.writeInt(anterior);
                        anterior = numero;
                        contador = 1;
                    }
                }

            }
            dos.writeInt(contador);
            dos.writeInt(anterior);

        } catch (Exception e) {
            System.out.println("Se ha producido un problema");
        }

    }
}
