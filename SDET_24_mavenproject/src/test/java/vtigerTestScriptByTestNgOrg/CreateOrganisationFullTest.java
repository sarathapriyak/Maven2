package vtigerTestScriptByTestNgOrg;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;
import com.vtiger.pomrepositorylib.CreateNewContact;
import com.vtiger.pomrepositorylib.CreatingNewOrganisation;
import com.vtiger.pomrepositorylib.HomePage;
import com.vtiger.pomrepositorylib.Organisation;

public class CreateOrganisationFullTest extends BaseClass{
	@Test
	public void CreateOrganisationTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String ORGNAME = eLib.ExcelProperty("Sheet1", 1, 1) + jLib.Randomnum();
		HomePage hp=new HomePage(driver);
		hp.getOrg().click();
		Organisation orgad = new Organisation(driver);
		orgad.addorg();
		CreatingNewOrganisation cno = new CreatingNewOrganisation(driver);
		cno.getaccname().sendKeys(ORGNAME);
		cno.getsave().click();
		orgad.getOrgcreate(ORGNAME);
		}
		@Test
		public void CreateOrgWithIndAndTypeTest() throws InterruptedException, EncryptedDocumentException, IOException
		{
			String ORGNAME = eLib.ExcelProperty("Sheet1", 1, 1) + jLib.Randomnum();
			String industryname = eLib.ExcelProperty("Sheet1", 1, 4);
			String industrytype = eLib.ExcelProperty("Sheet1", 1, 5);
			HomePage hp=new HomePage(driver);
			hp.getOrg().click();
			Organisation orgad = new Organisation(driver);
			orgad.addorg();
			CreatingNewOrganisation cno = new CreatingNewOrganisation(driver);
			cno.getaccname().sendKeys(ORGNAME);
			
			cno.getIndustryname().sendKeys(industryname);
			cno.getAcctype().sendKeys(industrytype);
			cno.getsave().click();
			orgad.getOrgcreate(ORGNAME);
	       
			}
		@Test
		public void CreateContact() throws InterruptedException, Throwable, IOException
		{
	
			String ORGNAME = eLib.ExcelProperty("Sheet1", 1, 1) + jLib.Randomnum();
			String industryname = eLib.ExcelProperty("Sheet1", 1, 4);
			String industrytype = eLib.ExcelProperty("Sheet1", 1, 5);
			HomePage hp=new HomePage(driver);
			hp.getOrg().click();
			Organisation orgad = new Organisation(driver);
			orgad.addorg();
			CreatingNewOrganisation cno = new CreatingNewOrganisation(driver);
			cno.getaccname().sendKeys(ORGNAME);
			
			cno.getIndustryname().sendKeys(industryname);
			cno.getAcctype().sendKeys(industrytype);
			cno.getsave().click();
			orgad.getOrgcreate(ORGNAME);
	        driver.navigate().refresh();
			WebElement webele = hp.getCon();
			wLib.ExplicitWait(driver, 10, webele);
            webele.click();
		}
		@Test
		public void CreateConWithOrgname() throws Throwable
		{
			String ORGNAME = eLib.ExcelProperty("Sheet1", 1, 1) + jLib.Randomnum();
			String industryname = eLib.ExcelProperty("Sheet1", 1, 4);
			String industrytype = eLib.ExcelProperty("Sheet1", 1, 5);
			String LASTNAME = eLib.ExcelProperty("Sheet1", 3, 3);
			HomePage hp=new HomePage(driver);
			hp.getOrg().click();
			Organisation orgad = new Organisation(driver);
			orgad.addorg();
			CreatingNewOrganisation cno = new CreatingNewOrganisation(driver);
			cno.getaccname().sendKeys(ORGNAME);
			cno.getIndustryname().sendKeys(industryname);
			cno.getAcctype().sendKeys(industrytype);
			cno.getsave().click();
			orgad.getOrgcreate(ORGNAME);
	        driver.navigate().refresh();
			WebElement webele = hp.getCon();
			wLib.ExplicitWait(driver, 10, webele);
            webele.click();
            WebElement createcon = hp.getCreatecontact();
    		createcon.click();
    		CreateNewContact cncon = new CreateNewContact(driver);
    		cncon.addlastname(LASTNAME);
    		cncon.getaddorg().click();
    		
    		wLib.SwitchWindow(driver, "Accounts&action");
    		orgad.gettextbox().sendKeys(ORGNAME);
    		orgad.getSearch().click();
    		Thread.sleep(3000);
    		
    		System.out.println(ORGNAME);
    		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click()  ;  		
    		//orgad.getname(ORGNAME).click();
    		//wLib.ExplicitWait(driver, 10, webele2);
    		//webele2.click();
    		//System.out.println("element found");
    		//driver.close();
    		wLib.SwitchWindow(driver, "Contacts&action");
    		
			
		}
		
	

		
	}


