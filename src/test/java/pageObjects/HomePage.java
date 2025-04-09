package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	public HomePage (WebDriver driver){
		
		super(driver);
	}
	
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath ="(//a[text()='Register'])[1]")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;
		
	public void ClickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void ClickRegister() {
		lnkRegister.click();
	}
	public void login() {
		login.click();
	}
	
}
