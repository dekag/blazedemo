package org.test.sample.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.test.sample.setup.TestDriver;

public class Reserve {

	private WebDriver driver;
	
	@FindBy(id="rememberMe")
	private WebElement rememberMe; 
	
	@FindBy(id="inputName")
	private WebElement inputName;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="state")
	private WebElement state;
	
	@FindBy(id="zipCode")
	private WebElement zipCode;
	
	@FindBy(id="creditCardNumber")
	private WebElement creditCardNumber;
	
	@FindBy(id="creditCardMonth")
	private WebElement creditCardMonth;
	
	@FindBy(id="creditCardYear")
	private WebElement creditCardYear;
	
	@FindBy(id="nameOnCard")
	private WebElement nameOnCard;
	
	@FindBy(xpath = "//input[@value='Purchase Flight']")
	private WebElement purchaseFlight;
	
	@FindBy(id="cardType")
	private WebElement cardType;
	
	public Reserve() {
		driver = TestDriver.getInstance().driver;
		PageFactory.initElements(driver,this);
	}

	public void verifyFlightDetails(String expectedFlightNumber) {
		String flightNumber = driver.findElement(By.xpath("//p[contains(text(),'Flight Number:')]")).getText().split(":")[1].trim();
		//Assert.assertEquals(expectedFlightNumber, flightNumber);
	}

	public void enterUserInfo(Map<String, String> data) {
		inputName.sendKeys(data.get("Name"));
		address.sendKeys(data.get("Address"));
		city.sendKeys(data.get("City"));
		state.sendKeys(data.get("State"));
		zipCode.sendKeys(data.get("Zip"));		
	}

	public void enterCardInfo(Map<String, String> data) {
		Select selectCity = new Select(cardType);
		selectCity.selectByVisibleText(data.get("Card Type"));			
		creditCardNumber.sendKeys(data.get("CreditCardNumber"));
		creditCardMonth.sendKeys(data.get("Month"));
		creditCardYear.sendKeys(data.get("Year"));
		nameOnCard.sendKeys(data.get("Name On Card"));		
	}

	public void clickPurchaseFlight() {
		purchaseFlight.submit();		
	}

	public void selectRemeberMe() {
		rememberMe.click();		
	}

	public void navigateBack() {
		driver.navigate().back();		
	}

}
