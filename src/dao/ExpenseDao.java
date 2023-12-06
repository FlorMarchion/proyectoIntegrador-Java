package dao;

import dao.dto.ExpenseDto;

import java.sql.SQLException;
import java.util.List;

public interface ExpenseDao {
    void insert(ExpenseDto expenseDto) throws SQLException;
    List<ExpenseDto> getAll();
    void update(ExpenseDto expenseDto);
    void delete(Integer id);
}
