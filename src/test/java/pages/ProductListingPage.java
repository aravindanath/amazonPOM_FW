package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage  extends BasePage{
	
	private WebDriver driver;
	
	public ProductListingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Display
	@FindBy(xpath="//span[text()='Analogue']")
	public WebElement analogueCB;
	
	//movement
	@FindBy(xpath="//span[text()='Quartz']")
	public WebElement quartzCB;
	
	@FindBy(xpath="//span[text()='Leather']")
	public WebElement leatherCB;
	
	@FindBy(xpath="//span[text()='25% Off or more']")
	public WebElement discountlink;
	
	@FindBy(xpath="(//span[text()='See more'])[1]")
	public WebElement seemoreBrands;
	
	@FindBy(xpath="(//span[text()='Titan'])[1]")
	public WebElement titan;
	
	@FindAll(@FindBy(xpath="//div[@class='s-result-list s-search-results sg-row']/div"))
	public List<WebElement> watches;
	
	@FindBy(css="#productTitle")
	public WebElement productTitle;
	

	@FindBy(css="#priceblock_ourprice")
	public WebElement priceTag;
	
	protected HashMap<String, String> plp;
	
	
	public void selectFilters() {
		click(driver, analogueCB);
		click(driver, quartzCB);
		click(driver, leatherCB);
		click(driver, discountlink);
		click(driver, seemoreBrands);
		click(driver, titan);

	 
	}
	
	public void selctWatch(int index) {
		watches.get(index).click();
	}
	
	public void getProductDetails() {
		windowHandle(driver);
		String producttitle = productTitle.getText();
		System.out.println(producttitle);
		String pricetag = priceTag.getText();
		System.out.println(pricetag);
		
	}

}
