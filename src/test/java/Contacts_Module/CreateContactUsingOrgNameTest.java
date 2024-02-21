package Contacts_Module;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.SDET43.GenericLibraries.BaseClass;
import com.SDET43.GenericLibraries.ExcelUtility;
import com.SDET43.GenericLibraries.FileUtility;
import com.SDET43.GenericLibraries.JavaUtility;
import com.SDET43.GenericLibraries.WebDriverUtility;
import com.SDET43.ObjectRepository.ContactsPage;
import com.SDET43.ObjectRepository.CreateContactsPage;
import com.SDET43.ObjectRepository.CreateOrganizationPage;
import com.SDET43.ObjectRepository.HomePage;
import com.SDET43.ObjectRepository.LoginPage;
import com.SDET43.ObjectRepository.OrganizationInfoPage;
import com.SDET43.ObjectRepository.OrganizationPage;


public class CreateContactUsingOrgNameTest extends BaseClass {

	@Test
	public void createContactUsingOrgNameTest() throws Throwable {
		
	
	//Create object for Generic Libraries
		//Create object for Generic Libraries
//				FileUtility pLib = new FileUtility();
//				ExcelUtility eLib = new ExcelUtility();
//				JavaUtility jLib = new JavaUtility();
//				WebDriverUtility wLib = new WebDriverUtility();
//				
//				String BROWSER = pLib.readDataFromPropertyFile("browser");
//				String URL = pLib.readDataFromPropertyFile("url");
//				String USERNAME = pLib.readDataFromPropertyFile("username");
//				String PASSWORD = pLib.readDataFromPropertyFile("password");
				
				String OrgName = eLib.readDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
				String LastName = eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
				String LeadSource = eLib.readDataFromExcel("Contacts", 1, 3);
				String ind = eLib.readDataFromExcel("Organization", 7, 3);
				String AccType = eLib.readDataFromExcel("Organization", 7, 4);
				
//				WebDriver driver = new ChromeDriver();
//				driver.manage().window().maximize();
//				driver.get(URL);
//				wLib.waitForPageLoad(driver);
				
				//login to App
				
//				LoginPage lp = new LoginPage(driver);
//				lp.loginPage(USERNAME, PASSWORD);
				
				
				HomePage hp = new HomePage(driver);
				hp.organizationLink();
				
				OrganizationPage op = new OrganizationPage(driver);
				op.organizationPage();
				
				CreateOrganizationPage cop = new CreateOrganizationPage(driver);
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
				
				hp.contactsLink();
				
				ContactsPage cp =new ContactsPage(driver);
				cp.contactPage();
				
				CreateContactsPage ccp =new CreateContactsPage(driver);
				ccp.createContact(driver, LastName, LeadSource, OrgName);
					
//				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//				
//				WebElement signout = driver.findElement(By.linkText("Sign Out"));
//				
//				Actions act = new Actions(driver);
//				act.moveToElement(signout);
//				
//				signout.click(); 
				
				
				
}
}
