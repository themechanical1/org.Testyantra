package selenium_practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookHotelOngoibogoTest {
	@Test
	public void bookHotel() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		Actions action= new Actions(driver);
		action.moveByOffset(20, 20).click().perform();
		
		driver.findElement(By.xpath("//a[text()='Hotels']")).click();
		driver.findElement(By.xpath("//h4[text()='India']")).click();
		driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//ul[@id='downshift-1-menu']")).click();
		driver.findElement(By.xpath("//div[text()='Check-in']")).click();
		driver.findElement(By.xpath("//li[@class='date_is_selectable_true']/span[text()='30']")).click();
		driver.findElement(By.xpath("//li[@class='date_is_selectable_true']/span[text()='1']")).click();
		driver.findElement(By.xpath("//span[text()='Guests & Rooms']")).click();
		for(int i=0; i<=2; i++) {
		driver.findElement(By.xpath("//span[text()='Children']/parent::div/descendant::span[text()='+']")).click();
		}
		driver.findElement(By.xpath("//h4[text()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='11']")).click();
		driver.findElement(By.xpath("//p[text()='2']/preceding::h4[text()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='7']")).click();
		driver.findElement(By.xpath("//p[text()='3']/preceding::h4[text()='Select']")).click();
		driver.findElement(By.xpath("//li[text()='9']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("//button[@data-testid='searchHotelBtn']")).click();
		List<WebElement> hotelName = driver.findElements(By.xpath("//h4[@itemprop='name']"));
		for(WebElement wb : hotelName){
			System.out.println(wb.getText());
		}
		
		}

}
