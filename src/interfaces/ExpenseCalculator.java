package interfaces;

import entities.Expense;

import java.util.List;

public interface ExpenseCalculator {

    //Firmas del método
    double calculateExpense(Expense expense);
    double calculateTotalExpense(List<Expense> expenses); //Lista que almacena todos los gastos
}
