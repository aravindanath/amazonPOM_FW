package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.ProductListingPage;

public class TC002 extends BaseTest {

	@Test
	public void searchProductWithPrice() {
		BasePage.assertTitle(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",
				driver);
		HomePage hp = new HomePage(driver);
		hp.enterProduct("AM_HM01");
		ProductListingPage plp = new ProductListingPage(driver);
		plp.selectFilters();
		plp.selctWatch(2);
		plp.getProductDetails();

	}

}
