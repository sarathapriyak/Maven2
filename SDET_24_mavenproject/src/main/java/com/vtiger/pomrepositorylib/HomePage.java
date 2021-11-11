package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtility;

public class HomePage {
	WebDriverUtility wLib=new WebDriverUtility();
	WebDriver driver;
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(linkText="Organizations")
private WebElement org;
@FindBy(linkText ="Contacts")
private WebElement con;
@FindBy(xpath=("//img[@title='Create Contact...']"))
private WebElement createcontact;
@FindBy(xpath=("//img[@src=\"themes/softed/images/user.PNG\"]"))
private WebElement signout;


@FindBy(linkText = "Sign Out")
private WebElement logout;
public WebElement getSignout() {
	return signout;
}
public WebElement getOrg() {
	return org;
}
public WebElement getCon() {
	return con;
}
public WebElement getCreatecontact() {
	return createcontact;
}

public WebElement getLogout() {
	return logout;
}
public void SignoutApp()
{
	signout.click();
	logout.click();
	
}



}