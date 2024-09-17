
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class Ejercicio01 {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String identificador = null;
        String nombre = null;
        Map<String, Integer> hs = new TreeMap<String, Integer>();
        int votos;
        do {
            System.out.print("Identificador de clase: ");
            identificador = sc.nextLine();
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (!identificador.equals("FIN")) {
                    System.out.print("Nombre del candidato: ");
                    nombre = sc.nextLine();
                    if (nombre.equals("FIN")) {
                        break;
                    } else {
                        System.out.print("Número de votos: ");
                        votos = sc.nextInt();
                        sc.nextLine();
                        addVoto((TreeMap<String, Integer>) hs, nombre, votos);
                    }
                }
            }
            
        } while (!identificador.equals("FIN"));
        System.out.println("SALIDA");
        
        for (Map.Entry<String, Integer> entry : hs.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println(key + " " + val + " votos");
            
        }
    }
    public static void addVoto(TreeMap<String, Integer> hs, String key, int votos){
        if (hs.containsKey(key)) {
            int votosAnteriores = hs.get(key);
            hs.put(key, votos + votosAnteriores);
        }else{
        hs.put(key, votos);
        }
    }
}
