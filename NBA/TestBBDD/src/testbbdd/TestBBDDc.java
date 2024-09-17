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

public class TestBBDDc {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        
        int jefeAnterior = 15;
        int jefePosterior = 10;
        
        //String sql = "update EMPLEADO set jefe = " + jefePosterior + " where jefe = " + jefeAnterior;
        String sql = "update EMPLEADO set jefe = ? where jefe = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); 
                PreparedStatement stm = con.prepareStatement(sql);) {
            stm.setInt(1, jefePosterior);
            stm.setInt(2, jefeAnterior);
            int r = stm.executeUpdate();
            System.out.println("Registros afectados: " + r);
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }

}
