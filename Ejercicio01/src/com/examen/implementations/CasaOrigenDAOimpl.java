/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.implementations;

import com.examen.dao.interfaces.CasaOrigenDAO;
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
public class CasaOrigenDAOimpl implements CasaOrigenDAO, AutoCloseable {

    static {
        try {
            Class.forName(Utils.DRIVER);
        } catch (ClassNotFoundException ex) {
            System.exit(1);
        }
    }

    Connection con = null;

    public CasaOrigenDAOimpl() throws Exception {
        con = DriverManager.getConnection(Utils.URL);
    }

    @Override
    public void close() throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
        }

    }

    @Override
    public List<Casa> cogerDatos(String poblacion) throws Exception {
        List<Casa> casas = new ArrayList<>();
        Casa c;
        int cont = 0;
        String sql = "SELECT * FROM casa_origen WHERE poblacion = ? ";
        ResultSet rs = null;
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            cont++;
            pstm.setString(cont, poblacion);

            rs = pstm.executeQuery();

            while (rs.next()) {
                c = new Casa(
                        rs.getString("identificador"),
                        rs.getString("direccion"),
                        rs.getString("poblacion"),
                        rs.getString("provincia")
                );
                casas.add(c);
            }
        } catch (Exception e) {
            System.out.println("Problemas al intentar recuperar la información");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el resultset");
                }
            }
        }
        return casas;

    }
}
