package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.genericUtility.WebDriverutility;

public class SwitchwindowforOpportunity extends WebDriverutility {
/* Initilizatiin of webelement */
	
	public SwitchwindowforOpportunity(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* declariation of webElement */
	@FindBy(xpath="//a[text()='vtigerCRM Inc']")
	private WebElement selectorganizationName;
	
	/* getters method to use it in testscript */
	
	
	public WebElement getSelectorganizationName() {
		return selectorganizationName;
	}
	
	/* Business Logic */
	WebDriverutility wLib= new WebDriverutility();
	
	
	
	public void selectorgname(WebDriver driver) {
		wLib.swithToWindow(driver, "Accounts&action");
		selectorganizationName.click();
		wLib.swithToWindow(driver,"Potentials&action");
		
		
		
	}
	
}
