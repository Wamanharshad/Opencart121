package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilitis.DataProviders;

public class TC003_loginDDT extends BaseClass {
	
	

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriver")
	public void verify_loginDDT(String email, String password, String expectedResult) throws InterruptedException {

		logger.info("******** TC003_LoginDDT excution strated ******");

		try {

			// HomePage
			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			hp.login();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.enterEmailid(email);
			lp.enterPassword(password);
			lp.clickLogin();

			// MyAccount
			MyAccountPage ma = new MyAccountPage(driver);
			boolean targetpage = ma.isMyAccountPageExits();

			if (expectedResult.equalsIgnoreCase("valid")) {
				if (targetpage == true) {
					Assert.assertTrue(true);
					ma.clickLogout();
				} else {
					Assert.assertTrue(false);
				}
			}
			if (expectedResult.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {
					ma.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {

			Assert.fail();
		}
		
		Thread.sleep(200);
		logger.info("******** Finished TC_003_LoginDDT  ******");

	}
}