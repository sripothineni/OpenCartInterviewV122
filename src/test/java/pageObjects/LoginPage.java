package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	//Locators
	@FindBy(how=How.XPATH, using="//input[@id='input-email']")
	WebElement tbEmail;
	
	@FindBy(how=How.XPATH, using="//input[@id='input-password']")
	WebElement tbPassword;
	
	@FindBy(how=How.XPATH, using="//input[@value='Login']")
	WebElement btnLogin;
	

	public void setEmail(String email) {
		tbEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		tbPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}

}
