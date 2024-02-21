package com.SDET43.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET43.GenericLibraries.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility{

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement OrgLookupImg;
	
	@FindBy(name = "search_text")
	private WebElement SearchEdt;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	@FindBy(name = "leadsource")
	private WebElement LeadsourceDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	

	//initialization
	public CreateContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookupImg() {
		return OrgLookupImg;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getLeadsourceDropdown() {
		return LeadsourceDropdown;
	}
	
	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	public WebElement getsaveButton()
	{
		return SaveBtn;
	}
	
	//Business Libraries
	
	public void createContact(String LastName)
	{
		lastNameEdt.sendKeys(LastName);
		SaveBtn.click();
	}
	
	public void createContact(String LastName, String LeadSource)
	{
		lastNameEdt.sendKeys(LastName);
		selectByVisibleText(LeadsourceDropdown, LeadSource);
		SaveBtn.click();
	}
	
	public void createContact(WebDriver driver, String LastName, String LeadSource, String OrgName)
	{
		lastNameEdt.sendKeys(LastName);
		OrgLookupImg.click();
		switchToWindow(driver, "Accounts");
		SearchEdt.sendKeys(OrgName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		selectByVisibleText(LeadsourceDropdown, LeadSource);
		SaveBtn.click();
		
	}
	
	
}


















