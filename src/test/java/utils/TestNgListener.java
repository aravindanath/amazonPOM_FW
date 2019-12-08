package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;

public class TestNgListener implements ITestListener {
//	private WebDriver driver;
	protected static ExtentReports reports;
	protected static ExtentTest test;
	protected BasePage bp;

	public void onTestStart(ITestResult result) {
		Reporter.log("on test start");
		test = reports.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("on test success");
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("on test failure");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		 
		  
				try {
					  bp.takeSnapShot( );
			 
				 
				} catch (Exception e) {
 
				}
			
			String file = test
					.addScreenCapture(bp.filePath);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed",
					result.getThrowable().getMessage());
		
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("on test skipped");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("on test sucess within percentage");
	}

	public void onStart(ITestContext context) {
		Reporter.log("on start");

		reports = new ExtentReports(System.getProperty("user.dir") + "/Output/ExtentReportResults.html");
	}

	public void onFinish(ITestContext context) {
		Reporter.log("on finish");
		 reports.endTest(test);
		 reports.flush();
	}

}
