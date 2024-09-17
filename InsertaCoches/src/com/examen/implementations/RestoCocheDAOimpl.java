/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.implementations;

import com.examen.pojo.Coche;
import com.examen.utils.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import com.examen.dao.interfaces.RestoCocheDAO;

/**
 *
 * @author dev
 */
public class RestoCocheDAOimpl implements RestoCocheDAO, AutoCloseable {

    static {
        try {
            Class.forName(Utils.DRIVER);
        } catch (ClassNotFoundException ex) {
            System.exit(1);
        }
    }
    Connection con = null;

    public RestoCocheDAOimpl() throws Exception {
        con = DriverManager.getConnection(Utils.URL);
    }

    @Override
    public void close() throws Exception {

        if (con != null && !con.isClosed()) {
            con.close();
        }

    }

   
    @Override
    public int insertarRestoCoches(Coche c) throws Exception {
        String sql = "INSERT INTO RestoCoches VALUES(?,?,?,?);";
        int numMod = 0;
        try (
                PreparedStatement pstm = con.prepareStatement(sql);) {

            pstm.setString(1, c.getMatricula());
            pstm.setString(2, c.getMarca());
            pstm.setString(3, c.getModelo());
            pstm.setString(4, c.getColor());
            pstm.executeUpdate();
            numMod++;

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return numMod++;
    }
}
