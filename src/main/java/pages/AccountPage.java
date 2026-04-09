package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),' Logged in as')]")
	WebElement loggedInText;

	@FindBy(xpath = "//a[@href='/delete_account']")
	WebElement deleteAccountBtn;

	public boolean isUserLoggedIn() {
		return isVisible(loggedInText, "Logged in as");
	}

	public void clickDeleteAccount() {
		click(deleteAccountBtn);
	}
}
