package conatact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Autodesk.POMRepository.ContactPage;
import com.crm.Autodesk.POMRepository.CreateNewContacts;
import com.crm.Autodesk.POMRepository.HomePageTest;
import com.crm.Autodesk.POMRepository.LoginPage;
import com.crm.Autodesk.genericUtility.BaseClass;
import com.crm.Autodesk.genericUtility.ExcelUtility;
import com.crm.Autodesk.genericUtility.Fileutility;
import com.crm.Autodesk.genericUtility.JavaUtility;
import com.crm.Autodesk.genericUtility.WebDriverutility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends BaseClass {
	@Test
	public void createContact() throws Throwable {
		
		
		 int randomInt= jLib.getRanDomNumber();
		 
		 /* test script Data */
		 String contactName = eLib.getDataFromExcel("contactname", 1, 0) + randomInt;
		
		
		
		
		
		
		
		//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		HomePageTest homepagetest=new HomePageTest(driver);
		homepagetest.clickOncontact();
		
		
		
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		ContactPage contactpage= new ContactPage(driver);
		contactpage.clickOnContactIcon();
		
		
		
		/*
		 * contactName=contactName+randomInt;
		 * driver.findElement(By.name("lastname")).sendKeys(contactName);
		 */
		CreateNewContacts cteatenewcontact= new CreateNewContacts(driver);
		cteatenewcontact.createContact(contactName);
		System.out.println("contact created successfully");
	
		
		
	}

}
