package com.crm.autodesk.createOpportunitiesWithPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Autodesk.POMRepository.CreateNewOpportunities;
import com.crm.Autodesk.POMRepository.HomePageTest;
import com.crm.Autodesk.POMRepository.LoginPage;
import com.crm.Autodesk.POMRepository.OpportunitiesInformation;
import com.crm.Autodesk.POMRepository.OpportunitiesPage;
import com.crm.Autodesk.POMRepository.OrganizationInformation;
import com.crm.Autodesk.POMRepository.SwitchwindowforOpportunity;
import com.crm.Autodesk.genericUtility.BaseClass;
import com.crm.Autodesk.genericUtility.ExcelUtility;
import com.crm.Autodesk.genericUtility.Fileutility;
import com.crm.Autodesk.genericUtility.JavaUtility;
import com.crm.Autodesk.genericUtility.WebDriverutility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunitieswithGroupTeamsellingTest extends BaseClass {
	@Test
	public void createopportunitieswithgroup() throws Throwable {
		
		int randomInt= jLib.getRanDomNumber();
		 /* common Data */
		 
		 
		 /* test script Data */
		 
		 String ExpectedOpportunityName = eLib.getDataFromExcel("Orgsheet", 1, 0) + randomInt;
		 String ClosingDate = eLib.getDataFromExcel("Orgsheet", 1, 4);
	
		
			
			HomePageTest homepagetest= new HomePageTest(driver);
			homepagetest.clickonOpportunities();
			
			OpportunitiesPage opportunitiesPage= new OpportunitiesPage(driver);
			opportunitiesPage.clickonOpportunities();
			
			CreateNewOpportunities createopportunities= new CreateNewOpportunities(driver);
			createopportunities.createopportunity(ExpectedOpportunityName);
			createopportunities.selectrelatedName();
			//wLib.swithToWindow(driver,"Accounts&action");
			SwitchwindowforOpportunity switchwindowopp= new SwitchwindowforOpportunity(driver);
			switchwindowopp.selectorgname(driver);
			//wLib.swithToWindow(driver,"Potentials&action");
			
			
			
			createopportunities.clickonGroupradioButton();
			createopportunities.clickonassignbox();
			createopportunities.clickondropBioxoption();
			
			createopportunities.selectclosingDate(ClosingDate);
			
			createopportunities.clickonSaveButton();
			
			OpportunitiesInformation opportunitiesInfo =new OpportunitiesInformation(driver);
			String actualOpportunityName= opportunitiesInfo.getOpportunitiesText();
			
			/* verification */
			/*
			 * if(actualOpportunityName.contains(ExpectedOpportunityName)) {
			 * System.out.println("Opportunity is created seccessfully"); } else {
			 * System.out.println("Opportunity is not created"); }
			 */
		Assert.assertEquals(actualOpportunityName.contains(ExpectedOpportunityName),true);
			
			
	}

}
