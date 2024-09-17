/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.implementations;

import com.examen.dao.interfaces.CocheDAO;
import com.examen.pojo.Coche;
import com.examen.utils.Utils;
import static com.examen.utils.Utils.URL;
import java.io.File;
import java.io.FileWriter;
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
public class CocheDAOimpl implements CocheDAO, AutoCloseable {

    static {
        try {
            Class.forName(Utils.DRIVER);
        } catch (ClassNotFoundException ex) {
            System.exit(1);
        }
    }

    Connection con = null;

    public CocheDAOimpl() throws Exception {
        con = DriverManager.getConnection(Utils.URL);
    }

    @Override
    public void close() throws Exception {

        if (con != null && !con.isClosed()) {
            con.close();
        }

    }

    @Override
    public List<Coche> getCocheByFilter(String fichero, String matricula, String marca, String modelo, String color) throws Exception {
        List<Coche> coches = new ArrayList<>();
        Coche c;

        String sql = "SELECT * FROM coche WHERE 1=1 ";
        int cont = 0;

        if (matricula != null && !String.valueOf(matricula).equals("")) {
            sql += "AND coche.matricula LIKE ? ";
        }
        if (marca != null && !String.valueOf(marca).equals("")) {
            sql += "AND coche.marca LIKE ? ";
        }
        if (modelo != null && !String.valueOf(modelo).equals("")) {
            sql += "AND coche.modelo LIKE ? ";
        }
        if (color != null && !String.valueOf(color).equals("")) {
            sql += "AND coche.color LIKE ? ";
        }

        ResultSet rs = null;

        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            if (matricula != null && !String.valueOf(matricula).equals("")) {
                cont++;
                pstm.setString(cont, matricula);
            }
            if (marca != null && !String.valueOf(marca).equals("")) {
                cont++;
                pstm.setString(cont, marca + "%");
            }
            if (modelo != null && !String.valueOf(modelo).equals("")) {
                cont++;
                pstm.setString(cont, modelo + "%");
            }
            if (color != null && !String.valueOf(color).equals("")) {
                cont++;
                pstm.setString(cont, color + "%");
            }

//        System.out.println("SQL = " + sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                c = new Coche(
                        rs.getString("matricula"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("color")
                );
                coches.add(c);
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
        return coches;
    }
}
