package basepackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {

	static WebDriver driver;
	static Properties p;
	

	public static WebDriver initilizeBrowser() throws IOException {
		
		switch (getProperties().getProperty("browser").toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser");
			driver = null;
		}

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(
				"C:\\Users\\2303724\\eclipse-workspace\\hackathon\\src\\test\\resources\\config.properties");

		p = new Properties();
		p.load(file);
		return p;
	}

	public String captureScreen(String name) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) Base.getDriver();
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshot\\" + name + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}
