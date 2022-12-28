package dao;


import dto.Employees;
import mapper.Mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO implements IEmployeesDAO{
    @Override
    public List<Employees> getAll() {
        List<Employees> employees = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.employees")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                employees.add(Mapper.employeesMapper(resultSet));
                System.out.println("Employee "+resultSet.getString(2)+" is listed.");
            }
        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
        return employees ;
    }

    @Override
    public Employees getById(final Integer id) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.employees where employees.id=?")) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Employee: " + resultSet.getString(2) + " is selected.");
                return Mapper.employeesMapper(resultSet);
            }else {
                System.out.println("Employee id: " + id +" is not in the database." );
                return null;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(final Employees object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.employees set employees.employee_name=?," +
                    "employees.employee_age=? , employees.employee_phone_number WHERE employees.id=? ")) {

            preparedStatement.setString(1, object.getEmployeeName());
            preparedStatement.setInt(2, object.getAge());
            preparedStatement.setString(3, object.getEmployeePhoneNumber());
            preparedStatement.setInt(4, object.getId());



            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Employee: " + object.getEmployeeName() + " has been updated");
                return true;
            }else {
                System.out.println("Employee with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(final Employees object) {

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.employees WHERE employees.id=?")) {

            preparedStatement.setString(1, object.getEmployeeName());




            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Employee: " + object.getEmployeeName() + " has been deleted.");
                return true;
            }else {
                System.out.println("Employee with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean create(final Employees object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.employees(employee_name,employee_age,employee_phone_number) values(?,?,?)")) {

            preparedStatement.setString(1, object.getEmployeeName());
            preparedStatement.setInt(2, object.getAge());
            preparedStatement.setString(3, object.getEmployeePhoneNumber());




            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Employee: " + object.getEmployeeName() + " has been added to the database.");
                return true;
            }else {
                System.out.println("Failed to add employee: " + object.getEmployeeName()+" in the database." );
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.employees where employees.id=?")) {
            preparedStatement.setInt(1,id);


            if (preparedStatement.execute()) {
                System.out.println("Employee with id: " + id + " exists.");
                return true;
            }else {
                System.out.println("Employee id: " + id +" does not exist." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }

    }
}
