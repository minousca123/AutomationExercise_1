package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import driver.DriverManager;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		ExtentManager.getInstance();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());

		ExtentTestManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = DriverManager.getDriver();

		String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());

		ExtentTestManager.getTest().fail(result.getThrowable(),
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().skip("Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.getInstance().flush();
		ExtentTestManager.unload();
	}
}