package chapter13.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL , user , pass);
            System.out.println("successful connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
