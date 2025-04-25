package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='input-firstname']")
	WebElement tbFirstName;
	
	@FindBy(how=How.XPATH, using="//input[@id='input-lastname']")
	WebElement tbLastName;
	
	@FindBy(how=How.XPATH, using="//input[@id='input-email']")
	WebElement tbEmail;
	
	@FindBy(how=How.XPATH, using="//input[@id='input-telephone']")
	WebElement tbTelephone;
	
	@FindBy(how=How.XPATH, using="//input[@id='input-password']")
	WebElement tbPassword;
	
	@FindBy(how=How.XPATH, using="//input[@id='input-confirm']")
	WebElement tbConfirmPassword;
	
	@FindBy(how=How.XPATH, using="//input[@name='agree']")
	WebElement cbProvacyPolicy;
	
	@FindBy(how=How.XPATH, using="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(how=How.XPATH, using="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement lblConfirmationMsg;


	public void setFirstName(String fName) {
		tbFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		tbLastName.sendKeys(lName);
	}

	public void setEmail(String email) {
		tbEmail.sendKeys(email);
	}
	
	public void setTelephone(String phone) {
		tbTelephone.sendKeys(phone);
	}

	public void setPassword(String pwd) {
		tbPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String cpwd) {
		tbConfirmPassword.sendKeys(cpwd);
	}
	
	public void selectPrivacyPolicy() {
		cbProvacyPolicy.click();
	}

	public void clickOnContinue() {
		btnContinue.click();
	}
	
	public String getConformationMessage() {
		try {
		return lblConfirmationMsg.getText();
		} catch(Exception e) {
			return e.getMessage();
		}
	}
	
}
