package org.test.sample.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.test.sample.setup.TestDriver;


public class Home {
	
	private WebDriver driver;
	
	public Home() {
		driver = TestDriver.getInstance().driver;
	}
	
	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public void verifyHomePage() {
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Welcome to the Simple Travel Agency!");		
	}

	public void enterDeparatureCity(String depCity) {
		Select selectCity = new Select(driver.findElement(By.name("fromPort")));
		selectCity.selectByVisibleText(depCity);		
	}

	public void enterDestinationCity(String desCity) {
		Select selectCity = new Select(driver.findElement(By.name("toPort")));
		selectCity.selectByVisibleText(desCity);
		
	}

	public void clickFindFlights() {
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();		
	}

}
