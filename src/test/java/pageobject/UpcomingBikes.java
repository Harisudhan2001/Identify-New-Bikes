package pageobject;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Utils;

public class UpcomingBikes extends BaseClass{


	public UpcomingBikes(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"makeId\" and @class=\"custom-select\"]")
	WebElement dropDown;

	@FindBy(xpath = "//span[text()=\"...Read More\"]")
	WebElement readMore;

	@FindBy(xpath = "/html/body/main/div/div/div[1]/div[1]/div[1]/div/div[2]/div/table/thead")
	WebElement scrollDown;

	@FindBy(xpath = "//tbody/tr/td[1]")
	List<WebElement> Model;

	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> Price;

	@FindBy(xpath = "//tbody/tr/td[3]")
	List<WebElement> launchDate;

	@FindBy(xpath = "//a[normalize-space()='Used Cars']")
	WebElement usedCars;

	@FindBy(xpath = "//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/ul/li/div[2]/ul/li")
	List<WebElement> usedCarsDropdown;

	public void selectHonda() {
		dropDown.click();
		Select select = new Select(dropDown);
		select.selectByVisibleText("Honda");
	}

	public void clickReadmore() {
		readMore.click();
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollDown);

	}

	public void bikeBelow4lac() throws IOException {
		Utils.createSheets();
		int j=1;
		for (int i = 0; i < Price.size(); i++) {
			WebElement price = Price.get(i);
			WebElement model = Model.get(i);
			WebElement date = launchDate.get(i);
				
			String amount = price.getText();
			double amt = Double.parseDouble(amount.substring(3, 6));

			if (amt < 4 || amt > 40) {
				String modelName = model.getText();
				String bikePrice = price.getText();
				String launchDate = date.getText();
				System.out.print("Model Name : " + modelName + "         ");
				System.out.print("Price : " + bikePrice + "         ");
				System.out.print("Launch Date : " + launchDate);
				System.out.println();
				Utils.writeData("Honda Bikes < 4L", j, 0, modelName);
				Utils.writeData("Honda Bikes < 4L", j, 1, bikePrice);
				Utils.writeData("Honda Bikes < 4L", j, 2, launchDate);
				j+=1;
			}

		}

	}

	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");

	}

	public void hover() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(usedCars).perform();
	}

	public void selectChennai() {
		for (WebElement element : usedCarsDropdown) {
			if (element.getText().equals("Chennai")) {
				element.click();
				break;
			}
		}
	}

}
