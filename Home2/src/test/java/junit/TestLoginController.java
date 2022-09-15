package junit;

import home.home2.beans.LoginBean;
import home.home2.controller.LoginController;
import home.home2.model.exceptions.LoginFailedException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*Author Nguikoo Letisia Ornelle
* Matricola : 0273667*/

class TestLoginController{

    private static final String USERNAME = "Lety";
    private static final String PASSWORD = "letisia";
    private static final String WRONG = "progettoISPW";

    @Test
    void testLoginWork(){
        boolean risultato;

        LoginController loginController = new LoginController();
        LoginBean loginbean = new LoginBean();

        loginbean.setUsername(USERNAME);
        loginbean.setPassword(PASSWORD);

        try{
            loginController.login(loginbean);
            risultato = true;
        } catch (LoginFailedException e) {
            risultato = false;
        }

        assertEquals(true,risultato);
    }

    @Test
    void testLoginWrongUsername(){
        LoginController loginController = new LoginController();
        LoginBean loginbean = new LoginBean();

        final String wrongUsername = WRONG;


        loginbean.setUsername(wrongUsername);
        loginbean.setPassword(PASSWORD);

        assertThrows(LoginFailedException.class, () ->loginController.login(loginbean));
    }

    @Test
    void testLoginWrongCredentials(){
        LoginController loginController = new LoginController();
        LoginBean loginbean = new LoginBean();

        final String wrongUsername = WRONG;
        final String wrongPassword = WRONG;

        loginbean.setUsername(wrongUsername);
        loginbean.setPassword(wrongPassword);

        assertThrows(LoginFailedException.class, () ->loginController.login(loginbean));
    }



}
