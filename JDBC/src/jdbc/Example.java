package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Example {
    public static void main(String[] args) {
        
        String jdbcUrl = "jdbc:mysql://localhost:3306/person";
    
        String username = "root";
        String password = "Divya@2005";

        Connection connection = null;
        Statement statement = null;

        try {
 
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(jdbcUrl, username, password);

            statement = connection.createStatement();

            String insertSql = "INSERT INTO personinfo (id, name, addres) VALUES (220101120150, 'Rokkam Divya', 'Odisha')";
            statement.executeUpdate(insertSql);
            System.out.println("Record inserted successfully");

            String selectSql = "SELECT * FROM personinfo";
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
               
                long id = resultSet.getLong("id"); // Use getLong for big integers
                String name = resultSet.getString("name");
                String addres = resultSet.getString("addres");
                System.out.println("ID: " + id + ", Name: " + name + ", Address: " + addres);
            }

            resultSet.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
