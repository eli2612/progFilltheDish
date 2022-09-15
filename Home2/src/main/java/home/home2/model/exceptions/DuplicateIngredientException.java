package home.home2.model.exceptions;

public class DuplicateIngredientException extends Exception{

    public DuplicateIngredientException(){
        super();
    }

    public DuplicateIngredientException(String message){
        super(message);
    }

    public DuplicateIngredientException(Throwable cause){
        super(cause);
    }

    public DuplicateIngredientException (String message, Throwable cause){
        super("+++"+message+"+++",cause);
    }

}
