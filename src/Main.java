import entities.*;
import entities.Expense;

import java.util.Scanner;

public class Main {
    public static int counter = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index = 1;
        double amount;
        boolean isWrongType = false;
        int amountExpeses = 0;

        do{
            System.out.print("Ingrese la cantidad de datos que quiere registrar: ");
         if(scanner.hasNextInt()){
             amountExpeses = scanner.nextInt();
         }else{
             System.out.println("Has ingresado un dato inválido");
         }
        }while(isWrongType);

        //guardo los gastos que ingresé en un array
        Expense[] expenses = new Expense[amountExpeses];

    do{
        Expense expense = new Expense();
        ExpenseCategory category = new ExpenseCategory();

        System.out.print("Ingresá el monto del gasto número " + index + ": ");
        amount = scanner.nextDouble();

        scanner.nextLine();

        String name = scanner.nextLine().toLowerCase().trim();
        category.setName(name);

        System.out.print("Ingresa la fecha del gasto: (dd/MM/yyyy) ");
        String date = scanner.nextLine();

        expense.setId(counter);
        expense.setAmount(amount);
        expense.setCategory(category);
        expense.setDate(date);

        //guardo el gasto
        expenses[index] = expense;

        counter++;
        index++;
    }while (index < amountExpeses);

        System.out.println("DETALLE DE GASTOS INGRESADOS:");
        for (int i = 0; i<expenses.length; i++){
            System.out.println(expenses[i]);
        }

        /*//AGRAGAR SALDO
        Saldo saldo = new Saldo();
        Saldo.cargarSaldo();
        System.out.println("Tu saldo actual es: " + saldo.getSaldo());

        //AGREGAR GASTO
        Expense miGasto = new Expense();
        miGasto.agregarGasto(); */


        //Instancio categorías:
        Contador.Alimentacion alimentacion = new Contador.Alimentacion();
        /*CuidadoPersonal CuidadoPersonal = new CuidadoPersonal("Cuidado Personal");
        DeudasPagos deudasPagos = new DeudasPagos("Deudas y Pagos");
        Educacion educacion = new Educacion("Educación");
        Entretenimiento entretenimiento = new Entretenimiento("Entretenimiento");
        Impuestos impuestos = new Impuestos("Impuestos");
        RopaAccesorios ropaAccesorios = new RopaAccesorios("Ropa y Accesorios");
        Transporte transporte = new Transporte("Transporte");
        Vivienda vivienda = new Vivienda("Vivienda");
        Micelaneos micelaneos = new Micelaneos("Micelaneos");*/

        /*System.out.println(alimentacion.getNombre());
        OperacionesGastos operacionesGastos = new OperacionesGastos();
        operacionesGastos.contador(saldo);*/
    }
}