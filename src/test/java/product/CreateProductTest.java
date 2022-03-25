package product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Autodesk.POMRepository.CreateNewProduct;
import com.crm.Autodesk.POMRepository.HomePageTest;
import com.crm.Autodesk.POMRepository.LoginPage;
import com.crm.Autodesk.POMRepository.ProductPage;
import com.crm.Autodesk.genericUtility.BaseClass;
import com.crm.Autodesk.genericUtility.ExcelUtility;
import com.crm.Autodesk.genericUtility.Fileutility;
import com.crm.Autodesk.genericUtility.JavaUtility;
import com.crm.Autodesk.genericUtility.WebDriverutility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass{
	@Test
	public void CreateProduct() throws Throwable {
		/*
		 * FileInputStream fil=new
		 * FileInputStream(".\\src\\test\\resources\\organization\\Organization.xlsx");
		 * Workbook wb= WorkbookFactory.create(fil); Sheet
		 * sheet=wb.getSheet("productname"); int rowcount = sheet.getLastRowNum(); short
		 * columncount = sheet.getRow(0).getLastCellNum();
		 * System.out.println("Total number of Rows "+rowcount);
		 * System.out.println("Total number of Columns "+columncount); for (int i=0;
		 * i<=rowcount; i++) { for (int j=0;j<columncount - 1; j++) { Row
		 * row=sheet.getRow(i); Cell cell=row.getCell(j); String
		 * data=cell.getStringCellValue(); System.out.print(data+"  "); }
		 * System.out.println(); }
		 * System.out.println("=======================================================")
		 * ; String productName=sheet.getRow(1).getCell(0).getStringCellValue();
		 * System.out.println("organization Name is "+productName); FileInputStream fis
		 * = new
		 * FileInputStream(".\\src\\main\\resources\\commondata\\credentials.properties"
		 * ); Properties pro_obj=new Properties(); pro_obj.load(fis); String
		 * browser=pro_obj.getProperty("browser"); String
		 * url=pro_obj.getProperty("url"); String
		 * username=pro_obj.getProperty("username"); String
		 * password=pro_obj.getProperty("password"); System.out.println(browser);
		 * System.out.println(url); System.out.println(username);
		 * System.out.println(password);
		 */
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
		 String productName = eLib.getDataFromExcel("productname", 1, 0) + randomInt;

		//runtime Polymorphism
		/*
		 * WebDriver driver=null; if(browser.equalsIgnoreCase("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver();
		 * System.out.println("launched browser is "+browser); } else if
		 * (browser.equalsIgnoreCase("firefox")) {
		 * WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver();
		 * System.out.println("launched browser is "+browser);
		 * 
		 * } else { System.out.println("specify a valid browser"); }
		 * wLib.waitForPageToLoad(driver); driver.manage().window().maximize();
		 * driver.get(url);
		 */
		
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(username);
		 * driver.findElement(By.name("user_password")).sendKeys(password);
		 * driver.findElement(By.id("submitButton")).click();
		 */
		/*
		 * LoginPage loginpage=new LoginPage(driver); loginpage.login(username,
		 * password);
		 */
		
		HomePageTest homepagetest= new HomePageTest(driver);
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		homepagetest.clickOnProduct();
		
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		ProductPage produdtpage=new ProductPage(driver);
		produdtpage.clickonProducticon();
		
		CreateNewProduct createnewproduct=new CreateNewProduct(driver);
		createnewproduct.createProduct(productName);
		System.out.println("product Created successfully");
		
		/*productName=productName+randomInt;
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);*/
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//driver.close();
		/*
		 * homepagetest.logout(driver); driver.quit();
		 */
	}

}
