package org.cucumber_framework.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Customers.feature", // feature file address
		glue = "org.cucumber_framework.StepDefinition", // stepdefinition package
		dryRun = false, //run each and every test steps
		monochrome = true, //remove unnecessary characters in the console window
		plugin = {"pretty","html:target/test-output.html"}, // generate HTML Report
		tags = "@CreateUser"
		)

public class loginTestRunner {
	
}
