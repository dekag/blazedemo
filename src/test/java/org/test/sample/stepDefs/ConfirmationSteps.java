package org.test.sample.stepDefs;

import org.test.sample.pages.Confirmation;

import io.cucumber.java8.En;

public class ConfirmationSteps implements En{

	Confirmation confirmation = new Confirmation();
	
	public ConfirmationSteps() {
		Then("verify the confirmation page is displayed", () -> {
			confirmation.verifyConfirmationPage();
		});
		Then("verify the booking status is {string}", (String status) -> {
			confirmation.verifyBookingStatus(status);
		});
	}

}
