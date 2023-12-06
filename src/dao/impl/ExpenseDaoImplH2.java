package dao.impl;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import entities.Expense;
import exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ExpenseDaoImplH2 implements ExpenseDao {

    private static final String INSERT_INTO_EXPENSE =
            "INSERT INTO expense (date, description, amount, category_id) VALUES (?, ?, ?, ?)";

    private final Connection connection; //dependencia

    public ExpenseDaoImplH2(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(ExpenseDto expenseDto) throws SQLException {

        //PreparedStatement genera la ejecución de la sentencia SQl
        try(PreparedStatement statement = connection.prepareStatement(
                INSERT_INTO_EXPENSE)){
            //Mapeo el dto hacia la entidad
            Expense expense = mapDtoToExpense(expenseDto);
            statement.setString(1, expense.getDate());
            statement.setString(2, expense.getDescription());
            statement.setDouble(3, expense.getAmount());
            statement.setInt(4, expense.getCategoryId());

           int affectedRows =  statement.executeUpdate();
           if(affectedRows == 0){
               throw new DAOException("Error al insertar el gasto, ninguna fila fue afectada");
           }

        }catch (SQLException | DAOException e) {
            throw new RuntimeException(e);
        }

        connection.prepareStatement();
    }

    private Expense mapDtoToExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setAmount(expenseDto.getAmount());
        expense.setCategoryId(expenseDto.getCategory());
        expense.setDate(expenseDto.getDate());
        return expense;
    }

    @Override
    public List<ExpenseDto> getAll() {
        return null;
    }

    @Override
    public void update(ExpenseDto expenseDto) {

    }

    @Override
    public void delete(Integer id) {

    }
}
