package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverManager;

public class VignetteHandler {
	  public static void handleIfPresent() {
/*	        WebDriver driver = DriverManager.getDriver();

	        try {
	            if (!driver.getCurrentUrl().contains("google_vignette")) {
	                return;
	            }
	            System.out.println("⚠️ Google Vignette detected");
	            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	            for (WebElement frame : iframes) {
	                driver.switchTo().frame(frame);
	                List<WebElement> closeBtns = driver.findElements(
	                        By.xpath("//*[text()='Close' or @aria-label='Close']"));
	                if (!closeBtns.isEmpty()) {
	                    closeBtns.get(0).click();
	                    driver.switchTo().defaultContent();
	                    return;
	                }
	                driver.switchTo().defaultContent();
	            }
	            // fallback
	            driver.navigate().back();
	        } catch (Exception e) {
	            driver.switchTo().defaultContent();
	        }
	    }
	   WebDriver driver = DriverManager.getDriver();*/
		  WebDriver driver = DriverManager.getDriver();

		    try {
		        List<WebElement> iframes = driver.findElements(By.cssSelector("iframe"));

		        for (WebElement frame : iframes) {

		            String src = frame.getAttribute("src");

		            if (src != null && src.contains("googleads")) {

		              //  System.out.println("⚠️ Ad iframe detected");

		                driver.switchTo().frame(frame);

		                List<WebElement> closeBtns = driver.findElements(
		                        By.xpath("//*[text()='Close' or @aria-label='Close']"));

		                if (!closeBtns.isEmpty()) {
		                    closeBtns.get(0).click();
		                }

		                driver.switchTo().defaultContent();
		            }
		        }

		    } catch (Exception e) {
		        driver.switchTo().defaultContent();
		    }
		  
   }
}

