package exceptions;

public class InvalidExpenseException extends Exception{
    public InvalidExpenseException(String message){
        super(message); //Llama al constructor de la clase Exception
    }
}
