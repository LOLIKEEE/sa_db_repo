package sa.homework.jdbc.mapper;

import sa.homework.jdbc.dto.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper {
    static Customer toCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt(1));
        customer.setName(resultSet.getString(2));
        customer.setContactNumber(resultSet.getString(3));

        return customer;
    }

    static Employee toEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();

        employee.setId(resultSet.getInt(1));
        employee.setName(resultSet.getString(2));
        employee.setAge(resultSet.getInt(3));
        employee.setPhoneNumber(resultSet.getString(4));

        return employee;
    }

    static Project toProject(ResultSet resultSet) throws SQLException {
        Project project = new Project();

        project.setId(resultSet.getInt(1));
        project.setName(resultSet.getString(2));

        return project;
    }

    static ProjectOwner toProjectOwner(ResultSet resultSet) throws SQLException {
        ProjectOwner projectOwner = new ProjectOwner();

        projectOwner.setId(resultSet.getInt(1));
        projectOwner.setName(resultSet.getString(2));

        return projectOwner;
    }

    static RecordStatus toRecordStatus(ResultSet resultSet) throws SQLException {
        RecordStatus recordStatus = new RecordStatus();

        recordStatus.setId(resultSet.getInt(1));
        recordStatus.setStatus(resultSet.getString(2));

        return recordStatus;
    }

    static Task toTask(ResultSet resultSet) throws SQLException {
        Task task = new Task();

        task.setId(resultSet.getInt(1));
        task.setName(resultSet.getString(2));

        return task;
    }

    static TimeTracking toTimeTracking(ResultSet resultSet) throws SQLException {
        TimeTracking timeTracking = new TimeTracking();

        timeTracking.setId(resultSet.getInt(1));
        timeTracking.setEmployee(new Employee(resultSet.getInt(2),resultSet.getString(3),
                                                resultSet.getInt(4),resultSet.getString(5)));
        timeTracking.setProject(new Project(resultSet.getInt(6),resultSet.getString(7)));
        timeTracking.setWorkedHours(resultSet.getInt(8));
        timeTracking.setProjectOwner(new ProjectOwner(resultSet.getInt(9),resultSet.getString(10)));
        timeTracking.setTask(new Task(resultSet.getInt(11),resultSet.getString(12)));
        timeTracking.setStart(resultSet.getDate(13));
        timeTracking.setEnd(resultSet.getDate(14));
        timeTracking.setCustomer(new Customer(resultSet.getInt(15),
                                                resultSet.getString(16),resultSet.getString(17)));
        timeTracking.setRecordStatus(new RecordStatus(resultSet.getInt(18),resultSet.getString(19)));
        timeTracking.setComment(resultSet.getString(20));

        return timeTracking;
    }

}
