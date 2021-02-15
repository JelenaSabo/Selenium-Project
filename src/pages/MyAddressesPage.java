package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAddressesPage {
	
	WebDriver driver;
	WebElement updateAddressBtn;
	WebElement addressField;
	WebElement cityField;
	WebElement stateField;
	WebElement zipCodeField;
	WebElement mobilePhoneNumberField;
	WebElement addressAliasField;
	WebElement saveBtn;
	WebElement currentAddressLabel;
	WebElement addNewAddressBtn;
	WebElement stateDropdownSelection;
	WebElement submitBtn;
	WebElement secondAddressLabel;
	WebElement deleteSecondAddressBtn;
	
	public MyAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	
	public WebElement getUpdateAddressBtn() {
		return driver.findElement(By.linkText("Update"));
	}


	public WebElement getAddressField() {
		return driver.findElement(By.id("address1"));
	}


	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}
	//public WebElement getStateField() {
	//	return driver.findElement(By.);
	


	public WebElement getZipCodeField() {
		return driver.findElement(By.id("postcode"));
	}


	public WebElement getMobilePhoneNumberField() {
		return driver.findElement(By.id("phone_mobile"));
	}


	public WebElement getAddressAliasField() {
		return driver.findElement(By.id("alias"));
	}


	public WebElement getSaveBtn() {
		return driver.findElement(By.id("submitAddress"));
	}


	public WebElement getCurrentAddressLabel() {
		return driver.findElement(By.className("address_address1"));
	}


	public WebElement getAddNewAddressBtn() {
		return driver.findElement(By.xpath("//a[@title='Add an address']"));
	}


	public WebElement getStateDropdownSelection() {
		return driver.findElement(By.id("id_state"));
	}


	public WebElement getSubmitBtn() {
		return driver.findElement(By.id("submitAddress"));
	}


	public WebElement getSecondAddressLabel() {
		return driver.findElement(By.xpath("//div[@class='addresses']/div/div[2]/ul/li/h3"));
	}


	public WebElement getDeleteSecondAddressBtn() {
		return driver.findElement(By.xpath("//div[@class='addresses']/div/div[2]/ul/li[9]/a[2]"));
	}
	public void clickUpdateAddressBtn() {
		getUpdateAddressBtn().click();
	}
	public void clickAddressField() {
		getAddressField().click();
		getAddressField().clear();
		
	}
	public void clickSaveBtn() {
		getSaveBtn().click();
	}
	public void clickAddNewAddressBtn() {
		getAddNewAddressBtn().click();
	}
	public void clickMobilePhoneNumberField() {
		getMobilePhoneNumberField().click();
		getMobilePhoneNumberField().clear();
	}
	public void clickSubmitAddressBtn() {
		getSubmitBtn().click();
	}
	public void clickDeleteSecondAddressBtn() {
		getDeleteSecondAddressBtn().click();
	}
	public void selectStateFromDropdownList(int index) {
		Select stateFromDropDownList = new Select(getStateDropdownSelection());
		stateFromDropDownList.selectByIndex(index);
		getStateDropdownSelection().click();
	}
	public void clickCityField() {
		getCityField().click();
	}
	public void clickZipCode() {
		getZipCodeField().click();
	}
	public void clickAddressAliasField() {
		getAddressAliasField().click();
	}
	


	

}
