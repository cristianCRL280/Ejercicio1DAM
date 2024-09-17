/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rodriguez.utils;

/**
 *
 * @author dev
 */
public class utils {

    public static boolean isInteger(String s) {

        try {
            Long.parseLong(s);
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public static boolean isReal(String s) {

        try {
            Double.parseDouble(s);
            return true;

        } catch (Exception e) {

            return false;
        }

    }
}
