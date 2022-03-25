package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOncampign {
	/* Initilization Of Webelement */
	public ClickOncampign(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/* decleration Of Webelememnt */
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement clickOncampign;
	
	/* Getters Method to use it in Testscript */
	public WebElement getClickOncampign() {
		return clickOncampign;
	}
	/* Business logic */
	public void clickonCampignLink() {
		clickOncampign.click();
		
	}
	
	

}
