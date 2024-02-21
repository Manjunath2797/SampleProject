package Practice_Package;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingMultipleData_Pro {

	
	public static void main(String[] args) throws Throwable {
				//PropertyFile
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				Properties pObj = new Properties();
				pObj.load(fis);
				String BROWSER = pObj.getProperty("browser");
				String URL = pObj.getProperty("url");
				String USERNAME = pObj.getProperty("username");
				String PASSWORD = pObj.getProperty("password");
				
				//read data from excel
				FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Excel.xlsx");
				Workbook wb = WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet("Sheet1");
				int count = sh.getLastRowNum();
				
			
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(URL);
				driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				Thread.sleep(2000);
				
				
				driver.findElement(By.xpath("//input[@id='submitButton']")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				ArrayList<String> columnList = new ArrayList<String>();
				columnList.add("accountname");
				columnList.add("website");
				columnList.add("tickersymbol");
				columnList.add("phone");
				
				for(int i=1; i<=count; i++)
				{
					String value = sh.getRow(i).getCell(0).getStringCellValue();
					driver.findElement(By.name(columnList.get(i-1))).sendKeys(value);
				}
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				

	}

}
