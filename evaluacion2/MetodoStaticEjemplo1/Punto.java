/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetodoStaticEjemplo1;

/**
 *
 * @author dev
 */
public class Punto {
    static {
        System.out.println("Se ejecuta solo una vez");
        
    }
    
    
static final int COORDENADA_MAX = 100;
static final int COORDENADA_MIN = -100;
    public static int contador = 0;

    public static int getContador() {
        return contador;
    }
    private int x;
    private int y;

    public Punto(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Punto{" + "x=" + x + ", y=" + y + '}';
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}
