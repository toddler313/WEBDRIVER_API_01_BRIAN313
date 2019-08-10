package selenium_api;

import java.util.Set;
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

public class Topic03_webBrowser_webElement {
	WebDriver driver;
	String pageTitle, currentURL;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//set size for the browser
//		driver.manage().window().maximize();
//		driver.manage().window().setSize(new Dimension(1024, 768));
//		driver.manage().window().setPosition(new Point(100, 50));
//		Dimension initial_size = driver.manage().window().getSize();
//		int height = initial_size.getHeight();
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
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Timeout for scripts
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		
		//navigate()
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("URL string"); // => tracking navigation history. driver.get("URL string") cannot achieve same thing.
		
		//Alert, iFrame, Windows
		driver.switchTo().alert();
		
		driver.switchTo().frame("");
		driver.switchTo().defaultContent();
		
		driver.switchTo().window("");
	}

	@Test
	public void TC_02_WebElement() {
		
	}


	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}
