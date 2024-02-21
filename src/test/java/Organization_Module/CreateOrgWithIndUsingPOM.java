package Organization_Module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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

//import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.SDET43.GenericLibraries.ListenerImplementaionClass.class)
public class CreateOrgWithIndUsingPOM extends BaseClass{

	@Test
	public void createOrgWithIndUsingPOM() throws Throwable{

		//Create object for Generic Libraries
//		FileUtility pLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
		
//		String BROWSER = pLib.readDataFromPropertyFile("browser");
//		String URL = pLib.readDataFromPropertyFile("url");
//		String USERNAME = pLib.readDataFromPropertyFile("username");
//		String PASSWORD = pLib.readDataFromPropertyFile("password");
		String OrgName = eLib.readDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
		String ind = eLib.readDataFromExcel("Organization", 7, 3);
		String AccType = eLib.readDataFromExcel("Organization", 7, 4);
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get(URL);
//		wLib.waitForPageLoad(driver);
		
		
		//login to App
		
//		LoginPage lp = new LoginPage(driver);
//		lp.loginPage(USERNAME, PASSWORD);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
//		Thread.sleep(2000);
		
		//Create Organization
		HomePage hp = new HomePage(driver);
		hp.organizationLink();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.organizationPage();
		Assert.fail();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		
	
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
	//	eLib.getList("Sheet1");
		
		cop.createOrganization(OrgName, ind, AccType);
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
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.organizationInfoPage(driver);
		System.out.println("Org created");
		
//		WebElement info = driver.findElement(By.xpath("//span[@class='small']"));
//		wLib.waitForElementToBeVisible(driver, info);
		
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		
//		WebElement signout = driver.findElement(By.linkText("Sign Out"));
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(signout);
//		
//		signout.click();
//		hp.signout(driver);
		
	}

	
	
}
