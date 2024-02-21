package Contacts_Module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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



public class POM {

	public static void main(String[] args) throws Throwable {
		
		
		//Create object for Generic Libraries
			//Create object for Generic Libraries
					FileUtility pLib = new FileUtility();
					ExcelUtility eLib = new ExcelUtility();
					JavaUtility jLib = new JavaUtility();
					WebDriverUtility wLib = new WebDriverUtility();
					
					String BROWSER = pLib.readDataFromPropertyFile("browser");
					String URL = pLib.readDataFromPropertyFile("url");
					String USERNAME = pLib.readDataFromPropertyFile("username");
					String PASSWORD = pLib.readDataFromPropertyFile("password");
					
					String OrgName = eLib.readDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
					String LastName = eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
					String LeadSource = eLib.readDataFromExcel("Contacts", 1, 3);
					String ind = eLib.readDataFromExcel("Organization", 7, 3);
					String AccType = eLib.readDataFromExcel("Organization", 7, 4);
					
				//	WebDriverManager.chromedriver().setup();
					WebDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.get(URL);
					wLib.waitForPageLoad(driver);
					
					//login to App
					driver.findElement(By.name("user_name")).sendKeys(USERNAME);
					driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@id='submitButton']")).click();
					
					
					//Create Organization
					LoginPage lp = new LoginPage(driver);
					lp.loginPage(USERNAME, PASSWORD);
					
					HomePage hp = new HomePage(driver);
					hp.organizationLink();
					
					OrganizationPage op = new OrganizationPage(driver);
					op.organizationPage();
					
					CreateOrganizationPage cop = new CreateOrganizationPage(driver);
					cop.createOrganization(OrgName, ind, AccType);
					
//					driver.findElement(By.linkText("Organizations")).click();
//					
//					driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//					
//					driver.findElement(By.name("accountname")).sendKeys(OrgName);
					
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
					
//					WebElement industry = driver.findElement(By.name("industry"));
//					wLib.selectByVisibleText(industry, ind);
//					
//					WebElement type = driver.findElement(By.name("accounttype"));
//					wLib.selectByVisibleText(type, AccType);
//					
//					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
//					WebElement infoEle = driver.findElement(By.xpath("//span[@class='small']"));
//					
//					wLib.waitForElementToBeVisible(driver, infoEle);
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
					oip.organizationInfoPage(driver);
					
					ContactsPage cp = new ContactsPage(driver);
					cp.contactPage();
					
					CreateContactsPage ccp = new CreateContactsPage(driver);
					ccp.createContact(LastName, LeadSource);
//					driver.findElement(By.linkText("Contacts")).click();
//					
//					driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//					
//					driver.findElement(By.name("lastname")).sendKeys(LastName);
//					
//					driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
//					
//					wLib.switchToWindow(driver, "Accounts");
//					
//					driver.findElement(By.name("search_text")).sendKeys(OrgName);
//					
//					driver.findElement(By.name("search")).click();
//					
//					driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
//
//					wLib.switchToWindow(driver, "Contacts");
//					
//					WebElement Lead = driver.findElement(By.xpath("//select[@name='leadsource']"));
//					
//					wLib.selectByVisibleText(Lead, LeadSource);
//					
//					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
				/*	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
					
					WebElement signout = driver.findElement(By.linkText("Sign Out"));
					
					Actions act = new Actions(driver);
					act.moveToElement(signout);
					
					signout.click();*/
					
				hp.signout(driver);	
					
	}
	}

