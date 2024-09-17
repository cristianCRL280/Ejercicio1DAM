/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExamenDawAceptaElReto;

/**
 *
 * @author danie
 */
public class casas implements Comparable{
    String Nombre;
    double precio;
    double metros;
    int hrasSol;

    public casas(String Nombre, double precio, double metros, int hrasSol) {
        this.Nombre = Nombre;
        this.precio = precio;
        this.metros = metros;
        this.hrasSol = hrasSol;
    }

    @Override
    public String toString() {
        return "casas{" + "Nombre=" + Nombre + ", precio=" + precio + ", metros=" + metros + ", hrasSol=" + hrasSol + '}';
    }
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    public int getHrasSol() {
        return hrasSol;
    }

    public void setHrasSol(int hrasSol) {
        this.hrasSol = hrasSol;
    }
    
    public double getPrecioMts(){
        return 1.0d * this.precio / this.metros;
    }

    @Override
    public int compareTo(Object o) {
        casas otro = (casas) o;
        if (this.getPrecioMts() != otro.getPrecioMts()) {
            return Double.compare(this.getPrecioMts(), otro.getPrecioMts());
        }else{
            return Integer.compare(otro.hrasSol, this.hrasSol);
        }
    }
    
    
    
}
