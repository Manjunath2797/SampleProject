package Contacts_Module;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET43.GenericLibraries.ExcelUtility;
import com.SDET43.GenericLibraries.FileUtility;
import com.SDET43.GenericLibraries.JavaUtility;
import com.SDET43.GenericLibraries.WebDriverUtility;
import com.SDET43.ObjectRepository.ContactsPage;
import com.SDET43.ObjectRepository.CreateContactsPage;
import com.SDET43.ObjectRepository.HomePage;
import com.SDET43.ObjectRepository.LoginPage;

public class CreateContact_genericUtility {

	public static void main(String[] args) throws Throwable {
		
		//Create object for Generic Libraries
		FileUtility pLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		
		//read data from excel
		String LastName = eLib.readDataFromExcel("Sheet1", 0, 1)+jLib.getRandomNumber();
		String website = eLib.readDataFromExcel("Sheet1", 1, 1);
		String tickersymbol = eLib.readDataFromExcel("Sheet1", 2, 1);
		String phone = eLib.readDataFromExcel("Sheet1", 3, 1);
		
		//Launch browser
		WebDriver driver = null;
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
		
		//maximize window
		wLib.maximizeWindow(driver);
		
		driver.get(URL);
		
		//wait for page load
		wLib.waitForPageLoad(driver);
		
		//login to App
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(USERNAME, PASSWORD);
		
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.contactsLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.contactPage();
		
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createContact(LastName);
		
		
	}
}
