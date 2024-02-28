package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass{

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/a")
	public WebElement NewBikes;
	
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/ul/li")
	List<WebElement> newBikesDropdown;
	
	public void hover()
	{
		Actions act = new Actions(driver);
		act.moveToElement(NewBikes).perform();	
	}
	
	public void selectUpcomingBikes()
	{
		for(WebElement option : newBikesDropdown)
		{
			if(option.getText().equals("Upcoming Bikes"))
			{
				option.click();
				break;
			}
		}
	}
	
}
