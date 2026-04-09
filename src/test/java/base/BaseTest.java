package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driver.DriverFactory;
import driver.DriverManager;
import utils.ConfigReader;
import utils.VignetteHandler;

public class BaseTest {
	protected WebDriver driver;
	protected PageObjectManager pom;
	protected final Logger log = LogManager.getLogger(this.getClass());


	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional String browser) {
		 log.info("========== START TEST ==========");

		String browserName = browser != null ? browser : ConfigReader.get("browser");

		DriverManager.setDriver(DriverFactory.initDriver(browserName));
		driver = DriverManager.getDriver();
		driver.get(ConfigReader.getUrl());

		pom = new PageObjectManager();
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
		log.info("========== END TEST ==========");
	}
}
