package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; // Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Date;
import java.util.Properties;

public class BaseClass {
	public Logger logger; // Log4j
	public static WebDriver driver;
public Properties p;
	@BeforeClass(groups= {"Sanity","Regression","Master","Datadrivern"})
	@Parameters({ "os", "browser" })
	public void SetUp(String os, String br) throws IOException {
		
		FileReader file = new FileReader(".//src//test//resources//config.poperties");
		p= new Properties();
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser name ...");
			return;
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("Appurl"));
		driver.manage().window().maximize();

	}

	@AfterClass(groups= {"Sanity","Regression","Master","Datadrivern"})
	public void tearDown() {
		driver.quit();
	}
	
	public void ExplicitWait(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public String randomString() {

		String generatedstring = RandomStringUtils.randomAlphabetic(4);
		return generatedstring;
	}

	public String randomNumber() {
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public String randomAlphaNumeric() {
		String generatedstring = RandomStringUtils.randomAlphabetic(2);
		String generatednumber = RandomStringUtils.randomNumeric(3);
		return (generatedstring + "@" + generatednumber);
	}

	public String captureScreen(String tname) throws IOException {
	    // Create a timestamp to make the filename unique
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	    // Take the screenshot and store it as a file
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    // Define target path where screenshot will be saved
	    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);

	    // Move source file to target location
	    sourceFile.renameTo(targetFile);

	    // Return the path of the saved screenshot
	    return targetFilePath;
	}
	
}
