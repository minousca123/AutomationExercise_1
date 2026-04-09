package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reporting.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	 public void onTestStart(ITestResult result) {
		   ExtentManager.createTest(result.getMethod().getMethodName());
	    }

	    public void onTestSuccess(ITestResult result) {
	        ExtentManager.logPass("Test Passed");
	    }

	    public void onTestFailure(ITestResult result) {
	    	 ExtentManager.logFail(result.getThrowable().getMessage());

	    	    String path = ScreenshotUtil.captureScreenshot(result.getName());
	    	    ExtentManager.attachScreenshot(path);
	    }

	    public void onFinish(ITestContext context) {
	        ExtentManager.flush();
	    }
}