/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author dev
 */
import testbbdd.*;
import java.sql.*;
import java.util.Scanner;

public class Ej1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
    }

    public static void menu(Scanner sc) {
        System.out.println("---- INSERT ----");
        System.out.println("1.- Insertar Empleado");
        System.out.println("2.- Insertar Vehículo");
        System.out.println("3.- Insertar Proyecto");
        System.out.println("4.- Asignar empleado a proyecto");
        System.out.println("---- SELECTS ----");
        System.out.println("5.- Consulta de empleados");
        System.out.println("6.- Detalles de un empleado");
        System.out.println("7.- Consulta de proyectos");
        System.out.println("8.- Detalles de proyecto");
        System.out.println("9.- Consulta de vehículos");
        System.out.println("10.- Nombre y código de proyecto del proyecto que tenga más personal asignado");
        System.out.println("S.- Salir");
        opciones(sc);

    }

    public static void opciones(Scanner sc) {
        String opcion = null;
        opcion = sc.nextLine();
        switch (opcion) {
            case "1":
                insertarEmpleado(sc);
                break;
            case "2":
                insertarVehiculo(sc);
                break;
            case "3":
                insertarProyecto(sc);
                break;
            case "4":
                asignarEmpleadoAProyecto(sc);
                break;
            case "5":
                consultaEmpleados(sc);
                break;
            case "6":
                detallesEmpleados(sc);
                break;
            case "7":
                consultaProyectos(sc);
                break;
            case "8":
                detallesProyecto(sc);
                break;
            case "9":
                asignarEmpleadoAProyecto(sc);
                break;
            case "10":
                asignarEmpleadoAProyecto(sc);
                break;
            case "S":
                break;
        }
        if (!opcion.equalsIgnoreCase("S")) {
            menu(sc);
        }

    }
//1
    public static void consultaEmpleados(Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        String sql = "SELECT EMPLEADO.NOMBRE, EMPLEADO.ID, EMPLEADO.DNI, TABLAJEFE.NOMBRE FROM EMPLEADO LEFT JOIN EMPLEADO as TABLAJEFE ON EMPLEADO.JEFE  = TABLAJEFE.ID";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                System.out.println("-----------");
                System.out.println("Nombre: " + rs.getString(1) + ", ID: " + rs.getInt(2) + ", DNI: " + rs.getString(3) + ", su jefe es -> " + rs.getString(4));

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }
//2
    //Pido que me ponga el id de alguien y le pongo todo lo que tiene ese
    public static void detallesEmpleados(Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        String sql = "SELECT EMPLEADO.NOMBRE, EMPLEADO.ID, EMPLEADO.DNI, TABLAJEFE.NOMBRE FROM EMPLEADO LEFT JOIN EMPLEADO as TABLAJEFE ON EMPLEADO.JEFE  = TABLAJEFE.ID WHERE EMPLEADO.ID = " + id;
        String sql2 = "SELECT VEHICULO.MATRICULA, VEHICULO.MARCA, VEHICULO.MODELO FROM VEHICULO WHERE VEHICULO.PERSONA = " + id;
        String sql3 = "SELECT PROYECTO.NOMBRE FROM PROYECTO WHERE PROYECTO.CODIGO IN (SELECT ASIGNACION.CODIGO FROM ASIGNACION WHERE ASIGNACION.ID = " + id  +")";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); 
                PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql); 
                PreparedStatement stm2 = con.prepareStatement(sql2); ResultSet rs2 = stm2.executeQuery(sql2); 
                PreparedStatement stm3 = con.prepareStatement(sql3); ResultSet rs3 = stm3.executeQuery(sql3);) {
            while (rs.next()) {
                System.out.println("-----------");
                System.out.println("Nombre: " + rs.getString(1) + ", ID: " + rs.getInt(2) + ", DNI: " + rs.getString(3) + ", su jefe es -> " + rs.getString(4));

            }
            while (rs2.next()) {
                System.out.println("Matricula: " + rs2.getString(1) + ", Marca: " + rs2.getString(2) + ", Modelo: " + rs2.getString(3));
            }
            while (rs3.next()) {
                System.out.println("Nombre de proyecto: " + rs3.getString(1));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }
//3
    public static void consultaProyectos(Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        

        String sql = "SELECT PROYECTO.CODIGO, PROYECTO.NOMBRE, EMPLEADO.NOMBRE FROM PROYECTO, EMPLEADO";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
                PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                System.out.println("-----------");
                System.out.println("Codigo del Proyecto: " + rs.getInt(1) + ", Nombre: " + rs.getString(2) + ", Participantes: " + rs.getString(3));

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }
//4
    public static void detallesProyecto(Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        
        System.out.print("CODIGO: ");
        int p = Integer.parseInt(sc.nextLine());

        String sql = "SELECT P.CODIGO, P.NOMBRE, E.NOMBRE, E.DNI FROM ASIGNACION AS A JOIN PROYECTO AS P ON P.CODIGO = A.CODIGO JOIN EMPLEADO AS E ON E.ID = A.ID  WHERE P.CODIGO=" + p + ";";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
                PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                System.out.println("-----------");
                System.out.println("Código de proyecto -> " + rs.getInt(1) + "     Nombre de proyecto -> " + rs.getString(2) + "\nNombre del empleado -> " + rs.getString(3) + "     DNI del empleado ->" + rs.getNString(4) + "\n");

            }
                        System.out.println("");
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }
//5
    public static void consultaVehiculos(Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        

        String sql = "SELECT V.MATRICULA, V.MARCA, V.MODELO, E.ID, E.NOMBRE FROM VEHICULO AS V LEFT JOIN EMPLEADO AS E ON V.PERSONA = E.ID;";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
                PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                System.out.println("-----------");
                System.out.println("Matrícula: " + rs.getString(1) + "         Marca: " + rs.getString(2) + "       Modelo: " + rs.getString(3) + "\nID del empleado : " + rs.getInt(4) + "         Nombre del empleado: "+ rs.getString(5) + "\n");

            }
