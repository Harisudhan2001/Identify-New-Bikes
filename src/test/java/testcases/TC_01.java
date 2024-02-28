package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.UpcomingBikes;

public class TC_01 extends BaseClass {
	HomePage home;
	UpcomingBikes bikes;
	boolean result;


	@Test(priority = 1)
	public void navigate_to_zig_wheels_website() {
		System.out.println(driver.getTitle());
		result = driver.getTitle().contains("ZigWheels.com");
		Assert.assertTrue(result);
	}

	@Test(priority = 2)
	public void user_hover_to_new_bikes_option() {
		home = new HomePage(driver);
		home.hover();

	}

	@Test(priority = 3)
	public void user_click_upcoming_bikes_from_the_dropdown() {
		home.selectUpcomingBikes();

	}

	@Test(priority = 4)
	public void user_navigate_to_upcoming_bikes_page() {

		result = driver.getTitle().contains("Upcoming Bikes in India");
		Assert.assertTrue(result);

	}

	@Test(priority = 5)
	public void user_select_honda_from_manufacturers_dropdown() {
		bikes = new UpcomingBikes(driver);
		bikes.selectHonda();

	}

	@Test(priority = 6)
	public void user_click_read_more_option() {
		bikes.clickReadmore();

	}

	@Test(priority = 7)
	public void user_displays_upcoming_honda_bikes_which_is_less_than_4lac() throws IOException {
		bikes.bikeBelow4lac();

	}
	@Test(priority = 8)
	public void user_hover_used_cars() {

		bikes.hover();
	}

	@Test(priority = 9)
	public void user_click_chennai_option_from_the_dropdown() {
		bikes.selectChennai();

	}
	
	@Test(priority = 10)
	public void user_navigate_to_used_cars_in_chennai_page() {
		result = driver.getTitle().contains("Used Cars in Chennai");
		Assert.assertTrue(result);
	}

}
