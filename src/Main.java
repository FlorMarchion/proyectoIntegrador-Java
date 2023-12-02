import entities.*;
import entities.Expense;
import exceptions.InvalidExpenseException;
import interfaces.ExpenseAmountValidator;
import interfaces.ExpenseAmountValidatorImpl;
import interfaces.ExpenseCalculator;
import interfaces.ExpenseCalculatorImpl;
import util.Utilities;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static int counter = 1;
    public static void main(String[] args) throws InvalidExpenseException {
        Scanner scanner = new Scanner(System.in);

        int index = 0;
        double amount;
        boolean isWrongType = false;
        int amountExpeses = 0;

        ExpenseAmountValidator expenseAmountValidator = new ExpenseAmountValidatorImpl();
        ExpenseCalculator expenseCalculator = new ExpenseCalculatorImpl();

        /*do{
            System.out.print("Ingrese la cantidad de datos que quiere registrar: ");
         if(scanner.hasNextInt()){
             amountExpeses = scanner.nextInt();
         }else{
             System.out.println("Has ingresado un dato inválido");
         }
        }while(isWrongType);*/

        boolean cutLogicVar;
        System.out.println("¿Desea cargar un gasto? TRUE/FALSE");
        cutLogicVar = scanner.nextBoolean();

        List<Expense> expenses = new ArrayList<>();

        Map<String, Integer> countCategoryMap = null;
        while (cutLogicVar) {
            Expense expense = new Expense();
            ExpenseCategory category = new ExpenseCategory();

            countCategoryMap = new HashMap<>();

            System.out.print("Ingresá el monto del gasto número " + (index+1) + ": ");
            amount = scanner.nextDouble();

            if (!expenseAmountValidator.validateAmount(amount)) {
                System.out.println("El monto es: " + amount);
            }

            scanner.nextLine();

            System.out.print("Ingresa la categoría del gasto: ");
            String name = scanner.nextLine().toLowerCase().trim();
            category.setName(name);

            System.out.print("Ingresa la fecha del gasto: (dd/MM/yyyy) ");
            String date = scanner.nextLine();

            countCategoryMap.put(name, countCategoryMap.getOrDefault(name, 0) + 1);

            expense.setId(counter);
            expense.setAmount(amount);
            expense.setCategory(category);
            expense.setDate(date);

            //guardo el gasto
            expenses.add(expense);

            counter++;
            index++;

            System.out.println("¿Desea cargar otro gasto? TRUE/FALSE");
            cutLogicVar = scanner.nextBoolean();
        }

        System.out.println("Total de gastos ingresados: $" + expenseCalculator.calculateTotalExpense(expenses));

        System.out.println("TOP 3 DE MONTOS DE GASTOS INGRESADOS"); //Queda pendiente mostrar los 3 gastos de mayor a menor
        List<Double> amounts = expenses.stream()
                .map(e -> e.getAmount())
                .limit(3)
                .collect(Collectors.toList());
        amounts.forEach(System.out::println);

        System.out.println("CONTADOR POR CATEGORÍA");
        countCategoryMap.forEach((category, count) -> System.out.println(category + ": " + count));

        System.out.println("DETALLE DE GASTOS INGRESADOS");
        Utilities.printElements(expenses);
    }



        /*//AGRAGAR SALDO
        Saldo saldo = new Saldo();
        Saldo.cargarSaldo();
        System.out.println("Tu saldo actual es: " + saldo.getSaldo());

        //AGREGAR GASTO
        Expense miGasto = new Expense();
        miGasto.agregarGasto(); */


        //Instancio categorías:
      //  Contador.Alimentacion alimentacion = new Contador.Alimentacion();
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
