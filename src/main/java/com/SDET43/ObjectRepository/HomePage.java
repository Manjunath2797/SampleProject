package com.SDET43.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET43.GenericLibraries.WebDriverUtility;



public class HomePage extends WebDriverUtility{
	
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrgnameLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement Administrator;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOut;
	
	//initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	
	public WebElement getOrgnameLink() {
		return OrgnameLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getAdministrator() {
		return Administrator;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	//Business Library
	public void organizationLink()
	{
		OrgnameLink.click();
	}

	public void contactsLink()
	{
		ContactsLink.click();
	}
	
	public void signout(WebDriver driver)
	{
		Administrator.click();
		mouseHover(driver, Administrator);
		SignOut.click();
		
	}
}
