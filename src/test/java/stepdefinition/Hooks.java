package stepdefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import basepackage.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriver driver;
	Properties p;
	
	@Before
	public void setup()throws IOException
	{
		driver=Base.initilizeBrowser();
		
		p=Base.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@After
	public void close(Scenario scenario)
	{
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		
	}
	
	
	
}
