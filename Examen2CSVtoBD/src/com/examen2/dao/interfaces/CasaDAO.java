/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen2.dao.interfaces;

import com.examen2.pojo.Casa;
import java.util.List;

/**
 *
 * @author dev
 */
public interface CasaDAO {

    public void deleteCasas() throws Exception;

    public void insertarCasas(Casa c) throws Exception;
}
