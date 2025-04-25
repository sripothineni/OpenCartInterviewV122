package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC001_AccountRegistrationTest extends TestBase{
	
	HomePage homePage;
	AccountRegistrationPage accountRegistration;
	
	
	@Test(groups={"regression","master"})
	public void verify_Account_Registration() {
		try {
		
		logger.info("****************verify_Account_Registration*********************");
		homePage = new HomePage(driver);
		
		homePage.clickMyAccount();
		homePage.clickRegister();
		
		accountRegistration = new AccountRegistrationPage(driver);
		accountRegistration.setFirstName(ramdomString());
		accountRegistration.setLastName(ramdomString());
		accountRegistration.setEmail(ramdomString()+"@gmail.com");
		accountRegistration.setTelephone(ramdomNumber());
		
		String password = ramdomString();
		accountRegistration.setPassword(password);
		accountRegistration.setConfirmPassword(password);
		
		accountRegistration.selectPrivacyPolicy();
		accountRegistration.clickOnContinue();
		
		String actualMessage = accountRegistration.getConformationMessage();
		
		if(actualMessage.equals("Your Account Has Been Created!")) {
			logger.info("****************verify_Account_Registration :: Message is matching validation Passed*********************");
			Assert.assertTrue(true);
		}else{
			logger.info("****************verify_Account_Registration :: Message is not matching validation Failed*********************");
			Assert.fail();
		}
		
		//Assert.assertEquals(actualMessage, "Your Account Has Been Created!");
		
		}
		catch (Exception e) {
			logger.error("Test Failed...");
			logger.debug("Debug Logs....");
			Assert.fail();
		}
	}

}
