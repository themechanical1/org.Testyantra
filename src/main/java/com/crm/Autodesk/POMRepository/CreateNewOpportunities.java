package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreateNewOpportunities  {
	
	/* Initilization of WebElement */
	public CreateNewOpportunities(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* declaration of Webelement */
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement opportunitiesnameTextField;
	
	@FindBy(xpath="//input[@id='related_to_display']/parent::td/descendant::img")
	private WebElement selectRelatedName;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupradioButton;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement selectassign;
	
	@FindBy(xpath="//option[text()='Team Selling']")
	private WebElement Selectdropbox;
	
	@FindBy(xpath="//input[@name='closingdate']")
	private WebElement selectclosingdate;
	
	@FindBy(xpath="//select[@name='sales_stage']")
	private WebElement clickonSalesStage;
	
	@FindBy(xpath="//option[@value='Prospecting']")
	private WebElement selectProspecting;
	
	
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	/* getters method to use it in testscript */

	public WebElement getOpportunitiesnameTextField() {
		return opportunitiesnameTextField;
	}

	public WebElement getSelectOrganization() {
		return selectRelatedName;
	}

	

	public WebElement getGroupradioButton() {
		return groupradioButton;
	}

	public WebElement getSelectassign() {
		return selectassign;
	}
	

	public WebElement getSelectdropbox() {
		return Selectdropbox;
	}
	

	public WebElement getSelectclosingdate() {
		return selectclosingdate;
	}
	
	public WebElement getClickonSalesStage() {
		return clickonSalesStage;
	}
	

	public WebElement getSelectProspecting() {
		return selectProspecting;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/* Business Logic */
	
	public void createopportunity(String opportunitiesName) {
		opportunitiesnameTextField.sendKeys(opportunitiesName);
		
	}
	
	public void selectrelatedName()  {
		selectRelatedName.click();
		
	}
	
	public void clickonGroupradioButton() {
		groupradioButton.click();	}
	
	public void clickonassignbox() {
		selectassign.click();
		
	}
	
	public void clickondropBioxoption() {
		Selectdropbox.click();
		
	}
	public void selectclosingDate(String DDMMYY) {
		selectclosingdate.clear();
		
		selectclosingdate.sendKeys(DDMMYY);
	}
	
	public void clickonSaveButton() {
		saveButton.click();
		
	}
	
	public void clickOnsalesStage() {
		clickonSalesStage.click();
		
	}
	
	public void clickOnProspecting() {
		selectProspecting.click();
	}
	

	
	
	
	
	
	

}
