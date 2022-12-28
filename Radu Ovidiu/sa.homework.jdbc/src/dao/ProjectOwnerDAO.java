package dao;

import dto.ProjectOwner;
import mapper.Mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectOwnerDAO implements IProjectOwnerDAO{
    @Override
    public List<ProjectOwner> getAll() {
        List<ProjectOwner> projectOwner = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project_owner")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                projectOwner.add(Mapper.projectOwnerMapper(resultSet));
                System.out.println("Project owner "+resultSet.getString(2)+" is listed.");
            }
        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
        return projectOwner;
    }

    @Override
    public ProjectOwner getById(final Integer id) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project_owner where project_owner.id=?")) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Project owner: " + resultSet.getString(2) + " is selected.");
                return Mapper.projectOwnerMapper(resultSet);
            }else {
                System.out.println("Project owner id: " + id +" is not in the database." );
                return null;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(final ProjectOwner object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.project_owner set project_owner.project_owner_name=? WHERE project_owner.id=? ")) {

            preparedStatement.setString(1, object.getProjectOwnerName());
            preparedStatement.setInt(2, object.getId());



            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Project owner: " + object.getProjectOwnerName() + " has been updated");
                return true;
            }else {
                System.out.println("Project owner with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(final ProjectOwner object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.project_owner WHERE project_owner.id=?")) {

            preparedStatement.setInt(1,object.getId());


            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Project owner: " + object.getProjectOwnerName() + " has been deleted.");
                return true;
            }else {
                System.out.println("Project owner with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean create(final ProjectOwner object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.project_owner(project_owner_name) values(?)")) {

            preparedStatement.setString(1,object.getProjectOwnerName());


            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Project owner: " + object.getProjectOwnerName() + " has been added in the database.");
                return true;
            }else {
                System.out.println("Failed to add project owner: " + object.getProjectOwnerName() +" in the database." );
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project_owner where project_owner.id=?")) {
            preparedStatement.setInt(1,id);


            if (preparedStatement.execute()) {
                System.out.println("Project owner with id: " + id + " exists.");
                return true;
            }else {
                System.out.println("Project owner id: " + id +" does not exist." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }
}


