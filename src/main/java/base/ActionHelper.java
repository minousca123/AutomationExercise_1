package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reporting.ExtentManager;
import utils.ScreenshotUtil;

public class ActionHelper{

	  private WebDriver driver;
	    private WebDriverWait wait;
	    private static final Logger log = LogManager.getLogger(ActionHelper.class);
	    
	    public ActionHelper(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	public  void click(WebElement element, String name) {
		try {
	        // Wait until clickable
	        wait.until(ExpectedConditions.elementToBeClickable(element));

	        // Scroll to center (VERY IMPORTANT for Jenkins)
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

	       // Thread.sleep(300);

	        // Try normal click
	        element.click();

	        log.info("Clicking: " + name); ExtentManager.logStep("Click: " + name);

	    } catch (Exception e) {

	        log.warn("Normal click failed, trying JS click: " + element);

	        // ✅ BEST FALLBACK → JS CLICK (bypasses iframe overlay)
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", element);

	        log.info("Clicked using JS: " + element);
	    }
    }

    public static void type(WebElement element, String text, String name) {

        log.info("Typing '" + text + "' into: " + name);
        ExtentManager.logStep("Type '" + text + "' into: " + name);

        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {

            log.error("Typing failed: " + name, e);
            ExtentManager.logFail("Typing failed: " + name);

            String path = ScreenshotUtil.captureScreenshot("fail_type_" + System.currentTimeMillis());
            ExtentManager.attachScreenshot(path);

            throw e;
        }
    }
}
