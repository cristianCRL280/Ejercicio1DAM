/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioStatic1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dev
 */
public class Utils {
    
    
    public static int aleatorio(int min, int max){
        return (int) (Math.random() * (max + 1 - min) + min);
        
        
        
    }
    public static double hipotenusa(double c1, double c2){
        return Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
        
    }
    public static double kmToMi(double km){
        return km * 0.621371d;
        
    }
    
    public static double miToKm(double mi){
        
        return mi * 1.68934d;
        
    }
    public static boolean esPrimo(int n){
        if (n == 1) {
            return false;
            
            
        }
        if (n == 2) {
            return true;
            
        }
        if (n % 2 == 0) {
            return false;
            
        }
        for (int i = 3; i < n; i = i + 2) {
            if (n % i == 0) {
                
                return false;
                
            }
            
        }
        return true;
    }
    
    public static List listaPrimos(int n){
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            
            if (esPrimo(i)) {
                l.add(i);
            }
            
        }
        return l;
    }
    public static List fibonacci(int n){
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(1);
        for (int i = 2; i < n; i++) {
            
            l.add(l.get(i - 1 ) + l.get(i - 2));
        }
        return l;
    }
}
