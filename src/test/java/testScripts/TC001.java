package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;

public class TC001 extends BaseTest{
	
	@Test
	public void searchProduct() {
		BasePage.assertTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver);
		HomePage hp = new HomePage(driver);
		hp.enterProduct("AM_HM02");
		Assert.fail("Failing for fun..");
		
		
	}
	
	
	

}
