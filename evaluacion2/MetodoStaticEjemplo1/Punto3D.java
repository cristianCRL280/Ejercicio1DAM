/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetodoStaticEjemplo1;

/**
 *
 * @author dev
 */
public class Punto3D extends Punto {
    private int z;

    public Punto3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + super.getX() + "," + super.getY() + "," + z + ")";
    }
    
    

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    
    
    
    
}
