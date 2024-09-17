/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testbbdd;

/**
 *
 * @author dev
 */
import java.sql.*;

public class TestBBDD {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        String sql = "select id, nombre, dni, jefe from EMPLEADO";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); 
            Statement stm = con.createStatement(); 
            ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                System.out.println("-----------");
                System.out.println(rs.getInt("id") + " --- " + rs.getString(2)
                + " --- " + rs.getString("dni") + " --- " + rs.getInt(4));

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }

}
