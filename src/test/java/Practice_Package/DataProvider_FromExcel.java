package Practice_Package;

import java.io.FileInputStream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDET43.GenericLibraries.ExcelUtility;
import com.SDET43.GenericLibraries.IPathConstants;

public class DataProvider_FromExcel {
	
	@Test(dataProvider = "getData")
	public void teavel(String src, String dst, String price)
	{
		System.out.println(src+"--->"+dst+"---->"+price);
	}

	
@DataProvider
public Object[][] getData() throws Throwable
{
	ExcelUtility eLib = new ExcelUtility();
	Object[][] value = eLib.readMultipleData("Sheet1");
	return value;
}
	

}
