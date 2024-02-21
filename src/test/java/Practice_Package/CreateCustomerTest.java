package Practice_Package;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateCustomerTest {
	
	@BeforeClass
	public void confbc()
	{
		System.out.println("----Launch browser----");
	}
	
	@AfterClass
	public void confac()
	{
		System.out.println("----Close browser----");
	}
	
	@BeforeMethod
	public void confbm()
	{
		System.out.println("--- Login to App---");
	}
	@AfterMethod
	public void confam()
	{
		System.out.println("---Logout from App---");
	}
	
	@Test
	public void createOrg()
	{
		System.out.println("Navigating to app");
		System.out.println("org created");
	}

	@Test
	public void createContact()
	{
		System.out.println("Navigating to app");
		System.out.println("Contact created");
	}
	
	@BeforeSuite
	public void confbs()
	{
		System.out.println("---connect to DB---");
	}
	
	@AfterSuite
	public void confas()
	{
		System.out.println("---Close DB---");
	
	}
	
}
