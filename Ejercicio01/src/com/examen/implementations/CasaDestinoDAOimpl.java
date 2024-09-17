/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.implementations;

import com.examen.dao.interfaces.CasaDestinoDAO;
import com.examen.pojo.Casa;
import com.examen.utils.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev
 */
public class CasaDestinoDAOimpl implements CasaDestinoDAO, AutoCloseable {

    static {
        try {
            Class.forName(Utils.DRIVER);
        } catch (ClassNotFoundException ex) {
            System.exit(1);
        }
    }

    Connection con = null;

    public CasaDestinoDAOimpl() throws Exception {
        con = DriverManager.getConnection(Utils.URL);
    }

    @Override
    public void close() throws Exception {

        if (con != null && !con.isClosed()) {
            con.close();
        }

    }

    @Override
    public void borrarDatos() throws Exception {
        String sql = "delete from casa_destino";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public void insertarDatos(Casa c) throws Exception {
        String sql = "insert into casa_destino(identificador,direccion,poblacion,provincia) values (?,?,?,?)";
        try (PreparedStatement stm = con.prepareStatement(sql);) {

            stm.setString(1, c.getIdentificador());
            stm.setString(2, c.getDireccion());
            stm.setString(3, c.getPoblacion());
            stm.setString(4, c.getProvincia());

            stm.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }

    }

}
