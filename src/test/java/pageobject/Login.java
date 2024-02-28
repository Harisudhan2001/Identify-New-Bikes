package pageobject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BaseClass{

	public Login(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath = "//a[@class=\"zw i-b mt-10 pt-2 zw-srch-logo\"]")
	WebElement logo;
	
	@FindBy(id = "forum_login_title_lg")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")
	WebElement google;
	
	@FindBy(id="identifierId")
	WebElement email;
	
	@FindBy(xpath="//span[text()=\"Next\"]")
	WebElement nextBtn;
	
	@FindBy(xpath="//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
	WebElement error;

	public String errorMsg;
	
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public void clickLogo() {
		logo.click();
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	public void clickGoogle() throws InterruptedException
	{
		Thread.sleep(2000);
		google.click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		List<String> windowss = new ArrayList<String>(windows);
		for(String window : windowss)
		{
			System.out.println(window);
		}
		driver.switchTo().window(windowss.get(1));
	}
	
	public void email() throws InterruptedException, IOException
	{
		email.sendKeys("abdsfd@gmail.com");
		nextBtn.click();
		errorMsg = error.getText();
		System.out.println(errorMsg);
		Thread.sleep(3000);
	}
	
	public void screenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\2303724\\eclipse-workspace\\hackathon\\screenshot\\error.png");
		FileUtils.copyFile(src,trg);
	}
	
	public String errorMsg()
	{
		return errorMsg;
	}

	
	
	

}
