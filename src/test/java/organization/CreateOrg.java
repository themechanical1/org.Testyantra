package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrg {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fil=new FileInputStream(".\\src\\test\\resources\\organization\\Organization.xlsx");
		Workbook wb= WorkbookFactory.create(fil);
		Sheet sheet=wb.getSheet("Orgsheet");
		int rowcount = sheet.getLastRowNum();
		short columncount = sheet.getRow(0).getLastCellNum();
		System.out.println("Total number of Rows "+rowcount);
		System.out.println("Total number of Columns "+columncount);
		for (int i=0; i<=rowcount; i++) {
			for (int j=0;j<columncount - 1; j++) {
				Row row=sheet.getRow(i);
				Cell cell=row.getCell(j);
				String data=cell.getStringCellValue();
				System.out.print(data+"  ");
			}
			System.out.println();
		}
		System.out.println("=======================================================");
		String orgName=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println("organization Name is "+orgName);
		
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\commondata\\credentials.properties");
		Properties pro_obj=new Properties();
		pro_obj.load(fis);
		String browser=pro_obj.getProperty("browser");
		String url=pro_obj.getProperty("url");
		String username=pro_obj.getProperty("username");
		String password=pro_obj.getProperty("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		//runtime Polymorphism
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is "+browser);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is "+browser);
			
		} else {
			System.out.println("specify a valid browser");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		//click on organization link
		
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		//click on + img
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//enter org name
		Random r = new Random();
		int randomNum = r.nextInt(1000);
		
		orgName=orgName+randomNum;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		//select industry as healthcare

//		WebElement industry=driver.findElement(By.cssSelector("select[name='industry']"));
//		Select s=new Select(industry);
//		List<WebElement> lst=s.getOptions();
//		for(WebElement wbr : lst) {
//			System.out.println(wbr.getText());
//			if(wbr.getText().equalsIgnoreCase("Healthcare")) {
//			wbr.click();
//			break;
//		}
//		}
		String industryname=sheet.getRow(1).getCell(3).getStringCellValue();
		WebElement industry=driver.findElement(By.cssSelector("select[name='industry']"));
		Select s=new Select(industry);
		s.selectByValue(industryname);
		
		//click on save button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(5000);
		//click on sign out
		WebElement log=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(log).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
	driver.close();
		
	  }
	}




