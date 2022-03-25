package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.genericUtility.WebDriverutility;

public class CreateNewOrganization extends WebDriverutility {
	/* Initialization of WEbElement */
	public CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	/* declariation of webElement */
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationNametextField;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement selectIndustry;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	/* getters method to use it in test Script */

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getOrganizationNametextField() {
		return organizationNametextField;
	}

	public WebElement getSelectIndustry() {
		return selectIndustry;
	}
	
	/* Business Logic */
	/**
	 * this method is used to create organization with industry
	 * @param organizationName
	 * @param dropDownValue
	 */
	public void createOrganization(String organizationName,String dropDownValue) {
		organizationNametextField.sendKeys(organizationName);
		
		select(selectIndustry,dropDownValue);
		saveButton.click();
}

}
