package Generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBUtility {
	
	Connection con = null;
	
	public void connectToDB() throws Throwable
	{
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(null, null, null);
		
	}
		public String executeAndgetData(String query, int columnIndex, String expData) throws Throwable
		{
			String data = null;
			boolean flag = false;
			ResultSet result = con.createStatement().executeQuery(query);
		
		while(result.next())
		{
			data = result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data verified");
			return expData;
		}
		else
		{
			System.out.println("data not verified");
			return "";
		}
		
		
	}

}
