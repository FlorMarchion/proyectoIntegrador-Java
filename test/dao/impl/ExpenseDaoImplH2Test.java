package dao.impl;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

class ExpenseDaoImplH2Test {

    private final Connection connectionMock = mock(Connection.class);

    @Mock
    private PreparedStatement preparedStatementMock;
    private ExpenseDao expenseDao;

    @BeforeEach //Antes de cada test se ejecutaŕa lo que está dentro de este método generalizador.
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);//Inserta los mocks de esta clase.
        when (connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);//mockea la inicializacion deñ preparedStatement.
        expenseDao = new ExpenseDaoImplH2(connectionMock);

    }

    @Test
    void insertExpense_WhenValidExpenseDto() throws SQLException {
        //GIVEN
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setAmount(100.00);
        expenseDto.setDate("4/08/2023");
        expenseDto.setCategoryId(2);

        //Verifico el funcionamiento de las sentencias que se ejecutan, el este caso los statements
        when(preparedStatementMock.executeUpdate()).thenReturn(1);

        //WHEN
        expenseDao.insert(expenseDto);

        //THEN
        verify(preparedStatementMock).setDouble(1, expenseDto.getAmount());
        verify(preparedStatementMock).setInt(2, expenseDto.getCategoryId());
        verify(preparedStatementMock).setString(3, expenseDto.getDate());
        //agregar tmb el verify de description
        verify(preparedStatementMock, times(1)).executeUpdate();

    }

}