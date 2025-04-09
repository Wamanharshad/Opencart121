package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCartiPhone extends BasePage {

	WebDriver driver;

	public AddCartiPhone(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@href='https://tutorialsninja.com/demo/index.php?route=common/home']")
	WebElement home;

	@FindBy(xpath = "//input[@class='form-control input-lg']")
	WebElement Search;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement Searchclick;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	WebElement Iphone;
	
	@FindBy(xpath="//div[contains(@class, 'alert') and contains(@class, 'alert-success')]")
	WebElement text;
	
	
	

	public void ClickHome() {
		home.click();
	}

	public WebElement searchiPhone(String name) {
		Search.sendKeys(name);
		Searchclick.click();
		return Search;
	}
	
	public void ClickIphone() {
		Iphone.click();
	}
	
	public String checktext() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement successMessage = wait.until(ExpectedConditions.visibilityOf(text));
	        return successMessage.getText();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


}
