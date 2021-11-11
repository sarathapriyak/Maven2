package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
public Contactpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(linkText = "Contacts")
private WebElement contacts;
public WebElement getcontacts()
{
	return contacts;
}
public void clickcontact()
{
	contacts.click();
}
}
