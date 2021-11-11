package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_non_select_try_catch_throw {

	public static void main(String[] args) throws SQLException {
		Connection c=null;
		try {
		Driver d= new Driver();
		DriverManager.registerDriver(d);
		 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		Statement m = c.createStatement();
		int res = m.executeUpdate("insert into student values(7,'mmm','nnn','mmm@gmail.com')");
		if(res==1)
		{
		System.out.println("Successfully added");
		
	}
		else
		{
			System.out.println("Not added");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			System.out.println("conection closed");
			c.close();
		}
			}}