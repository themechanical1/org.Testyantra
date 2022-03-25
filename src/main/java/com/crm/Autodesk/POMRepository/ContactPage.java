package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	/* Initilization of WebElement */
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* Declaration of WebElement */
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement clickOnContactIcon;
	
	/* Getters method to use it in testScript */

	public WebElement getClickOnContactIcon() {
		return clickOnContactIcon;
	}
	
	/* Business logic */
	public void clickOnContactIcon() {
		clickOnContactIcon.click();
	}
	
	

}
