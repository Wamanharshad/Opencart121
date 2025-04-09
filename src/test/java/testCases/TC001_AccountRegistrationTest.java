package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression", "Master"})
	public void verify_Account_Registration() {
		logger.info("******** Starting TC001_AccountRegistrationTest  ****");
		try {

			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			logger.info("Clicked on MyAcccount link");
			hp.ClickRegister();
			logger.info("Clicked on Register link");
			AccountRegisterPage regpage = new AccountRegisterPage(driver);
			logger.info("Providing Customer details.........");

			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com");
			regpage.setTelephone(randomNumber());
			String password = randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setPasswordConfirm(password);
			// regpage.selectRadioButton();
			regpage.selectPrivacy();
			regpage.clickContinue();
			String confirme = regpage.checktext();

			if (confirme.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed......");
				logger.debug("Debug logs......");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			Assert.fail();
		}	
		logger.info("********** Finished Testcase ********");
	}
}