package Practice_Package;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.SDET43.GenericLibraries.IPathConstants;

public class datapr {
	
@DataProvider
public Object[][] readMultipleData() throws Throwable
{
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("Sheet2");
	int lastRow = sh.getLastRowNum()+1;
	int lastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] obj = new Object[lastRow][lastCell];
	for (int i = 0; i<lastRow; i++) 
	{
		for (int j = 0; j <lastCell; j++) 
		{
		obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	
	return obj;
}

}
