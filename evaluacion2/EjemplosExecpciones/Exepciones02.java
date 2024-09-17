/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemplosExecpciones;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Exepciones02 {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = 0;
        System.out.println("Dame un numero entero: ");
        
        try{
            n = dameUnNumero();
            
        } catch(NumberFormatException e){
            
            System.out.println("Se ha producido un error ");
        } catch (IOException e) {
            System.out.println("Error en la entrada salida");
        }
        
        System.out.println("El numero es " + n);
    }
    
    
    
    public static int dameUnNumero() throws NumberFormatException, IOException{
        
        return Integer.parseInt(sc.nextLine());
        
    }
}
