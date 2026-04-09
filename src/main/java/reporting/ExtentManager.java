package reporting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.ScreenshotUtil;

public class ExtentManager {


    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // Initialize report
    public static ExtentReports getInstance() {

        if (extent == null) {

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/ExtentReport_" + timestamp + ".html");

            // 🔥 PREMIUM UI CONFIG
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setReportName("Automation Execution Report");
            reporter.config().setDocumentTitle("QA Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            // 🧠 SYSTEM INFO
            extent.setSystemInfo("Tester", "Mini");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }

        return extent;
    }

    // Create test
    public static void createTest(String testName) {
        test.set(getInstance().createTest(testName));
    }

    // Get current test
    public static ExtentTest getTest() {
        return test.get();
    }

    // Log step
    public static void logStep(String message) {
        if (getTest() != null) {
            getTest().info(message);
        }
    }
    
    public static void logStepWithScreenshot(String message) {
    	 if (getTest() != null) {
    	        try {
    	            String path = ScreenshotUtil.captureScreenshot("step_" + System.currentTimeMillis());
    	            getTest().info(message).addScreenCaptureFromPath(path);
    	        } catch (Exception e) {
    	            getTest().info(message);
    	        }
    	    }
    }

    // Pass
    public static void logPass(String message) {
        if (getTest() != null) {
            getTest().pass(message);
        }
    }

    // Fail
    public static void logFail(String message) {
        if (getTest() != null) {
            getTest().fail(message);
        }
    }

    // Attach screenshot
    public static void attachScreenshot(String path) {
        try {
            if (getTest() != null && path != null) {
                getTest().addScreenCaptureFromPath(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    


    // Flush report
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}