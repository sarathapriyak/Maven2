package com.crm.vtiger.createorganisation ;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.generic.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vtigerCreateOrgnameByProperties {

	public static void main(String[] args) throws Throwable {
		Random r=new Random();
		int ranger = r.nextInt(100);
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	
	
	/*WebDriver driver;
	driver=new ChromeDriver();*/
	
	FileUtility f=new FileUtility();
	

	String BROWSER = f.getpropertyfile("browser");
	String URL = f.getpropertyfile("url");
	String USERNAME = f.getpropertyfile("username");
	String PASSWORD = f.getpropertyfile("password");
	String ORGNAME = f.getpropertyfile("orgname");
	
	WebDriver driver=null;
	if(BROWSER.contains("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.contains("firefox"))
	{
		driver=new FirefoxDriver();
	}
	
	
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
driver.findElement(By.name("accountname")).sendKeys(ORGNAME+""+ranger);
driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"][1]")).click();
driver.close();
	}

	
		
	}


