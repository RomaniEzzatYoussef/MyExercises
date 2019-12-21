package Tests.databaseProgramming;

import oracle.jdbc.OracleDriver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConecction 
{
	public static void main(String[] args)
	{
		System.out.print("aaaaaaaaa");
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
