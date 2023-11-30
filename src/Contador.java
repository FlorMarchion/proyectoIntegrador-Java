import entities.Expense;

import java.util.Scanner;

public interface Contador  {

    //Método que toma el saldo actual
     void contador(Saldo saldo);

    interface ExpensesFuntions {

        default void agregarGasto() {
            Scanner scanner = new Scanner(System.in);
            boolean respuesta = false;
            do {
                System.out.println("¿Desea agregar un nuevo gasto?");
                String respuestaIngresada = scanner.nextLine();
                if (respuestaIngresada.contains("si")) {
                    elegirCategoria();
                    respuesta = true;
                } else if (respuestaIngresada.contains("no")) {
                    System.out.println("Tu saldo actual es:");
                    respuesta = true;
                }
            } while (!respuesta);
        }

        default void elegirCategoria() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Elige en cuál de las siguientes categorías quieres agregar tu gasto: ");
            System.out.println("1. Alimentos\n2. Cuidado Personal\n3. Deudas y Pagos\n4. Educación\n5. Entretenimiento\n6. Impuestos\n7. Ropa y Accesorios\n8. Transporte\n9. Vivienda\n10. Misceláneos");
            System.out.println("Escribe el número de la opción elegida ---> ");
            //Manejar validación de datos.
            //Crear una excepción que meneje elección de categorías.

            int opcion = scanner.nextInt();
            scanner.nextLine();


           /* switch (opcion) {
                case 1:
                    Alimentacion alimentacion = new Alimentacion();
                    alimentacion.agregarGastoCategoria();
                    break;
                // Agregar casos para otras categorías
                default:
                    System.out.println("Opción no válida");
                    break;
            }*/


        }
    }

    class Alimentacion extends Expense {

        public Alimentacion() {
        }
    }
}
