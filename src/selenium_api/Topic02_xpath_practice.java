package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic02_xpath_practice {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/index.php/mobile.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
	}

	@Test
	public void TC_00() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals("Mobile", pageTitle);
		
		driver.findElement(By.xpath("//a[@title='IPhone']/parent::h2[@class='product-name']/following-sibling::div[@class='actions']/button[@title='Add to Cart']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		pageTitle = driver.getTitle();
		Assert.assertEquals("Shopping Cart", pageTitle);
		
		
	}
	
	

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}
