package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBase;
import utilities.DataProviders;

public class TC003_LoginDDT extends TestBase{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = { "Datadriven" }) 
	// getting data  provider from different class
	
	public void verify_login(String email, String pwd, String expectedResult) {
		logger.info("***************** Starting testcase TC003_LoginDDT ******************");
		//System.out.println(email + "::" + pwd + "::" + expectedResult);
		try {
			// Home Page
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickOnLoginLink();

			// Login Page
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(email);
			loginPage.setPassword(pwd);
			loginPage.clickLogin();

			// MyAccount Page
			MyAccountPage myaccount = new MyAccountPage(driver);
			boolean targetPage = myaccount.isMyAccountPageExists();

			if (expectedResult.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					Assert.assertTrue(true);
					homePage.clickMyAccount();
					myaccount.clickLogout();
				} else {
					Assert.assertTrue(false);
				}
			}

			if (expectedResult.equalsIgnoreCase("Invalid")) {
				if (targetPage == false) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***************** Starting testcase TC003_LoginDDT ******************");

	}

}
