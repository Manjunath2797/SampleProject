package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public String readDataFromExcel(String SheetName, int rowNo, int columnNo) throws Throwable
	{
		FileInputStream fi = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(rowNo).getCell(columnNo).getStringCellValue();
		return value;
	}
	
	public int getLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	
	public void writeDataIntoExcel(String SheetName,int rowNo, int columnIndex, String data) throws Throwable
	{
		FileInputStream fi = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.createRow(rowNo);
		Cell cel = ro.createCell(columnIndex);
		cel.setCellValue(data);
		FileOutputStream fo = new FileOutputStream("");
		wb.write(fo);
		
	}
	
	public HashMap<String,String> getList(String SheetName, int keyCell, int valueCell) throws Throwable
	{
		FileInputStream fi = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value = sh.getRow(i).getCell(valueCell).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
}
