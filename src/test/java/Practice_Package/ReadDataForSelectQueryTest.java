package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataForSelectQueryTest {

	public static void main(String[] args) throws Throwable 
	{
		//create object for driver
		Driver driver = new Driver();
		
		//step1: Register database
		DriverManager.registerDriver(driver);
		
		//step2: Get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
		
		//step3: issue Create Statement
		Statement state = con.createStatement();
		String query = "select * from SDET43";
		
		//step4: excecute query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		
		//step5: close db
		con.close();
		

	}

}
