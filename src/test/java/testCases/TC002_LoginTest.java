package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBase;

public class TC002_LoginTest extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccPage;
	@Test(groups={"sanity","master"})
	public void verify_Login_Test() {
		logger.info("********Starting verify_Login_Test**********");
		try {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickOnLoginLink();
		
		loginPage= new LoginPage(driver);
		loginPage.setEmail(prop.getProperty("email"));
		loginPage.setPassword(prop.getProperty("password"));
		
		loginPage.clickLogin();
		
		myAccPage = new MyAccountPage(driver);
		
		Boolean targetPage = myAccPage.isMyAccountPageExists();
		
		Assert.assertEquals(true, targetPage);
		}
		catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("********Finished verify_Login_Test**********");
		
	}
}
