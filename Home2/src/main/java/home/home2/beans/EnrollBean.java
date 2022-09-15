package home.home2.beans;
import java.util.regex.Pattern;

public class EnrollBean {

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    public void setUsername(String userName){
        this.username = userName;
    }

    public String getUsername(){
        return username;
    }


    public void setName(String name){
        this.nome = name;
    }

    public String getName(){
        return nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public String getCognome(){ return cognome;}

    public void setEmail(String email) { this.email = email;  }

    public String getEmail(){ return email;}

    public void setPassword(String pwd){
        this.password = pwd;
    }

    public String getPassword(){
        return password;
    }

    public static boolean verifyEmail(String email){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$";
        Pattern p = Pattern.compile(regex);
        return p.matcher(email).matches();
    }


}
