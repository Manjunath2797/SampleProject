package com.SDET43.GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.SDET43.ObjectRepository.HomePage;
import com.SDET43.ObjectRepository.LoginPage;

public class BaseClass {
	
	public DatabaseUtility dLib =new DatabaseUtility();
	public FileUtility fLib= new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite
	public void connectToDB() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("-- connect to database-- ");
	}
	

	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		 String BROWSER = fLib.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		sdriver =driver;
		
		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		
		String URL = fLib.readDataFromPropertyFile("url");
		
		driver.get(URL);
	}
	
	@BeforeMethod
	public void loginToApp() throws Throwable
	{
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(USERNAME, PASSWORD);
		System.out.println("-- Login to App --");
	}
	
	@AfterMethod
	public void signout()
	{
		HomePage hp = new HomePage(driver);
		hp.signout(driver);
		System.out.println("-- Logout from App --");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("-- close browser --");
	}
	
	@AfterSuite
	public void closeDB() throws Throwable
	{
	dLib.closeDB();
	System.out.println("-- close DB --");
}
}
