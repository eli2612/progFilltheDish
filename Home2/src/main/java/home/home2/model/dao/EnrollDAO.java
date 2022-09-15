package home.home2.model.dao;

import home.home2.model.dao.queries.DBConnection;
import home.home2.model.dao.queries.Queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnrollDAO {

    Statement stmt = null;
    Connection conn = null;

    public void newUser(String username, String nome, String cognome, String email, String password ){

        try{
            conn = DBConnection.getInstance().getConnection();
            stmt =  conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            Queries.enroll(stmt, username, nome,cognome,email, password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
