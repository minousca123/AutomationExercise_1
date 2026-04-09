package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import reporting.ExtentManager;
import utils.ScreenshotUtil;

public class ActionHelper {
	 private static final Logger log = LogManager.getLogger(ActionHelper.class);
	public static void click(WebElement el, String name) {
		
		log.info("Clicking: " + name);
        ExtentManager.logStep("Click: " + name);

        try {
            el.click();
        } catch (Exception e) {

            log.error("Click failed: " + name, e);
            ExtentManager.logFail("Click failed: " + name);

            String path = ScreenshotUtil.captureScreenshot("fail_click_" + System.currentTimeMillis());
            ExtentManager.attachScreenshot(path);

            throw e;
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
