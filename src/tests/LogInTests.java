package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase {
	
	@BeforeMethod
	public void logIn() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(3000);
	}
	@Test (priority = 0)
	public void validCredentialsLogIn() throws InterruptedException {
		String email = excelReader.getCellData("LogIn", 5, 5);
		String password = excelReader.getCellData("LogIn", 6, 5);
		logIn(email,password);
		Assert.assertEquals(true, authPage.getValidEmailAddressLabel().isDisplayed());

		Thread.sleep(3000);
	}
	@Test (priority = 5)
	public void invalidEmailLogin() throws InterruptedException {
		String email = excelReader.getCellData("LogIn", 16, 5);
		String password = excelReader.getCellData("LogIn", 17, 5);
		logIn(email,password);
		Assert.assertEquals(true, authPage.getInvalidEmailAddressLabel().isDisplayed());

		Thread.sleep(3000);
	}
	@Test (priority = 10)
	public void invalidPasswordLogin() throws InterruptedException {
		String email = excelReader.getCellData("LogIn", 24, 5);
		String password = excelReader.getCellData("LogIn", 25, 5);
		logIn(email,password);
		Assert.assertEquals(true, authPage.getInvalidEmailAddressLabel().isDisplayed());

		Thread.sleep(3000);	

}
	@Test (priority = 15)
	public void loginWithoutCredentials() throws InterruptedException {
		String email = "";
		String password = "";
		logIn(email,password);
		Assert.assertEquals(true, authPage.getInvalidEmailAddressLabel().isDisplayed());

		Thread.sleep(3000);	
		
	}
	@Test
	public void signOut() throws InterruptedException {
		validCredentialsLogIn();
		authPage.clickSignOutBtn();
		mainPage.getSignInBtn().isDisplayed();
		
		
		
		
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
}
