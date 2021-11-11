package db_practice;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

 

public class vtigerTest2 {
	

	
	 

		@Test
		 
			public void CreateIndustriesTest(XmlTest xml) throws Throwable {
			Random r=new Random();
		int ranger = r.nextInt(100);
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			ExcelUtility e=new ExcelUtility();
			
			
		


			String url = xml.getParameter("url");
			String username = xml.getParameter("un");
			String password = xml.getParameter("pw");
			
			String org = e.ExcelProperty("Sheet1", 1, 1);
			
		
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
			WebElement list = driver.findElement(By.name("industry"));
			driver.findElement(By.name("accountname")).sendKeys(org);
			Select s=new Select(list);
			s.selectByVisibleText("Finance");
			WebElement list2 = driver.findElement(By.name("accounttype"));
			Select s1=new Select(list2);
			s1.selectByVisibleText("Press");
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"][1]")).click();
			driver.close();
		}

	}



