package ordenardatoscsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenarDatosCSV {

    public static void main(String[] args) {
        String archivo = "hola.csv";  // Nombre del archivo CSV
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) { // Corregido 'FileeRader' a 'FileReader'
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

            // Ordenar las líneas alfabéticamente utilizando una clase personalizada Comparator
            Collections.sort(lineas, new CSVLineComparator());

            // Imprimir las líneas ordenadas
            for (String l : lineas) {
                System.out.println(l);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clase Comparator personalizada para comparar las líneas del archivo CSV
    static class CSVLineComparator implements Comparator<String> {
        @Override
        public int compare(String linea1, String linea2) {
            String[] campos1 = linea1.split(",");
            String[] campos2 = linea2.split(",");
            // Comparar los primeros campos de las líneas
            return campos1[1].compareTo(campos2[1]);
        }
    }
}
