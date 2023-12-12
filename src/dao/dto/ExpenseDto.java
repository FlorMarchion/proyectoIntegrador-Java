package dao.dto;

import entities.ExpenseCategory;

public class ExpenseDto {
    private String date;
    private String description;
    private Double amount;
    private int categoryId;

    public ExpenseDto() {
    }

    public ExpenseDto(String date, String description, Double amount, int categoryId) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.categoryId = categoryId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", categoryId=" + categoryId +
                '}';
    }
};

