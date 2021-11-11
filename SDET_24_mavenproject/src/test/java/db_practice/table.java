package db_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.generic.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class table {
	@Test
	public void vtiger() throws Throwable
	{
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		FileUtility flib=new FileUtility();
		String USERNAME = flib.getpropertyfile("username");
		String PASSWORD = flib.getpropertyfile("password");
		String BROWSER = flib.getpropertyfile("browser");
		if(BROWSER.contains("chrome"))
		{
			 driver = new ChromeDriver();
		}
		else if(BROWSER.contains("firefox"))
		{
			 driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
	
		List<WebElement> listorg = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[1]/input"));
		for(int i=1;i<listorg.size();i++)
		{
			listorg.get(i).click();
		}
		listorg.get(listorg.size()-1).click();
		listorg.get(5).click();
		
		List<WebElement> listorg2 = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[3]/a"));
		for(int i=1;i<listorg2.size();i++)
		{
			System.out.println(listorg2.get(i).getText());
		}
		//List<WebElement> listorg3 = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[8]"));
	}
	

}
