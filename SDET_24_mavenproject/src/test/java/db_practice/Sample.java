package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample {

	public static void main(String[] args) throws SQLException {
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		Statement stat = con.createStatement();
		int result = stat.executeUpdate("insert into student values(8,'sara','tha','saratha1@gmail.com')");
		if (result == 1) {
			System.out.println("user created");

		} else {
			System.out.println("user not created");
		}

		con.close();
	}
}
