import java.util.Locale;
import java.util.Scanner;

public interface Gasto {

    int id = 0;
    String fecha = null;
    String categoria = null;


default void agregarGasto(){
    Scanner scanner = new Scanner(System.in);
    boolean respuesta = false;
    do{
            System.out.println("¿Desea agregar un nuevo gasto?");
            String respuestaIngresada = scanner.nextLine();
            if(respuestaIngresada.contains("si")){
                elegirCategoria();
                respuesta = true;
            } else if (respuestaIngresada.contains("no")) {
                System.out.println("Nos vemos pronto");
                respuesta = true;
            }
    }while(!respuesta);
}

default void elegirCategoria(){
    Scanner scanner = new Scanner(System.in);
    String respuesta = "";
    System.out.println("Elige en cuál de las siguientes categorías quieres agregar tu gasto: \n Alimentos\n Cuidado Personal\n Deudas y Pagos\n Educación\n Entretenimiento\n Impuestos\n Ropa y Accesorios\n Transporte\n Vivienda\n Mecelaneos ");
    System.out.println("Escribre la opción elegida ---> ");
     //Manejar validación de datos.
    //Crear una excepción que meneje elección de categorías.
     try{
         respuesta = scanner.nextLine().toLowerCase();
     }catch (Exception e){
         System.out.println("Error: Has ingresado un dato inválido");
     }
    System.out.println("Tu respuesta es: " + respuesta);

}
public abstract void calcularGasto();

}
