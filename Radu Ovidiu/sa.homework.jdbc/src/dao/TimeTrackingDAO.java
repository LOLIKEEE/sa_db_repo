package dao;


import dto.TimeTracking;
import mapper.Mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimeTrackingDAO implements ITimeTrackingDAO{
    @Override
    public List<TimeTracking> getAll() {
        List<TimeTracking> timeTracking = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT time_tracking.id, time_tracking.employee_id, time_tracking.customer, time_tracking.project_name,"+
                    "time_tracking.project_name, time_tracking.project_owner, time_tracking.task_type, time_tracking.worked_hours, time_tracking.start_date,"+
                    "time_tracking.end_date,time_tracking.comment, time_tracking.record_status FROM time_tracking " +
                    "INNER JOIN employees ON time_tracking.employee_id = employees.id "+
                    "INNER JOIN customer ON time_tracking.customer = customer.id " +
                    "INNER JOIN project_name ON time_tracking.project_name = project_name.id "+
                    "INNER JOIN project_owner ON time_tracking.project_owner = project_owner.id "+
                    "INNER JOIN task_type ON time_tracking.task_type = task_type.id")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                timeTracking.add(Mapper.timeTrackingMapper(resultSet));
                System.out.println("Time tracking item "+resultSet.getString(1)+" is listed.");
            }
        }
        catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
        return timeTracking ;
    }

    @Override
    public TimeTracking getById(final Integer id) {

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT time_tracking.id, time_tracking.employee_id, time_tracking.customer, time_tracking.project_name"+
                    "time_tracking.project_name, time_tracking.project_owner, time_tracking.task_type, time_tracking.worked_hours, time_tracking.start_date"+
                    "time_tracking.end_date,time_tracking.comment, time_tracking.record_status FROM time_tracking" +
                    "INNER JOIN employees ON time_tracking.employee_id = employees.id "+
                    "INNER JOIN customer ON time_tracking.customer = customer.id " +
                    "INNER JOIN project_name ON time_tracking.project_name = project_name.id "+
                    "INNER JOIN project_owner ON time_tracking.project_owner = project_owner.id "+
                    "INNER JOIN task_type ON time_tracking.task_type = task_type.id ")) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Time tracking item with id: " + id + " is selected.");
                return Mapper.timeTrackingMapper(resultSet);
            }else {
                System.out.println("Time tracking item with id: " + id +" is not in the database." );
                return null;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean update(final TimeTracking object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.time_tracking set time_tracking.id=?, time_tracking.employee_id =?,time_tracking.customer=?,"+
                    "time_tracking.project_name=? , time_tracking.project_owner=?, time_tracking.task_type=?, time_tracking.worked_hours=?, time_tracking.start_date=?,"+
                    "time_tracking.end_date=?, time_tracking.comment=?,time_tracking.record_status=? WHERE time_tracking.id=?")){
            preparedStatement.setInt(1,object.getId());
            if (new EmployeesDAO().exists(object.getEmployeeId().getId())){
                preparedStatement.setInt(2,object.getEmployeeId().getId());
            }else{
                System.out.println("Employee with id " + object.getEmployeeId().getId()+" not found in the database");
                return false;
            }
            if (new CustomerDAO().exists(object.getCustomer().getId())){
                preparedStatement.setInt(3,object.getCustomer().getId());
            } else {
                System.out.println("Customer with id " + object.getCustomer().getId() + " not found in the database");
                return false;
            }
            if (new ProjectNameDAO().exists(object.getProjectName().getId())){
                preparedStatement.setInt(4, object.getProjectName().getId());
            }else{
                System.out.println("Project with id " + object.getProjectName().getId()+" not found in the database");
                return false;
            }

            if (new ProjectOwnerDAO().exists(object.getProjectOwner().getId())){
                preparedStatement.setInt(5,object.getProjectOwner().getId());
            } else {
                System.out.println("Project owner with id " + object.getCustomer().getId()+" not found in the database");
                return false;
            }
            if (new TaskTypeDAO().exists(object.getTaskType().getId())){
                preparedStatement.setInt(6,object.getTaskType().getId());
            } else {
                System.out.println("Task with id " + object.getTaskType().getId()+" not found in the database");
                return false;
            }
            preparedStatement.setInt(7, object.getWorkedHours());
            preparedStatement.setDate(8, Date.valueOf(object.getStartDate().toString()));
            preparedStatement.setDate(9, Date.valueOf(object.getEndDate().toString()));
            preparedStatement.setString(10, object.getComment());
            preparedStatement.setString(11, object.getRecordStatus());
            preparedStatement.setInt(12,object.getId());


            if (preparedStatement.executeUpdate() > 0){
                System.out.println("Time tracking item with id: " + object.getId() + " has been updated.");
                return true;
            }else{
                System.out.println("Time tracking item with id: " + object.getId() +" is not in the database.");
                return false;
            }


        }catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(final TimeTracking object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.time_tracking WHERE time_tracking.id=?")) {

            preparedStatement.setInt(1,object.getId());


            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Time tracking item with id: " + object.getId() + " has been deleted.");
                return true;
            }else {
                System.out.println("Time tracking item with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean create(final TimeTracking object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.time_tracking" +
                    "(id,employee_id, customer, project_name, project_owner, task_type, worked_hours, start_date, end_date, comment, record_status)" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?)")){
            preparedStatement.setInt(1, object.getId());
            if (new EmployeesDAO().exists(object.getEmployeeId().getId())){
                preparedStatement.setInt(2,object.getEmployeeId().getId());
            }else{
                System.out.println("Employee with id " + object.getEmployeeId().getId()+" not found in the database");
                return false;
            }
            if (new CustomerDAO().exists(object.getCustomer().getId())){
                preparedStatement.setInt(3,object.getCustomer().getId());
            } else {
                System.out.println("Customer with id " + object.getCustomer().getId() + " not found in the database");
                return false;
            }
            if (new ProjectNameDAO().exists(object.getProjectName().getId())){
                preparedStatement.setInt(4, object.getProjectName().getId());
            }else{
                System.out.println("Project with id " + object.getProjectName().getId()+" not found in the database");
                return false;
            }

            if (new ProjectOwnerDAO().exists(object.getProjectOwner().getId())){
                preparedStatement.setInt(5,object.getProjectOwner().getId());
            } else {
                System.out.println("Project owner with id " + object.getCustomer().getId()+" not found in the database");
                return false;
            }
            if (new TaskTypeDAO().exists(object.getTaskType().getId())){
                preparedStatement.setInt(6,object.getTaskType().getId());
            } else {
                System.out.println("Task with id " + object.getTaskType().getId()+" not found in the database");
                return false;
            }
            preparedStatement.setInt(7, object.getWorkedHours());
            preparedStatement.setDate(8, Date.valueOf(object.getStartDate().toString()));
            preparedStatement.setDate(9, Date.valueOf(object.getEndDate().toString()));
            preparedStatement.setString(10, object.getComment());
            preparedStatement.setString(11, object.getRecordStatus());

            if (preparedStatement.executeUpdate() > 0){
                System.out.println("Time tracking item with id: " + object.getId() + " has been created.");
                return true;
            }else{
                System.out.println("Time tracking item with id: " + object.getId() +" is not in the database.");
                return false;
            }


        }catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exists(final Integer id) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.time_tracking where time_tracking.id=?")) {
            preparedStatement.setInt(1,id);


            if (preparedStatement.execute()) {
                System.out.println("Time tracking with id: " + id + " exists.");
                return true;
            }else {
                System.out.println("Time tracking id: " + id +" does not exist." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }
}
