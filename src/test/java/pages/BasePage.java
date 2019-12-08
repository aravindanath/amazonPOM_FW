package pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class BasePage {
	private static WebDriver driver;
	public static String filePath ;
	BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void assertTitle(String excepted, WebDriver driver) {
		String actual = driver.getTitle();
		Assert.assertEquals(actual, excepted, "Title mis match!");
	}

	public void click(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).build().perform();
	}

	public void windowHandle(WebDriver driver) {

		Set<String> winID = driver.getWindowHandles();
		Iterator<String> iter = winID.iterator();
		System.out.println("First window: " + iter.next());

		winID = driver.getWindowHandles();
		iter = winID.iterator();
		System.out.println("Total no of windows open: " + winID.size());

		String first = iter.next();
		String second = iter.next();
		System.out.println("First window :" + first);
		System.out.println("Second window :" + second);

		driver.switchTo().window(second);

		String title2 = driver.getTitle();
		System.out.println("Title: " + title2);

		// driver.close();
		// driver.switchTo().window(first);

	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void assertPageTitle(String actual, String expected) {
		Assert.assertEquals(actual, expected, " Mismatch in Actual vs Expected!");
	}

	public static void takeSnapShot() throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		System.out.println(d);
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path = System.getProperty("user.dir") + "/test-output/";
		filePath = path + screenshotFile;
		System.err.println(filePath);
		// Move image file to new destination
		File DestFile = new File(filePath);
		// Copy file at destination
		Files.copy(SrcFile, DestFile);

	}

	public static String captureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/Output/screenShot.png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public static void assertPageTitle(String expected) {
		String actual = driver.getTitle();
		Reporter.log("Actual title: " + actual);
		Assert.assertEquals(actual, expected, " Mismatch in Actual vs Expected!");
	}

	/**
	 * @author aravindanathdm THis method is used to click on webelement
	 * @param element
	 */
	public static void click(WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).build().perform();
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");

	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static long generateMobile() {
		long mob = (long) (Math.random() * 9999999999l);
		return mob;
	}

	public String getTodayDate() {
		Date d = new Date();
		return d.toString();
	}

	public void rightClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public void dragNDrop(WebElement src, WebElement tgt) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, tgt).build().perform();
	}

}
