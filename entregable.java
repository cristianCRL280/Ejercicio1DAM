
import java.util.HashMap;
import java.util.Map;

import java.util.*;

/**
 *
 * @author Cristian-RodriguezyDaniel-Duque
 */
public class entregable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        String categoria, equipoLocal, equipoVisitante, ganador;
        int setLocal, setVisitante, equipos, partidosFaltan = 0, partidosJugados = 0;

        do {
      
            categoria = sc.nextLine();

            if (!categoria.equals("FIN")) {
                do {
                    equipoLocal = sc.next();

                    if (!equipoLocal.equals("FIN")) {
                        setLocal = Integer.parseInt(sc.next());
                        equipoVisitante = sc.next();
                        setVisitante = Integer.parseInt(sc.next());
                        partidosJugados++;
                        insertarVotos(equipoLocal, equipoVisitante, setLocal, setVisitante, hs);
                        equipos = hs.size();
                        partidosFaltan = calcularPartidos(equipos, partidosJugados);
                    }
                } while (!equipoLocal.equals("FIN"));
                ganador = getGanador(hs);
                sc.nextLine();
                System.out.println(ganador + " " + partidosFaltan);
                hs.clear();

            }
        } while (!categoria.equals("FIN"));
    }

    public static String getGanador(HashMap<String, Integer> hs) {
        int temp = 0;
        String ganador = "EMPATE";

        for (Map.Entry<String, Integer> entry : hs.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();

            if (val > temp) {
                ganador = key;
                temp = val;
            } else if (val == temp) {
                ganador = "EMPATE";
            }
        }

        return ganador;
    }

    public static void insertarVotos(String equipoLocal, String equipoVisitante, int setLocal, int setVisitante, HashMap<String, Integer> hs) {
        if (!hs.containsKey(equipoLocal)) {
            hs.put(equipoLocal, 0);
        }
        if (!hs.containsKey(equipoVisitante)) {
            hs.put(equipoVisitante, 0);
        }
        if (setLocal > setVisitante) {
            hs.put(equipoLocal, hs.get(equipoLocal) + 2);
            hs.put(equipoVisitante, hs.get(equipoVisitante) + 1);
        } else if (setLocal < setVisitante) {
            hs.put(equipoVisitante, hs.get(equipoVisitante) + 2);
            hs.put(equipoLocal, hs.get(equipoLocal) + 1);
        }
    }

    public static int calcularPartidos(int equipos, int partidosJugados) {
        int partidos;
        partidos = equipos * (equipos - 1) - partidosJugados;
        return partidos;
    }
}
