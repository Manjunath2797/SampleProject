package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws SQLException {
		
		Driver driver= new Driver();
		
		//step1: register the database
		DriverManager.registerDriver(driver);
		
		//step2: get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
		
		//step3: issue create statement
		Statement stat = con.createStatement();
		String query = "select * from sdet43";
		
		//step4: execute query
		ResultSet result = stat.executeQuery(query);
		while(result.next())
		{
		System.out.println(result.getString(1)+ " "+result.getString(2)+" "+result.getString(3));
		}
		
		//step5: close database connection
		con.close();
	}

}
