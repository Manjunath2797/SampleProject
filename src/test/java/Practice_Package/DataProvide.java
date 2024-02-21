package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide {
	
	@Test(dataProvider = "getData")
	public void travelling(String src, String dst, int price)
	{
		System.out.println(src+"---------->"+dst+"--------->"+price);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[2][3];
		
		obj[0][0] = "Bangalore";
		obj[0][1] = "Goa";
		obj[0][2] = 100;
		
		obj[1][0] = "Goa";
		obj[1][1] = "Bangalore";
		obj[1][2] = 100;
		
		return obj;
	
	}

}
