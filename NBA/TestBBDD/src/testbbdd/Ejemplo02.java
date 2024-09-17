/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testbbdd;

import com.cristian.dao.implementations.EmpleadoDAOimpl;
import com.cristian.dao.pojo.Empleado;
import java.util.ArrayList;

/**
 *
 * @author dev
 */
public class Ejemplo02 {

    public static void main(String[] args) {
        try (EmpleadoDAOimpl edi = new EmpleadoDAOimpl();) {
            ArrayList<Empleado> al = (ArrayList) edi.getEmpleadoByIdJefe(10);
            for (Empleado empleado : al) {
                System.out.println(empleado);
            }
            
            int filasAfectadas = edi.updateEmpleadoIdJefeByIdJefe(10, 15);
            System.out.println("Filas afectadas -> " + filasAfectadas);
            al = (ArrayList) edi.getEmpleadoByIdJefe(15);
            for (Empleado empleado : al) {
                System.out.println(empleado);
            }
            
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        }

    }
}
