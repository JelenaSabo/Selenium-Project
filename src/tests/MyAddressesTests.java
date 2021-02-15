package tests;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressesTests extends TestBase {
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(3000);
	}
//	@Test (priority = 0)
	public void updateAddress() throws InterruptedException {
		
		String newAddress = excelReader.getCellData("My address", 4, 5);
		String oldAddress = excelReader.getCellData("My address", 7, 5);
		validLogIn();
		
		changeAddress(newAddress);
		
		Assert.assertEquals(myAddresses.getCurrentAddressLabel().getText(), newAddress);
		
		revertAddress(oldAddress);
		
		Assert.assertEquals(myAddresses.getCurrentAddressLabel().getText(), oldAddress);
		Thread.sleep(3000);
	}
	@Test (priority = 5)
	public void addAddress() throws InterruptedException {
		validLogIn();
		myAccount.clickOnMyAddressBtn();
		myAddresses.clickAddNewAddressBtn();
		
		anotherAddressCreation();
		
		Assert.assertEquals(myAddresses.getSecondAddressLabel().getText(), "SECONDADDRESS");
		Thread.sleep(3000);
	}
	@Test (priority = 10)
	public void deleteAddress() {
		validLogIn();
		myAccount.clickOnMyAddressBtn();
		myAddresses.clickDeleteSecondAddressBtn();
		
		driver.switchTo().alert().accept();
		
		assertSecondAddressNotPresent();
	}
	
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
	}
	
	public void anotherAddressCreation() {
		String address = excelReader.getCellData("My address", 11, 5);
		String city = excelReader.getCellData("My address",12 , 5);
		String state = excelReader.getCellData("My address", 13, 5);
		String zipCode = excelReader.getCellData("My address",14 , 5);
		String mobilePhone = excelReader.getCellData("My address",15, 5);
		String addressTitle = excelReader.getCellData("My address",16, 5);
		
		myAddresses.clickAddressField();
		myAddresses.getAddressField().sendKeys(address);
		
		myAddresses.clickCityField();
		myAddresses.getCityField().sendKeys(city);
		
		myAddresses.selectStateFromDropdownList(10);
		myAddresses.getStateDropdownSelection().sendKeys(state);
		
		myAddresses.clickZipCode();
		myAddresses.getZipCodeField().sendKeys(zipCode);
		
		myAddresses.clickMobilePhoneNumberField();
		myAddresses.getMobilePhoneNumberField().sendKeys(mobilePhone);
		
		myAddresses.clickAddressAliasField();
		myAddresses.getAddressAliasField().clear();
		myAddresses.getAddressAliasField().sendKeys(addressTitle);
		
		myAddresses.clickSubmitAddressBtn();

	}
	public void changeAddress(String address) {
		myAccount.clickOnMyAddressBtn();
		myAddresses.clickUpdateAddressBtn();
		myAddresses.clickAddressField();
		myAddresses.getAddressField().sendKeys(address);
		myAddresses.clickSaveBtn();
	}
	public void revertAddress(String address) {
		myAddresses.clickUpdateAddressBtn();
		myAddresses.clickAddressField();
		myAddresses.getAddressField().sendKeys(address);
		myAddresses.clickSaveBtn();
	}
	public void assertSecondAddressNotPresent() {
		List<WebElement>
		dynamicElement = driver.findElements(By.xpath("//div[@class='addresses']/div/div[2]/ul/li/h3"));
		
		if(dynamicElement.size()!=0) {
			System.out.println("Element present");
		}else {
			System.out.println("Element not present");
		}
	}
}
