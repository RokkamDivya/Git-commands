package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {

    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/insert?useSSL=false", "root", "Divya@2005");

        PreparedStatement st = conn.prepareStatement("UPDATE new_table SET name=? WHERE id=?");
       
        st.setString(1, "Divya");
        st.setInt(2, 150);
        

        int i = st.executeUpdate();
        if (i > 0) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

        st.close();
        conn.close();
    }
}
