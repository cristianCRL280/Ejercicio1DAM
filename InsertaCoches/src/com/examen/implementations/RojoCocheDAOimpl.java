/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.implementations;

import com.examen.dao.interfaces.*;
import com.examen.pojo.Coche;
import com.examen.utils.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public class RojoCocheDAOimpl implements RojoCocheDAO, AutoCloseable {

    static {
        try {
            Class.forName(Utils.DRIVER);
        } catch (ClassNotFoundException ex) {
            System.exit(1);
        }
    }
    Connection con = null;

    public RojoCocheDAOimpl() throws Exception {
        con = DriverManager.getConnection(Utils.URL);
    }

    @Override
    public void close() throws Exception {

        if (con != null && !con.isClosed()) {
            con.close();
        }

    }

    @Override
    public int insertarCochesRojos(Coche c) throws Exception {
        String sql = "INSERT INTO CocheRojo VALUES(?,?,?);";
        int numMod = 0;
        try (
                PreparedStatement pstm = con.prepareStatement(sql);) {

            pstm.setString(1, c.getMatricula());
            pstm.setString(2, c.getMarca());
            pstm.setString(3, c.getModelo());
            pstm.executeUpdate();
            numMod++;

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return numMod++;

    }

}
