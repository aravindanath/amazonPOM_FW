package pages;

import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.JavaUtils;

public class HomePage extends BasePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox")
	private WebElement search;
	
	
	protected HashMap<String, String> hp;
	
	public void enterProduct(String uniqueValue) {
		hp =  JavaUtils.readExcelData("Home", uniqueValue);
		search.sendKeys(hp.get("PRODUCT"),Keys.ENTER);
	}
	
	
	

}
