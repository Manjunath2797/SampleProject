package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Throwable {
		
		//Create object for physical file
				FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
				
				//Create workbook
				Workbook wb = WorkbookFactory.create(fi);
				
				//get sheet
				Sheet sh = wb.getSheet("Sheet1");
				
				//get row
				Row ro = sh.createRow(2);
				
				//create cell
				Cell cel = ro.createCell(2);
					cel.setCellValue("Testyantra");
					
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Excel.xlsx");
		wb.write(fos);
		
	
	}

}
