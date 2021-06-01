package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featureFiles"},
		glue = {"stepDefinations"},
		plugin = {"pretty", "html:Report"},
		dryRun = false,
		strict = true,
		monochrome = true,
		tags = "@P1"
		//name = "category"
		)

public class TestRunner {

}
