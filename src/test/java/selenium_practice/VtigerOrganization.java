package selenium_practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VtigerOrganization {
	public static void main(String[] args) {
		Random random = new Random();
		int ranNum=random.nextInt(1000);
		String orgName="testyantra"+ranNum;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String actheadermsg=driver.findElement(By.className("dvHeaderText")).getText();
		if(actheadermsg.contains(orgName)) {
			System.out.println(orgName+"is verified");
		}else {
			System.out.println(orgName+"is not verified");
		}
		WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

}
