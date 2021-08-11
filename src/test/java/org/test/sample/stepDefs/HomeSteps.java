package org.test.sample.stepDefs;

import org.test.sample.pages.Home;

import io.cucumber.java8.En;

public class HomeSteps implements En {

	public HomeSteps() {
		Home home = new Home();
		Given("user navigates to Simple Travel Agency", () -> {
			home.navigateToUrl("https://blazedemo.com/index.php");
		});
		Then("verify the home page is loaded", () -> {
			home.verifyHomePage();
		});
		When("user enters the deparature city as {string}", (String depCity) -> {
			home.enterDeparatureCity(depCity);
		});
		When("user enters the destination city ad {string}", (String desCity) -> {
			home.enterDestinationCity(desCity);
		});
		When("clicks on Find FLights", () -> {
			home.clickFindFlights();
		});

	}

}
