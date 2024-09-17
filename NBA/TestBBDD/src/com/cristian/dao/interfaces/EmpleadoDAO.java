/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cristian.dao.interfaces;

import com.cristian.dao.pojo.Empleado;
import java.util.List;

/**
 *
 * @author dev
 */
public interface EmpleadoDAO {
    
    public List<Empleado> getEmpleadoByIdJefe(int idJefe) throws Exception;
    public int updateEmpleadoIdJefeByIdJefe (int idJefeAnterior, int idJefePosterior) throws Exception;
    
}
