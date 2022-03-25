package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampign {
	/* Initilization Of WebElement */
	public CreateNewCampign(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/* Declaration Of WebElement */
	@FindBy(css="input[name='campaignname']")
	private WebElement campignNameTextField;
	
	@FindBy(css="img[title='Select']")
	private WebElement clickOnProductIcon;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	/* Getters Method to use it in TestScript */
	public WebElement getCampignNameTextField() {
		return campignNameTextField;
	}
	
	
	public WebElement getClickOnProductIcon() {
		return clickOnProductIcon;
	}
	


	public WebElement getSaveButton() {
		return saveButton;
	}


	/* Business Logic */
	public void CreateCampignName(String CampignName) {
	campignNameTextField.sendKeys(CampignName);
	}
	
	public void clickOnProductIcon() {
		clickOnProductIcon.click();
		saveButton.click();
	}
}
