/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04Maps;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author dev
 */
public class Exec {
    public static void main(String[] args) {
         ArrayList<Jugador> al = new ArrayList<Jugador>();
          Scanner sc = new Scanner(System.in);
        String menu = "";
        
        do {
            menu = menu(sc);
            
            if (menu.equals("1")) {
                introducirDatos(al, sc);
              
            }   else if (menu.equals("2")){
                
                mostrarDatos(al);
                
            } else if (menu.equals("3")){
                consultaByNombre(al,sc);
                
                
            } else if (menu.equals("4")) {
                
                consultaByProvincia(al,sc);
                
            } else if (menu.equals("5")) {
                
                modificacionCanastasByNombre(al, sc);
                
            } else if ( menu.equals("6")){
                
                mostrarJugadoresOrdenadosByProvincia(al ,sc);
                
            } else if (menu.equals("7")){
                borradoByNumCanastas(al ,sc);
                
            } else if (menu.equals("8")){
                borradoCompleto(al);
            }
            
            
        } while (!menu.equalsIgnoreCase("S"));
        System.out.println("Adios!!");
        
    }
    
    public static void borradoCompleto(ArrayList<Jugador> al){
        al.clear();
       
    }
    
    public static void mostrarDatos(ArrayList<Jugador> al){
        System.out.println("-------Datos de jugadores------------");
        
        for (Jugador jugador : al) {
            System.out.println(jugador);
        }
        
        
    }
    
    public static void borradoByNumCanastas(ArrayList<Jugador> al, Scanner sc){
        
        System.out.println("----Borrado por numero de canastas-------");
        System.out.println("Minimo: ");
        int min = Integer.parseInt(sc.nextLine());
        System.out.println("Maximo: ");
        int max = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < al.size(); i++) {
            
            
            if (al.get(i).getNumCanastasIntroducidas()>= min && al.get(i).getNumCanastasIntroducidas() <= max) {
                al.remove(i);
                i--;
            }
        }
    }
    
    public static void modificacionCanastasByNombre(ArrayList<Jugador> al, Scanner sc){
        
        System.out.println("-------------Modificacion de canastas por nobmre--------");
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Numero nuevo de canastas introducidas");
        int nuevo = Integer.parseInt(sc.nextLine());
        for (Jugador jugador : al) {
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                jugador.setNumCanastasIntroducidas(nuevo);
                
            }
            
        }
    }
    
    public static void mostrarJugadoresOrdenadosByProvincia(ArrayList<Jugador> al, Scanner sc){
        TreeSet<String> provincias = new TreeSet<String>();
        for (Jugador jugador : al) {
            provincias.add(jugador.getProvincia());
            
        }
        System.out.println("--------------Jugadores ordenados por provincias-------------");
        
        for (String provincia : provincias) {
            
            System.out.println("----------------" + provincia + "------------");
            
            for (Jugador jugador : al) {
                
                if (jugador.getProvincia().equals(provincia)) {
                    System.out.println(jugador);
                    
                }
            }
        }
       
        
        
    }
    
      public static void consultaByProvincia(ArrayList<Jugador> al , Scanner sc){
        System.out.println("---------------Consulta por nombre------------");
        System.out.println("Provincia: ");
        String provincia = sc.nextLine();
        for (Jugador jugador : al) {
            
            if (jugador.getProvincia().equalsIgnoreCase(provincia)) {
                
                System.out.println(jugador);
            }
            
        }
        
    }
    
    
    public static void consultaByNombre(ArrayList<Jugador> al , Scanner sc){
        System.out.println("---------------Consulta por nombre------------");
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        for (Jugador jugador : al) {
            
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                
                System.out.println(jugador);
            }
            
        }
        
    }
    
    public static void introducirDatos(ArrayList<Jugador> al , Scanner sc){
        System.out.println("--------------Introduzca informacion------------");
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.println("Nombre de equipo: ");
        String nombreEquipo = sc.nextLine();
        System.out.println("Numero de canastas introducidas: ");
        int numCanastasIntroducidas = Integer.parseInt(sc.nextLine());
        System.out.println("Provincia");
        String provincia = sc.nextLine();
        Jugador j = new Jugador(nombre, edad, nombreEquipo, numCanastasIntroducidas, provincia);
        al.add(j);
        
    }
    
    public static String menu(Scanner sc){
        String opcion = "";
        System.out.println("-----------------Menu---------------");
        System.out.println("1.-Introducir datos");
        System.out.println("2.-Mostrar todos los jugadores");
        System.out.println("3.-Consulta de los datos de todos los jugadorres a partir del nombre");
        System.out.println("4.-Consulta de jugador por provincia");
        System.out.println("5.-Modificacion de las canastas introducidas por un jugador");
        System.out.println("6.-Mostrar los jugadores ordenados por provincia");
        System.out.println("7.-Borrado del jugador con determinado rango de canastas introducidas");
        System.out.println("8.-Borrado toda la coleccion");
        System.out.println("S.- Para salir");
        
        do{
            System.out.println("Introduzca una opcion");
            opcion = sc.nextLine();
            
            
        } while(!opcion.equals("1")||!opcion.equals("2")|| !opcion.equals("3")|| !opcion.equals("4")|| !opcion.equals("5")|| 
                !opcion.equals("6")|| !opcion.equals("7")|| !opcion.equals("8")|| !opcion.equals("S"));
        
        
        return opcion;
    }
    
    
}
