/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen2.implementations;

import com.examen2.dao.interfaces.CasaDAO;
import com.examen2.pojo.Casa;

import static com.examen2.utils.Utils.DRIVER;
import static com.examen2.utils.Utils.URL;
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
public class CasaDAOimpl implements CasaDAO, AutoCloseable {

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            System.exit(1);
            
        }
    }
 Connection con = null;

    public CasaDAOimpl() throws Exception {
        con = DriverManager.getConnection(URL);
    }

        @Override
    public void close() throws Exception {

        if (con != null && !con.isClosed()) {
            con.close();
        }

    }
    @Override
    public List<Casa> getCasaByFilter(String identificador, String direccion, String poblacion, String provincia) throws Exception {
      List<Casa> casas = new ArrayList<>();
        Casa c;
        String sql = "SELECT * FROM casa WHERE 1=1 ";
        int cont = 0;
        if (identificador != null && !String.valueOf(identificador).equals("")) {
            sql += "AND casa.identificador LIKE ? ";
        }
        if (direccion != null && !String.valueOf(direccion).equals("")) {
            sql += "AND casa.direccion LIKE ? ";
        }
        if (poblacion != null && !String.valueOf(poblacion).equals("")) {
            sql += "AND casa.poblacion LIKE ? ";
        }
        if (provincia != null && !String.valueOf(provincia).equals("")) {
            sql += "AND casa.provincia LIKE ? ";
        }
         ResultSet rs = null;
         
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            if (identificador != null && !String.valueOf(identificador).equals("")) {
                cont++;
                pstm.setString(cont, identificador);
            }
            if (direccion != null && !String.valueOf(direccion).equals("")) {
                cont++;
                pstm.setString(cont, direccion + "%");
            }
            if (poblacion != null && !String.valueOf(poblacion).equals("")) {
                cont++;
                pstm.setString(cont, poblacion + "%");
            }
            if (provincia != null && !String.valueOf(provincia).equals("")) {
                cont++;
                pstm.setString(cont, provincia + "%");
            }
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
