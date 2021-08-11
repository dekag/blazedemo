package org.test.sample.setup;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {

	private static TestDriver testDriverInstance = null;

	public WebDriver driver;

	private TestDriver() {
		driver = setWebDriver();
	}

	public static TestDriver getInstance() {
		if (testDriverInstance == null)
			testDriverInstance = new TestDriver();
		return testDriverInstance;
	}

	private WebDriver setWebDriver() {
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			Assert.fail("Driver Initialization Error " + e);
		}
		return driver;
	}

	public void tearDown() {
		if (driver != null) {
			testDriverInstance = null;
			driver.quit();	
		}
				
	}

}
