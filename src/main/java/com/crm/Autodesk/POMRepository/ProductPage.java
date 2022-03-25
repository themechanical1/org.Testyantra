package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	/* Initilization Of webElement */
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* Declaration of WebElememnt */
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement clickonProductimg;

	
	
	
	/* getter method to use it in testScript */
	public WebElement getClickonProductimg() {
		return clickonProductimg;
	}
	
	
	
	/* Bussiness logic */
	public void clickonProducticon() {
		clickonProductimg.click();
	}
	

}
