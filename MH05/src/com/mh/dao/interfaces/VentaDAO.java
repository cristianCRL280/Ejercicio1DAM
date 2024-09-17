/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mh.dao.interfaces;

import com.mh.dao.pojo.Venta;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public interface VentaDAO {
    public int addVenta(Venta v) throws Exception;
   public ArrayList<Venta> getVenta() throws Exception;
    
}
