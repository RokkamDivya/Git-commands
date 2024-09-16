package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Retrieve {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/insert?useSSL=false", "root", "Divya@2005");

        PreparedStatement st = conn.prepareStatement("SELECT * FROM new_table");
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
        	System.out.println(rs.getString("name"));
        	System.out.println(rs.getInt("id"));
        }

         st.close();
        conn.close();
    }
}
