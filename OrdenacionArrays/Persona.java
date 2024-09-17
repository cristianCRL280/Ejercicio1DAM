/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OrdenacionArrays;

/**
 *
 * @author dev
 */
public class Persona implements Comparable {

    private String nombre;
    private int edad;
    private double altura;

    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + '}';
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Object o) {
//negativo si this es menor que 0 
//positivo si this es mayor que 0
// cero si son iguales 
        Persona otro = (Persona) o;

//return this.edad - otro.edad; // ascendente por edad
//return otro.edad - this.edad; // descendente por edad
// return this.nombre.compareTo(otro.nombre); //ascendente por nombre
// return otro.nombre.compareTo(this.nombre); //descendente por nombre
        Double thisAltura = this.altura;
        Double otroAltura = otro.altura;

//return thisAltura.compareTo(otroAltura); //ascendente por altura
//return otroAltura.compareTo((thisAltura)); //descendente por altura



//ordena por edad, y en caso de que tuvieran la misma, por orden alfabetico del nombre


if (this.edad == otro.edad) {

            return this.nombre.compareTo(otro.nombre);

        } else {

            return this.edad - otro.edad;

        }

    }

}
