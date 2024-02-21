package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		
		//Create object for physical file
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
				
		//Create workbook
		Workbook wb = WorkbookFactory.create(fi);
				
		//get sheet
				Sheet sh = wb.getSheet("Sheet1");
				int count = sh.getLastRowNum();
				for(int i=1; i<=count; i++)
				{
					Row ro = sh.getRow(i);
					String clients = ro.getCell(1).getStringCellValue();
					System.out.println(clients);
				}
				
			

	}

}
