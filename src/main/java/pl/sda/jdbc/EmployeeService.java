package pl.sda.jdbc;

import java.sql.*;

public class EmployeeService {
    Connection connection = DBConnector.getConnection();

    public void addEmployee(int employeeNumber,String lastName, String firstName, String extension ,String email,int officeCode, int reportsTo ,String jobTitle) {
        try {
            String insert = "insert into employees (`employeeNumber`,`lastName`,`firstName`,`extension`,`email`,`officeCode`,`reportsTo`,`jobTitle`) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, employeeNumber);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, extension);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, officeCode);
            preparedStatement.setInt(7, reportsTo);
            preparedStatement.setString(8, jobTitle);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllEmployee() {
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String sql = "select * from employees";
            ResultSet resultSet = statement.executeQuery(sql);
            //System.out.println(resultSet);
            while (resultSet.next()) {
                System.out.println("Imie: " + resultSet.getString("firstName")
                        + ", Nazwisko: " + resultSet.getString("lastName")
                        + ", Extension: " + resultSet.getString("extension")
                        + ", Email: " + resultSet.getString("email")
                        + ", Office Code: " + resultSet.getInt("officeCode")
                        + ", ReportsTo: " + resultSet.getInt("ReportsTo")
                        + ", Job Title: " + resultSet.getString("jobTitle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
