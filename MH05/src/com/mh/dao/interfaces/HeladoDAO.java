/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mh.dao.interfaces;

import com.mh.dao.pojo.Helado;
import java.util.*;

/**
 *
 * @author dev
 */
public interface HeladoDAO {
    public List <Helado> getHelados() throws Exception;
    public int refreshHelado(Helado h) throws Exception;
  public Helado getHeladoByPosition(String posicion) throws Exception;
}
