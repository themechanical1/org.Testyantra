package com.crm.Autodesk.genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.Autodesk.POMRepository.HomePageTest;
import com.crm.Autodesk.POMRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver=null;
	public Fileutility fLib=new Fileutility();
    public ExcelUtility eLib=new ExcelUtility();
    public JavaUtility jLib=new JavaUtility();
    public WebDriverutility wLib=new WebDriverutility();
    public static WebDriver sDriver;
    
    @BeforeSuite(groups={"smokeTest","regerssionTest"})
    public void bs() {
    	System.out.println("data base connection");
    }
    @BeforeTest(groups={"smokeTest","regerssionTest"})
    
    public void bt() {
    	System.out.println("execute testScript in Parellel mode");
    	
    }
    //@Parameters("browsername")
    @BeforeClass(groups={"smokeTest","regerssionTest"})
    public void bc() throws Throwable {
    	String browserName=fLib.getPropertyKeyValue("browser");
    	String url=fLib.getPropertyKeyValue("url");
    	if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is "+browserName);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is "+browserName);
			
		} else {
			driver=new ChromeDriver();
		}
    	driver.get(url);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	sDriver= driver;
    	
    	
    }
    @BeforeMethod(groups={"smokeTest","regerssionTest"})
	public void bm() throws Throwable {
    	String userName=fLib.getPropertyKeyValue("username");
    	String password=fLib.getPropertyKeyValue("password");
    	LoginPage loginPage=new LoginPage(driver);
    	loginPage.login(userName, password);
    			
		
	}
    @AfterMethod(groups={"smokeTest","regerssionTest"})
    public void am() {
    	HomePageTest homePage=new HomePageTest(driver);
    	homePage.logout(driver);
    	
    }
    @AfterClass(groups={"smokeTest","regerssionTest"})
    public void ac() {
    	driver.quit();
    }
    @AfterTest(groups={"smokeTest","regerssionTest"})
    public void at() {
    	System.out.println("close parallel mode execution");
    	
    }
    @AfterSuite(groups={"smokeTest","regerssionTest"})
    public void as() {
    	System.out.println("Close database connection");
    	
    }

}
