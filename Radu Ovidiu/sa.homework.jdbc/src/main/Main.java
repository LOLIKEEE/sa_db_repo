package main;

import dao.*;
import dto.*;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {




        EmployeesDAO employeesDAO = new EmployeesDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        ProjectNameDAO projectNameDAO = new ProjectNameDAO();
        ProjectOwnerDAO projectOwnerDAO = new ProjectOwnerDAO();
        TaskTypeDAO taskTypeDAO = new TaskTypeDAO();
        TimeTrackingDAO timeTrackingDAO = new TimeTrackingDAO();

        TimeTracking timeTracking = new TimeTracking(23, employeesDAO.getById(1), customerDAO.getById(1), projectNameDAO.getById(1), projectOwnerDAO.getById(1), taskTypeDAO.getById(1), 8,
                Date.valueOf(LocalDate.of(2022,9,9)), Date.valueOf(LocalDate.of(2022,9,9)),
                "I studied the mysql tutorial pretty hard." ,"paid");



       timeTrackingDAO.create(timeTracking);


}
}