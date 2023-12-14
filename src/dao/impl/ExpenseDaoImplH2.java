package dao.impl;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import entities.Expense;
import exceptions.DAOException;

import javax.management.StringValueExp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDaoImplH2 implements ExpenseDao {

    private static final String INSERT_INTO_EXPENSE =
            "INSERT INTO GESTION_GASTOS.EXPENSE (date, description, amount, category_id) VALUES (?, ?, ?, ?)";

    private static final String GET_ALL_EXPENSES = "SELECT * FROM GESTION_GASTOS.EXPENSE";
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
    }

    private Expense mapDtoToExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setAmount(expenseDto.getAmount());
        expense.setCategoryId(expenseDto.getCategoryId());
        expense.setDate(expenseDto.getDate());
        return expense;
    }

    //Datos que traigo de la DB
    @Override
    public List<ExpenseDto> getAll() {
        try(PreparedStatement statement = connection.prepareStatement(GET_ALL_EXPENSES)){
            ResultSet resultSet = statement.executeQuery();
            List<ExpenseDto> expenses = new ArrayList<>();
            //Itero el resultSet para agregar el gasto a la lista y
            //Mientras agrego, realizo el mapeo a cada item
            while (resultSet.next()){ // si existe un registro, lo agrego a la lista
                expenses.add(mapResultSetToExpenseDto(resultSet));
            }
            return expenses;
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la lista de gastos",e);
        }
    }

    private ExpenseDto mapResultSetToExpenseDto(ResultSet resultSet) throws SQLException {
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setAmount(resultSet.getDouble("amount"));
        expenseDto.setDate((resultSet.getString("date")));
        expenseDto.setDescription(resultSet.getString("description"));
        expenseDto.setCategoryId(resultSet.getInt("categoryId"));
        return expenseDto;
    }

    @Override
    public void update(ExpenseDto expenseDto) {

    }

    @Override
    public void delete(Integer id) {

    }
}
