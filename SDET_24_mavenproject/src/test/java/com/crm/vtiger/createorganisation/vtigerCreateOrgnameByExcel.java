package com.crm.vtiger.createorganisation;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vtigerCreateOrgnameByExcel {

	public static void main(String[] args) throws Throwable, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Random r=new Random();
		int range = r.nextInt(1000);
		
		
		FileUtility f = new FileUtility();

		
		String URL = f.getpropertyfile("url");
		String USERNAME = f.getpropertyfile("username");
		String PASSWORD = f.getpropertyfile("password");
		
		
		ExcelUtility e = new ExcelUtility();
		String ORGNAME = e.ExcelProperty("Sheet1", 2, 1);
		
	
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+" "+range);
		System.out.println(ORGNAME);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"][1]")).click();
	
		WebElement orgname = driver.findElement(By.className("dvHeaderText"));
		String txt = orgname.getText();
		if(txt.contains(ORGNAME))
		{
			e.ExcelWrite("Sheet1", 4, 5, "pass");
		}
		else
		{
			e.ExcelWrite("Sheet1", 4, 5, "fail");
		}
		
		driver.close();
		
	}

}
