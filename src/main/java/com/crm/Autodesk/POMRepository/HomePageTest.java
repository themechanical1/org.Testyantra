package com.crm.Autodesk.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.genericUtility.WebDriverutility;
/**
 * 
 * @author Aman
 *
 */

public class HomePageTest extends WebDriverutility  {
	

	/* Initialization of WEbElement */
	public HomePageTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/* declariation of webElement */
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunutiesLink;
	
	@FindBy(css="[src=\"themes/softed/images/menuDnArrow.gif\"]")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutIconImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	
	/* getters method to use it in the test script */
	
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getOpportunutiesLink() {
		return opportunutiesLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}
	

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}
	

	public WebElement getSignOutIconImage() {
		return signOutIconImage;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	/* Business Logic */
	/**
	 * This method is used to click on organization
	 */
	public void clickonOrganization() {
		organizationLink.click();
		
	}
	/**
	 * This method os used to click on Product
	 */
	
	public void clickOnProduct() {
		productsLink.click();
		
	}
	
	public void clickOncontact() {
		contactsLink.click();
	}
	
	/**
	 * this Method is used to click on Opportunities
	 */
	public void clickonOpportunities() {
		opportunutiesLink.click();
		}
	/**
	 * This method is used to MouseOver on More
	 * @param driver
	 */
	public void mouseoveronMore(WebDriver driver) {
		mouseOverOnElemnet(driver,moreLink);
		
	}
	/**
	 * This metod is used to logout from the Application
	 * @param driver
	 */
	
	public void logout(WebDriver driver) {
		mouseOverOnElemnet(driver,signOutIconImage);
		signOutLink.click();
	}

		
	}
	

