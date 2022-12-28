package dao;

import dto.ProjectName;
import mapper.Mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectNameDAO implements IProjectNameDAO {
    @Override
    public List<ProjectName> getAll() {
        List<ProjectName> projectName = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project_name")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                projectName.add(Mapper.projectNameMapper(resultSet));
                System.out.println("Project "+resultSet.getString(2)+" is listed.");
            }
        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
        return projectName;
    }

    @Override
    public ProjectName getById(final Integer id) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project_name where project_name.id=?")) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Project: " + resultSet.getString(2) + " is selected.");
                return Mapper.projectNameMapper(resultSet);
            }else {
                System.out.println("Project id: " + id +" is not in the database." );
                return null;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(final ProjectName object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE timesheet.project_name set project_name.project_name=? WHERE project_name.id=? ")) {

            preparedStatement.setString(1, object.getProjectName());
            preparedStatement.setInt(2, object.getId());



            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Project: " + object.getProjectName() + " has been updated");
                return true;
            }else {
                System.out.println("Project with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(final ProjectName object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM timesheet.project_name WHERE project_name.id=?")) {

            preparedStatement.setInt(1,object.getId());


            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Project: " + object.getProjectName() + " has been deleted.");
                return true;
            }else {
                System.out.println("Project with id: " + object.getId() +" is not in the database." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean create(final ProjectName object) {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/timesheet" , "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO timesheet.project_name(project_name) values(?)")) {

            preparedStatement.setString(1,object.getProjectName());


            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("Project: " + object.getProjectName() + " has been added in the database.");
                return true;
            }else {
                System.out.println("Failed to add project: " + object.getProjectName() +" in the database." );
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM timesheet.project_name where project_name.id=?")) {
            preparedStatement.setInt(1,id);


            if (preparedStatement.execute()) {
                System.out.println("Project with id: " + id + " exists.");
                return true;
            }else {
                System.out.println("Project id: " + id +" does not exist." );
                return false;
            }


        } catch (SQLException e){
            System.out.println("Something happend in SQL opperation" + e.getStackTrace());
            throw new RuntimeException(e);
        }
    }
}
