package campign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Autodesk.POMRepository.CampignPage;
import com.crm.Autodesk.POMRepository.ClickOncampign;
import com.crm.Autodesk.POMRepository.CreateNewCampign;
import com.crm.Autodesk.POMRepository.HomePageTest;
import com.crm.Autodesk.POMRepository.LoginPage;
import com.crm.Autodesk.POMRepository.SwitchtoWindowForcampign;
import com.crm.Autodesk.genericUtility.BaseClass;
import com.crm.Autodesk.genericUtility.ExcelUtility;
import com.crm.Autodesk.genericUtility.Fileutility;
import com.crm.Autodesk.genericUtility.JavaUtility;
import com.crm.Autodesk.genericUtility.WebDriverutility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.Autodesk.genericUtility.ListenerImplementationClass.class)
public class CreateCampignTest extends BaseClass{
	@Test
	public void createcampign() throws Throwable {
		
		
		 int randomInt= jLib.getRanDomNumber();
		 
		 /* test script Data */
		 String campignName = eLib.getDataFromExcel("campign", 1, 0) + randomInt;
		
	
				HomePageTest homepagetest= new HomePageTest(driver);
		homepagetest.mouseoveronMore(driver);
		
		
		
		
		ClickOncampign clickoncampign=new ClickOncampign(driver);
		clickoncampign.clickonCampignLink();
		
		CampignPage campignPage=new CampignPage(driver);
		campignPage.clickoncampignIcon();

	     //Assert.fail();
		
		CreateNewCampign createnewcampign=new CreateNewCampign(driver);
		createnewcampign.CreateCampignName(campignName);
		
		
		
		createnewcampign.clickOnProductIcon();
		
				 
		wLib.swithToWindow(driver,"Products");
		
		SwitchtoWindowForcampign switchtowinforCampign=new SwitchtoWindowForcampign(driver);
		switchtowinforCampign.selectProductfromlist();
	
		wLib.swithToWindow(driver,"Campaigns&action");



		
		
	}

}
