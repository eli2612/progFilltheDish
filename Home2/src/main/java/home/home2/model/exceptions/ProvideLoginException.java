package home.home2.model.exceptions;

public class ProvideLoginException extends Exception {

    public  ProvideLoginException() {
        super();
    }

    public ProvideLoginException(String message){
        super(message);
    }

    public ProvideLoginException(Throwable cause){
        super (cause);
    }

    public ProvideLoginException(String message, Throwable cause){
        super("+++"+message+"+++",cause);
    }
}
