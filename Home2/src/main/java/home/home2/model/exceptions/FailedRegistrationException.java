package home.home2.model.exceptions;

public class FailedRegistrationException extends Exception {

    public FailedRegistrationException(){
        super();
    }

    public FailedRegistrationException(String message){
        super(message);
    }

    public FailedRegistrationException(Throwable cause){
        super(cause);
    }

    public FailedRegistrationException (String message, Throwable cause) {
        super("+++" + message + "+++", cause);
    }
}
