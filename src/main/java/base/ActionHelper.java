package base;

import org.openqa.selenium.WebElement;

import reporting.ExtentManager;

public class ActionHelper {
	public static void click(WebElement el, String name) {

	    if (name.toLowerCase().contains("login") || name.toLowerCase().contains("submit")) {
	        ExtentManager.logStepWithScreenshot("Click: " + name);
	    } else {
	        ExtentManager.logStep("Click: " + name);
	    }

	    el.click();
	}

	    public static void type(WebElement element, String text, String name) {
	        ExtentManager.logStep("Type '" + text + "' into: " + name);
	        element.clear();
	        element.sendKeys(text);
	    }
}
