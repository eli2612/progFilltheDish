package home.home2.model.dao;
import home.home2.model.dao.queries.DBConnection;
import home.home2.model.dao.queries.Queries;
import home.home2.model.UserEntity;

import java.sql.*;


public class UserDAO {
    private static final String USERNAME = "username";


   public String verify( String username, String password) {
       Statement stmt = null;
       Connection con = null;
       String result = null;

       try{
           con = DBConnection.getInstance().getConnection();
           stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

           ResultSet res = Queries.credentials(stmt, username, password);


           if (!res.first()) {
               //
           } else {
               String username1 = res.getString(USERNAME);
               String pass = res.getString("password");


               if (username1.equals(username) && pass.equals(password)) {
                   result = res.getString(USERNAME);
               }
           }
       }catch (SQLException e){
           e.printStackTrace();
       }

       return result;


   }

    public static UserEntity getUserAccount(String username, String password) throws SQLException {
        Statement stmt = null;
        Connection con = null;

        con = DBConnection.getInstance().getConnection();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultset = Queries.credentials(stmt, username,password);

        UserEntity userentity;

        if(!resultset.first()){
            return null;
        }

        else{

            resultset.first();

            userentity = new UserEntity();

            userentity.setUsername(resultset.getString(USERNAME));
            userentity.setName(resultset.getString("nome"));
            userentity.setSurname(resultset.getString("cognome"));
            userentity.setEmail(resultset.getString("email"));
            userentity.setPassword(resultset.getString("password"));

        }


        return userentity;

    }


}
