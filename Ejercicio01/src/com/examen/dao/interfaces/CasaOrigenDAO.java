/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.dao.interfaces;

import com.examen.pojo.Casa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev
 */
public interface CasaOrigenDAO {
 
     public List<Casa> cogerDatos(String poblacion) throws Exception;

     
}
