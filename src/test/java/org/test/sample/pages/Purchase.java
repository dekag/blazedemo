package org.test.sample.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.test.sample.setup.TestDriver;

public class Purchase {

	private WebDriver driver;	

	public Purchase() {
		driver = TestDriver.getInstance().driver;
	}

	public void verifyHeadersFlight(String depCity, String destCity) {
		Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),
				"Flights from " + depCity + " to " + destCity + ":");
	}

	public void verifyFlightDetails() {
		List<WebElement> values = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		Assert.assertTrue(values.size() > 0);		
	}

	public void chooseFlight(String flightNumber) {
		List<WebElement> allFlightNUmbers = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[2]"));
		List<WebElement> chooseFlight = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td[1]/input"));
		
		for (int i = 0; i < allFlightNUmbers.size(); i++) {
			if(allFlightNUmbers.get(i).getText().equals(flightNumber)) {
				chooseFlight.get(i).click();
				break;
			}				
		}		
	}

}
