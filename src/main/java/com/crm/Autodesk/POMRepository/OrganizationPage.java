package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	/* Initilizatiin of webelement */
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	/* declaration of WebElement */
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement organizationPage;
	
	/* getters method to use it in test Script */

	public WebElement getOrganizationPage() {
		return organizationPage;
	}
	/* Business logic */
	/**
	 * This method is used to click on Organization + sign
	 */
	public void clickonOrganizationimg() {
		organizationPage.click();
		
	}
}
