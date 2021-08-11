package org.test.sample.stepDefs;

import java.util.List;
import java.util.Map;

import org.test.sample.pages.Reserve;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

public class ReserveSteps implements En{
	
	Reserve reserve = new Reserve();

	public ReserveSteps() {
		Then("user is able to view the purchase page with the selected flight number {string}", (String flightNumber) -> {
			reserve.verifyFlightDetails(flightNumber);
		});
		When("user enters the below user information to purchase the flight",(DataTable dataTable) -> {
			List<Map<String,String>> data = dataTable.asMaps();
			reserve.enterUserInfo(data.get(0));
		});
		When("user enters the below card information to purchase the flight", (DataTable dataTable) -> {
			List<Map<String,String>> data = dataTable.asMaps();
			reserve.enterCardInfo(data.get(0));
		});
		When("user clicks on Purchase flight", () -> {
			reserve.clickPurchaseFlight();
		});
		When("User selects Remember Me checkbox", () -> {
		   reserve.selectRemeberMe();
		});
		When("user navigates back to reserve flight page", () -> {
		   reserve.navigateBack();
		});
	}
}
