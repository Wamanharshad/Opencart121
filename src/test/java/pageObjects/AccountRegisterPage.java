package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {

	public AccountRegisterPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "input-firstname")
	WebElement First_name;

	@FindBy(id = "input-lastname")
	WebElement Last_name;

	@FindBy(id = "input-email")
	WebElement Email;

	@FindBy(id = "input-telephone")
	WebElement Telephone;

	@FindBy(id = "input-password")
	WebElement Password;

	@FindBy(id = "input-confirm")
	WebElement Password_Confirm;

	@FindBy(xpath = "(//input [@value='1'])[1]")
	WebElement Radio_button;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement Privacy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Continue;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement text;

	public void setFirstName(String fName) {
		First_name.sendKeys(fName);
	}

	public void setLastName(String lName) {
		Last_name.sendKeys(lName);
	}

	public void setEmail(String email) {
		Email.sendKeys(email);
	}

	public void setTelephone(String number) {
		Telephone.sendKeys(number);
	}
	
	public void setPassword(String Pass) {
		Password.sendKeys(Pass);
	}

	public void setPasswordConfirm(String CPass) {
		Password_Confirm.sendKeys(CPass);
	}

	public void selectPrivacy() {
		Privacy.click();
	}

	public void clickContinue() {
		Continue.submit();
	}

	public String checktext() {
		try {
			return (text.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}