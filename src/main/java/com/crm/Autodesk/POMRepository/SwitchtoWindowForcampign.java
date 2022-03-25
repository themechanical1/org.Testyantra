package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchtoWindowForcampign {
	/* Initilization Of WebElement */
	public SwitchtoWindowForcampign(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/* Declarition of WebElement */
	@FindBy(linkText="Vtiger Single User Pack")
	private WebElement selectProduct;

	/* Getters Method to use it in TestScript */
	
	public WebElement getSelectProduct() {
		return selectProduct;
	}
	
	/* Business LOgic */
	public void selectProductfromlist() {
		selectProduct.click();
	}

}
