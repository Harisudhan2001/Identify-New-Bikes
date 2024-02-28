package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { ".//Feature/Bike.feature" }, 
		 glue = "stepdefinition", 
		 plugin = { "pretty",
		"html:CucumberReport/myreport.html", "rerun:target/reurn.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
		 dryRun = false, 
		 monochrome = true, 
		 publish = true)

public class TestRunner{

}
	