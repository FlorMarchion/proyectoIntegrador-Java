import java.util.Scanner;

public class Saldo {

    static double saldo = 0.0;


    public Saldo() {
    }

    public Saldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static void cargarSaldo(){
        Scanner scanner = new Scanner(System.in);
        boolean entradaValida = false;
        do{
            try{
                System.out.println("Ingresa tu saldo actual: ");
                String saldoIngresado = scanner.nextLine();
                saldo = Double.parseDouble(saldoIngresado);
               entradaValida = true;
            }catch (NumberFormatException e){
                System.out.println("Error: Ingresa un valor numérico válido!");
            }
        }while(!entradaValida);
    }
}
