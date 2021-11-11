package com.crm.vtiger.CreateOrgnameandIndustries;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vtigerCreateContact {
	@Test
	public void CreateContact() throws Throwable {
		WebDriverManager.chromedriver().setup();

		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();

		String BROWSER = fLib.getpropertyfile("browser");
		String URL = fLib.getpropertyfile("url");
		String USERNAME = fLib.getpropertyfile("username");
		String PASSWORD = fLib.getpropertyfile("password");
		WebDriver driver = null;
		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		String ORGNAME = eLib.ExcelProperty("sheet1", 1, 1) + "" + jLib.Randomnum();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);

		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		WebElement list1 = driver.findElement(By.name("industry"));
		Select s = new Select(list1);
		s.selectByVisibleText("Finance");
		WebElement list2 = driver.findElement(By.name("accounttype"));
		Select s1 = new Select(list2);
		s1.selectByVisibleText("Press");
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"][1]")).click();
		Thread.sleep(1000);
		WebElement ORGHEAD = driver.findElement(By.className("dvHeaderText"));
		String org = ORGHEAD.getText();
		if (org.contains(ORGNAME))

		{
			System.out.println(ORGNAME + " has been created successfully");
		} else {
			System.out.println(ORGNAME + "has not been created successfully");

		}
		WebElement con = driver.findElement(By.linkText("Contacts"));
		/*
		 * WebDriverWait wait=new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(
		 * "Contacts"))));
		 */
		wLib.ExplicitWait(driver, 10, con);

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		String LASTNAME = eLib.ExcelProperty("Sheet1", 2, 3);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		wLib.SwitchWindow(driver, "Accounts&action");
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();
		wLib.SwitchWindow(driver, "Contacts&action");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		System.out.println("contact saved");
		WebElement contacthead = driver.findElement(By.className("dvHeaderText"));
		wLib.ExplicitWait(driver, 10, contacthead);
		String conhead = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(conhead.contains(LASTNAME))
		{
			System.out.println(LASTNAME + "contact's has been created successfully");
		} else {
			System.out.println("contact has not been created  successfully");
		}
//Actions a=new Actions(driver);
		WebElement log = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//a.moveToElement(log).perform();
//driver.findElement(By.linkText("Sign Out")).click();
		//wLib.Actionmove(driver, log, "Sign Out");
		driver.close();
	}

}
