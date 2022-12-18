package sa.homework.jdbc.dao.classes;

import sa.homework.jdbc.dao.interfaces.ICustomerDAO;
import sa.homework.jdbc.dto.Customer;
import sa.homework.jdbc.mapper.Mapper;
import sa.homework.logger.classes.Logger;
import sa.homework.resources.config.MyProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.customer")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                customers.add(Mapper.toCustomer(resultSet));

                Logger.info("Customer: " + resultSet.getString(2) + " added in list.");
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
        return customers;
    }

    @Override
    public Customer getById(final Integer id) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.customer WHERE customer.id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Logger.info("Customer: " + resultSet.getString(2) + " selected from database.");
                return Mapper.toCustomer(resultSet);
            } else {
                Logger.info("Customer with id: " + id + " not found in database.");
                return null;
            }
        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean update(final Customer object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.customer set customer.name=?," + "customer.contact_number=? WHERE customer.id=? ")) {

            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getContactNumber());
            preparedStatement.setInt(3, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Customer: " + object.getName() + " updated in database.");
                return true;
            } else {
                Logger.info("Customer with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean delete(final Customer object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.customer WHERE customer.id=?")) {

            preparedStatement.setInt(1, object.getId());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Customer: " + object.getName() + " deleted from database.");
                return true;
            } else {
                Logger.info("Customer with id: " + object.getId() + " not found in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean create(final Customer object) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.customer(name,contact_number) values(?,?)")) {

            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getContactNumber());

            if (preparedStatement.executeUpdate() > 0) {
                Logger.info("Customer: " + object.getName() + " added in database.");
                return true;
            } else {
                Logger.info("Customer: " + object.getName() + " failed to add in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public boolean exists(final Integer id) {
        try (Connection connection = DriverManager.getConnection(MyProperties.getDatabaseUrl(), MyProperties.getDatabaseUser(), MyProperties.getDatabasePassword()); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.customer WHERE customer.id=?")) {

            preparedStatement.setInt(1, id);

            if (preparedStatement.execute()) {
                Logger.info("Customer with id: " + id + " exists in database.");
                return true;
            } else {
                Logger.info("Customer with id: " + id + " does not exists in database.");
                return false;
            }

        } catch (SQLException e) {
            Logger.error(Arrays.toString(e.getStackTrace()) + e.getMessage());
            throw new RuntimeException();
        }
    }
}
