/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04Maps;

//Aquí os dejo el enunciado:
//Realizar un programa que permita gestionar jugadores de baloncesto con la siguiente información: 
//- Nombre
//- Edad
//- NombreEquipo
//- NumCanastasIntroducidas
//- Provincia
//Funciones:
//- Introducir datos (usaremos una estructura tipo List).
//- Mostrar todos los jugadores.
//- Consulta de los datos de todos los jugadores a partir del nombre
//- Consulta de jugador por provincia
//- Modificación de las canastas introducidas por un jugador.
//- Mostrar jugadores ordenados por provincias.
//- Borrado del jugador con determinado rango de canastas introducidas.
//- Borrado toda la colección.
/**
 *
 * @author dev
 */
public  class Jugador {
    //
    private String Nombre;
    private int Edad;
    private String NombreEquipo;
    private int NumCanastasIntroducidas;
    private String Provincia;

    public Jugador(String Nombre, int Edad, String NombreEquipo, int NumCanastasIntroducidas, String Provincia) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.NombreEquipo = NombreEquipo;
        this.NumCanastasIntroducidas = NumCanastasIntroducidas;
        this.Provincia = Provincia;
    }

    @Override
    public String toString() {
        return "Jugador{" + "Nombre=" + Nombre + ", Edad=" + Edad + ", NombreEquipo=" + NombreEquipo + ", NumCanastasIntroducidas=" + NumCanastasIntroducidas + ", Provincia=" + Provincia + '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getNombreEquipo() {
        return NombreEquipo;
    }

    public void setNombreEquipo(String NombreEquipo) {
        this.NombreEquipo = NombreEquipo;
    }

    public int getNumCanastasIntroducidas() {
        return NumCanastasIntroducidas;
    }

    public void setNumCanastasIntroducidas(int NumCanastasIntroducidas) {
        this.NumCanastasIntroducidas = NumCanastasIntroducidas;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }
    
    
}

