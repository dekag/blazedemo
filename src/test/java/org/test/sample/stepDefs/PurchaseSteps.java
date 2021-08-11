package org.test.sample.stepDefs;


import org.test.sample.pages.Purchase;

import io.cucumber.java8.En;


public class PurchaseSteps implements En{
	
	Purchase purchase = new Purchase();
	
	public PurchaseSteps() {
		Then("user is able to view the flights from {string} to {string}", (String depCity, String destCity) -> {
			purchase.verifyHeadersFlight(depCity, destCity);
		});
		Then("verify flight details is displayed correctly", () -> {
			purchase.verifyFlightDetails();
		});
		When("user clicks on Choose the Flight option for the flight number {string}", (String flightNumber) -> {
			purchase.chooseFlight(flightNumber);
		});

		
	}

}
