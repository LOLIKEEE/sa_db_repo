package sa.homework.jdbc.dao.classes;

import sa.homework.jdbc.dao.interfaces.IRecordStatusDAO;
import sa.homework.jdbc.dto.RecordStatus;
import sa.homework.jdbc.mapper.Mapper;
import sa.homework.logger.classes.Logger;
import sa.homework.resources.config.MyProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecordStatusDAO implements IRecordStatusDAO {

    @Override
    public List<RecordStatus> getAll() {
        List<RecordStatus> recordStatusList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.record_status")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                recordStatusList.add(Mapper.toRecordStatus(resultSet));

                Logger.info("Record Status: " + resultSet.getString(2) + " added in list.");
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
        return recordStatusList;
    }

    @Override
    public RecordStatus getById(final Integer id) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.record_status " +
                     "WHERE record_status.id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Logger.info("Record Status: " + resultSet.getString(2) + " selected from database.");
                return Mapper.toRecordStatus(resultSet);
            } else {
                Logger.info("Record Status with id: " + id + " not found in database.");
                return null;
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean update(final RecordStatus object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.record_status set record_status.status=?" +
                     " WHERE record_status.id=? ")) {

            preparedStatement.setString(1, object.getStatus());
            preparedStatement.setInt(2, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Record Status: " + object.getStatus() + " updated in database.");
                return true;
            } else {
                Logger.info("Record Status with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean delete(final RecordStatus object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.record_status " +
                     "WHERE record_status.id=?")) {

            preparedStatement.setInt(1, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Record Status: " + object.getStatus() + " deleted from database.");
                return true;
            } else {
                Logger.info("Record Status with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean create(final RecordStatus object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.record_status(status)" +
                     " values(?)")) {

            preparedStatement.setString(1, object.getStatus());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Record Status: " + object.getStatus() + " added in database.");
                return true;
            } else {
                Logger.info("Record Status: " + object.getStatus() + " failed to add in database.");
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
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.record_status " +
                     "WHERE record_status.id=?")) {

            preparedStatement.setInt(1, id);

            if (preparedStatement.execute()) {
                Logger.info("Record Status with id: " + id + " exists in database.");
                return true;
            } else {
                Logger.info("Record Status with id: " + id + " does not exists in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }
}
