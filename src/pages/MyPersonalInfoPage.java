package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInfoPage {
	
	WebDriver driver;
	WebElement firstBtn;
	WebElement secondBtn;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement emailField;
	WebElement saveBtn;
	WebElement currentPasswordField;
	WebElement personalInfoUpdateSuccessfullLabel;
	WebElement backToAccountBtn;
	WebElement getAccountLabel;
	
	public MyPersonalInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	

	public WebElement getFirstBtn() {
		return driver.findElement(By.id(""));
	}


	public WebElement getSecondBtn() {
		return secondBtn;
	}


	public WebElement getFirstNameField() {
		return driver.findElement(By.id("firstname"));
	}


	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastname"));
	}


	public WebElement getEmailField() {
		return emailField;
	}


	public WebElement getSaveBtn() {
		return driver.findElement(By.name("submitIdentity"));
	}


	public WebElement getCurrentPasswordField() {
		return driver.findElement(By.id("old_passwd"));
	}


	public WebElement getPersonalInfoUpdateSuccessfullLabel() {
		return driver.findElement(By.xpath("//p[@class='alert alert-success']"));
	}


	public WebElement getBackToAccountBtn() {
		return driver.findElement(By.xpath("//ul[contains(@class,'footer_links')]/li[1]/a"));
	}


	public WebElement getGetAccountLabel() {
		return driver.findElement(By.xpath("//a[@class='account']"));
	}
	
	public void clickFirstNameField( ) {
		getFirstNameField().click();
		getFirstNameField().clear();
	}
	
	public void clickLastNameField( ) {
		getLastNameField().click();
		getLastNameField().clear();
	}
	
	public void clickSaveBtn() {
		getSaveBtn().click();
	}
	
	public void clickCurrentPasswordField() {
		getCurrentPasswordField().click();
		getCurrentPasswordField().clear();
	}
	
	public void clickBackToAccountBtn() {
		getBackToAccountBtn().click();
	}


	
	

}
