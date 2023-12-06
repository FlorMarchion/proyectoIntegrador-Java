package dao.dto;

import entities.ExpenseCategory;

public class ExpenseDto {
    private String date;
    private String description;
    private Double amount;
    private ExpenseCategory category;

    public ExpenseDto() {
    }

    public ExpenseDto(String date, String description, Double amount, ExpenseCategory category) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.category = category;
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ExpeseDto{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", category=" + category +
                '}';
    }
};

