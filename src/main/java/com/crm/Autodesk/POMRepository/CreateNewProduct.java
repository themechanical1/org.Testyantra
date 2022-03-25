package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct {
	/* Initilizatrion of Webelement */
	public CreateNewProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* Declarition of WebElement */
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productTextField;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	
	
	/* Getter method to use it in testScript */
	public WebElement getProductTextField() {
		return productTextField;
	}
	
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}



	/* Bussiness logic */
	public void createProduct(String ProductName) {
		productTextField.sendKeys(ProductName);
		saveButton.click();
	}
	

}
