package interfaces;

import dao.dto.ExpenseDto;
import entities.Expense;

import java.util.List;

public interface ExpenseCalculator {

    //Firmas del método
    double calculateExpense(Expense expense);
    double calculateTotalExpense(List<ExpenseDto> expenses); //Lista que almacena todos los gastos
}
