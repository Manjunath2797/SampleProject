package Organization_Module;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Listeners;
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

public class CreateOrgWithIndustryTypeTest extends BaseClass {

	@Test
	public void createOrgWithIndustryTypeTest ()throws Throwable {

		//Create object for Generic Libraries
//		FileUtility pLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
//		
//		String BROWSER = pLib.readDataFromPropertyFile("browser");
//		String URL = pLib.readDataFromPropertyFile("url");
//		String USERNAME = pLib.readDataFromPropertyFile("username");
//		String PASSWORD = pLib.readDataFromPropertyFile("password");	
//	
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get(URL);
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		
//		//login to App
//		LoginPage lp = new LoginPage(driver);
//		lp.loginPage(USERNAME, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		hp.organizationLink();
		
		
		OrganizationPage op = new OrganizationPage(driver);
		CreateOrganizationPage createOp=new CreateOrganizationPage(driver);
		op.organizationPage();
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
//		Thread.sleep(2000);
		
		//Create Organization
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
	//	createOp.createOrganization(eLib.getList("Sheet1", 0,1), jLib, driver);
		
		
		/*
		//Validate with expData
		String expData= "kjbgjhb";
		WebElement actData = driver.findElement(By.className("dvHeaderText"));
		
		if (actData.equals(expData)) 
		{
			System.out.println("data is valid");
		}	
		else
		{
			System.out.println("data is invalid");
		}*/
		
		//WebElement industry = driver.findElement(By.name("industry"));
		
//		Select sel = new Select(industry);
//		sel.selectByVisibleText("Healthcare");
		
		//wLib.selectByVisibleText(industry, "Healthcare");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.organizationInfoPage(driver);
		
//		driver.navigate().refresh();
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		
//		WebElement signout = driver.findElement(By.linkText("Sign Out"));
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(signout);
//		
//		signout.click();
		
		
	}

}
