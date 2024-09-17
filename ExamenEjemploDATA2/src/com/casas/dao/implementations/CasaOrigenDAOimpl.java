/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.casas.dao.implementations;

import com.casas.dao.interfaces.CasasDAO;
import com.casas.dao.pojo.Casas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public class CasaOrigenDAOimpl implements AutoCloseable, CasasDAO{
     static {
        try {
            Class.forName(com.casas.dao.utils.Config04.DRIVER);
        } catch (Exception e) {
            System.out.println("Error en el driver: " + e.getMessage());
        }
    }
    Connection con = null;

    public CasaOrigenDAOimpl() throws Exception {
        con = DriverManager.getConnection(com.casas.dao.utils.Config04.URL);
    }

    @Override
    public int insertarDatos(ArrayList<Casas> cs) throws Exception {
        int numMod = 0;
        String sql = "INSERT INTO casa VALUES(?,?,?,?);";
        try (
                PreparedStatement pstm = con.prepareStatement(sql);
                ){
            
            for (Casas c : cs) {
                pstm.setString(1, c.getIdentificador());
                pstm.setString(2, c.getDireccion());
                pstm.setString(3, c.getPoblacion());
                pstm.setString(4, c.getProvincia());
                pstm.executeUpdate();
                numMod++;
            }
            
            
        }catch (Exception e){
            throw e;
        }
        return numMod;
    }

    @Override
    public void borrarDatos() throws Exception {
        String sql = "DELETE FROM casa;";
        try (
                PreparedStatement pstm = con.prepareStatement(sql);
                ){
            pstm.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void close() throws Exception {
        con.close();
    }
}
