package Organization_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SDET43.GenericLibraries.BaseClass;
import com.SDET43.GenericLibraries.ExcelUtility;
import com.SDET43.GenericLibraries.FileUtility;
import com.SDET43.GenericLibraries.JavaUtility;
import com.SDET43.GenericLibraries.WebDriverUtility;
import com.SDET43.ObjectRepository.CreateOrganizationPage;
import com.SDET43.ObjectRepository.HomePage;
import com.SDET43.ObjectRepository.LoginPage;
import com.SDET43.ObjectRepository.OrganizationInfoPage;
import com.SDET43.ObjectRepository.OrganizationPage;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass{

	@Test
	public void createOrganization () throws Throwable{
		
		HomePage hp = new HomePage(driver);
		hp.organizationLink();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.organizationPage();
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		
		//Create Organization
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("accountname");
//		list.add("website");
//		list.add("tickersymbol");
//		list.add("phone");
//		
//		for(int i=0; i<=count; i++)
//		{
//			String value = sh.getRow(i).getCell(1).getStringCellValue();
//			driver.findElement(By.name(list.get(i))).sendKeys(value);
//		}
		
//		eLib.getList("Sheet1");
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		//cop.createOrganization(eLib.getList("Sheet1", 0,1), jLib, driver);
		
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.organizationInfoPage(driver);
		
		
	}
	

	}




