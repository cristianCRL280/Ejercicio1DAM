/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rol.personajes;

import com.exceptions.TooLowNumberException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dev
 */
public class Clan {

//    private ArrayList<Personajes> al = new ArrayList<Personajes>(); con arraylist
    private HashMap<String, Personajes> al = new HashMap<String, Personajes>(); // con hashmap
    private String codigo;
    private String nombre;

    public Clan(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void addPersonaje(Personajes p) {

        this.al.put(p.getCodigo(), p);
    }
//public void borarElfosByLargOrejas(double largOrejas){   Recorrer con arrayList
//        
//    for (int i = 0; i < this.al.size(); i++) {
//        
//        if (this.al.get(i) instanceof Elfo) {
//            Elfo e = (Elfo)this.al.get(i);
//            if (e.getLongitudOrejas() > largOrejas) {
//                
//                this.al.remove(i);
//                i--;
//            }
//        }
//        
//    }
//        
//}

    //recorrer con hashmap
                public void borarElfosByLargOrejas(double largOrejas) {
ArrayList<String> keyBorrar = new ArrayList<String>();
        for (Map.Entry<String, Personajes> entry : al.entrySet()) {
            String key = entry.getKey();
            Personajes val = entry.getValue();
            
            
            if (val instanceof Elfo) {
                Elfo e = (Elfo)val; 
                
                if (e.getLongitudOrejas()> largOrejas) {
                    keyBorrar.add(key);
                }
                
            }
        }
        for (String key : keyBorrar) {
            this.al.remove(key);
            
        }
        
    }

    public void herir(int herida) {

        for (Personajes p : al.values()) {
            p.herir(herida);
        }

    }

    public Mago getBestMago() {
        ArrayList<Mago> ms = new ArrayList<Mago>();
        for (Personajes p : al.values()) {

            if (p instanceof Mago) {

                ms.add((Mago) p);

            }
        }
       
        return Collections.max(ms);
    }

    public int getNumPersonajesByTipo(String tipo) {

        int r = 0;
        for (Personajes p : al.values()) {
            if (p.getClass().getSimpleName().equals(tipo)) {
                r++;
            }
        }

        return r;

    }

    public int getSumaPuntosVidaByTipo(String tipo) {
        int r = 0;
        for (Personajes p : al.values()) {
            if (p.getClass().getSimpleName().equals(tipo)) {
                r += p.getPuntosVida();
            }
        }

        return r;
    }

    public void cambiarColorTogaMagos(String colorAntes, String colorDespues) throws TooLowNumberException {
        for (Personajes p : al.values()) {

            if (p instanceof Mago) {

                Mago m = (Mago) p;

                if (m.getColorToga().equalsIgnoreCase(colorAntes)) {

                    m.setColorToga(colorDespues);

                }

            }

        }

    }

    public void pocimaSanadoraMagos(String color) {

        for (Personajes p : al.values()) {

            if (p instanceof Mago) {

                Mago m = (Mago) p;

                if (m.getColorToga().equalsIgnoreCase(color)) {

                    m.pocimaSanadora();

                }

            }

        }
    }

    @Override
    public String toString() {
        String r = "Clan{" + "al=" + al + ", codigo=" + codigo + ", nombre=" + nombre + '}';

        for (Personajes p : al.values()) {

            r += p.toString() + "\n";
        }
        return r;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
