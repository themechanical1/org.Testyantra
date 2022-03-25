package CreateOrganizationWithPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Autodesk.POMRepository.CreateNewOrganization;
import com.crm.Autodesk.POMRepository.HomePageTest;
import com.crm.Autodesk.POMRepository.LoginPage;
import com.crm.Autodesk.POMRepository.OrganizationInformation;
import com.crm.Autodesk.POMRepository.OrganizationPage;
import com.crm.Autodesk.genericUtility.BaseClass;
import com.crm.Autodesk.genericUtility.ExcelUtility;
import com.crm.Autodesk.genericUtility.Fileutility;
import com.crm.Autodesk.genericUtility.JavaUtility;
import com.crm.Autodesk.genericUtility.WebDriverutility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateorganizationTest extends BaseClass {
	@Test
	public void createorganizationTest() throws Throwable {
		
		int randomInt= jLib.getRanDomNumber();
		 		 
		 /* test script Data */
		 String industryName = eLib.getDataFromExcel("Orgsheet", 1, 3);
		 String ExpectedOrgName = eLib.getDataFromExcel("Orgsheet", 1, 0) + randomInt;
		
			
			HomePageTest homepagetest= new HomePageTest(driver);
			homepagetest.clickonOrganization();
			
			OrganizationPage organizationpage = new OrganizationPage(driver);
			organizationpage.clickonOrganizationimg();
			
			CreateNewOrganization createneworganization= new CreateNewOrganization(driver);
			createneworganization.createOrganization(ExpectedOrgName,industryName);
			
			OrganizationInformation organizatiomonfo =new OrganizationInformation(driver);
			String actualOrgName= organizatiomonfo.getOrganizationText();
			
			/* verification */
			/*
			 * if(actualOrgName.contains(ExpectedOrgName)) {
			 * System.out.println("Organization is created seccessfully"); } else {
			 * System.out.println("Organization is not created"); }
			 */
			Assert.assertEquals(actualOrgName.contains(ExpectedOrgName),true);
	}
	

}
