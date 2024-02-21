package com.SDET43.ObjectRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET43.GenericLibraries.JavaUtility;
import com.SDET43.GenericLibraries.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
	
	//declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement TypeDropdown;
	
	
	//Initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getTypeDropdown() {
		return TypeDropdown;
	}
	
	//Business Libraries
	
	public void createOrganization(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
	}
	
	public void createOrganization(String OrgName, String industry)
	{
		OrgNameEdt.sendKeys(OrgName);
		selectByVisibleText(industryDropdown, industry);
		SaveBtn.click();
	}
	
	public void createOrganization(String OrgName, String industry, String Type)
	{
		OrgNameEdt.sendKeys(OrgName);
		selectByVisibleText(industryDropdown, industry);
		selectByVisibleText(TypeDropdown, Type);
		SaveBtn.click();
	}
	
	public void createOrganization(Map<String, String> map, JavaUtility jlib, WebDriver driver) {
			for(Entry<String, String> set:map.entrySet()) {
				if(set.getKey().equals("accountname")) {
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+"_"+jlib.getRandomNumber());	
				}
				else {
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
				}
			}
			SaveBtn.click();	
	}

}











