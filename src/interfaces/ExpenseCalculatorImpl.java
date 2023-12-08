package interfaces;

import dao.dto.ExpenseDto;
import entities.Expense;

import java.util.List;

public class ExpenseCalculatorImpl implements ExpenseCalculator {
    @Override
    public double calculateExpense(Expense expense) {
        return expense.getAmount();
    }

    @Override
    public double calculateTotalExpense(List<ExpenseDto> expenses) {
        double totalExpense = 0;
        for (ExpenseDto expense : expenses){
            totalExpense += expense.getAmount();
        }
        return totalExpense;
    }
}
