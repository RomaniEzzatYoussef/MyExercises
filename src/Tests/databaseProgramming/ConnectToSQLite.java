package Tests.databaseProgramming;

import java.sql.*;
import java.util.Date;

public class ConnectToSQLite
{
    static Connection conn = null;
    public static void main(String[] args) {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:E:\\work\\IntelliJ IDEA Projects\\OceanApp\\web\\WEB-INF\\classes\\myDB.db");

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(user_id) from users;");

            int user_id = 0;
            while (resultSet.next())
                user_id = resultSet.getInt(1)+1;

            final String SQL = "INSERT INTO USERS  VALUES  (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(SQL);


            ps.setInt(1 , user_id);
            ps.setString(2 ,"Romani");
            ps.setString(3 ,"Ezzat");
            ps.setString(4 ,"romaniezzat@hotmail.com");
            ps.setString(5 ,"14/07/1995");
            ps.setString(6 ,"01205224265");
            ps.setString(7 ,"RomaniEzzat");
            ps.setString(8 ,"r");
            ps.setString(9 ,new Date().toString());

            int i = ps.executeUpdate();

            if (i != 0)
            {
                System.out.println("Record has been inserted");
            } else {
                System.out.println("failed to insert the data");
            }



        } catch (SQLException | ClassNotFoundException e) {
            e.getStackTrace();
            System.out.println(e.getStackTrace());
            System.out.println( e.getClass().getName() + ": " + e.getMessage() );
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
