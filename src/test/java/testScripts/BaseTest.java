package testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.JavaUtils;

public class BaseTest {

	protected WebDriver driver;

	@BeforeClass
	public void launchBrowser() throws IOException {
		if (JavaUtils.getVal("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (JavaUtils.getVal("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(JavaUtils.getVal("url"));
		
	}
	
	
	
	@AfterClass
	public void close() {
		driver.quit();
		
	}
	
}
