package db_practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	@Test
	public void mytrip() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Date dateobj=new Date();
		String date = dateobj.toString();
		String[] today = date.split(" ");
		String day = today[0];
		String month = today[1];
		String actualday = today[2];
		String year = today[5];
		 String condate = day+ " " +month+ " " +actualday+ " " +year;
		 System.out.println(date);
		 System.out.println(condate);
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);
		WebElement myele = driver.findElement(By.xpath("//a[@data-cy=\"mmtLogo\"]"));
		Actions ac=new Actions(driver);
		ac.moveToElement(myele).click().perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[.=\"From\"]")).click();
		//driver.findElement(By.className("fsw_inputBox searchCity inactiveWidget ")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).sendKeys("BOM");
		driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).sendKeys("Chennai");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[contains(text(),'Chennai, India')]")).click();
		//driver.findElement(By.className("fsw_inputBox dates inactiveWidget ")).click();
		//driver.findElement(By.className("font14 appendBottom5 blackText")).click();
		driver.findElement(By.xpath("//label[@for=\"departure\"]")).click();
		//driver.findElement(By.xpath("//div[@aria-label=\"Wed Nov 10 2021\"]")).click();
				 driver.findElement(By.xpath("//div[@aria-label='"+condate+"']")).click();
				//WebDriverWait wait=new WebDriverWait(driver, 20);
				//wait.until(ExpectedConditions.visibilityOf(dateele));
				//dateele.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.=\"Search\"]")).click();
		
	}

}
