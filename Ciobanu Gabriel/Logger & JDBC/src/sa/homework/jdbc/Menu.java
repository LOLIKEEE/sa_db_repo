package sa.homework.jdbc;

import sa.homework.jdbc.dao.classes.*;
import sa.homework.jdbc.dao.interfaces.*;
import sa.homework.jdbc.dto.Customer;
import sa.homework.jdbc.dto.Employee;
import sa.homework.jdbc.dto.TimeTracking;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Menu {
    public static void main(String[] args) {
        IEmployeeDAO employeeDAO = new EmployeeDAO();
        ICustomerDAO customerDAO = new CustomerDAO();
        IProjectDAO projectDAO = new ProjectDAO();
        IProjectOwnerDAO projectOwnerDAO = new ProjectOwnerDAO();
        IRecordStatusDAO recordStatusDAO = new RecordStatusDAO();
        ITaskDAO taskDAO = new TaskDAO();
        ITimeTrackingDAO timeTrackingDAO = new TimeTrackingDAO();

        TimeTracking timeTracking = new TimeTracking(2,employeeDAO.getById(2),projectDAO.getById(2),4,projectOwnerDAO.getById(2),
                taskDAO.getById(2), Date.valueOf(LocalDate.of(2022,4,18)),Date.valueOf(LocalDate.of(2022,5,20)),
                customerDAO.getById(2),recordStatusDAO.getById(2),"Study from Udemy.");

        timeTrackingDAO.create(timeTracking);
    }
}
