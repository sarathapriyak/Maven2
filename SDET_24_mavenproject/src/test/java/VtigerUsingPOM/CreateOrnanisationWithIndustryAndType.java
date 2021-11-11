package VtigerUsingPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;
import com.vtiger.pomrepositorylib.CreatingNewOrganisation;
import com.vtiger.pomrepositorylib.HomePage;
import com.vtiger.pomrepositorylib.Login;
import com.vtiger.pomrepositorylib.Organisation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrnanisationWithIndustryAndType {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = null;
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		String URL = fLib.getpropertyfile("url");
		String BROWSER = fLib.getpropertyfile("browser");
		String USERNAME = fLib.getpropertyfile("username");
		String PASSWORD = fLib.getpropertyfile("password");
		String ORGNAME = eLib.ExcelProperty("Sheet1", 1, 1) + jLib.Randomnum();
		String LASTNAME = eLib.ExcelProperty("Sheet1", 3, 3);
		String industryname = eLib.ExcelProperty("Sheet1", 1, 4);
		String industrytype = eLib.ExcelProperty("Sheet1", 1, 5);
		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(URL);
		Login lp = new Login(driver);
		lp.loginTovtiger(USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		hp.getOrg().click();
		Organisation orgad = new Organisation(driver);
		orgad.addorg();
		CreatingNewOrganisation cno = new CreatingNewOrganisation(driver);
		cno.getaccname().sendKeys(ORGNAME);
		cno.getIndustryname().sendKeys(industryname);
		cno.getAcctype().sendKeys(industrytype);
		cno.getsave().click();
		orgad.getOrgcreate(ORGNAME);
		driver.close();
	}

}
