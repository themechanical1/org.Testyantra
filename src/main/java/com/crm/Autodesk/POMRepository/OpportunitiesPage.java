package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	/* initializartion of Webelement */
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* declaration of WebElement */
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement opportunitiesPage;
	
	/* getters methods to use it in testscript */

	public WebElement getOpportunitiesPage() {
		return opportunitiesPage;
	}
	
	/* Bussiness Logic */
	/**
	 * This method is used to click on Opportunities + sign
	 */
	public void clickonOpportunities() {
		opportunitiesPage.click();
		
	}
	

}
