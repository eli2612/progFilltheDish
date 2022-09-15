package home.home2.model.exceptions;

public class InvalidSyntaxEmailException extends Exception {

    public InvalidSyntaxEmailException(){
        super();
    }

    public InvalidSyntaxEmailException(String message){
        super(message);
    }

    public InvalidSyntaxEmailException(Throwable cause){
        super(cause);
    }

    public InvalidSyntaxEmailException (String message, Throwable cause) {
        super("+++" + message + "+++", cause);
    }
}
