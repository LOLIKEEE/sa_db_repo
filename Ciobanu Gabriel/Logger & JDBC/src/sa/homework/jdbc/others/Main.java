package sa.homework.jdbc.others;

import sa.homework.jdbc.others.Database;
import sa.homework.logger.classes.Logger;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Database database = new Database();

      //  database.readData("employees");
        //database.create("test","id int  NOT NULL auto_increment primary key, name varchar(55)");

        Logger.printAllLogs();
    }

}