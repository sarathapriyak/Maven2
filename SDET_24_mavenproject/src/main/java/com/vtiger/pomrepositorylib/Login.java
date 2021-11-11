package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
@FindBy(name="user_name")
private WebElement usernamebtn;
@FindBy(name="user_password")
private WebElement passwordbtn;
@FindAll({@FindBy (id="submitButton"), @FindBy(xpath="//input[@id='submitButton']")})
private WebElement loginbtn;
public WebElement getusernamebtn()
{
return usernamebtn;
}
public WebElement getpasswordbutton()
{
	return passwordbtn;
}
public WebElement getloginbtn()
{
	return loginbtn;
}
public void loginTovtiger(String username,String password)
{
	usernamebtn.sendKeys(username);
	passwordbtn.sendKeys(password);
	loginbtn.click();
}
}
