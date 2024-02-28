package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import basepackage.Base;
import pageobject.UsedCars;

public class TC_02 extends BaseClass {

	UsedCars cars;
	boolean result;

	@Test(priority = 11)
	public void user_displays_popular_models_in_the_list() throws IOException {
		cars = new UsedCars(Base.getDriver());
		cars.popularModels();

	}
}
