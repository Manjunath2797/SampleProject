package Practice_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SDET43.GenericLibraries.ExcelUtility;
import com.SDET43.GenericLibraries.FileUtility;
import com.SDET43.GenericLibraries.JavaUtility;
import com.SDET43.GenericLibraries.WebDriverUtility;

public class WebTable {

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

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	//login to App
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();


	//Create Organization
	driver.findElement(By.linkText("Organizations")).click();
	
	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[last()]"));
	
	
	
	}

}
