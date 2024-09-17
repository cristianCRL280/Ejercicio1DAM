/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danielm.mh.biz;

import com.danielm.mh.dao.implementations.*;
import com.danielm.mh.exceptions.*;
import com.danielm.mh.pojo.Helado;
import com.danielm.mh.pojo.*;
import com.danielm.mh.utils.Utils;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Daniel Marin y Cristian Rodriguez
 */
public class MaquinaHelados {

    private double monedero;
    private double ingresos;

    public Helado pedirHelado(String posicion) throws Exception {
        Helado helado;
        try (HeladoDAOimpl heladoDAO = new HeladoDAOimpl(); VentaDAOimpl ventaDAO = new VentaDAOimpl(); ) {
            helado = heladoDAO.getHeladoByPosition(posicion);
            validarHelado(helado);
            actualizarDatos(helado, ventaDAO, heladoDAO);
        } catch (Exception e) {
            throw e;
        }
        return helado;
    }

    private void validarHelado(Helado helado) throws Exception {
        if (helado == null) {
            throw new NotValidPositionException("Posición Incorrecta");
        } else if (this.monedero < helado.getPrecio()) {
            throw new ThereIsNotEnoughMoneyException("No tienes suficiente dinero");
        } else if (helado.getCantidad() <= 0) {
            throw new QuantityExceededException("No hay helados suficientes");
        }
    }

    private void actualizarDatos(Helado helado, VentaDAOimpl ventaDAO, HeladoDAOimpl imple) throws Exception {
        this.ingresos += helado.getPrecio();
        this.monedero -= helado.getPrecio();
        this.ingresos = Utils.redondeoDecimales(this.ingresos);
        this.monedero = Utils.redondeoDecimales(this.monedero);
        helado.setCantidad(helado.getCantidad() - 1);
        imple.updateHelado(helado);
        ventaDAO.addVenta(new Venta(LocalDate.now().toString(), helado.getPosicion(), helado.getNombre(), helado.getPrecio(), helado.getTipo(), 1));
    }

    @Override
    public String toString() {
        String r = "";
        try (HeladoDAOimpl impl = new HeladoDAOimpl()) {
            List<Helado> helados = impl.getHelados();
            for (Helado helado : helados) {
                r += helado.toString() + "\n";
            }
        } catch (Exception e) {
        }
        return r;
    }

    public double getMonedero() {
        return monedero;
    }

    public void setMonedero(double monedero) {
        this.monedero = monedero;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

}
