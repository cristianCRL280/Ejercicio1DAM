/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.obj.DAO.interfaces;

import com.obj.biz.Producto;
import java.util.List;

/**
 *
 * @author dev
 */
public interface ProductoDAO {
    
    public int insertProductos(Producto p) throws Exception;
    public void deleteProductos() throws Exception;
    public List<Producto> getProductos() throws Exception;
    
}
