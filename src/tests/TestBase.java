package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AuthenticationPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyPersonalInfoPage;
import pages.MyWishlistPage;

public class TestBase {
	WebDriver driver;
	MainPage mainPage;
	AuthenticationPage authPage;
	ExcelReader excelReader;
	MyAccountPage myAccount;
	MyAddressesPage myAddresses;
	MyPersonalInfoPage myPInfo;
	MyWishlistPage myWishlist;
	
	
	public void logIn(String email, String password) {
		mainPage.clickOnSignInBtn();
		authPage.inputLoginEmail(email);
		authPage.passwordInput(password);
		authPage.clickSignInBtn();
	}
	public void validLogIn() {
		mainPage.clickOnSignInBtn();
		authPage.inputLoginEmail(excelReader.getCellData("LogIn", 5, 5));
		authPage.passwordInput(excelReader.getCellData("LogIn", 6, 5));
		authPage.clickSignInBtn();
	}
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.mainPage = new MainPage(driver);
		this.authPage = new AuthenticationPage(driver);
		this.excelReader = new ExcelReader("TestPlan/TestCasesZavrsniTest.xlsx");
		this.myAccount = new MyAccountPage(driver);
		this.myAddresses = new MyAddressesPage(driver);
		this.myPInfo = new MyPersonalInfoPage(driver);
		this.myWishlist = new MyWishlistPage(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@AfterClass
	public void afterClass() throws IOException {
		driver.close();
		excelReader.fis.close();
		excelReader.wb.close();
		
	}
}
