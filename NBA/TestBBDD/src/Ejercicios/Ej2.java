/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author dev
 */
public class Ej2 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("No se ha podido cargar el driver");
            System.exit(1);
        }
        Scanner sc = new Scanner(System.in);
        menu(sc);
    }

    public static void menu(Scanner sc) {
        System.out.println("┌─────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                               MENÚ                                  │");
        System.out.println("├─────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Consulta de jugadores                                            │");
        System.out.println("│ 2. Detalles de jugador                                              │");
        System.out.println("│ 3. Numero de victorias y derrotas                                   │");
        System.out.println("│ S. Salir                                                            │");
        System.out.println("└─────────────────────────────────────────────────────────────────────┘");
        System.out.println();
        System.out.print("Introduce una opción: ");
        opciones(sc);
    }

    public static void opciones(Scanner sc) {
        String opcion = null;
        opcion = sc.nextLine();
        System.out.println();
        switch (opcion) {
            case "1":
                consultaJugadores(sc);
                break;
            case "2":
                detalleJugador(sc);
                break;
            case "3":
                nVictoriasDerrotas(sc);
                break;
            case "S":
                break;
        }
        if (!opcion.equalsIgnoreCase("S")) {
            menu(sc);
        }

    }

    public static void consultaJugadores(Scanner sc) {
        System.out.println("Introduzca los filtros");
        System.out.print("Nombre del equipo: ");
        String nombreEquipo = sc.nextLine();
        System.out.print("Ciudad del equipo: ");
        String ciudad = sc.nextLine();
        System.out.print("Conferencia: ");
        String conferencia = sc.nextLine();
        System.out.print("Division: ");
        String division = sc.nextLine();

        String sql;
        sql = "select jugadores.codigo, jugadores.Nombre, jugadores.Nombre_equipo from jugadores, equipos where equipos.Nombre =jugadores.Nombre_equipo AND 1 = 1 ";
        int c = 0;
        if (nombreEquipo != null && !nombreEquipo.equals("")) {
            sql = sql + " AND Nombre_equipo = ? ";
        }
        if (ciudad != null && !ciudad.equals("")) {
            sql = sql + " AND Ciudad = ? ";
        }
        if (conferencia != null && !conferencia.equals("")) {
            sql = sql + " AND Conferencia = ? ";
        }
        if (division != null && !division.equals("")) {
            sql = sql + " AND Division = ? ";
        }
        System.out.println("SQL = " + sql);
        ResultSet rs = null;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NBA", "root", ""); PreparedStatement pstm = con.prepareStatement(sql);) {
            if (nombreEquipo != null && !nombreEquipo.equals("")) {
                c++;
                pstm.setString(c, nombreEquipo);
            }
            if (ciudad != null && !ciudad.equals("")) {
                c++;
                pstm.setString(c, ciudad + "%");
            }
            if (conferencia != null && !conferencia.equals("")) {
                c++;
                pstm.setString(c, conferencia + "%");
            }
            if (division != null && !division.equals("")) {
                c++;
                pstm.setString(c, division + "%");
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " -- " + rs.getString(2) + " -- " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Problemas al intentar recuperar la información");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el resultset");
                }
            }
        }
    }

    public static void detalleJugador(Scanner sc) {
        System.out.print("Codigo del jugador: ");
        int codigo = Integer.parseInt(sc.nextLine());
        ResultSet rs = null;
        String sql = "SELECT jugadores.codigo, jugadores.Nombre, jugadores.Procedencia, jugadores.Altura, jugadores.Peso, jugadores.Posicion, jugadores.Nombre_equipo FROM `jugadores` WHERE jugadores.codigo = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NBA", "root", ""); PreparedStatement stm = con.prepareStatement(sql);) {
            stm.setInt(1, codigo);
            rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println("-----------");
                System.out.println("→ Código: " + rs.getInt(1));
                System.out.println("→ Nombre: " + rs.getString(2));
                System.out.println("→ Procedencia: " + rs.getString(3));
                System.out.println("→ Altura: " + rs.getString(4));
                System.out.println("→ Peso: " + rs.getInt(5));
                System.out.println("→ Posición: " + rs.getString(6));
                System.out.println("→ Nombre del Equipo: " + rs.getString(7));
                System.out.println("----------");

            }
        } catch (Exception e) {
            System.out.println("Error " + e.getClass().getSimpleName() + ": " + e.getCause());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el resultset");
                }
            }
        }
    }

    public static void nVictoriasDerrotas(Scanner sc) {
        
        System.out.print("Equipo: ");
        String equipo = sc.nextLine();
        System.out.print("Temporada: ");
        String temporada = sc.nextLine();

        ResultSet rsV = null;
        ResultSet rsD = null;
        
        String sqlVictorias = "SELECT COUNT(*) as victorias from partidos where ((partidos.equipo_local = ? and partidos.puntos_local > partidos.puntos_visitante) OR (partidos.equipo_visitante = ? and partidos.puntos_visitante > partidos.puntos_local)) AND partidos.temporada = ?";
        String sqlDerrotas = "SELECT COUNT(*) as victorias from partidos where ((partidos.equipo_local = ? and partidos.puntos_local < partidos.puntos_visitante) OR (partidos.equipo_visitante = ? and partidos.puntos_visitante < partidos.puntos_local)) AND partidos.temporada = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/NBA", "root", "");
            PreparedStatement stmV = con.prepareStatement(sqlVictorias); 
            PreparedStatement stmD = con.prepareStatement(sqlDerrotas);) {
            stmV.setString(1, equipo);
            stmV.setString(2, equipo);
            stmV.setString(3, temporada);
            stmD.setString(1, equipo);
            stmD.setString(2, equipo);
            stmD.setString(3, temporada);
            rsV = stmV.executeQuery();
            rsD = stmD.executeQuery();

            while (rsV.next()) {
                System.out.println("-----------");
                System.out.println("→ Victorias: " + rsV.getInt(1));
                System.out.println("----------");
            }
            while (rsD.next()) {
                System.out.println("→ Derrotas: " + rsD.getInt(1));
                System.out.println("----------");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + ": " + e.getCause());
            e.printStackTrace();
        } finally {
            if (rsV != null) {
                try {
                    rsV.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el resultset");
                }
            }
            if (rsD != null) {
                try {
                    rsD.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el resultset");
                }
            }
        }

    }

}
