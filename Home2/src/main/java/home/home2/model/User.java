package home.home2.model;

import home.home2.model.dao.EnrollDAO;
import home.home2.model.dao.UserDAO;


import java.sql.SQLException;

public  class User {

    private static User instance = null;
    private static UserEntity userE ;

    public static synchronized User getInstance(){
        if(instance == null){
            instance = new User();
        }
        return instance;
    }

    private User(){
    }

    public UserEntity getUser(){
        return userE;
    }

    public static void loginUser(String userName , String passWord) {

        try{
            User.userE = new UserEntity();
            userE.setUsername(userName);
            userE.setPassword(passWord);
            User.userE = UserDAO.getUserAccount(userName, passWord);
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public void registerNewUser(String username, String nome, String cognome, String email, String password ) {
       EnrollDAO enrolldao = new EnrollDAO();
       enrolldao.newUser(username,nome,cognome,email,password);
    }




}
