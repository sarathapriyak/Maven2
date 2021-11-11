package com.vtiger.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {
	public CreateNewContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lname;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement addorg;
	
	public WebElement getaddorg() {
		return addorg;
	}
	public WebElement getlname()
	{
		return lname;
	}
	public void addlastname(String name)
	{
		
		lname.sendKeys(name);
	}
	

}
