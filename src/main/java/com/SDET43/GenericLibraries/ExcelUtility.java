package com.SDET43.GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility extends JavaUtility{

	/**
	 * This method is used to read data from excel
	 *@author Manjunath S
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(RowNo);
		Cell cel = ro.getCell(ColumnNo);
		String value = cel.getStringCellValue();
		return value;
	}

	/**
	 * @author Manjunath S
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String SheetName, int RowNo, int ColumnNo, String data) throws Throwable
	{

		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.createRow(RowNo);
		Cell cel = ro.createCell(ColumnNo);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
	}

	/**
	 * THis method is used to get last row count
	 * @author Vijayalaxmi
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}

	public  Map<Object, Object> getList(String sheetName, int keyCell, int valueCell ) throws Throwable

	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		for(int i=0; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value = sh.getRow(i).getCell(valueCell).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}


	public Object[][] readMultipleData(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelDP);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRow][lastCell];
		for (int i = 0; i<lastRow; i++) 
		{
			for (int j = 0; j < lastCell; j++) 
			{
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}

		return obj;
	}

}

