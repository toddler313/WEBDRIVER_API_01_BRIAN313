package selenium_api;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic03_webBrowser_webElement {
	WebDriver driver;
	String pageTitle, currentURL;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_WebBrowser() {
		//Get curent page source code
		String pageSource = driver.getPageSource();
		//Used for relative checking if it contains something something
		Assert.assertTrue(pageSource.contains("SELENIUM WEBDRIVER"));
		
		//Get windows ID of the current page.
		String currentHomepageId = driver.getWindowHandle();
		//Get windows ID of all pages.
		Set<String> allHomepageIds = driver.getWindowHandles();
		
		/* WebDriver Wait */
		//Wait for Element (findElement, findElements)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		//Wait for a page to complete loading
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.DAYS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.DAYS);
		
		
	}

	@Test
	public void TC_02_WebElement() {
		
	}


	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}
