package com.vtiger.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtility;

public class Organisation {
	WebDriver driver;

	public Organisation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	WebDriverUtility wLIB = new WebDriverUtility();
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement add;
	@FindBy(name = "search_text")
	private WebElement textbox;
	@FindBy(name = "search")
	private WebElement search;
	@FindBy(xpath = "//input[@title='Save [Alt+S]'][1]")
	private WebElement save;
	@FindBy(className = "dvHeaderText")
	private WebElement orgcreate;

	public WebElement getOrgcreate(String ORGNAME) throws InterruptedException {
		Thread.sleep(4000);
		String text = orgcreate.getText();

		if (text.contains(ORGNAME)) {
			System.out.println("organisation was created");
		} else {
			System.out.println("organaization was not created");
		}
		return orgcreate;

	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement gettextbox() {
		return textbox;
	}

	public WebElement getadd() {
		return add;
	}

	public void addorg() {
		add.click();
	}

	public WebElement getname(String ORGNAME) throws InterruptedException {

		// Thread.sleep(2000);
		WebElement webele2 = driver.findElement(By.xpath("//a[.='" + ORGNAME + "']"));
		wLIB.ExplicitWait(driver, 20, webele2);
		return webele2;

	}

	public WebElement getSave() {
		return save;
	}

}