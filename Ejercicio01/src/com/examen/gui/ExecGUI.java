/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.gui;

import com.examen.implementations.CasaDestinoDAOimpl;
import com.examen.implementations.CasaOrigenDAOimpl;
import com.examen.pojo.Casa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev
 */
public class ExecGUI {

    public static void main(String[] args) {
        List<Casa> casas;

        try (CasaDestinoDAOimpl c = new CasaDestinoDAOimpl(); 
             CasaOrigenDAOimpl co = new CasaOrigenDAOimpl();) {

            c.borrarDatos();

            casas = co.cogerDatos("Leganes");

            for (Casa casa : casas) {
                c.insertarDatos(casa);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

    }

}
