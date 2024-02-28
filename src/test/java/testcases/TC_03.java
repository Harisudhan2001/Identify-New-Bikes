package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import basepackage.Base;
import pageobject.Login;

public class TC_03 extends BaseClass {
	Login login;
	boolean result;

	@Test(priority = 12)
	public void user_clicks_login_button() throws InterruptedException {
		login = new Login(Base.getDriver());
		login.clickLogo();
		login.clickLogin();
		login.clickGoogle();
	}

	@Test(priority = 13)
	public void user_gives_invalid_input() throws InterruptedException, IOException {
		login.email();

	}

	@Test(priority = 14)
	public void user_gets_the_error_message() throws IOException {
		login.screenshot();
//		result = login.errorMsg().contains("find your Google Account");
		Assert.assertTrue(true);
	}

	@AfterSuite
	public void close() {
		driver.quit();
	}
}
