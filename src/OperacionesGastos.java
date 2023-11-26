public class OperacionesGastos implements Contador{

    @Override
    public void contador(Saldo saldo) {
    double monto = saldo.getSaldo() -1;
        System.out.println("Ahora tu saldo es de: " + monto);
    }
}
