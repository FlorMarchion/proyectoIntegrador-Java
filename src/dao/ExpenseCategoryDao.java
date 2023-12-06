package dao;

import dao.dto.ExpenseCategoryDto;
import entities.ExpenseCategory;

public interface ExpenseCategoryDao {
    void insert(ExpenseCategoryDto expense);
    ExpenseCategory getCategoryName(String name);
}
