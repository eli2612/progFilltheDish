package home.home2.model.exceptions;

public class DuplicateRecipeException extends Exception{

    public DuplicateRecipeException(){
        super();
    }

    public DuplicateRecipeException(String message){
        super(message);
    }

    public DuplicateRecipeException(Throwable cause){
        super(cause);
    }

    public DuplicateRecipeException (String message, Throwable cause){
        super("+++"+message+"+++",cause);
    }
}
