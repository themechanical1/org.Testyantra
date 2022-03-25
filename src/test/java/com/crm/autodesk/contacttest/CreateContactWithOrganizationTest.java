package com.crm.autodesk.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.Autodesk.POMRepository.HomePageTest;
import com.crm.Autodesk.POMRepository.LoginPage;
import com.crm.Autodesk.genericUtility.BaseClass;
import com.crm.Autodesk.genericUtility.ExcelUtility;
import com.crm.Autodesk.genericUtility.Fileutility;
import com.crm.Autodesk.genericUtility.JavaUtility;
import com.crm.Autodesk.genericUtility.WebDriverutility;


public class CreateContactWithOrganizationTest extends BaseClass{
	@Test
	public void createcontactwithOrg() throws Throwable {
		
		
		 int randomInt= jLib.getRanDomNumber();
		 /* common Data */
		
		 /* test script Data */
		 String contactName = eLib.getDataFromExcel("contactname", 1, 0) + randomInt;
		 String orgName = eLib.getDataFromExcel("Orgsheet", 1, 3) + randomInt;
		
		
		//step:2 navigate to Organization
		
		HomePageTest homepagetest= new HomePageTest(driver);
		homepagetest.clickonOrganization();		
		//step:3 navigate to create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//Step:4 create a new org
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//Step:5 verify
		String actHeaderMsg=driver.findElement(By.className("dvHeaderText")).getText();
		if(actHeaderMsg.contains(orgName)) {
			System.out.println(orgName+"is verified==PASS");
		}else {
			System.out.println(orgName+"is not verified==Fail");
		}
				wLib.waitForElementToBeClickable(driver, driver.findElement(By.linkText("Contacts")) );
		//navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		//navigate to create contactpage
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//create a new Contact
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		wLib.swithToWindow(driver,"Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		wLib.swithToWindow(driver,"Contacts");
		

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actHeaderMsg1=driver.findElement(By.className("dvHeaderText")).getText();
		if(actHeaderMsg1.contains(contactName)) {
			System.out.println(contactName+"is verified==PASS");
		}else {
			System.out.println(contactName+"is not verified==Fail");
		}
		


	}

}
