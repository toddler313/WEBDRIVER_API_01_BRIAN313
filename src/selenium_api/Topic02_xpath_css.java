package selenium_api;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic02_xpath_css {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		String homePageTitle = driver.getTitle();
		Assert.assertEquals("Home page", homePageTitle);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
