/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danielm.mh.dao.implementations;

import com.danielm.dao.interfaces.HeladoDAO;
import com.danielm.mh.pojo.Helado;
import java.sql.*;
import java.util.*;
import com.danielm.mh.utils.Utils;

/**
 *
 * @author Daniel Marin y Cristian Rodriguez
 */
public class HeladoDAOimpl implements HeladoDAO, AutoCloseable {

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

    public HeladoDAOimpl() throws Exception {
        c = DriverManager.getConnection(Utils.URL);
    }

    @Override
    public ArrayList<Helado> getHelados() throws Exception {
        ArrayList<Helado> h = new ArrayList<>();
        String consulta = "SELECT posicion, nombre, precio, tipo, cantidad FROM helado";
        try (PreparedStatement ps = c.prepareStatement(consulta); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                h.add(new Helado(rs.getString("posicion"), rs.getString("nombre"), rs.getDouble("precio"), rs.getString("tipo"),
                        rs.getInt("cantidad")));
            }
        } catch (Exception e) {
            throw e;
        }
        return h;
    }

    @Override
    public Helado getHeladoByPosition(String posicion) throws Exception {
        ResultSet rs = null;
        Helado h = null;
        String consulta = "SELECT posicion, nombre, precio, tipo, cantidad FROM helado WHERE posicion = ?";
        try (PreparedStatement ps = c.prepareStatement(consulta);) {
            ps.setString(1, posicion);
            rs = ps.executeQuery();
            if (rs.next()) {
                h = new Helado(rs.getString("posicion"), rs.getString("nombre"), rs.getDouble("precio"), rs.getString("tipo"),
                        rs.getInt("cantidad"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return h;
    }

    @Override
    public int updateHelado(Helado h) throws Exception {
        String consulta = "UPDATE helado SET nombre = ?, precio = ?, tipo = ?, cantidad = ? WHERE posicion = ?";
        int r = 0;
        try (PreparedStatement ps = c.prepareStatement(consulta);) {
            ps.setString(1, h.getNombre());
            ps.setDouble(2, h.getPrecio());
            ps.setString(3, h.getTipo());
            ps.setInt(4, h.getCantidad());
            ps.setString(5, h.getPosicion());
            r = ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
        return r;
    }

    @Override
    public void close() throws Exception {
        c.close();
    }

    

}
