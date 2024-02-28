package pageobject;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import basepackage.Base;

public class Setup {

	static WebDriver driver;
	static Properties p;

	public static void main(String args[]) throws IOException, InterruptedException {

		driver = Base.initilizeBrowser();

		HomePage home = new HomePage(driver);
		UpcomingBikes bike = new UpcomingBikes(driver);
		UsedCars usedCars = new UsedCars(driver);
		Login login = new Login(driver);

		p = Base.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();

		home.hover();
		home.selectUpcomingBikes();

		bike.selectHonda();
		bike.clickReadmore();
//		bike.scrollDown();
		bike.bikeBelow4lac();

//		bike.scrollUp();
		bike.hover();
		bike.selectChennai();

		usedCars.scrollDown();
		usedCars.popularModels();

		login.scrollUp();
		login.clickLogo();
		login.clickLogin();
		login.clickGoogle();
		login.email();
		login.screenshot();
	}
}
