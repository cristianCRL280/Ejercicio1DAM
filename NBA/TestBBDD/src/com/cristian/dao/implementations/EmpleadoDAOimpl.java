/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristian.dao.implementations;

import com.cristian.dao.interfaces.EmpleadoDAO;
import com.cristian.dao.pojo.Empleado;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public class EmpleadoDAOimpl implements EmpleadoDAO, AutoCloseable {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.exit(1);
        }
    }

    Connection con = null;

    public EmpleadoDAOimpl() throws Exception {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
    }

    @Override
    public List<Empleado> getEmpleadoByIdJefe(int idJefe) throws Exception {
        List<Empleado> l = new ArrayList<>();
        Empleado en;
        ResultSet rs = null;
        String sql = "select id, nombre, dni, jefe from EMPLEADO where jefe = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setInt(1, idJefe);
            rs = pstm.executeQuery();
            while (rs.next()) {
                en = new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni"), rs.getInt("jefe"));
                l.add(en);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return l;
    }

    @Override
    public int updateEmpleadoIdJefeByIdJefe(int idJefeAnterior, int idJefePosterior) throws Exception {
        int r = 0;
        String sql = "update EMPLEADO set jefe = ? where jefe = ?";
        try (PreparedStatement stm = con.prepareStatement(sql);) {
            stm.setInt(1, idJefePosterior);
            stm.setInt(2, idJefeAnterior);
            r = stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
        return r;

    }

    public void close() throws Exception {
        con.close();
    }
}
