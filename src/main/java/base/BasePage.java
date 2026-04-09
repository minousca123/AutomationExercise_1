package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;

//reusable actions 

public class BasePage {
	protected WebDriver driver;
	protected WaitUtils wait;
	protected ActionHelper action;
	protected final Logger log = LogManager.getLogger(this.getClass());

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
		this.action = new ActionHelper(driver);
		PageFactory.initElements(driver, this);
	}

	protected void click(WebElement element) {
		// ActionHelper.click(wait.waitForClickable(element), getName(element));
		try {
			action.click(wait.waitForClickable(element), getName(element));
		} catch (org.openqa.selenium.ElementClickInterceptedException e) {

			// 🔥 Handle ads / overlays
			utils.VignetteHandler.handleIfPresent();

			// Retry click
			action.click(wait.waitForClickable(element), getName(element));
		}

	}

	protected void type(WebElement element, String text) {
		action.type(wait.waitForVisible(element), text, getName(element));
	}

	protected boolean isVisible(WebElement element, String name) {

		// return wait.waitForVisible(element).isDisplayed();
		try {
			boolean status = wait.waitForVisible(element).isDisplayed();

			if (status) {
				log.info(name + " is visible");
			} else {
				log.error(name + " is NOT visible");
			}

			return status;

		} catch (Exception e) {
			log.error(name + " is NOT visible due to exception: " + e.getMessage());
			return false;
		}
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
		/*
		 * try { if (!el.getText().isEmpty()) return el.getText(); if
		 * (el.getAttribute("id") != null) return el.getAttribute("id"); if
		 * (el.getAttribute("placeholder") != null) return
		 * el.getAttribute("placeholder"); } catch (Exception ignored) { } return
		 * "element";
		 */
		try {
			

			// 1. placeholder (BEST for inputs)
			String placeholder = el.getAttribute("placeholder");
			if (placeholder != null && !placeholder.isEmpty())
				return placeholder;

			// 2. name attribute
			String name = el.getAttribute("name");
			if (name != null && !name.isEmpty())
				return name;

			// 3. aria-label (modern apps)
			String aria = el.getAttribute("aria-label");
			if (aria != null && !aria.isEmpty())
				return aria;

			// 4. id
			String id = el.getAttribute("id");
			if (id != null && !id.isEmpty())
				return id;

			// 5. visible text (for buttons, labels)
			String text = el.getText();
			if (text != null && !text.trim().isEmpty())
				return text.trim();

		} catch (Exception ignored) {
		}

		return "element";
	}
}
