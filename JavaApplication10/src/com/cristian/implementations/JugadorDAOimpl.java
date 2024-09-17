/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cristian.implementations;

import com.cristian.dao.interfaces.JugadorDAO;
import com.cristian.pojo.Jugador;
import static com.cristian.utils.Utils.*;
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
public class JugadorDAOimpl implements JugadorDAO, AutoCloseable {

    private Connection con;

    static {
        try {
            Class.forName(Driver);
        } catch (Exception e) {
            System.exit(1);
        }

    }

    public JugadorDAOimpl() throws Exception {
        con = DriverManager.getConnection(URL, User, password);
    }

    @Override
    public List<Jugador> getJugadorByFilter(String codigo, String nombre, String procedencia, String altura, String peso, String posicion, String Nombre_equipo) throws Exception {
        List<Jugador> jugadores = new ArrayList<>();
        Jugador j;
        String sql;
        sql = "select * from jugadores, equipos where equipos.Nombre=jugadores.Nombre_equipo AND 1 = 1 ";
        int c = 0;
        if (codigo != null && !String.valueOf(codigo).equals("")) {
            sql += " AND jugadores.codigo = ? ";
        }
        if (nombre != null && !String.valueOf(nombre).equals("")) {
            sql += " AND jugadores.Nombre = ? ";
        }
        if (procedencia != null && !String.valueOf(procedencia).equals("")) {
            sql += " AND jugadores.Procedencia = ? ";
        }
        if (altura != null && !String.valueOf(altura).equals("")) {
            sql += " AND jugadores.Altura = ? ";
        }
        if (peso != null && !String.valueOf(peso).equals("")) {
            sql += " AND jugadores.Peso = ? ";
        }
        if (posicion != null && !String.valueOf(posicion).equals("")) {
            sql += " AND jugadores.Posicion = ? ";
        }
        if (Nombre_equipo != null && !String.valueOf(Nombre_equipo).equals("")) {
            sql += " AND jugadores.Nombre_equipo = ? ";
        }

//        System.out.println("SQL = " + sql);
        ResultSet rs = null;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba", "root", ""); 
                PreparedStatement pstm = con.prepareStatement(sql);) {
            
            if (codigo != null && !String.valueOf(codigo).equals("")) {
                c++;
                pstm.setString(c, codigo);
            }
            if (nombre != null && !String.valueOf(nombre).equals("")) {
                c++;
                pstm.setString(c, nombre + "%");
            }
            if (procedencia != null && !String.valueOf(procedencia).equals("")) {
                c++;
                pstm.setString(c, procedencia + "%");
            }
            if (altura != null && !String.valueOf(altura).equals("")) {
                c++;
                pstm.setString(c, altura + "%");
            }
            if (peso != null && !String.valueOf(peso).equals("")) {
                c++;
                pstm.setString(c, peso + "%");
            }
            if (posicion != null && !String.valueOf(posicion).equals("")) {
                c++;
                pstm.setString(c, posicion + "%");
            }
            if (Nombre_equipo != null && !String.valueOf(Nombre_equipo).equals("")) {
                c++;
                pstm.setString(c, Nombre_equipo + "%");
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                j = new Jugador(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("procedencia"),
                        rs.getString("altura"),
                        rs.getString("peso"),
                        rs.getString("posicion"),
                        rs.getString("Nombre_equipo")
                );
                jugadores.add(j);
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
        return jugadores;
    }

    @Override
    public void close() throws Exception {

        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

}
