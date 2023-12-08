package dao.impl;

import dao.ExpenseCategoryDao;
import dao.dto.ExpenseCategoryDto;
import entities.ExpenseCategory;
import exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseCategoryDaoImplH2 implements ExpenseCategoryDao {

    private static final String GET_CATEGORY_BY_NAME = "SELECT * FORM expensecategory WHERE name = ?";
    private static final String INSERT_INTO_EXPENSE_CATEGORY = " INSERT INTO expenseCategory (name) VALUES (?)";
    private final Connection connection;
    public ExpenseCategoryDaoImplH2(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(ExpenseCategoryDto expenseCategoryDto) {
        try(PreparedStatement statement = connection.prepareStatement(INSERT_INTO_EXPENSE_CATEGORY)){
            //Mapeo desde el DTO hacia la entidad
            ExpenseCategory expenseCategory = mapDtoExpenseCategory(expenseCategoryDto);

            statement.setString(1, expenseCategory.getName());
            int affectedRows = statement.executeUpdate();
            //Vallido si el resultado de la ejecución del statement no devuelve filas afectadas,
            //entonces hubo un error al insertar en la base de datos
            if(affectedRows == 0){
                throw new DAOException("Error al insertar el gato, ninguna fila fue afectada");
            }
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private ExpenseCategory mapDtoExpenseCategory(ExpenseCategoryDto expenseCategoryDto) {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setName(expenseCategory.getName());
        return expenseCategory;
    }


    @Override
    public ExpenseCategory getCategoryName(String name) {
        try(PreparedStatement statement = connection.prepareStatement(GET_CATEGORY_BY_NAME)){
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){ //si resulSet tiene un valor...(se itera resultSet)
                return new ExpenseCategory(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener el gasto por ID", e);
        }
    }
}
