package entities;

public class Expense{
   private Integer id;
   private String date;
   private String description;
   private Double amount;
   private Integer categoryId;

    public Expense() {
    }

    public Expense(Integer id, String date, String description, Double amount, Integer categoryId) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", categoryId=" + categoryId +
                '}';
    }
};
