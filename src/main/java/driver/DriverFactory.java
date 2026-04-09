package driver;

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

            	options.addArguments("--disable-notifications");
            	options.addArguments("--disable-infobars");
            	options.addArguments("--disable-extensions");
            	options.addArguments("--disable-popup-blocking");
            	options.addArguments("--disable-gpu");

            	// 🔥 THIS BLOCKS ADS
            	options.addArguments("--disable-features=VizDisplayCompositor");

            	// Optional but powerful:
            	options.addArguments("--blink-settings=imagesEnabled=false");
            	options.addArguments("--headless=new");
            	options.addArguments("--window-size=1920,1080");
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
