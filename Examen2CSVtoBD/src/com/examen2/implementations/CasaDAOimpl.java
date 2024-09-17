/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2.implementations;

import com.examen2.dao.interfaces.CasaDAO;
import com.examen2.pojo.Casa;
import com.examen2.utils.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 *
 * @author dev
 */
public class CasaDAOimpl implements CasaDAO, AutoCloseable {

    static {
        try {
            Class.forName(Utils.DRIVER);
        } catch (ClassNotFoundException ex) {
            System.exit(1);
        }
    }
    Connection con = null;

    public CasaDAOimpl() throws Exception {
        con = DriverManager.getConnection(Utils.URL);
    }

    @Override
    public void close() throws Exception {

        if (con != null && !con.isClosed()) {
            con.close();
        }

    }

    @Override
    public void deleteCasas() throws Exception {

        String sql = "delete from casa";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println( e.getMessage());
         

        }
    }

   
    @Override
    public void insertarCasas(Casa c) throws Exception { 
        String sql = "insert into casa(identificador,direccion,poblacion,provincia) values (?,?,?,?)";
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

