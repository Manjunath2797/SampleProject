package com.SDET43.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement ContactsLookupImg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getContactsLookupImg() {
		return ContactsLookupImg;
	}

	//Business Library
	public void contactPage()
	{
		ContactsLookupImg.click();
	}
	
}
