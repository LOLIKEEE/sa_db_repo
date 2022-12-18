package sa.homework.logger;

import sa.homework.logger.classes.Database;
import sa.homework.logger.classes.Logger;
import sa.homework.logger.enums.Destination;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Database database = new Database();

      //  database.readData("employees");
        //database.create("test","id int  NOT NULL auto_increment primary key, name varchar(55)");

        Logger.printAllLogs();
    }

}