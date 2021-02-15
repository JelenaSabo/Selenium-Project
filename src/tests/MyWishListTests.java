package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishListTests extends TestBase {
	
	@BeforeMethod
	public void openPage() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		
	}
	@Test(priority = 0)
	public void addWishList() {
	String myWishList1 = excelReader.getCellData("My wishlist", 3, 5);
	validLogIn();
	myAccount.clickOnMyWishListBtn();
	createWishLists(myWishList1);
	Assert.assertEquals(true, myWishlist.getFirstWishlistLabel().isDisplayed());
}
	@Test(priority = 5) 
	public void addMultipleWishLists() {
		int i;
		validLogIn();
		
		myAccount.clickOnMyWishListBtn();
		
		for(i = 2; i<6; i++) {
			createWishLists(excelReader.getCellData("My wishlist", 3, 5)+i);
		}
		verifyNumberOfWishlists(i);
		
	}
	
	@Test(priority = 10)
	public void deleteWishList() throws InterruptedException {
		validLogIn();
		
		myAccount.clickOnMyWishListBtn();
		List<WebElement> numberOfWishlists = driver.findElements(By.xpath("//div[@id='block-history']/table/tbody/tr"));
		for (int i = 0; i<numberOfWishlists.size();i++) {
			
		
	//	while(myWishlist.getRemoveButton().isDisplayed()) {
			myWishlist.clickRemoveButton();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
		}
		List<WebElement> numberOfWishlistsAfter = driver.findElements(By.xpath("//div[@id='block-history']/table/tbody/tr"));

		Assert.assertEquals(numberOfWishlistsAfter.size(), 0);
	}
	@AfterMethod
	public void clearRefresh() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
	}
	public void createWishlist(String wishListName) {
		myAccount.clickOnMyWishListBtn();
		myWishlist.clickWishlistNameField();
		myWishlist.getWishlistNameField().sendKeys(wishListName);
		myWishlist.clickSaveButton();
	}
	public void createWishLists(String wishListName) {
		myWishlist.clickWishlistNameField();
		myWishlist.getWishlistNameField().sendKeys(wishListName);
		myWishlist.clickSaveButton();
	}
	public void verifyNumberOfWishlists(int i) {
		List<WebElement> 
		numberOfWishlists = driver.findElements(By.xpath("//div[@id='block-history']/table/tbody/tr"));
		if(numberOfWishlists.size()==i) {
			System.out.println(i + "wishlists are present");
		}else {
			System.out.println("Incorrect number of wishlists present");
		}
	}
}