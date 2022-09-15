package home.home2.model.dao;
import home.home2.model.dao.queries.DBConnection;
import home.home2.model.dao.queries.Queries;

import java.sql.*;

public class LoginDAO {

    Statement stmt = null;
    Connection con = null;

    public boolean verify( String username, String password) throws SQLException {

        con = DBConnection.getInstance().getConnection();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet res = Queries.credentials(stmt, username, password);

        if(!res.first()){
            //
        }
        else {
            String username1 = res.getString("username");
            String pass = res.getString("password");


            if (username1.equals(username) && pass.equals(password)) {
                return true;
            }
        }


        return false;


    }


}
