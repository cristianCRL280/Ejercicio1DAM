/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MaquinaDeHelados;

/**
 *
 * @author dev
 */
public class MaquinaHelados {

    double monedero = 0;
    double ingresos = 0;
    Helado[][] helados = new Helado[3][3];

    public MaquinaHelados() {
        helados[0][0] = new Helado("ChocoBomba", 1.1, "tarrina");
        helados[0][1] = new Helado("FresaGuapi", 0.8, "palo");
        helados[0][2] = new Helado("LimonCanela", 1.5, "cucurucho");
        helados[1][0] = new Helado("FrigLemon", 1.8, "tarrina");
        helados[1][1] = new Helado("PiñaColada", 1.0, "palo");
        helados[1][2] = new Helado("MoraGuay", 1.2, "cucurucho");
        helados[2][0] = new Helado("ChocoLoco", 1.8, "tarrina");
        helados[2][1] = new Helado("TuttiFrutti", 1.3, "palo");
        helados[2][2] = new Helado("Mentazul", 1.2, "cucurucho");
    }
    

}
