package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelect_Query {

	public static void main(String[] args) throws SQLException {
		
		int result = 0;
		
		Driver driver= new Driver();
		
		//step1: register the database
		DriverManager.registerDriver(driver);
		
		//step2: get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
		
		//step3: issue create statement
		Statement stat = con.createStatement();
		String query = "insert into sdet43 values('Megha', 'API', 1)";
		
		//step4: execute update
		result = stat.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("data updated");
		}
		else
		{
			System.out.println("data not updated");
		}
		
		//step5: close database connection
		con.close();
	
	}

}
