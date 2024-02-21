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

import com.SDET43.ObjectRepository.ContactsPage;
import com.SDET43.ObjectRepository.CreateContactsPage;
import com.SDET43.ObjectRepository.HomePage;
import com.SDET43.ObjectRepository.LoginPage;



public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		
		Random ran = new Random();
		int random = ran.nextInt(10);
		
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
		Sheet sh = wb.getSheet("Contacts");
		String LastName = sh.getRow(1).getCell(2).getStringCellValue();
	
		//Launch browser
	//	WebDriverManager.chromedriver().setup();
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
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().window().maximize();
		
		//login to App
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
//		Thread.sleep(2000);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(USERNAME, PASSWORD);
		System.out.println("good");
	//	HomePage hp = new HomePage(driver);
		//hp.organizationLink();
		
//		ContactsPage cp = new ContactsPage(driver);
//		cp.contactPage();
//		
//		CreateContactsPage ccp = new CreateContactsPage(driver);
//		ccp.createContact(LastName);
		
		//create Contact
//		driver.findElement(By.linkText("Contacts")).click();
//		
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//		
//		driver.findElement(By.name("lastname")).sendKeys(LastName+"_"+random);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

}
