package selenium_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithDataProviderTest {
	//to execute same script with multiple data
	//use @DataProvider annotation==>it will provide data to @Test annotatedmethod
	@Test(dataProvider="getdata")
	public void multipleData(String name,String company,String emailID,String Contact) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(Contact);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//click on sign out
				WebElement log=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act=new Actions(driver);
				act.moveToElement(log).perform();
				
				driver.findElement(By.linkText("Sign Out")).click();
			driver.close();
		
	}
	@DataProvider
	public Object[][] getdata(){
		Object[][] objArray = new Object[5][4];
		objArray[0][0]="Aman";
		objArray[0][1]="Tyss Bangeluru";
		objArray[0][2]="aman@gmail.com";
		objArray[0][3]="8766262630";
		
		objArray[1][0]="AmanAnand";
		objArray[1][1]="Tyss Bangeluru";
		objArray[1][2]="amananand@gmail.com";
		objArray[1][3]="8766262630";
		
		objArray[2][0]="Milan";
		objArray[2][1]="Tyss Bangeluru";
		objArray[2][2]="milan@gmail.com";
		objArray[2][3]="8766262630";
		
		objArray[3][0]="Bibhu";
		objArray[3][1]="Tyss Bangeluru";
		objArray[3][2]="Bibhu@gmail.com";
		objArray[3][3]="8766262630";
		
		objArray[4][0]="Sagar";
		objArray[4][1]="Tyss Bangeluru";
		objArray[4][2]="sagar@gmail.com";
		objArray[4][3]="8766262630";
		
		return objArray;
		
	}

}
