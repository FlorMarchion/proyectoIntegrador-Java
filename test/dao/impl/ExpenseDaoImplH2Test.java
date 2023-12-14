package dao.impl;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ExpenseDaoImplH2Test {

    private final Connection connectionMock = mock(Connection.class);
    private final ResultSet resultSetMock = mock(ResultSet.class);
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
    @DisplayName("Cuando inserto un dto con valores correctos, " +
    "el registro es insertado correctamente a la DB")
    void insertExpense_WhenValidExpenseDto() throws SQLException {
        //GIVEN
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setAmount(100.0);
        expenseDto.setDate("4/08/2023");
        expenseDto.setCategoryId(2);

        //Verifico el funcionamiento de las sentencias que se ejecutan, el este caso los statements
        when(preparedStatementMock.executeUpdate()).thenReturn(1);

        //WHEN
        expenseDao.insert(expenseDto);

        //THEN
        verify(preparedStatementMock).setString(1, expenseDto.getDate());
        verify(preparedStatementMock).setString(2, expenseDto.getDescription());
        verify(preparedStatementMock).setDouble(3, expenseDto.getAmount());
        verify(preparedStatementMock).setInt(4, expenseDto.getCategoryId());
        verify(preparedStatementMock, times(1)).executeUpdate();

    }

    @Test
    void getAll_ShouldReturnListOfExpenseDto_WhenDBHasData() throws SQLException {
        //GIVEN
        //Datos que espero recibir a partir del método getAll()
        List<ExpenseDto> expectedList;
        expectedList = List.of(
                new ExpenseDto("4/08/2023", "algo", 100.0, 2),
                new ExpenseDto("4/08/2023", "otra cosa", 400.0, 1)
        );

        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true, true, false);
        //when(resultSetMock.getInt("id")).thenReturn(2, 1);
        when(resultSetMock.getString("date")).thenReturn("4/08/2023");
        when(resultSetMock.getString("description")).thenReturn("algo", "otra cosa");
        when(resultSetMock.getDouble("amount")).thenReturn(100.0, 400.0);
        when(resultSetMock.getInt("categoryId")).thenReturn(2);

        //WHEN
        List<ExpenseDto> resultList = expenseDao.getAll(); //Ejecuto el método

        //THEN
        verify(preparedStatementMock).executeQuery();
        //agregar tmb el verify de description 2
       // verify(resultSetMock, times(2)).getInt("id");
        verify(resultSetMock, times(2)).getString("date");
        verify(resultSetMock, times(2)).getString("description");
        verify(resultSetMock, times(2)).getDouble("amount");
        verify(resultSetMock, times(2)).getInt("categoryId");

        assertEquals(expectedList.size(), resultList.size());
    }

}