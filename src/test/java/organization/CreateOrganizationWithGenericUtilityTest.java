package organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Autodesk.genericUtility.BaseClass;
import com.crm.Autodesk.genericUtility.ExcelUtility;
import com.crm.Autodesk.genericUtility.Fileutility;
import com.crm.Autodesk.genericUtility.JavaUtility;
import com.crm.Autodesk.genericUtility.WebDriverutility;

public class CreateOrganizationWithGenericUtilityTest extends BaseClass {
	@Test
	
	public void createorganizationwithGenericUtility() throws Throwable {
		/*Object Creation for Lib */
		/*
		 * JavaUtility jLib= new JavaUtility(); WebDriverutility wLib= new
		 * WebDriverutility(); Fileutility fLib= new Fileutility(); ExcelUtility eLib=
		 * new ExcelUtility();
		 */
		 int randomInt= jLib.getRanDomNumber();
		 /* common Data */
			/*
			 * String url = fLib.getPropertyKeyValue("url"); String username =
			 * fLib.getPropertyKeyValue("username"); String password =
			 * fLib.getPropertyKeyValue("password"); String browser =
			 * fLib.getPropertyKeyValue("browser");
			 */
		 /* test script Data */
		 String orgName = eLib.getDataFromExcel("Orgsheet", 1, 0) + randomInt;
		 String industryName = eLib.getDataFromExcel("Orgsheet", 1, 3) + randomInt;
		 
		 /* Navigate to app */
			/*
			 * WebDriver driver = null; if(browser.equals("chrome")) { driver=new
			 * ChromeDriver(); } else if(browser.equals("firefox")) { driver= new
			 * FirefoxDriver(); } else { driver = new ChromeDriver(); }
			 * wLib.waitForPageToLoad(driver); driver.get(url);
			 */
		 
		 /* Step 1 : login */
			/*
			 * driver.findElement(By.name("user_name")).sendKeys(username);
			 * driver.findElement(By.name("user_password")).sendKeys(password);
			 * driver.findElement(By.id("submitButton")).click();
			 */
		 
		 /* step 2 : Navigate to organization */
			driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		
		 
		 /* Step 3 : navigate to create new organization page by click on + img */
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		/* Step 4 : create organizatin */
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.cssSelector("select[name='industry']")).sendKeys(industryName);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		 
		 /* Step 5 : verify the successful msg with org name */
			WebElement wb=driver.findElement(By.cssSelector("span.dvHeaderText"));
			
			String result=wb.getText();
			System.out.println(result);
			/*
			 * if(result.contains(industryName)) {
			 * System.out.println(result+"==>is Created Successfully"+" [validation Pass] "
			 * ); } else { System.out.println("Validation Fail"); }
			 */
			 
		    Assert.assertEquals(result.contains(orgName),true);

	        
	       /*step 6 : logout*/

			wLib.waitForElementToBeClickable(driver, wb);
			WebElement log=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			

			
			wLib.mouseOverOnElemnet(driver, log);
			
			driver.findElement(By.linkText("Sign Out")).click();
			
			
		driver.close();
		

		 
		
	}

}
