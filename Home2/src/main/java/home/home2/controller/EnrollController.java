package home.home2.controller;

import home.home2.beans.EnrollBean;
import home.home2.model.User;
import home.home2.model.exceptions.FailedRegistrationException;
import home.home2.model.exceptions.InvalidSyntaxEmailException;

import static home.home2.beans.EnrollBean.verifyEmail;

public class EnrollController {

    public boolean addUser(EnrollBean eb )throws FailedRegistrationException, InvalidSyntaxEmailException {

        if ((eb.getPassword().equals("") || eb.getUsername().equals("") || eb.getName().equals("") || eb.getCognome().equals("") || eb.getEmail().equals(""))) {

            throw new FailedRegistrationException();
        }
        if( eb.getPassword().length() < 8 ){

            throw new FailedRegistrationException();

        }
        if(!verifyEmail(eb.getEmail())){
            throw new InvalidSyntaxEmailException();

        }
        else {

            User.getInstance().registerNewUser(eb.getUsername(), eb.getName(), eb.getCognome(), eb.getEmail(), eb.getPassword());

            return true;

        }
    }
}
