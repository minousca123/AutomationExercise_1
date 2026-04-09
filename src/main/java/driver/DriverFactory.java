package driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver initDriver(String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "chrome":
            	ChromeOptions options = new ChromeOptions();
            	Map<String, Object> prefs = new HashMap<>();
            	prefs.put("profile.default_content_setting_values.notifications", 2);
            	prefs.put("profile.default_content_setting_values.ads", 2);

            	options.setExperimentalOption("prefs", prefs);

            	// Disable ads + popups
            	options.addArguments("--disable-notifications");
            	options.addArguments("--disable-infobars");
            	options.addArguments("--disable-extensions");
            	options.addArguments("--disable-popup-blocking");
            	options.addArguments("--disable-gpu");
            	options.addArguments("--no-sandbox");
            	options.addArguments("--disable-dev-shm-usage");
            	options.addArguments("--window-size=1920,1080");
            	options.addArguments("--disable-blink-features=AutomationControlled");
            	options.addArguments("--remote-allow-origins=*");
            	
                driver = new ChromeDriver(options);
                break;
            case "firefox":
    			driver = new FirefoxDriver();
    			break;
    		case "edge":
    			driver = new EdgeDriver();
    			break;
            default:
                throw new RuntimeException("Browser not supported");
        }

        driver.manage().window().maximize();
        return driver;
    }
}
