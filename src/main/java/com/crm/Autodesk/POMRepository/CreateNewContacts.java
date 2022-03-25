package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContacts {
	/* Initilization of webelemnt */
	public CreateNewContacts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/* Declarition of webelemnt */
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	
	
	/* Getters Method to use it in testscript */
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	
	/* Business Logic */
	public void createContact(String ContactName) {
		lastNameTextField.sendKeys(ContactName);
		
		
	}
	
	
	

}
