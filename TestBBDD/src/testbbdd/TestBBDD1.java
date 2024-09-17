/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testbbdd;

import java.sql.*;

/**
 *
 * @author dev
 */
public class TestBBDD1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        String sql = "update EMPLEADO set jefe = 10 where jefe = 15";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); 
                Statement stm = con.createStatement();) {

            int r = stm.executeUpdate(sql);
            
            System.out.println("Registros afectados:" + r);
            
        } catch (Exception e) {

            
            
            
            
            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }

    }

}
