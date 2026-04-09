package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private WebDriverWait wait;
	private WebDriver driver;

	public WaitUtils(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement waitForVisible(WebElement element) {
		VignetteHandler.handleIfPresent();
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForClickable(WebElement element) {
		
		//  VignetteHandler.handleIfPresent(); 
		  return wait.until(ExpectedConditions.elementToBeClickable(element));
		 
		/* WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

		if (driver.getCurrentUrl().contains("google_vignette")) {
			VignetteHandler.handleIfPresent();
			try {
				// If element is still there → action failed → retry
				if (element.isDisplayed()) {
					
					 clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
				}
			} catch (Exception e) {
				// Element gone → action succeeded ✅
			}
		}
		
		return clickableElement;
	}*/
	}
}
