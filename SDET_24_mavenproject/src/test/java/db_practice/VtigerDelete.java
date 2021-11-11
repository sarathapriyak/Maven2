package db_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.batik.svggen.font.table.Ligature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.Test;

import com.vtiger.generic.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerDelete {
@Test
public void deleteOrg() throws Throwable
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/");
	FileUtility flib=new FileUtility();
	String USERNAME = flib.getpropertyfile("username");
	String PASSWORD = flib.getpropertyfile("password");
	String BROWSER = flib.getpropertyfile("browser");
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	
	
	List<WebElement> listorg = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[3]/a"));
	for(int i=1;i<listorg.size();i++)
	{
		String orgname="TesTYantra511";
		Thread.sleep(3000);
		String text = listorg.get(i).getText();
		if(orgname.equals(text))
		{
			System.out.println("this is working");
			driver.findElement(By.xpath("/a[contains(text(),'"+orgname+"')]/parent::td/following-sibling::td[5]/a[2]")).click();
			driver.switchTo().alert().accept();
			}
		
		driver.close();
	}
	
	//driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[3]/a"));
}
}
