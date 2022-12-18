package sa.homework.jdbc.dao.classes;

import sa.homework.jdbc.dao.interfaces.IEmployeeDAO;
import sa.homework.jdbc.dto.Employee;
import sa.homework.jdbc.mapper.Mapper;
import sa.homework.logger.classes.Logger;
import sa.homework.resources.config.MyProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    @Override
    public List<Employee> getAll() {

        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.employee")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                employees.add(Mapper.toEmployee(resultSet));

                Logger.info("Employee: " + resultSet.getString(2) + " added in list.");
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
        return employees;
    }

    @Override
    public Employee getById(final Integer id) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.employee WHERE employee.id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Logger.info("Employee: " + resultSet.getString(2) + " selected from database.");
                return Mapper.toEmployee(resultSet);
            } else {
                Logger.info("Employee with id: " + id + " not found in database.");
                return null;
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean update(final Employee object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.employee set employee.name=?," +
                     "employee.age=?,employee.phone_number=? WHERE employee.id=? ")) {

            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getAge());
            preparedStatement.setString(3, object.getPhoneNumber());
            preparedStatement.setInt(4, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Employee: " + object.getName() + " updated in database.");
                return true;
            } else {
                Logger.info("Employee with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean delete(final Employee object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.employee WHERE employee.id=?")) {

            preparedStatement.setInt(1, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Employee: " + object.getName() + " deleted from database.");
                return true;
            } else {
                Logger.info("Employee with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean create(final Employee object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(),
                MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword());
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.employee(name,age,phone_number) values(?,?,?)")) {

            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getAge());
            preparedStatement.setString(3, object.getPhoneNumber());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Employee: " + object.getName() + " added in database.");
                return true;
            } else {
                Logger.info("Employee: " + object.getName() + " failed to add in database.");
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
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.employee" +
                     " WHERE employee.id=?")) {

            preparedStatement.setInt(1, id);

            if (preparedStatement.execute()) {
                Logger.info("Employee with id: " + id + " exists in database.");
                return true;
            } else {
                Logger.info("Employee with id: " + id + " does not exists in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }
}
