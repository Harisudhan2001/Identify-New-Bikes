package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basepackage.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomePage;
import pageobject.UpcomingBikes;

public class Bikes {
	WebDriver driver = Base.getDriver();
	HomePage home = new HomePage(driver) ;
	UpcomingBikes bikes = new UpcomingBikes(driver);	
boolean result;
	
	@Given("Navigate to ZigWheels website")
	public void navigate_to_zig_wheels_website() {
		System.out.println(driver.getTitle());
		result = driver.getTitle().contains("ZigWheels.com");
		Assert.assertTrue(result);
	}

	@When("User Hover to New Bikes Option")
	public void user_hover_to_new_bikes_option() {
		 home.hover();
		
	}

	@When("User click Upcoming Bikes from the dropdown")
	public void user_click_upcoming_bikes_from_the_dropdown() {
		 home.selectUpcomingBikes();
		
	}

	@Then("User navigate to Upcoming Bikes Page")
	public void user_navigate_to_upcoming_bikes_page() {
		result = driver.getTitle().contains("Upcoming Bikes in India");
		Assert.assertTrue(result);
		
	}

	@When("User select Honda from Manufacturers dropdown")
	public void user_select_honda_from_manufacturers_dropdown() {
		 bikes.selectHonda();
		
	}

	@When("User click ReadMore option")
	public void user_click_read_more_option() {
		 bikes.clickReadmore();
		
	}

	@Then("User displays Upcoming Honda Bikes which is less than 4lac")
	public void user_displays_upcoming_honda_bikes_which_is_less_than_4lac() throws IOException {
		 bikes.bikeBelow4lac();
		
	}

}
