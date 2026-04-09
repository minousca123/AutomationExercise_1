package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;

import reporting.ExtentTestManager;
import utils.ScreenshotUtil;

public class ActionHelper{

	 private WebDriver driver;
	    private WebDriverWait wait;
	    private static final Logger log = LogManager.getLogger(ActionHelper.class);

	    public ActionHelper(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    public void click(WebElement element, String name) {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(element));

	            ((JavascriptExecutor) driver)
	                    .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

	            element.click();

	            log.info("Clicked: {}", name);
	            ExtentTestManager.getTest().info("Clicked: " + name);

	        } catch (Exception e) {

	            log.warn("Normal click failed, trying JS click: {}", name);

	            try {
	                ((JavascriptExecutor) driver)
	                        .executeScript("arguments[0].click();", element);

	                log.info("Clicked using JS: {}", name);
	                ExtentTestManager.getTest().info("Clicked using JS: " + name);

	            } catch (Exception ex) {

	                log.error("Click failed completely: {}", name, ex);

	                String path = ScreenshotUtil.captureScreenshot(driver, "fail_click_" + System.currentTimeMillis());

	                try {
	                    ExtentTestManager.getTest().fail(
	                            "Click failed: " + name,
	                            MediaEntityBuilder.createScreenCaptureFromPath(path).build()
	                    );
	                } catch (Exception mediaEx) {
	                    ExtentTestManager.getTest().fail("Click failed: " + name);
	                }

	                throw ex;
	            }
	        }
	    }

	    public void type(WebElement element, String text, String name) {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(element));

	            element.clear();
	            element.sendKeys(text);

	            log.info("Typed '{}' into {}", text, name);
	            ExtentTestManager.getTest().info("Typed '" + text + "' into " + name);

	        } catch (Exception e) {

	            log.error("Typing failed: {}", name, e);

	            String path = ScreenshotUtil.captureScreenshot(driver, "fail_type_" + System.currentTimeMillis());

	            try {
	                ExtentTestManager.getTest().fail(
	                        "Typing failed: " + name,
	                        MediaEntityBuilder.createScreenCaptureFromPath(path).build()
	                );
	            } catch (Exception mediaEx) {
	                ExtentTestManager.getTest().fail("Typing failed: " + name);
	            }

	            throw e;
	        }
	    }
}
