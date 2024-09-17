/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.danielm.dao.interfaces;

import com.danielm.mh.pojo.*;
import java.util.ArrayList;

/**
 *
 * @author Daniel Marin y Cristian Rodriguez
 */
public interface VentaDAO {
    public ArrayList<Venta> getVenta() throws Exception;
    public int addVenta(Venta v) throws Exception;
}
