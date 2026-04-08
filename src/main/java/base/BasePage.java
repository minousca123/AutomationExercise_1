package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.VignetteHandler;
import utils.WaitUtils;

//reusable actions 

public class BasePage {
	protected WebDriver driver;
	protected WaitUtils wait;
	protected final Logger log = LogManager.getLogger(this.getClass());

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
		PageFactory.initElements(driver, this);
	}

	protected void click(WebElement element) {
		ActionHelper.click(wait.waitForClickable(element), getName(element));
		
	}

	protected void type(WebElement element, String text) {
		ActionHelper.type(wait.waitForVisible(element), text, getName(element));
	}

	protected boolean isVisible(WebElement element) {
		return wait.waitForVisible(element).isDisplayed();
	}

	protected String getText(WebElement element) {
		return wait.waitForVisible(element).getText();
	}

	protected String getValue(WebElement element) {
		return wait.waitForVisible(element).getAttribute("value");
	}

	protected void selectDropdown(WebElement element, String type, String value) {
		org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(element);

		switch (type.toLowerCase()) {
		case "text":
			select.selectByVisibleText(value);
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		}
	}

	private String getName(WebElement el) {
		try {
			if (!el.getText().isEmpty())
				return el.getText();
			if (el.getAttribute("id") != null)
				return el.getAttribute("id");
		} catch (Exception ignored) {
		}
		return "element";
	}
}
