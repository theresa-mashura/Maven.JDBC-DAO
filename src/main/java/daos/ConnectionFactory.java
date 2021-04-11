package daos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/JDBC_Lab";
    public static final String USER = "theresa";
    public static final String PASS = "zipcode0";

    // Get connection to MySQL Database
    public static Connection getConnection() {
        try{
            //DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }

    }

    // Test the Connection
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }
}
