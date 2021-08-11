package org.test.sample.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.test.sample.setup.TestDriver;

public class Confirmation {
	private WebDriver driver;

	public Confirmation() {
		driver = TestDriver.getInstance().driver;
	}

	public void verifyConfirmationPage() {
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Thank you for your purchase today!");			
	}

	public void verifyBookingStatus(String status) {
		Assert.assertEquals(driver.findElement(By.xpath("//td[contains(text(),'Status')]/following-sibling::td")).getText(), status);		
	}
}