System.out.println("");
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }
//6
    public static void nombreCodigoProyectoMayorPersonal(Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        

        String sql = "SELECT A.CODIGO, P.NOMBRE, COUNT() FROM ASIGNACION AS A JOIN PROYECTO AS P ON A.CODIGO = P.CODIGO GROUP BY A.CODIGO HAVING COUNT() >= ALL (SELECT COUNT(*) FROM ASIGNACION GROUP BY CODIGO)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
                PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                System.out.println("-----------");
                System.out.println("El proyecto con más personal asignado es: " + rs.getInt(1) + "  y el nombre del proyecto es: " + rs.getString(2) + "  Con un número de personal de: " + rs.getInt(3));

            }
System.out.println("");
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }

    public static void insertarEmpleado(Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Jefe: ");
        int jefe = Integer.parseInt(sc.nextLine());

        String sql = "insert into EMPLEADO values (?,?,?,?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql);) {
            stm.setInt(1, id);
            stm.setString(2, nombre);
            stm.setString(3, dni);
            stm.setInt(4, jefe);
            int r = stm.executeUpdate();
            System.out.println("Registros afectados: " + r);
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }

    public static void insertarVehiculo(Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        System.out.print("Matricula: ");
        String matricula = sc.nextLine();
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Persona: ");
        int persona = Integer.parseInt(sc.nextLine());

        String sql = "insert into VEHICULO values (?,?,?,?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql);) {
            stm.setString(1, matricula);
            stm.setString(2, marca);
            stm.setString(3, modelo);
            stm.setInt(4, persona);
            int r = stm.executeUpdate();
            System.out.println("Registros afectados: " + r);
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }
    
    public static void insertarProyecto(Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        System.out.print("Codigo: ");
        int codigo = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        String sql = "insert into PROYECTO values (?,?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql);) {
            stm.setInt(1, codigo);
            stm.setString(2, nombre);
            int r = stm.executeUpdate();
            System.out.println("Registros afectados: " + r);
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }

    public static void asignarEmpleadoAProyecto(Scanner sc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Codigo: ");
        int codigo = Integer.parseInt(sc.nextLine());

        String sql = "insert into ASIGNACION values (?,?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql);) {
            stm.setInt(1, id);
            stm.setInt(2, codigo);
            int r = stm.executeUpdate();
            System.out.println("Registros afectados: " + r);
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
        }
    }

}
