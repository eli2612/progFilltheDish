package home.home2.controller;

import home.home2.beans.LoginBean;
import home.home2.model.dao.UserDAO;
import home.home2.model.exceptions.LoginFailedException;
import home.home2.model.User;


public class LoginController {

    public boolean login(LoginBean loginbean) throws LoginFailedException {

        UserDAO userdao = new UserDAO();

        String s = userdao.verify(loginbean.getUsername(),loginbean.getPassword());
        if(s == null){
            throw new LoginFailedException("Account non registrato");
        }
        else {
           User.loginUser(loginbean.getUsername(), loginbean.getPassword());

            return true;
        }


    }

}
