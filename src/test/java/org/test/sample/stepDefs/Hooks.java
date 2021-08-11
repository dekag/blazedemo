package org.test.sample.stepDefs;

import org.test.sample.setup.TestDriver;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;

public class Hooks implements En {

	public Hooks() {
		Before((Scenario scenario) -> {
			TestDriver.getInstance();
		});
		After((Scenario scenario) -> {
			TestDriver.getInstance().tearDown();
		});		
	}
	
}
