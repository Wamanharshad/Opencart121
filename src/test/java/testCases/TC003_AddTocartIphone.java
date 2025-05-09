package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddCartiPhone;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC003_AddTocartIphone extends BaseClass {
	@Test

	public void verify_AddcartIphone() throws InterruptedException {

		logger.info("******** Starting TC003_AddcartIphone_ Testcase Started  ****");
		HomePage hm = new HomePage(driver);
		hm.ClickMyAccount();
		hm.login();
		LoginPage lp = new LoginPage(driver);
		lp.enterEmailid(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();

		AddCartiPhone Ad = new AddCartiPhone(driver);
		Thread.sleep(2000);
		Ad.ClickHome();
		ExplicitWait(Ad.searchiPhone("iPhone"));
		Ad.ClickIphone();
		Thread.sleep(2000);
		String checktext = Ad.checktext();
		logger.info("Captured success message: " + checktext);

		if (checktext != null && checktext.contains("Success: You have added iPhone to your shopping cart!")) {
			Assert.assertTrue(true);
			logger.info("Test passed: iPhone added to cart successfully.");
		} else {
			logger.error("Test failed: Success message not found or incorrect.");
			Assert.fail("iPhone was not added to cart. Actual message: " + checktext);
		}
		
		Ad.clickonViewCart();
		
		
	}
}