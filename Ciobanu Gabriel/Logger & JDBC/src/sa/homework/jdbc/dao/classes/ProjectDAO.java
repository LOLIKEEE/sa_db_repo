package sa.homework.jdbc.dao.classes;

import sa.homework.jdbc.dao.interfaces.IProjectDAO;
import sa.homework.jdbc.dto.Project;
import sa.homework.jdbc.mapper.Mapper;
import sa.homework.logger.classes.Logger;
import sa.homework.resources.config.MyProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectDAO implements IProjectDAO {

    @Override
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                projects.add(Mapper.toProject(resultSet));

                Logger.info("Project: " + resultSet.getString(2) + " added in list.");
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
        return projects;
    }

    @Override
    public Project getById(final Integer id) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project WHERE project.id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Logger.info("Project: " + resultSet.getString(2) + " selected from database.");
                return Mapper.toProject(resultSet);
            } else {
                Logger.info("Project with id: " + id + " not found in database.");
                return null;
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean update(final Project object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.project set project.name=? " +
                     "WHERE project.id=? ")) {

            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Project: " + object.getName() + " updated in database.");
                return true;
            } else {
                Logger.info("Project with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean delete(final Project object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.project WHERE project.id=?")) {

            preparedStatement.setInt(1, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Project: " + object.getName() + " deleted from database.");
                return true;
            } else {
                Logger.info("Project with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean create(final Project object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.project(name) values(?)")) {

            preparedStatement.setString(1, object.getName());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Project: " + object.getName() + " added in database.");
                return true;
            } else {
                Logger.info("Project: " + object.getName() + " failed to add in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean exists(final Integer id) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project" +
                     " WHERE project.id=?")) {

            preparedStatement.setInt(1, id);

            if (preparedStatement.execute()) {
                Logger.info("Project with id: " + id + " exists in database.");
                return true;
            } else {
                Logger.info("Project with id: " + id + " does not exists in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }
}
