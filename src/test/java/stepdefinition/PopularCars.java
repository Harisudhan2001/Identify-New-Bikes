package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basepackage.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.UpcomingBikes;
import pageobject.UsedCars;

public class PopularCars {
	WebDriver driver = Base.getDriver();
	UpcomingBikes bikes = new UpcomingBikes(driver);
	UsedCars cars = new UsedCars(driver);
	boolean result;
	
	@When("User Hover Used Cars")
	public void user_hover_used_cars() {
		 
		bikes.hover();
	}

	@When("User click Chennai option from the dropdown")
	public void user_click_chennai_option_from_the_dropdown() {
		 bikes.selectChennai();
		
	}

	@Then("User navigate to UsedCars in Chennai page")
	public void user_navigate_to_used_cars_in_chennai_page() {
		 result = driver.getTitle().contains("Used Cars in Chennai");
		 Assert.assertTrue(result);
	}

	@Then("User displays Popular models in the list")
	public void user_displays_popular_models_in_the_list() throws IOException {
		 cars.popularModels();
		
	}

}
