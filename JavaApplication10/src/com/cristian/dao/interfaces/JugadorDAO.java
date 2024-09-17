/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cristian.dao.interfaces;

import com.cristian.pojo.Jugador;
import java.util.List;

/**
 *
 * @author dev
 */
public interface JugadorDAO {

    public List<Jugador> getJugadorByFilter(String codigo,
            String nombre,
            String procedencia,
            String altura,
            String peso,
            String posicion,
            String Nombre_equipo)
            throws Exception;
}
