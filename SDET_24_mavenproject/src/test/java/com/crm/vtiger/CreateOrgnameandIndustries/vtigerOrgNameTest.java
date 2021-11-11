package com.crm.vtiger.CreateOrgnameandIndustries;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.vtiger.generic.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vtigerOrgNameTest {

	@Test
	 
		public void CreateOrganizationTest() throws Throwable, IOException {
		Random r=new Random();
	    int ranger = r.nextInt(100);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		ExcelUtility e=new ExcelUtility();
		
		
	

		String url =System.getProperty("url");
		String username =System.getProperty("un");
		String password = System.getProperty("pw");
		System.out.println(url);
		
		String org = e.ExcelProperty("Sheet1", 1, 1);
		
	
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(org);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"][1]")).click();
		driver.close();
		
	}

}
