package testcases;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import basepackage.Base;

public class BaseClass {
	WebDriver driver;
	@BeforeTest
	@Parameters({"os","browser"})
	public void navigate(String os, String browser) throws IOException {

		Properties p = Base.getProperties();
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching os.....");
				return;
			}
			switch(browser.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome");
						break;
			case "edge":cap.setBrowserName("MicrosoftEdge");
						break;
			default:System.out.println("No matching browser....");
						return;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		else if(p.getProperty("execution_env").equals("local")) {

			driver = Base.initilizeBrowser();
		}
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
