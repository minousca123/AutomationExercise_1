package base;

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

	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional String browser) {

		String browserName = browser != null ? browser : ConfigReader.get("browser");

		DriverManager.setDriver(DriverFactory.initDriver(browserName));
		driver = DriverManager.getDriver();
		driver.get(ConfigReader.getUrl());

		pom = new PageObjectManager();
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
	}
}
