package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesInformation {
	
	/* Initilization of WebElement */
	
	public OpportunitiesInformation(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	/* Declaration of WebElemengt */
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement opportunitiesInformation;

		
	/* getters method to use it in test Script */
	
	public WebElement getOpportunitiesInformation() {
		return opportunitiesInformation;
	}
	
	/* Business Logic */
	public String getOpportunitiesText() {
		return opportunitiesInformation.getText();
		
	}


	
	

}
