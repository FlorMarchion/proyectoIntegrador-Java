import categorias.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //AGRAGAR SALDO
        Saldo saldo = new Saldo();
        Saldo.cargarSaldo();
        System.out.println("Tu saldo actual es: " + saldo.getSaldo());

        //AGREGAR GASTO
        Gasto miGasto = new MiGasto();
        miGasto.agregarGasto();
        miGasto.elegirCategoria();




        //Instancio categorías:
        Alimentacion alimentacion = new Alimentacion("Alimentación");
        CuidadoPersonal CuidadoPersonal = new CuidadoPersonal("Cuidado Personal");
        DeudasPagos deudasPagos = new DeudasPagos("Deudas y Pagos");
        Educacion educacion = new Educacion("Educación");
        Entretenimiento entretenimiento = new Entretenimiento("Entretenimiento");
        Impuestos impuestos = new Impuestos("Impuestos");
        RopaAccesorios ropaAccesorios = new RopaAccesorios("Ropa y Accesorios");
        Transporte transporte = new Transporte("Transporte");
        Vivienda vivienda = new Vivienda("Vivienda");
        Micelaneos micelaneos = new Micelaneos("Micelaneos");

        System.out.println(alimentacion.getNombre());
        OperacionesGastos operacionesGastos = new OperacionesGastos();
        operacionesGastos.contador(saldo);
    }
}