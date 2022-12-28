package dao;

import dto.Customer;
import mapper.Mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    @Override
    public List<Customer> getAll() {
        List<Customer> customer = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.customer")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                customer.add(Mapper.customerMapper(resultSet));
                System.out.println("Customer "+resultSet.getString(2)+" is listed.");
            }
        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public Customer getById(final Integer id) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.customer where customer.id=?")) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Customer: " + resultSet.getString(2) + " is selected.");
                return Mapper.customerMapper(resultSet);
            }else {
                System.out.println("Customer id: " + id +" is not in the database." );
                return null;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean update(final Customer object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.customer set customer.customer_name=?,customer.customer_contact_number=? WHERE customer.id=? ")) {

            preparedStatement.setString(1, object.getCustomerName());
            preparedStatement.setString(2, object.getCustomerContactNumber());
            preparedStatement.setInt(3, object.getId());



            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Customer: " + object.getCustomerName() + " has been updated");
                return true;
            }else {
                System.out.println("Customer with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean delete(final Customer object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.customer WHERE customer.id=?")) {

            preparedStatement.setInt(1,object.getId());


            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Customer: " + object.getCustomerName() + " has been deleted.");
                return true;
            }else {
                System.out.println("Customer with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean create(final Customer object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.customer(customer_name,customer_contact_number) values(?,?)")) {

            preparedStatement.setString(1,object.getCustomerName());
            preparedStatement.setString(2,object.getCustomerContactNumber());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Customer: " + object.getCustomerName() + " has been added in the database.");
                return true;
            }else {
                System.out.println("Failed to add customer: " + object.getCustomerName() +" in the database." );
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.customer where customer.id=?")) {
            preparedStatement.setInt(1,id);


            if (preparedStatement.execute()) {
                System.out.println("Customer with id: " + id + " exists.");
                return true;
            }else {
                System.out.println("Customer id: " + id +" does not exist." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }
}
