package dao;

import dto.ProjectOwner;
import dto.TaskType;
import mapper.Mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskTypeDAO implements ITaskTypeDAO{
    @Override
    public List<TaskType> getAll() {
        List<TaskType> taskType = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.task_type")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                taskType.add(Mapper.taskTypeMapper(resultSet));
                System.out.println("Task "+resultSet.getString(2)+" is listed.");
            }
        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
        return taskType;
    }

    @Override
    public TaskType getById(final Integer id) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.task_type where task_type.id=?")) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Task: " + resultSet.getString(2) + " is selected.");
                return Mapper.taskTypeMapper(resultSet);
            }else {
                System.out.println("Task id: " + id +" is not in the database." );
                return null;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(final TaskType object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.task_type set task_type.type=? WHERE task_type.id=? ")) {

            preparedStatement.setString(1, object.getType());
            preparedStatement.setInt(2, object.getId());



            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Project: " + object.getType() + " has been updated");
                return true;
            }else {
                System.out.println("Project with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(final TaskType object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.task_type WHERE task_type.id=?")) {

            preparedStatement.setInt(1,object.getId());


            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Task: " + object.getType() + " has been deleted.");
                return true;
            }else {
                System.out.println("Task with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean create(final TaskType object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.task_type(type) values(?)")) {

            preparedStatement.setString(1,object.getType());


            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Task: " + object.getType() + " has been added in the database.");
                return true;
            }else {
                System.out.println("Failed to add task: " + object.getType() +" in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exists(final Integer id) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.task_type where task_type.id=?")) {
            preparedStatement.setInt(1,id);


            if (preparedStatement.execute()) {
                System.out.println("Task with id: " + id + " exists.");
                return true;
            }else {
                System.out.println("Task id: " + id +" does not exist." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

}
