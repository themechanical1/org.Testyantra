package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampignPage {
	
	/* initilization Of webdriver */
	public CampignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* Declaration Of WebElement */
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement clickOnCampignIcon;
	
	/* Getters Method to use it in TestScript */

	public WebElement getClickOnCampignIcon() {
		return clickOnCampignIcon;
	}
	
	/* Business Logic */
	public void clickoncampignIcon() {
		clickOnCampignIcon.click();
	}
	
	

}
