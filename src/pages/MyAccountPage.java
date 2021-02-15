package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	
	WebDriver driver;
	WebElement myAccountPageLabel;
	WebElement myAddressBtn;
	WebElement myPersonalInfoBtn;
	WebElement myWishListBtn;
	

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getMyAccountPageLabel() {
		return driver.findElement(By.className("page-heading"));
	}

	public WebElement getMyAddressBtn() {
		return driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[3]/a/span"));
	}

	public WebElement getMyPersonalInfoBtn() {
		return driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a/span"));
	}
	public WebElement getMyWishListBtn() {
		return driver.findElement(By.xpath("//*[@id='center_column']/div/div[2]/ul/li"));
	}
	public void clickOnMyAddressBtn() {
		getMyAddressBtn().click();
	}
	public void clickOnMyPersonalInfoBtn() {
		getMyPersonalInfoBtn().click();
	}
	public void clickOnMyWishListBtn() {
		getMyWishListBtn().click();
	}
}
