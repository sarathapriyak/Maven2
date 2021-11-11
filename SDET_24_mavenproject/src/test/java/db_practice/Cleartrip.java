package db_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cleartrip {
	@Test
	public void bookticket() throws Throwable {
		//WebDriver driver=null;
		//WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();		
		driver.get("https://www.cleartrip.com/");
		//driver.findElement(By.xpath("//input[@placeholder=\"Any worldwide city or airport\"]")).sendKeys("Bangalore");
		//driver.findElement(By.xpath("//h4[contains(text(),'From')]/../div")).sendKeys("Bangalore");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//h4[contains(text(),'From')]/../div/div/div/input")).sendKeys("Bangalore");
		
		driver.findElement(By.xpath("//p[contains(text(),'Bangalore, IN - Kempegowda International Airport (BLR)')]")).click();
		driver.findElement(By.xpath("//h4[contains(text(),'To')]/../div/div/div/input")).sendKeys("Chennai");
		driver.findElement(By.xpath("//p[.=\"Chennai, IN - Chennai Airport (MAA)\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.className("t-all ml-2")).click();
		
		
	}

}
