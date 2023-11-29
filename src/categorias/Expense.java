package categorias;

public class Expense implements Gasto{

   private int id;
   private String date;
   private String description;
   private double amount;


    public Expense() {
    }

    public Expense(int id, String date, String description, double amount) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }

    public void agregarGastoCategoria(){
        System.out.println("Esta sería la lista de gastos dentro de la categoría alimentación");
    };


}
