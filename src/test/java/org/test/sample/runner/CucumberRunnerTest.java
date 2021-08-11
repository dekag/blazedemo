package org.test.sample.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true, 
		features = "src/test/resources/features", 
		tags = "@Functional and not @NotAutomated", 
		dryRun = false,
		snippets = CucumberOptions.SnippetType.CAMELCASE,
		glue = { "org.test.sample.stepDefs" }, 
		plugin = { "pretty", "json:target/cucumber-report.json","junit:target/cucumber-report.xml"})

public class CucumberRunnerTest {

}
