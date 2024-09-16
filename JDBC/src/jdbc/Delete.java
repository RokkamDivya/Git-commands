package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/insert?useSSL=false", "root", "Divya@2005");

        PreparedStatement st = conn.prepareStatement("DELETE FROM new_table WHERE id=?");
        st.setInt(1, 150);

        int i = st.executeUpdate();
        if (i > 0) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
        st.close();
        conn.close();
    }
}