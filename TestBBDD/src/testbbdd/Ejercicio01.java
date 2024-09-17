/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testbbdd;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Ejercicio01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int primeraResp;
        do {

            System.out.println("-------------Menú------------------");
            System.out.println("1- Insertar Empleado");
            System.out.println("2- Insertar Vehiculo");
            System.out.println("3-Insertar Proyecto");
            System.out.println("4-Asignar empleado a proyecto");
            System.out.println("5-Consultar empleados (junto al nombre de su jefe si tuviera)");
            System.out.println("6-Detalles de un empleado (con los datos de su jefe, vehículos y proyectos");
            System.out.println("7-Consultar proyectos");
            System.out.println("8-Detalles de proyecto (con los datos de los empleados asignados al proyecto)");
            System.out.println("9- Consulta de vehículos (todos, junto al empleado asignado si lo tuviera)");
            System.out.println("10- Consulta de vehículos (todos, junto al empleado asignado si lo tuviera)");
            System.out.println("(0 para acabar)");
            primeraResp = sc.nextInt();
            if (primeraResp != 0) {
                if (primeraResp == 1) {
                    insertarempleado();
                } else if (primeraResp == 2) {
                    insertarVehiculo();
                } else if (primeraResp == 3) {
                    insertarProyecto();
                } else if (primeraResp == 4) {
                    asignarEmpAproy();
                } else if (primeraResp == 5) {
                    consultaEmp();
                } else if (primeraResp == 6) {
                    consultaEmp2();
                } else if (primeraResp == 7) {
                    consultaProy();
                } else if (primeraResp == 8) {
                    consultaProy2();
                } else if (primeraResp == 9) {
                    consultaVehiculo();
                } else if (primeraResp == 10) {
                    consultaCod();
                }
            }
        } while (primeraResp != 0);
    }

    public static void insertarempleado() {
        Scanner em = new Scanner(System.in);

        System.out.println("Inserte ID");
        int id = em.nextInt();
        em.nextLine();

        System.out.println("Inserte Nombre");
        String nombre = em.nextLine();

        System.out.println("Inserte DNI");
        String dni = em.nextLine();

        System.out.println("Inserte jefe");
        int jefe = em.nextInt();
        em.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        String sql = "insert into EMPLEADO(id,nombre,dni,jefe) values (?,?,?,?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql);) {

            stm.setInt(1, id);
            stm.setString(2, nombre);
            stm.setString(3, dni);
            stm.setInt(4, jefe);

            stm.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }
    }

    public static void insertarVehiculo() {
        Scanner veh = new Scanner(System.in);

        System.out.println("Inserte Matricula");
        String MATRICULA = veh.nextLine();

        System.out.println("Inserte Marca");
        String MARCA = veh.nextLine();

        System.out.println("Inserte Modelo");
        String MODELO = veh.nextLine();

        System.out.println("Inserte Persona");
        String PERSONA = veh.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        String sql = "insert into VEHICULO(matricula ,marca,modelo,persona) values (?,?,?,?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql);) {

            stm.setString(1, MATRICULA);
            stm.setString(2, MARCA);
            stm.setString(3, MODELO);
            stm.setString(4, PERSONA);

            stm.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }

    }

    public static void insertarProyecto() {
        Scanner proy = new Scanner(System.in);

        System.out.println("Inserte Codigo");
        int codigo = proy.nextInt();

        proy.nextLine();

        System.out.println("Inserte Nombre");
        String nombre = proy.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        String sql = "insert into PROYECTO(CODIGO,NOMBRe) values (?,?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql);) {

            stm.setInt(1, codigo);
            stm.setString(2, nombre);
            stm.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }

    }

    public static void asignarEmpAproy() {

        Scanner asig = new Scanner(System.in);

        System.out.println("Inserte ID");
        int id = asig.nextInt();

        System.out.println("Inserte Codigo");
        int codigo = asig.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        String sql = "insert into ASIGNACION(id,codigo) values (?,?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql);) {

            stm.setInt(1, id);
            stm.setInt(2, codigo);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }

    }

    public static void consultaEmp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        String sql = "SELECT EMPLEADO.NOMBRE, EMPLEADO.ID, EMPLEADO.DNI, TABLAJEFE.NOMBRE FROM EMPLEADO LEFT JOIN EMPLEADO AS TABLAJEFE ON EMPLEADO.JEFE = TABLAJEFE.ID";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            System.out.println("-----------------------------");
            while (rs.next()) {

                System.out.println(" NOMBRE EMPLEADO " + rs.getString("nombre") + " ID DEL EMPLEADO: " + " DNI " + rs.getString("DNI") + " NOMBRE JEFE: "
                        + rs.getString("nombre"));

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }

    }

    public static void consultaEmp2() {
        Scanner emp = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        System.out.print("Introduce número de ID del empleado para filtrar búsqueda: ");
        int n = Integer.parseInt(emp.nextLine());

        String sql = "SELECT E.ID, E.NOMBRE, E.DNI, J.ID, J.NOMBRE, J.DNI, V.MATRICULA, V.MARCA,V.MODELO, V.PERSONA, A.CODIGO FROM EMPLEADO AS E LEFT JOIN EMPLEADO AS J ON E.JEFE = J.ID RIGHT JOIN VEHICULO AS V ON E.ID = V.PERSONA JOIN ASIGNACION AS A ON A.ID = E.ID WHERE E.ID = " + n + ";";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            System.out.println("-----------------------------");
            while (rs.next()) {

                System.out.println("----------> EMPLEADO/ ID: " + rs.getInt(1) + "  NOMBRE: " + rs.getString(2) + "  DNI: " + rs.getString(3) + "\n"
                        + "----------> JEFE/ ID: " + rs.getInt(4) + "  NOMBRE: " + rs.getString(5) + "  DNI: " + rs.getString(6) + "\n"
                        + "----------> VEHÍCULO/ MATRICULA: " + rs.getString(7) + "  MARCA:  " + rs.getString(8) + "  MODELO:" + rs.getString(9) + "  PERSONA: " + rs.getInt(10) + "\n"
                        + "----------> ASIGNACIÓN/ CÓDIGO " + rs.getInt(11) + "\n");

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }

    }

    public static void consultaProy() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        String sql = "SELECT P.CODIGO, P.NOMBRE FROM PROYECTO AS P;";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            System.out.println("-----------------------------");
            while (rs.next()) {

                System.out.println("Código de proyecto -> " + rs.getInt(1) + "     Nombre de proyecto -> " + rs.getString(2));

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }

    }

    public static void consultaProy2() {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        System.out.print("Introduce número de ID de proyecto para filtrar búsqueda: ");
        int p = Integer.parseInt(sc.nextLine());

        String sql = "SELECT P.CODIGO, P.NOMBRE, E.NOMBRE, E.DNI FROM ASIGNACION AS A JOIN PROYECTO AS P ON P.CODIGO = A.CODIGO JOIN EMPLEADO AS E ON E.ID = A.ID  WHERE P.CODIGO=" + p + ";";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            System.out.println("-----------------------------");
            while (rs.next()) {

                System.out.println("Código de proyecto -> " + rs.getInt(1) + "     Nombre de proyecto -> " + rs.getString(2) + "\nNombre del empleado -> " + rs.getString(3)
                        + "     DNI del empleado ->" + rs.getNString(4) + "\n");

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }

    }

    public static void consultaVehiculo() {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        System.out.print("Introduce número de ID de proyecto para filtrar búsqueda: ");
        int p = Integer.parseInt(sc.nextLine());

        String sql = "SELECT V.MATRICULA, V.MARCA, V.MODELO, E.ID, E.NOMBRE FROM VEHICULO AS V LEFT JOIN EMPLEADO AS E ON V.PERSONA = E.ID;";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            System.out.println("-----------------------------");
            while (rs.next()) {

                System.out.println("Matrícula: " + rs.getString(1) + "         Marca: " + rs.getString(2) + "       Modelo: " + rs.getString(3) + "\nID del empleado : " + rs.getInt(4) + "      "
                        + "   Nombre del empleado: " + rs.getString(5) + "\n");

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }
    }

    public static void consultaCod() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }

        String sql = "SELECT A.CODIGO, P.NOMBRE, COUNT(*) FROM ASIGNACION AS A JOIN PROYECTO AS P ON A.CODIGO = P.CODIGO GROUP BY A.CODIGO HAVING COUNT(*) >= ALL (SELECT COUNT(*) FROM ASIGNACION GROUP BY CODIGO) ;";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", ""); PreparedStatement stm = con.prepareStatement(sql); ResultSet rs = stm.executeQuery(sql);) {
            System.out.println("-----------------------------");
            while (rs.next()) {

                    System.out.println("El proyecto con más personal asignado es: " + rs.getInt(1) + "  y el nombre del proyecto es: " + rs.getString(2) + "  Con un número de personal de: " + rs.getInt(3));

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        }
    }
}
