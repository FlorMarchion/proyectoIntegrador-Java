package exceptions;
import java.sql.SQLException;

//Custom Exception
public class DAOException extends Exception {
    public DAOException(String message){super(message);}
    public DAOException(String message, SQLException e) {super(message);}
}
