package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformation {
	
	/* Initilizatiin of webelement */
	
	public OrganizationInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* declariation of webElement */
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationinformation;

	/* getters method to use it in test Script */
	public WebElement getOrganizationinformation() {
		return organizationinformation;
	}
	/* Busssiness logic */
	public String getOrganizationText() {
		return organizationinformation.getText();
		
	}

}
