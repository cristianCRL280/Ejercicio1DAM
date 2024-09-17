/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioA;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author dev
 */
public class exec {

    public static void main(String[] args) {
        ArrayList<persona> per = new ArrayList<persona>();
        try {
            portero p1 = new portero(10d, "portero1", "paco", "sanchez", LocalDate.parse("1995-12-20"), 100d);
            per.add(p1);
        } catch (PorteroException e) {
            System.out.println(e.getMessage());
        }

        jugadorCampo jc1 = new jugadorCampo(7, "jc1", "pedro", "lopez", LocalDate.parse("1995-12-20"), 80);
        per.add(jc1);

        entrenador e1 = new entrenador(1995, "e1", "Cristian", "rodriguez", LocalDate.parse("1995-12-20"), 69d);
        per.add(e1);
        try {
            portero p2 = new portero(70d, "portero2", "carlos", "sanchez", LocalDate.parse("1995-12-20"), 10);
            per.add(p2);
        } catch (PorteroException e) {
            System.out.println(e.getMessage());
        }
        jugadorCampo jc2 = new jugadorCampo(20, "jc2", "juan", "lopez", LocalDate.parse("1995-12-20"), 8);
        per.add(jc2);

        entrenador e2 = new entrenador(1996, "e1", "aitor", "gomez", LocalDate.parse("1995-12-20"), 77d);
        per.add(e2);
        try {
            portero p3 = new portero(80d, "portero3", "munir", "harrasi", LocalDate.parse("1995-12-20"), 66);
            per.add(p3);
        } catch (PorteroException e) {
            System.out.println(e.getMessage());
        }
        jugadorCampo jc3 = new jugadorCampo(15, "jc3", "mike", "wasonski", LocalDate.parse("1995-12-20"), 60);
        per.add(jc3);

        entrenador e3 = new entrenador(1997, "e3", "xavi", "savito", LocalDate.parse("1995-12-20"), 50d);
        per.add(e3);

        listar(per);
        doparporteros(per);
        listar(per);
        getMediaGolesByGoles(per);
        getBestEntrenador(per);
        ordenarJugadores(per);
        borrarBestPortero(per);
        listar(per);
    }

    public static void listar(ArrayList<persona> per) {
        System.out.println("--------------------------");

        for (persona p : per) {
            System.out.println(p);
        }
    }

    public static void doparporteros(ArrayList<persona> per) {
        for (persona o : per) {
            if (o instanceof portero) {
                portero port = (portero) o;
                if (port.getPorcentajeParadas() < 20) {
                    port.doping();
                }
            }
        }

    }

    public static void getMediaGolesByGoles(ArrayList<persona> per) {
        int r = 0;
        int contador = 0;
        double media;
        for (persona o : per) {
            if (o instanceof jugadorCampo) {
                jugadorCampo jug = (jugadorCampo) o;
                r += jug.getGolesMarcados();
                contador++;
            }
        }
        media = 1.0d * r / contador;
        System.out.println("---------------");
        System.out.println(media);
    }

    public static void getBestEntrenador(ArrayList<persona> per) {
        ArrayList<entrenador> en = new ArrayList<entrenador>();
        for (persona o : per) {
            if (o instanceof entrenador) {
                en.add((entrenador) o);
            }
        }
        System.out.println("---------------");
        entrenador best = Collections.min(en);
        System.out.println(best);
    }

    public static void ordenarJugadores(ArrayList<persona> per) {
        ArrayList<jugadorCampo> en = new ArrayList<jugadorCampo>();
        for (persona o : per) {
            if (o instanceof jugadorCampo) {
                en.add((jugadorCampo) o);
                Collections.sort(en);
            }
        }
        System.out.println("---------------");
        for (jugadorCampo campo : en) {
            System.out.println(campo);
        }
    }

    public static void borrarBestPortero(ArrayList<persona> per) {
        double otroPorcentaje = Double.MIN_VALUE;
        portero temp = null;
        for (persona o : per) {
            if (o instanceof portero) {
                portero port = (portero) o;
                if (temp == null || port.getPorcentajeParadas() > otroPorcentaje) {
                    temp = port;
                    otroPorcentaje = port.getPorcentajeParadas();
                }
            }
        }
        System.out.println("--------------");
        per.remove(temp);
        System.out.println();
    }
}
