package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
	
	WebDriver driver;
	WebElement emailField;
	WebElement passwordField;
	WebElement signInBtn;
	WebElement invalidEmailAddressLabel;
	WebElement myAccountPageLabel;
	WebElement validEmailAddressLabel;
	WebElement signOutBtn;
	
	public WebElement getSignOutBtn() {
		return driver.findElement(By.className("logout"));
	}

	public WebElement getValidEmailAddressLabel() {
		return driver.findElement(By.className("info-account"));
	}

	public WebElement getMyAccountPageLabel() {
		return myAccountPageLabel;
	}
	
	public AuthenticationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getEmailField() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordField() {
		return driver.findElement(By.id("passwd"));
	}
	public WebElement getSignInBtn() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	public WebElement getInvalidEmailAddressLabel() {
		return driver.findElement(By.cssSelector("div.alert.alert-danger"));
	}
	public void inputLoginEmail(String email) {
		getEmailField().clear();
		getEmailField().sendKeys(email);
	}
	public void passwordInput(String password) {
		getPasswordField().clear();
		getPasswordField().sendKeys(password);
	}
	public void invalidEmailAddressLabel() {
		getInvalidEmailAddressLabel().clear();
		getInvalidEmailAddressLabel().sendKeys();
	}
	public void clickSignInBtn() {
		getSignInBtn().click();
	}
	public void myAccountPageLabel() {
		getValidEmailAddressLabel().clear();
		getValidEmailAddressLabel().sendKeys();
	}
	public void clickSignOutBtn() {
		getSignOutBtn().click();
	}
	public void validEmailAddressLabel() {
		getValidEmailAddressLabel().clear();
		getValidEmailAddressLabel().sendKeys();
	}
}
