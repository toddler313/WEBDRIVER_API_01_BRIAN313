package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		driver.get("https://truong.membrain.com/Login.aspx");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Login() {
//		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		String pageTitle = driver.getTitle();
		Assert.assertEquals("Membrain", pageTitle);

//		driver.findElement(By.xpath("//input[@id='eMailInput']")).click();
		driver.findElement(By.xpath("//input[@id='eMailInput']")).sendKeys("truong.nguyen@membrain.com");
		driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys("naT@31390");

//		driver.findElement(By.xpath("/html/body/div/form/div[1]/div[2]/div[1]/div[2]/table/tbody/tr/td[1]/div")).click();
//		driver.findElement(By.xpath("//div[@class='LoginButtonContainer']//div[@class='Button GreenButton']")).click();
//		driver.findElement(By.xpath("//div[@class='LoginButtonContainer']//div[contains(text(), 'Login')]")).click();
		driver.findElement(By.xpath("//div[@class='LoginButtonContainer']//div[text()='Login']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		pageTitle = driver.getTitle();
		Assert.assertEquals("Membrain for Membrain for Truong", pageTitle);

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}
