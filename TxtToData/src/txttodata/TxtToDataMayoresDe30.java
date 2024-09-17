import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtToDataMayoresDe30 {

    public static void main(String[] args) {
        String archivoTxt = "datos.txt";
        String archivoData = "datos.data";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoTxt));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoData))) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                int edad = Integer.parseInt(partes[2]);
                if (edad > 30) {
                    bw.write(linea);
                    bw.newLine();
                }
            }

            System.out.println("Datos de personas mayores de 30 escritos en el archivo " + archivoData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
