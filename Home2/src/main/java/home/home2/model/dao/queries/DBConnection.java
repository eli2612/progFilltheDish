package home.home2.model.dao.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{

    private String username = "testUser";
    private String pwd = "7BEpa]q=tLkm";
    private String myURL = "jdbc:mysql://allinoneexchange.com:3306/FillTheDish";

    private static DBConnection instance = null;   //riferimento all'istanza

    Connection connection = null;

    private DBConnection(){     //costruttore

        try{
           connection = DriverManager.getConnection(myURL, username, pwd);
        }  catch (SQLException exc){
            exc.printStackTrace();
        }
    }
    public static DBConnection getInstance(){
        if (instance == null){
            instance = new DBConnection();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;

    }

}
