
import java.sql.*;



public class LinkToDatabase {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/time_sheet";
        String userName="root";
        String password = "root";
        String querry = "SELECT * FROM time_sheet.porsche";


        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(querry);

            while (result.next()){
                int employee_id = result.getInt("employee_id");
                int project_name = result.getInt("project_name");
                int worked_hours = result.getInt("worked_hours");
                Date start_date = result.getDate("start_date");
                Date end_date = result.getDate("end_date");
                String comment = result.getString("comment");
                String record_status = result.getString("record_status");

                System.out.println(employee_id + " " + project_name + " " + worked_hours + " " + start_date + " " + end_date + " " + comment + " " + record_status);
            }

        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }
}
