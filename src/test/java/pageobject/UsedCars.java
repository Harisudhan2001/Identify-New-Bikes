package pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Utils;

public class UsedCars extends BaseClass{
	

	public UsedCars(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[text()='Popular Models']")
	WebElement scrollDown;
	
	
	@FindBy(xpath="/html/body/div[7]/div/div[1]/div[1]/div[1]/div[2]/ul/li[2]/div[2]/div[5]/ul/li/label")
	List<WebElement> popularModels;
	
	
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollDown);
	}
	
	public void popularModels() throws IOException
	{
		int j = 1;
		for(WebElement element : popularModels)
		{
			System.out.println(element.getText());
			Utils.writeData("Popular Model Cars", j, 0, element.getText());
			j+=1;
		}
	}
	
	
	
	
}
