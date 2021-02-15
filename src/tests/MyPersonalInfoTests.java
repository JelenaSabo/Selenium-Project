package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInfoTests extends TestBase {
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(3000);
		
	}
	@Test
	public void editPersonalInfo() {
		String firstNameChange = excelReader.getCellData("My personal info", 3, 5);
		String currentPassword = excelReader.getCellData("My personal info", 4, 5);
		String revertFirstName = excelReader.getCellData("My personal info", 8, 5);
		validLogIn();
		
		changeFirstName(firstNameChange, currentPassword);
		Assert.assertEquals(true, myPInfo.getPersonalInfoUpdateSuccessfullLabel().isDisplayed());
		Assert.assertEquals(myPInfo.getGetAccountLabel().getText(), "Jelenaaa Jelena");
		myPInfo.clickBackToAccountBtn();
		revertFirstName(revertFirstName, currentPassword);
	}
	
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	public void changeFirstName(String firstName, String currentPassword) {
		myAccount.clickOnMyPersonalInfoBtn();
		myPInfo.clickFirstNameField();
		myPInfo.getFirstNameField().clear();
		myPInfo.getFirstNameField().sendKeys(firstName);
		myPInfo.clickCurrentPasswordField();
		myPInfo.getCurrentPasswordField().sendKeys(currentPassword);
		myPInfo.clickSaveBtn();
		
	}
	public void revertFirstName(String revertFirstName, String currentPassword) {
		myAccount.clickOnMyPersonalInfoBtn();
		myPInfo.clickFirstNameField();
		myPInfo.getFirstNameField().sendKeys(revertFirstName);
		myPInfo.clickCurrentPasswordField();
		myPInfo.getCurrentPasswordField().sendKeys(currentPassword);
		myPInfo.clickSaveBtn();

}
}