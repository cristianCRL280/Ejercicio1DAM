/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.danielm.mh.utils;

/**
 *
 * @author Daniel Marin y Cristian Rodriguez
 */
public class Utils {
    
    public static final String URL = "jdbc:sqlite:./helados.db";
    public static final String DRIVER = "org.sqlite.JDBC";

    public static double redondeoDecimales(double d) {
        return 1.0d * Math.round(d * 100.0d) / 100.0d;
    }
}
