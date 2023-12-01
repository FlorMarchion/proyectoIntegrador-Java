package interfaces;

import entities.Expense;

public interface ExpenseCalculator {

    //Firmas del método
    double calculateExpense(Expense expense);
    double calculateTotalExpense(Expense[] expenses); //Array que almacena todos los gastos
}
