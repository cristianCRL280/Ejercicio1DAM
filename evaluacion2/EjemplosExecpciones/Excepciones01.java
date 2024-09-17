/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemplosExecpciones;

import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Excepciones01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean otrotrabajobienhecho = false;
        int resultado = 0;
        int i;
        do {
        
            
            
            try{
                
                i = Integer.parseInt(sc.nextLine());
            
            resultado = 1 / i;
            
                otrotrabajobienhecho = true;
                
            } catch(NumberFormatException e){
                
                System.out.println("El numero no tiene el formato adecuado");
                
            } catch(ArithmeticException e){
                
                System.out.println("Fallo aritmetico");
                
            }catch(Exception e){
                
                System.out.println("Se ha producido un error");
                System.out.println(e.getClass().getSimpleName());
                System.out.println(e.getMessage());
                
            }finally{
                
                System.out.println("resultado: " + resultado);
            }
            
            
            
            
        } while (!otrotrabajobienhecho);
        
        
        
        
    }
}
