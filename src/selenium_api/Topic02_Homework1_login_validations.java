package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic02_Homework1_login_validations {
	WebDriver driver;
	String pageTitle, currentURL;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.manage().window().setPosition(new Point(100, 50));
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() {
		pageTitle = driver.getTitle();
		Assert.assertEquals("Home page", pageTitle);

		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		pageTitle = driver.getTitle();
		Assert.assertEquals("Customer Login", pageTitle);

		driver.findElement(By.xpath("//button[@id='send2']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Empty validations
		Assert.assertEquals("This is a required field.",
				driver.findElement(
						By.xpath("//input[@id='email']/following-sibling::div[@id='advice-required-entry-email']"))
						.getText());
		Assert.assertEquals("This is a required field.",
				driver.findElement(
						By.xpath("//input[@id='pass']/following-sibling::div[@id='advice-required-entry-pass']"))
						.getText());
	}

	@Test
	public void TC_02() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("AnInvalidEmailAddress@fake");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.",
				driver.findElement(
						By.xpath("//input[@id='email']/following-sibling::div[@id='advice-validate-email-email']"))
						.getText());
		Assert.assertEquals("This is a required field.",
				driver.findElement(
						By.xpath("//input[@id='pass']/following-sibling::div[@id='advice-required-entry-pass']"))
						.getText());
	}

	@Test
	public void TC_03() {
		// Create account
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//form[@id='login-form']//a[@title='Create an Account']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		pageTitle = driver.getTitle();
		Assert.assertEquals("Create New Customer Account", pageTitle);
		// OR Assert True
		Assert.assertTrue(driver.getTitle().equals("Create New Customer Account"));

		// BACK
		driver.navigate().back(); // IF FORWARD, simply driver.navigate().forward();
		Assert.assertTrue(driver.getCurrentUrl().equals("http://live.guru99.com/index.php/customer/account/login/"));

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}
