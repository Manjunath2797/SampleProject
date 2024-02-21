package com.SDET43.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	//declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement OrganizationLookupImg;
	
	//initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrganizationLookupImg() {
		return OrganizationLookupImg;
	}
	
	//Business Library
	public void organizationPage()
	{
		OrganizationLookupImg.click();
	}
	
	

}
