package selenium_practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectNextdateAndBookFlightTest {
	@Test
	public void selectNextDate() {
		LocalDateTime dateAndTime = LocalDateTime.now().plusDays(2);
		System.out.println(dateAndTime);
		String month=dateAndTime.getMonth().toString();
		System.out.println(month);
		int date=dateAndTime.getDayOfMonth();
		System.out.println(date);
		int year=dateAndTime.getYear();
		System.out.println(year);
		String actualMonth=month.substring(0, 1)+month.substring(1).toLowerCase();
		System.out.println(actualMonth);
		String monthAndYear=actualMonth+" "+year;
		System.out.println(monthAndYear);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		Actions action= new Actions(driver);
		action.moveByOffset(20, 20).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//input[@data-cy='fromCity']")).click();
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("Patna");
		driver.findElement(By.xpath("//p[text()='Patna, India']")).click();
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("Bhubaneswar");
		driver.findElement(By.xpath("//div[text()='BBI']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		String calenderXpath="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		driver.findElement(By.xpath(calenderXpath)).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		List<WebElement> availableFlight =driver.findElements(By.xpath("//div[@class='makeFlex align-items-center  ']"));
		for(WebElement wb : availableFlight) {
			System.out.println(wb.getText());
		}

		}


}
