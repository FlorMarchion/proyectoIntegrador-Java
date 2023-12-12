import config.JdbcConfiguration;
import dao.ExpenseCategoryDao;
import dao.ExpenseDao;
import dao.dto.ExpenseCategoryDto;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseCategoryDaoImplH2;
import dao.impl.ExpenseDaoImplH2;
import entities.*;
import exceptions.InvalidExpenseException;
import interfaces.ExpenseAmountValidator;
import interfaces.ExpenseAmountValidatorImpl;
import interfaces.ExpenseCalculator;
import interfaces.ExpenseCalculatorImpl;
import util.Utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InvalidExpenseException {
        Scanner scanner = new Scanner(System.in);

        try(Connection connection = JdbcConfiguration.getDbConnection()){
            ExpenseDao expenseDao = new ExpenseDaoImplH2(connection);
            ExpenseCategoryDao expenseCategoryDao = new ExpenseCategoryDaoImplH2(connection);

            int index = 0;
            double amount;

            ExpenseAmountValidator expenseAmountValidator = new ExpenseAmountValidatorImpl();
            ExpenseCalculator expenseCalculator = new ExpenseCalculatorImpl();

            String cutLogicVar;
            System.out.println("¿Desea cargar un gasto? SI/NO");
            cutLogicVar = scanner.nextLine();

            Map<String, Integer> countCategoryMap = null;
            while (cutLogicVar.equals("SI")) {
                ExpenseDto expenseDto = new ExpenseDto();
                ExpenseCategoryDto category = new ExpenseCategoryDto();

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
                expenseCategoryDao.insert(category);

                System.out.print("Ingresa la fecha del gasto: (dd/MM/yyyy) ");
                String date = scanner.nextLine();

                countCategoryMap.put(name, countCategoryMap.getOrDefault(name, 0) + 1);

                expenseDto.setAmount(amount);

                ExpenseCategory expenseCategory = expenseCategoryDao.getCategoryName(name);

                expenseDto.setCategoryId(expenseCategory.getId()); //Tomo el id del name y seteo ese id en el expense
                expenseDto.setDate(date);
                //setDescription

                //insert
                expenseDao.insert(expenseDto);


                index++;

                System.out.println("¿Desea cargar otro gasto? SI/NO");
                cutLogicVar = scanner.nextLine();
            }

            //Lista de gastos recuperada de la DB
            List<ExpenseDto> expenses = expenseDao.getAll();

            System.out.println("Total de gastos ingresados: $" + expenseCalculator.calculateTotalExpense(expenses));

            System.out.println("TOP 3 DE MONTOS DE GASTOS INGRESADOS"); //Queda pendiente mostrar los 3 gastos de mayor a menor
            //Recupero el listado de gastos
            List<Double> amounts = expenses.stream()
                    .map(e -> e.getAmount())
                    .limit(3)
                    .collect(Collectors.toList());
            amounts.forEach(System.out::println);

            System.out.println("count categoryMap:" + countCategoryMap);

            System.out.println("CONTADOR POR CATEGORÍA");
            countCategoryMap.forEach((category, count) -> System.out.println(category + ": " + count));

            System.out.println("DETALLE DE GASTOS INGRESADOS");
            Utilities.printElements(expenses);
        }catch (SQLException exception){
            exception.printStackTrace();
        }
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
