package sample.Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Food_Delivery";
    static final String USER = "root";
    static final String PASSWORD = "toor";

    private DBConnector(){}

    public static DBConnector getInstance(){
        return new DBConnector();
    }
    public Connection getConnection(){

        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
}


