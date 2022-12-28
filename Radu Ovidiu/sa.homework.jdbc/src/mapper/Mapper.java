package mapper;

import dto.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper {
    static Customer customerMapper(final ResultSet resultSet) throws SQLException{
        Customer customer = new Customer();
        customer.setId(resultSet.getInt(1));
        customer.setCustomerName(resultSet.getString(2));
        customer.setCustomerContactNumber(resultSet.getString(3));
        return customer;
    }
    static Employees employeesMapper(final ResultSet resultSet) throws SQLException{
        Employees employees = new Employees();
        employees.setId(resultSet.getInt(1));
        employees.setEmployeeName(resultSet.getString(2));
        employees.setAge(resultSet.getInt(3));
        employees.setEmployeePhoneNumber(resultSet.getString(4));
        return employees;
    }
    static ProjectName projectNameMapper(final ResultSet resultSet) throws SQLException{
        ProjectName projectName = new ProjectName();
        projectName.setId(resultSet.getInt(1));
        projectName.setProjectName(resultSet.getString(2));
        return projectName;
    }
    static ProjectOwner projectOwnerMapper(final ResultSet resultSet) throws SQLException{
        ProjectOwner projectOwner = new ProjectOwner();
        projectOwner.setId(resultSet.getInt(1));
        projectOwner.setProjectOwnerName(resultSet.getString(2));
        return projectOwner;
    }
    static TaskType taskTypeMapper(final ResultSet resultSet) throws SQLException{
        TaskType taskType = new TaskType();
        taskType.setId(resultSet.getInt(1));
        taskType.setType(resultSet.getString(2));
        return taskType;
    }
    static TimeTracking timeTrackingMapper(final  ResultSet resultSet) throws SQLException{
        TimeTracking timeTracking = new TimeTracking();
        timeTracking.setId(resultSet.getInt(1));
        timeTracking.setEmployeeId(new Employees(resultSet.getInt(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5) ));
        timeTracking.setCustomer(new Customer(resultSet.getInt(6), resultSet.getString(7), resultSet.getString(8) ));
        timeTracking.setProjectName(new ProjectName(resultSet.getInt(9), resultSet.getString(10) ));
        timeTracking.setProjectOwner(new ProjectOwner(resultSet.getInt(11), resultSet.getString(12) ));
        timeTracking.setTaskType(new TaskType(resultSet.getInt(13), resultSet.getString(14) ));
        timeTracking.setWorkedHours(resultSet.getInt(15));
        timeTracking.setStartDate(resultSet.getDate(16));
        timeTracking.setEndDate(resultSet.getDate(17));
        timeTracking.setComment(resultSet.getString(18));
        timeTracking.setRecordStatus(resultSet.getString(19));
        return timeTracking;

    }

}
