package sa.homework.jdbc.dao.classes;

import sa.homework.jdbc.dao.interfaces.ITaskDAO;
import sa.homework.jdbc.dto.Task;
import sa.homework.jdbc.mapper.Mapper;
import sa.homework.logger.classes.Logger;
import sa.homework.resources.config.MyProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskDAO implements ITaskDAO {

    @Override
    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.task")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                tasks.add(Mapper.toTask(resultSet));

                Logger.info("Task: " + resultSet.getString(2) + " added in list.");
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
        return tasks;
    }

    @Override
    public Task getById(Integer id) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.task WHERE task.id=?")) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Logger.info("Task: " + resultSet.getString(2) + " selected from database.");
                return Mapper.toTask(resultSet);
            } else {
                Logger.info("Task with id: " + id + " not found in database.");
                return null;
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean update(Task object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.task set task.name=?" + " WHERE task.id=? ")) {

            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Task: " + object.getName() + " updated in database.");
                return true;
            } else {
                Logger.info("Task with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean delete(Task object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.task WHERE task.id=?")) {

            preparedStatement.setInt(1, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Task: " + object.getName() + " deleted from database.");
                return true;
            } else {
                Logger.info("Task with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean create(Task object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.task(name) " + "values(?)")) {

            preparedStatement.setString(1, object.getName());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Task: " + object.getName() + " added in database.");
                return true;
            } else {
                Logger.info("Task: " + object.getName() + " failed to add in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean exists(Integer id) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.task" +
                     " WHERE task.id=?")) {

            preparedStatement.setInt(1, id);

            if (preparedStatement.execute()) {
                Logger.info("Task with id: " + id + " exists in database.");
                return true;
            } else {
                Logger.info("Task with id: " + id + " does not exists in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }
}
