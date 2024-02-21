package Practice_Package;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDET43.GenericLibraries.ExcelUtility;
import com.SDET43.GenericLibraries.IPathConstants;

public class ReadMultiDataUsingDataProvider {
	
	@Test(dataProviderClass = datapr.class, dataProvider = "readMultipleData")
	public void name(String name, String price) throws Throwable
	{
		
		System.out.println(name+"="+price+"Rs");
	}

}
