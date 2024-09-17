/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.obj.DAO.implementations;

import com.obj.DAO.interfaces.ProductoDAO;
import com.obj.biz.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev
 */
public class ProductoDAOimpl implements AutoCloseable,ProductoDAO{
    
    static {
        try {
            Class.forName(com.obj.utils.Configuration.DRIVER);
        } catch (Exception e) {
            System.exit(1);
        }
    }
    
    Connection con = null;
    
    public ProductoDAOimpl() throws Exception {
        con = DriverManager.getConnection(com.obj.utils.Configuration.URL);
    }
    
    
    
    
    @Override
    public void close() throws Exception {
        con.close();
    }

    @Override
    public int insertProductos(Producto p) throws Exception {
        int n = 0;
        String sql = "insert into producto values (?,?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, p.getCodigo());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getCategoria());
            pstm.setDouble(4, p.getPrecio());
            n = pstm.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
        return n;
    }

    @Override
    public void deleteProductos() throws Exception {
        String sql = "delete from producto";
        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            int r = pstm.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public List<Producto> getProductos() throws Exception {
        String sql = "select * from producto";
        ResultSet rs = null;
        ArrayList<Producto> al = new ArrayList<>();
        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            rs = pstm.executeQuery();
            while (rs.next()) {
                Producto c = new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                al.add(c);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
        }
        return al;
    }
    
}
