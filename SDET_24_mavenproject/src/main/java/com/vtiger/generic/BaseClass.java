package com.vtiger.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vtiger.pomrepositorylib.HomePage;
import com.vtiger.pomrepositorylib.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//WebDriverManager.chromedriver.setup();
	public WebDriver driver;
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
//@Parameters(value = "BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	public void configBC() throws Throwable
	{
		String BROWSER = fLib.getpropertyfile("browser");
		System.out.println("Launching browser");
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		/*if(BROWSER.contains("chrome"))
				{
			driver=new ChromeDriver();
				}
		else if(BROWSER.contains("firefox"))
		{
			driver=new FirefoxDriver();
		}*/
}
	@BeforeMethod(groups= {"smoke","regression"})
	
		public void configBM() throws Throwable
		{
			/*common data*/
			String URL = fLib.getpropertyfile("url");
			
			String USERNAME = fLib.getpropertyfile("username");
			String PASSWORD = fLib.getpropertyfile("password");
			/*navigate to app*/
			
			driver.get(URL);
			/*step 1:login*/
			Login logpage=new Login(driver);
			logpage.loginTovtiger(USERNAME, PASSWORD);
		
		}
			@AfterMethod(groups= {"smoke","regression"})
			public void configAM()
			{
				
			HomePage hp=new HomePage(driver);
			hp.SignoutApp();
			
		}
			@AfterClass(groups= {"smoke","regression"})
			public void congigAC()
			{
				System.out.println("close the browser");
				driver.quit();
				
	}
}