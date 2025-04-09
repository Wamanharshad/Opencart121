package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{
	
	
	@Test (groups={"Sanity", "Master"})
	public void verfiy_login () {
		logger.info("********** Starting TC_002_LoginPage *******");
		try {
		//HomePage
		HomePage hp = new HomePage (driver);
		hp.ClickMyAccount();
		hp.login();
		
		//Login
		LoginPage lp= new LoginPage(driver);
		lp.enterEmailid(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage ma= new MyAccountPage(driver);
         boolean targetpage =ma.isMyAccountPageExits();
		Assert.assertEquals(targetpage, true, "login failed");
		}
		catch (Exception e) {
		logger.info("*********** Finished TC-002_login Test");
	}
	
	}
	
	

}
