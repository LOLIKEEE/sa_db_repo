package org.example;
import tables.Employee;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseOperation {
    private static final DatabaseConnection db = new DatabaseConnection();
    private static final Logger logger = new LoggerLibrary().getConfiguredLogger();

    public void printAllEmployees() {
        try (Connection conn = db.getConnection(); Statement stmt = conn.createStatement()) {
            logger.log(Level.INFO, "CREATED A SECURE CONNECTION WITH DATABASE");

            ResultSet rs = stmt.executeQuery("SELECT * FROM employee"); {
                while(rs.next()) {
                    System.out.println("ID: " + rs.getInt("employee_id"));
                    System.out.println("NAME: " + rs.getString("employee_name"));
                    System.out.println("AGE: " + rs.getInt("employee_age"));
                    System.out.println("PHONE: " + rs.getString("employee_phone_number") + "\n");
                }
                logger.log(Level.INFO, "ALL EMPLOYEE FROM DATABASE WAS PRINTED");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "EXCEPTION HANDLED : " + e);
        } finally {
            logger.log(Level.INFO, "CONNECTION WITH DATABASE WAS CLOSED");
        }
    }

    public void addNewEmployee(Employee emp) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO employee(employee_name, employee_age, employee_phone_number) VALUES (?,?,?)")) {
            logger.log(Level.INFO, "CREATED A SECURE CONNECTION WITH DATABASE");

            stmt.setString(1, emp.getEmployeeName());
            stmt.setInt(2, emp.getEmployeAge());
            stmt.setString(3, emp.getEmployeeContactNumber());
            stmt.executeUpdate();

            logger.log(Level.WARNING, "NEW EMPLOYEE WAS ADDED TO DATABASE");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "EXCEPTION HANDLED : " + e);
        } finally {
            logger.log(Level.INFO, "CONNECTION WITH DATABASE WAS CLOSED");
        }
    }

    public void deleteEmployee(int employeeId) {
        try (Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM employee WHERE employee_id = ?")) {
            stmt.setInt(1, employeeId);

            if(stmt.executeUpdate() == 1)
                logger.log(Level.WARNING, "EMPLOYEE " + employeeId + " WAS DELETED FROM DATABASE");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "EXCEPTION HANDLED : " + e);
        }
    }

    public void updateEmployee(int employeeId, String phoneNumber) {
        try (Connection conn = db.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE employee SET employee_phone_number = ? WHERE employee_id = ?")) {
            stmt.setString(1, phoneNumber);
            stmt.setInt(2, employeeId);

            if(stmt.executeUpdate() == 1)
                logger.log(Level.WARNING, "EMPLOYEES " + employeeId + " PHONE NUMBER WAS UPDATED");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "EXCEPTION HANDLED : " + e);
        }
    }
}
