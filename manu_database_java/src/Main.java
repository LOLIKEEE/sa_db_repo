import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

try {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2",
            "root", "root");

    Statement statement = connection.createStatement();

    ResultSet result = statement.executeQuery
            ("SELECT * FROM mydb2.customer_info");
    while (result.next()) {
        System.out.println(result.getString("customer_name"));
    }
}catch (Exception e ) {
    e.printStackTrace();
}


/*
* Connection - a connection (session) with a specific database
*
* DriverManager - basic service for managing JDBC  drivers
*
* Statement - an interface that represents a sql statement. You need a connection object to creatge a statement object
*
* Result Set - a table of data representing the results returned from the database
*
*  */

    }
}