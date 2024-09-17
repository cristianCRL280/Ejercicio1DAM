/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.casas.dao.interfaces;

import com.casas.dao.pojo.Casas;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public interface CasasDAO {
    public int insertarDatos(ArrayList<Casas> cs) throws Exception;
    public void borrarDatos() throws Exception;
}
