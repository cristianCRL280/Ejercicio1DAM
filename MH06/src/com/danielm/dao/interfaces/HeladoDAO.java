/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.danielm.dao.interfaces;

import com.danielm.mh.pojo.Helado;
import java.util.*;

/**
 *
 * @author Daniel Marin y Cristian Rodriguez
 */
public interface HeladoDAO {
    public ArrayList<Helado> getHelados() throws Exception;
    public Helado getHeladoByPosition(String posicion) throws Exception;
    public int updateHelado(Helado h) throws Exception;
    
}
