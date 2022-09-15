package home.home2.model.exceptions;

public class LoginFailedException extends Exception{

    public  LoginFailedException() {
        super();
    }

    public LoginFailedException(String message){
        super(message);
    }

    public LoginFailedException(Throwable cause){
        super (cause);
    }

    public LoginFailedException(String message, Throwable cause){
        super("+++"+message+"+++",cause);
    }


}
