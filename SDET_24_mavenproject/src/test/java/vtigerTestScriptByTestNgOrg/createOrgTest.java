package vtigerTestScriptByTestNgOrg;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;
import com.vtiger.pomrepositorylib.CreatingNewOrganisation;
import com.vtiger.pomrepositorylib.HomePage;
import com.vtiger.pomrepositorylib.Organisation;

public class createOrgTest extends BaseClass {
	@Test(groups="smoke")
	public void CreateOrganisationTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String ORGNAME = eLib.ExcelProperty("Sheet1", 1, 1) + jLib.Randomnum();
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.getOrg().click();
		Organisation orgad = new Organisation(driver);
		orgad.addorg();
		CreatingNewOrganisation cno = new CreatingNewOrganisation(driver);
		cno.getaccname().sendKeys(ORGNAME);
		cno.getsave().click();
		orgad.getOrgcreate(ORGNAME);
		}
	@Test(groups="regression")
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
	
}
