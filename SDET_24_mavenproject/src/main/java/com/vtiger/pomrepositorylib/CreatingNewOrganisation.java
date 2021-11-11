/**
 * 
 */
package com.vtiger.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author BASKARAN
 *
 */
public class CreatingNewOrganisation {
	public CreatingNewOrganisation(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="accountname")
	private WebElement accname;
	
	@FindBy(name="industry")
	private WebElement industryname;
	
	
	
	@FindBy(name="accounttype")
	private WebElement acctype;
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement save;
public WebElement getaccname()
{
return accname;	
}
public WebElement getsave()
{
	return save;
}


public WebElement getIndustryname() {
	return industryname;
}
public WebElement getAcctype() {
	return acctype;

}

}
