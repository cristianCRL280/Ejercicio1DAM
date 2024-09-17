package mecanico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Exec {

    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Moto m1 = new Moto(4, "Ducatti", "Marac", LocalDate.parse("2018-05-03"), 20);
        Moto m2 = new Moto(3, "Suzuki", "V-STROM 1050 TECH", LocalDate.parse("2022-01-01"), 222);
        Moto m3 = new Moto(2, "Honda", "CBR1000", LocalDate.parse("2015-11-07"), 156);

        vehiculos.add(m1);
        vehiculos.add(m2);
        vehiculos.add(m3);

        try {
            Camion c1 = new Camion(8, 3000, "Volvo", "Gama FH", LocalDate.parse("2017-07-07"), 400);
            vehiculos.add(c1);
        } catch (IncorrectEjesCamion e) {
            System.out.println("Error: Camion 1:  " + e.getMessage());
        }
        try {
            Camion c2 = new Camion(6, 5000, "Mercedes", "Gama Actros", LocalDate.parse("2014-01-01"), 542);
            vehiculos.add(c2);
        } catch (IncorrectEjesCamion e) {
            System.out.println("Error: Camion 2:  " + e.getMessage());
        }
        try {
            Camion c3 = new Camion(1, 1000, "Iveco", "Daily", LocalDate.parse("2019-09-09"), 450);
            vehiculos.add(c3);
        } catch (IncorrectEjesCamion e) {
            System.out.println("Error: Camion 3:  " + e.getMessage());
        }
        try {
            Coche co1 = new Coche(9, "Seat", "Cordoba", LocalDate.parse("2017-11-07"), 120);
            vehiculos.add(co1);
        } catch (IncorrectPasajerosCoche e) {
            System.out.println("Error: Coche 4:  " + e.getMessage());
        }
        try {
            Coche co2 = new Coche(4, "Seat", "Panda", LocalDate.parse("2012-11-11"), 120);
            vehiculos.add(co2);
        } catch (IncorrectPasajerosCoche e) {
            System.out.println("Error: Coche 5:  " + e.getMessage());
        }
        try {
            Coche co3 = new Coche(1, "Seat", "Leon", LocalDate.parse("2010-10-02"), 120);
            vehiculos.add(co3);
        } catch (IncorrectPasajerosCoche e) {
            System.out.println("Error: Coche 6:  " + e.getMessage());
        }
        listar(vehiculos);
        repostarCochesPasajerosIgual4(vehiculos);
        listar(vehiculos);
        maxminEjesCamiones(vehiculos);
        motoConMenosRuedas(vehiculos);
        mediaKmAutonomiaRestantesByTipoVehiculo(vehiculos);
        eliminarMotosMenosDe2yMasDe3Ruedas(vehiculos);
        listar(vehiculos);
    }

    public static void listar(ArrayList<Vehiculo> vehiculos) {
        System.out.println("------------- Listado de Vehiculos -------------");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }

    public static void repostarCochesPasajerosIgual4(ArrayList<Vehiculo> vehiculos) {
        System.out.println("------------- Repostar coches con número de pasajeros igual a 4 -------------");
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Coche) {
                Coche coche = (Coche) vehiculo;
                if (coche.getNumeroPasajeros() == 4) {
                    coche.repostar();
                }
            }
        }
    }

    public static void maxminEjesCamiones(ArrayList<Vehiculo> vehiculos) {
        System.out.println("------------- Número máximo y mínimo de ejes de los camiones -------------");
        int maxEjes = Integer.MIN_VALUE;
        int minEjes = Integer.MAX_VALUE;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Camion) {
                Camion camion = (Camion) vehiculo;
                int ejes = camion.getNumeroEjes();
                if (ejes > maxEjes) {
                    maxEjes = ejes;
                }
                if (ejes < minEjes) {
                    minEjes = ejes;
                }
            }
        }
        System.out.println("Número max de ejes de los camiones: " + maxEjes);
        System.out.println("Número min de ejes de los camiones: " + minEjes);
    }

    public static void motoConMenosRuedas(ArrayList<Vehiculo> vehiculos) {
        System.out.println("------------- Moto con menos número de ruedas -------------");
        Moto motoMasPequeña = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Moto) {
                Moto moto = (Moto) vehiculo;
                if (motoMasPequeña == null || moto.getCantidadRuedas() < motoMasPequeña.getCantidadRuedas()) {
                    motoMasPequeña = moto;
                }
            }
        }
        System.out.println("La moto con la rueda más pequeña es: " + motoMasPequeña);
    }

    public static void mediaKmAutonomiaRestantesByTipoVehiculo(ArrayList<Vehiculo> vehiculos) {
        System.out.println("------------- Meida de Km de Autonomia Restantes Por Tipo de Vehículo -------------");
        double kmCoche = 0;
        int cochesTotal = 0;
        double kmMoto = 0;
        int motosTotal = 0;
        double kmCamion = 0;
        int camionesTotal = 0;

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Coche) {
                kmCoche += vehiculo.getKmAutonomiaRestantes();
                cochesTotal++;
            }
            if (vehiculo instanceof Moto) {
                kmMoto += vehiculo.getKmAutonomiaRestantes();
                motosTotal++;
            }
            if (vehiculo instanceof Camion) {
                kmCamion += vehiculo.getKmAutonomiaRestantes();
                camionesTotal++;
            }
        }

        double mediaCoche = kmCoche / cochesTotal;
        double mediaMoto = kmMoto / motosTotal;
        double mediaCamion = kmCamion / camionesTotal;

                System.out.println("Media de km de autonomía restantes de los Coches: " + mediaCoche);
        System.out.println("Media de km de autonomía restantes de los Motos: " + mediaMoto);
        System.out.println("Media de km de autonomía restantes de los Camiones: " + mediaCamion);
    }

    public static void eliminarMotosMenosDe2yMasDe3Ruedas(ArrayList<Vehiculo> vehiculos) {
        System.out.println("------------- Eliminar Motos con Menos de 2 y Mas de 3 Ruedas -------------");
        ArrayList<Vehiculo> aBorrar = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Moto) {
                Moto moto = (Moto) vehiculo;
                if (moto.getCantidadRuedas() < 2 || moto.getCantidadRuedas() > 3) {
                    aBorrar.add(moto);
                }
            }
        }
        vehiculos.removeAll(aBorrar);
    }
}

