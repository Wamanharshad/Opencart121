package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-email")
	WebElement emailId;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement login_button;

	public void enterEmailid(String Email) {
		emailId.sendKeys(Email);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickLogin() {
		login_button.click();
	}

}
