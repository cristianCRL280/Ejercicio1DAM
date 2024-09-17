/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testbbdd;

import testbbdd.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class EjemploFiltros {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Problemas al cargar el driver");
            System.exit(1);
        }
        Scanner sc = new Scanner(System.in);
        String matricula, marca, modelo, respuesta;
        do {
            System.out.println("Introduzca los filtros");
            System.out.print("Matrícula: ");
            matricula = sc.nextLine();
            System.out.print("Marca: ");
            marca = sc.nextLine();
            System.out.print("Modelo: ");
            modelo = sc.nextLine();
            filtros(matricula, marca, modelo);
            System.out.println("¿Otra búsqueda? (S/N)");
            respuesta = sc.nextLine();
        } while (respuesta.equalsIgnoreCase("S"));
    }

    public static void filtros(String matricula, String marca, String modelo) {
        String sql;
        sql = "select matricula, marca, modelo from VEHICULO where 1 = 1 ";
        int c = 0;
        if (matricula != null && !matricula.equals("")) {
            sql = sql + " AND matricula = ? ";
        }
        if (marca != null && !marca.equals("")) {
            sql = sql + " AND marca like ? ";
        }
        if (modelo != null && !modelo.equals("")) {
            sql = sql + " AND modelo like ? ";
        }
        System.out.println("SQL = " + sql);
        ResultSet rs = null;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement pstm = con.prepareStatement(sql);) {
            if (matricula != null && !matricula.equals("")) {
                c++;
                pstm.setString(c, matricula);
            }
            if (marca != null && !marca.equals("")) {
                c++;
                pstm.setString(c, marca + "%");
            }
            if (matricula != null && !matricula.equals("")) {
                c++;
                pstm.setString(c, modelo + "%");
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " -- " + rs.getString(2) + " -- " + rs.getString(3));
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

    }

}
