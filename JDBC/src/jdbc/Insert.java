package jdbc;

import java.sql.DriverManager;
import java.sql.*;

public class Insert {
    public static void main(String[] args) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/insert?useSSL=false", "root", "Divya@2005");
            PreparedStatement st = conn.prepareStatement("INSERT INTO new_table values(?,?)");
            st.setInt(1,150 ); 
            st.setInt(2,147 ); 
            st.setString(2, "Divya");
            st.setString(2, "prenny");
            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("success");
            } else {
                System.err.println("fail");
            }
            st.close();
            conn.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Error: Duplicate entry for the primary key.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}