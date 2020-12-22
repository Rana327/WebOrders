package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		tags = "@Complete",
		glue="stepDefinitions",
		// plugin = { "pretty", "html:target/cucumber-reports" },
				 plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		// monochrome = true
		)
public class RunnerFile {

}
