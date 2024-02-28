package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basepackage.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Login;

public class UserLogin {
	WebDriver driver = Base.getDriver();
	Login login = new Login(driver);
	boolean result;
	

	@When("User clicks login button")
	public void user_clicks_login_button() throws InterruptedException {
		 login.clickLogo();
		 login.clickLogin();
		 login.clickGoogle();
	}

	@When("User gives invalid input")
	public void user_gives_invalid_input() throws InterruptedException, IOException {
		 login.email();
		
	}

	@Then("User gets the error message")
	public void user_gets_the_error_message() throws IOException {
		login.screenshot();
		Assert.assertEquals("Couldn’t find your Google Account",login.errorMsg);
	}

}
