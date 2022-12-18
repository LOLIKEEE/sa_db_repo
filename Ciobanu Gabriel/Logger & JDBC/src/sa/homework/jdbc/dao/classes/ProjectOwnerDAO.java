package sa.homework.jdbc.dao.classes;

import sa.homework.jdbc.dao.interfaces.IProjectOwnerDAO;
import sa.homework.jdbc.dto.ProjectOwner;
import sa.homework.jdbc.mapper.Mapper;
import sa.homework.logger.classes.Logger;
import sa.homework.resources.config.MyProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectOwnerDAO implements IProjectOwnerDAO {

    @Override
    public List<ProjectOwner> getAll() {
        List<ProjectOwner> projectOwners = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project_owner")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                projectOwners.add(Mapper.toProjectOwner(resultSet));

                Logger.info("Project Owner: " + resultSet.getString(2) + " added in list.");
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
        return projectOwners;
    }

    @Override
    public ProjectOwner getById(Integer id) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project_owner" +
                     " WHERE project_owner.id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Logger.info("Project Owner: " + resultSet.getString(2) + " selected from database.");
                return Mapper.toProjectOwner(resultSet);
            } else {
                Logger.info("Project Owner with id: " + id + " not found in database.");
                return null;
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean update(ProjectOwner object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.project_owner set project_owner.name=?" +
                     " WHERE project_owner.id=? ")) {

            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Project Owner: " + object.getName() + " updated in database.");
                return true;
            } else {
                Logger.info("Project Owner with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean delete(ProjectOwner object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.project_owner " +
                     "WHERE project_owner.id=?")) {

            preparedStatement.setInt(1, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Project Owner: " + object.getName() + " deleted from database.");
                return true;
            } else {
                Logger.info("Project Owner with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean create(ProjectOwner object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.project_owner(name) " +
                     "values(?)")) {

            preparedStatement.setString(1, object.getName());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Project Owner: " + object.getName() + " added in database.");
                return true;
            } else {
                Logger.info("Project Owner: " + object.getName() + " failed to add in database.");
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
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project_owner" +
                     " WHERE project_owner.id=?")) {

            preparedStatement.setInt(1, id);

            if (preparedStatement.execute()) {
                Logger.info("Project Owner with id: " + id + " exists in database.");
                return true;
            } else {
                Logger.info("Project Owner with id: " + id + " does not exists in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }
}
