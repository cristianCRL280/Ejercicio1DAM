/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.dao.implement;

import com.mh.dao.interfaces.VentaDAO;
import com.mh.dao.pojo.Venta;
import java.sql.*;
import com.mh.utils.*;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public class VentaDAOimpl implements VentaDAO, AutoCloseable {

    static {
        try {
            Class.forName(Utils.DRIVER);
        } catch (ClassNotFoundException ex) {
            System.exit(1);
        } catch (Exception e) {
            System.exit(1);
        }
    }

    Connection c = null;

    public VentaDAOimpl() throws Exception {
        c = DriverManager.getConnection(Utils.URL);
    }

    public ArrayList<Venta> getVenta() throws Exception {
        Venta v;
        ArrayList al = new ArrayList();
        ResultSet rs = null;
        String consulta = "SELECT fecha_hora, posicion, nombre, precio, tipo, cantidad FROM venta";
        try (PreparedStatement ps = c.prepareCall(consulta);) {
            rs = ps.executeQuery();
            while (rs.next()) {
                v = new Venta(rs.getString("fecha_hora"), rs.getString("posicion"), rs.getString("nombre"), rs.getDouble("precio"), rs.getString("tipo"), rs.getInt("cantidad"));
                al.add(v);
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return al;
    }

    public int addVenta(Venta v) throws Exception {

        String consulta = "INSERT INTO venta VALUES(datetime('now'),?,?,?,?,?)";
        int r = 0;
        try (PreparedStatement ps = c.prepareStatement(consulta);) {
            ps.setString(1, v.getPosicion());
            ps.setString(2, v.getNombre());
            ps.setDouble(3, v.getPrecio());
            ps.setString(4, v.getTipo());
            ps.setInt(5, v.getCantidad());
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        }
        return r;
    }

  
    public void close() throws Exception {
        c.close();
    }


}
