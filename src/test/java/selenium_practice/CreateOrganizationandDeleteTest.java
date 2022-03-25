package selenium_practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganizationandDeleteTest {
	@Test
	
	public void createorganization() throws InterruptedException {
		Random random = new Random();
		int ranNum=random.nextInt(1000);
		String orgName="Aman"+ranNum;
		
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
		Thread.sleep(5000);
		driver.findElement(By.linkText("Organizations")).click();
	
	
		for(;;) {
			try {
				driver.findElement(By.xpath("//tr[@bgcolor='white']/descendant::td/a[text()='"+orgName+"']")).click();
				break;
			}catch(Exception e) {
				driver.findElement(By.xpath("//a[@title='Next']/descendant::img[@align='absmiddle']")).click();				
				
			}
		}
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
	}

}

















